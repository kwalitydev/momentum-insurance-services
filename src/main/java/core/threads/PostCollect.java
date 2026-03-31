package core.threads;

import adapter.PaymentInterface;
import com.temenos.sbm_insurance.SBInsurancePaymentsResponse;
import core.beans.CollectContext;
import core.constants.NotificationTypes;
import core.constants.PaymentMethods;
import core.constants.Statuses;
import core.constants.T24Messages;
import core.util.CoreUtil;
import core.util.ProcessorUtil;
import core.util.QueryUtil;
import dao.entities.*;
import dao.repositories.SubProductAccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.Interval;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Date;
import java.util.Optional;
import java.util.function.Function;

import static core.util.CoreUtil.*;
import static core.util.Util.*;


@Dependent
public class PostCollect implements Function<CollectContext, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostCollect.class);

    @Inject
    private PaymentInterface paymentInterface;
    @Inject
    private SubProductAccountRepository subProductAccountRepository;
    @Inject
    private QueryUtil queryUtil;

    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private PostSMSCreate postSMSCreate;
    @Inject
    private ProcessorUtil processorUtil;


    @Override
    public synchronized String apply(CollectContext collectContext) {
        Date startProcessing = today();

        LOGGER.debug("Collection to be processed {}",collectContext);
        InsurancePolicy insurancePolicy = collectContext.getInsurancePolicy();
        PaymentSchedule paymentSchedule = new PaymentSchedule();
        PaymentLog paymentLog = new PaymentLog();
        String errorMessage = "";

        paymentSchedule.setCreatedDate(today());
        paymentSchedule.setInsurancePolicy(insurancePolicy);
        paymentSchedule.setLastAttempt(today());
        paymentSchedule.setRepaymentAmount(insurancePolicy.getTotalAmount());
        paymentSchedule.setRepaymentMonth(getCurrentMonth());
        paymentSchedule.setRepaymentYear(getCurrentYear());
        paymentSchedule.setNormalPayment(collectContext.isNormalPayment());
        CollectionLog collectionLog = new CollectionLog();
        try {
            Optional<SubProductAccount> subProductAccount = subProductAccountRepository.findBySubProductAndCurrencyAndStatus(insurancePolicy.getSubProduct(),
                    insurancePolicy.getCurrency(),setActive());

            if(subProductAccount.isPresent()) {

                if(insurancePolicy.getPolicyHolder()!=null) {
                    SBInsurancePaymentsResponse paymentsResponse = paymentInterface.postTransaction(
                            insurancePolicy.getPolicyHolder().getAccountNumber(),
                            insurancePolicy.getCurrency().getCurrencyId(),
                            String.valueOf(insurancePolicy.getTotalAmount().doubleValue()),
                            insurancePolicy.getPolicyId(),
                            insurancePolicy.getPolicyId(),
                            subProductAccount.get().getAccountId(),
                            CoreUtil.formatDate(today(), T24_DATE_PATTERN),
                            "Debito Directo -" + CoreUtil.formatDate(today(), "MM-yyyy"),
                            subProductAccount.get().getCompanyCode(),
                            collectContext.getLogId(),
                            collectContext.getTaskProduct()

                    );

                    String t24Status = paymentsResponse.getStatus().getSuccessIndicator().value();
                    LOGGER.info("Status returned from T24 -> {}. traceId -> {}",t24Status,collectContext.getLogId());

                    if (t24Status.equalsIgnoreCase(T24Messages.SUCCESS.toString())) {

                        boolean hasOverride = false;
                        if(paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE()!=null){
                            hasOverride = hasOverride(paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE().getOVERRIDE());
                        }


                        if (hasOverride) {
                            LOGGER.info("Transaction has overrides. Id -> {}. Overrides -> {}. ErrorMessage -> {}. traceId -> {}", paymentsResponse.getStatus().getTransactionId(),
                                    paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE().getOVERRIDE(),errorMessage,collectContext.getLogId());
                            paymentSchedule.setStatus(setStatus(Statuses.UNPAID.toString()));
                            paymentSchedule.setMessageId(paymentSchedule.getMessageId());

                        } else {
                            processorUtil.setPaymentSchedule(insurancePolicy, paymentSchedule, paymentsResponse, LOGGER);
                        }


                    }
                    else {
                        setT24Error(insurancePolicy, paymentSchedule, paymentsResponse, t24Status, LOGGER,collectContext.getLogId());
                    }

                    if(paymentSchedule.getStatus().getId().equals((Statuses.PAID.toString()))) {
                        PaymentSchedule savedPaymentSchedule = queryUtil.postPaymentScheduleSave(paymentSchedule, collectContext.getLogId());
                        paymentLog.setPaymentSchedule(savedPaymentSchedule);
                    }
                    else {
                        LOGGER.info("{} status is {}, skipping ... traceId -> {}",collectContext.getInsurancePolicy().getPolicyId(),
                                paymentSchedule.getStatus().getId(),collectContext.getLogId());
                    }



                   collectionLog.setResponse(paymentsResponse.getStatus().toString());
                    if(insurancePolicy.getPolicyHolder()!=null)
                        collectionLog.setAccountNumber(insurancePolicy.getPolicyHolder().getAccountNumber());

                    paymentLog.setAttemptDate(today());
                    paymentLog.setErrorMessage(errorMessage);
                    paymentLog.setPaymentMethod(PaymentMethods.NORMAL.getMethod());


                    paymentLog.setPaymentStatus(Statuses.SUCCESS.toString());
                    // queryUtil.postPaymentLog(paymentLog);
                    collectionLog.setStatus(Statuses.PAID.toString());
                }
                else {
                    LOGGER.info("policy {} has not associated account. traceId -> {}",insurancePolicy.getPolicyId(),collectContext.getLogId());

                }
            }
            else {
                LOGGER.info("No accounts found for policy {}. traceId -> {}",insurancePolicy.getPolicyId(),collectContext.getLogId());
            }
        }
        catch (Exception e){
            LOGGER.error("Generic error",e);
        }

        Interval interval = new Interval(startProcessing.getTime(), today().getTime());
        long delay = interval.toDurationMillis();
        LOGGER.info("Request {} took {} ms to process. traceId -> {}",collectContext.getLogId(),delay,collectContext.getLogId());

        return null;
    }

    public static void setT24Error(InsurancePolicy insurancePolicy, PaymentSchedule paymentSchedule,
                                   SBInsurancePaymentsResponse paymentsResponse, String t24Status, Logger logger,String traceId) {
        paymentSchedule.setStatus(setStatus(Statuses.UNPAID.toString()));
        if (t24Status.equalsIgnoreCase(T24Messages.T_24_ERROR.toString()) ||
                t24Status.equalsIgnoreCase(T24Messages.T24Error.toString())) {
            paymentSchedule.setMessageId(paymentSchedule.getMessageId());

            logger.error("T24 returned an error. id -> {}. error -> {}. traceId -> {}", insurancePolicy.getPolicyId(),paymentsResponse.getStatus().getMessages(),traceId);

        } else {
            paymentSchedule.setStatus(setStatus(Statuses.UNPAID.toString()));
            logger.error("T24 returned an unknown error. id -> {}. error -> {}. traceId -> {}", insurancePolicy.getPolicyId(),paymentsResponse.getStatus().getMessages(),traceId);

        }
    }


}
