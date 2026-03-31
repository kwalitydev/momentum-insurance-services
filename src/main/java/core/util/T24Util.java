package core.util;

import adapter.PaymentInterface;
import com.temenos.sbm_insurance.SBInsurancePaymentsResponse;
import core.beans.CorePayload;
import core.constants.PaymentMethods;
import core.constants.Statuses;
import core.constants.T24Messages;
import core.threads.PostCollectPremium;
import dao.entities.*;
import dao.interfaces.CollectionLogInterface;
import dao.interfaces.PaymentLogInterface;
import dao.repositories.PaymentScheduleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

import static core.util.CoreUtil.*;
import static core.util.Util.*;
import static core.util.Util.setStatus;

@ApplicationScoped
@Transactional
public class T24Util {

    private static final Logger LOGGER = LogManager.getLogger(PostCollectPremium.class);
    @Inject
    private PaymentInterface paymentInterface;
    @Inject
    private PaymentScheduleRepository paymentScheduleInterface;
    @Inject
    private PaymentLogInterface paymentLogInterface;
    @Inject
    private CollectionLogInterface collectionLogInterface;



    public boolean postTransaction(CorePayload corePayload) {
        Date startProcessing = today();

        PaymentSchedule paymentSchedule = new PaymentSchedule();
        PaymentLog paymentLog = new PaymentLog();
        StringBuilder errorMessage = new StringBuilder();

        paymentSchedule.setCreatedDate(today());
        paymentSchedule.setInsurancePolicy(corePayload.getInsurancePolicy());
        paymentSchedule.setLastAttempt(today());
        paymentSchedule.setRepaymentAmount(corePayload.getInsurancePolicy().getTotalAmount());
        paymentSchedule.setRepaymentMonth(getCurrentMonth());
        paymentSchedule.setRepaymentYear(getCurrentYear());
        paymentSchedule.setNormalPayment(true);

        Status status;
        BigDecimal paidAmount;
        boolean result = false;


        try {

            InsurancePolicy insurancePolicy = corePayload.getInsurancePolicy();

                if (insurancePolicy.getPolicyHolder() != null) {

                    SBInsurancePaymentsResponse paymentsResponse = paymentInterface.postTransaction(
                            insurancePolicy.getPolicyHolder().getAccountNumber(),
                            insurancePolicy.getCurrency().getCurrencyId(),
                            String.valueOf(Util.round(insurancePolicy.getTotalAmount().doubleValue(),2)),
                            insurancePolicy.getPolicyId(),
                            insurancePolicy.getPolicyId(),
                            corePayload.getSubProductAccount().getAccountId(),
                            CoreUtil.formatDate(today(), T24_DATE_PATTERN),
                            "Apolice - " + getCurrentMonth(),
                            corePayload.getSubProductAccount().getCompanyCode(),
                            corePayload.getTraceId(),
                            "Manual_Task"
                    );

                    String t24Status = paymentsResponse.getStatus().getSuccessIndicator().value();
                    if (t24Status.equalsIgnoreCase(T24Messages.SUCCESS.toString())) {
                        boolean hasOverride = false;

                        if(paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE()!=null){
                            hasOverride = hasOverride(paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE().getOVERRIDE());
                        }


                        if (hasOverride) {
                            LOGGER.info("Transaction has overrides. Id -> {}", paymentsResponse.getStatus().getTransactionId());


                        } else {
                            status = setStatus(Statuses.PAID.toString());
                            result = true;
                            LOGGER.info("Payment successfully processed. transactionId -> {}, traceId-> {}", paymentsResponse.getStatus().getTransactionId(),corePayload.getTraceId());

                            if (paymentsResponse.getFUNDSTRANSFERType() != null) {
                               String chargeCode = paymentsResponse.getFUNDSTRANSFERType().getCOMMISSIONCODE();
                               String transactionId = paymentsResponse.getStatus().getTransactionId();
                                paidAmount = paymentSchedule.getRepaymentAmount();

                                paymentSchedule.setStatus(status);
                                paymentSchedule.setTransactionId(transactionId);
                                paymentSchedule.setPaidAmount(paidAmount);
                                paymentSchedule.setChargeCode(chargeCode);
                                if (paymentsResponse.getStatus() != null) {
                                    paymentSchedule.setMessageId(paymentsResponse.getStatus().getMessageId());
                                }

                            }


                        }


                    } else if (t24Status.equalsIgnoreCase(T24Messages.T_24_ERROR.toString()) ||
                            t24Status.equalsIgnoreCase(T24Messages.T24Error.toString())) {
                        paymentSchedule.setMessageId(paymentSchedule.getMessageId());
                        for (String l : paymentsResponse.getStatus().getMessages()) {
                            errorMessage.append(l);
                            errorMessage.append(" ");
                        }
                        paymentSchedule.setStatus(setStatus(Statuses.ERROR.toString()));
                        LOGGER.error("T24 returned an error. id -> {}, traceId -> {}", insurancePolicy.getPolicyId(),corePayload.getTraceId());

                    } else {
                        errorMessage.append("Unknown T24 Status");
                        errorMessage.append(t24Status);
                        paymentSchedule.setStatus(setStatus(Statuses.ERROR.toString()));
                        LOGGER.warn("Unknown status -> {}. traceId -> {}", t24Status,corePayload.getTraceId());

                    }


                    paymentLog.setAttemptDate(today());
                    paymentLog.setErrorMessage(errorMessage.toString());
                    paymentLog.setPaymentMethod(PaymentMethods.NORMAL.getMethod());

                    CollectionLog collectionLog = new CollectionLog();
                    collectionLog.setAccountNumber(insurancePolicy.getPolicyHolder().getAccountNumber());


                    if (errorMessage.toString().isEmpty()) {
                        paymentLog.setPaymentStatus(Statuses.SUCCESS.toString());
                        collectionLog.setStatus(Statuses.PAID.toString());
                        paymentSchedule.setInsurancePolicy(insurancePolicy);


                    } else {

                        paymentLog.setPaymentStatus(Statuses.FAILED.toString());
                        collectionLog.setStatus(Statuses.UNPAID.toString());
                        collectionLog.setCreatedDate(today());
                        collectionLog.setPolicyId(insurancePolicy.getPolicyId());
                        collectionLog.setError(errorMessage.toString());
                        collectionLog.setResponse(paymentsResponse.getStatus().toString());


                    }

                    PaymentSchedule savedPaymentSchedule = paymentScheduleInterface.saveAndFlush(paymentSchedule);
                    paymentLog.setPaymentSchedule(savedPaymentSchedule);
                    LOGGER.info("PaymentSchedule saved {}, traceId -> {}", savedPaymentSchedule.getPaymentScheduleId(),corePayload.getTraceId());
                    CollectionLog savedCollectionLog = collectionLogInterface.save(collectionLog);
                    LOGGER.info("CollectionLog saved {}, traceId -> {}", savedCollectionLog.getId(),corePayload.getTraceId());



                } else {
                    LOGGER.info("policy {} has not associated account. traceId -> {}", insurancePolicy.getPolicyId(),corePayload.getTraceId());


                }


        } catch (Exception e) {
            LOGGER.error("Generic error. traceId -> {}",corePayload.getTraceId(),e);
        }

        LOGGER.info("Request took {} ms to process. traceId -> {}", getDelay(startProcessing),corePayload.getTraceId());


        return result;
    }

}
