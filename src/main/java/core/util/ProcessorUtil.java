package core.util;

import adapter.PaymentInterface;
import com.temenos.fundstransfer.FUNDSTRANSFERType;
import com.temenos.sbm_insurance.SBInsurancePaymentsResponse;
import com.temenos.sbm_insurance.Status;
import core.beans.CollectContext;
import core.beans.SMSContext;
import core.constants.Frequencies;
import core.constants.NotificationTypes;
import core.constants.Statuses;
import core.constants.T24Messages;
import core.threads.PostCollect;
import core.threads.PostSMSCreate;
import dao.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.xml.ws.WebServiceException;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import static core.util.CoreUtil.*;
import static core.util.CoreUtil.getCurrentMonth;
import static core.util.Util.*;
import static core.util.Util.formatDouble;

@ApplicationScoped
public class ProcessorUtil {
    private static final Logger LOGGER = LogManager.getLogger(ProcessorUtil.class);
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private PostSMSCreate postSMSCreate;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private PaymentInterface paymentInterface;

    public synchronized String apply(CollectContext collectContext, String taskName) {
        Date startProcessing = today();

        LOGGER.debug("{} : Collection to be processed {}", taskName, collectContext);
        if (Arrays.asList(collectContext.getChargePeriodArray()).contains(getCurrentDay())) {
            PaymentSchedule paymentSchedule = createPaymentSchedule(collectContext);
            CollectionLog collectionLog = new CollectionLog();
            collectionLog.setAccountNumber(collectContext.getAccountNumber());
            String errorMessage = "";

            LOGGER.info("{} : Attempting to send payment to core. policyId -> {}, accountNumber -> {}, traceId -> {}",
                    taskName, collectContext.getInsurancePolicy().getPolicyId(), collectContext.getAccountNumber(), collectContext.getLogId());

            try {
                SBInsurancePaymentsResponse paymentsResponse = buildPremiumCollection(
                        collectContext.getAccountNumber(), collectContext.getInsurancePolicy(),
                        collectContext, "Debito Directo - " + CoreUtil.formatDate(today(), "MM-yyyy"), collectContext.getLogId(),taskName
                );

                String t24Status = paymentsResponse.getStatus().getSuccessIndicator().value();
                LOGGER.info("{} : T24 response -> {}, traceId -> {}", taskName, paymentsResponse.getStatus(), collectContext.getLogId());

                if (t24Status.equalsIgnoreCase(T24Messages.SUCCESS.toString())) {
                } else {
                    handleFailedPayment(collectContext, paymentSchedule, paymentsResponse, t24Status, errorMessage);
                }

                saveCollectionLog(taskName, collectContext, collectionLog, errorMessage, paymentsResponse);

            } catch (WebServiceException wse) {
                handleWebServiceException(taskName, collectContext, wse, errorMessage);
            } catch (Exception e) {
                handleException(taskName, collectContext, e, errorMessage);
            }

            getDelay(LOGGER, startProcessing,collectContext.getLogId());
        }
        else {
            LOGGER.info("{} : Today is not a collection day. traceId -> {}", taskName, collectContext.getLogId());

        }
        return null;
    }

    public PaymentSchedule createPaymentSchedule(CollectContext collectContext) {
        PaymentSchedule paymentSchedule = new PaymentSchedule();
        paymentSchedule.setCreatedDate(today());
        paymentSchedule.setInsurancePolicy(collectContext.getInsurancePolicy());
        paymentSchedule.setLastAttempt(today());
        paymentSchedule.setRepaymentAmount(collectContext.getInsurancePolicy().getTotalAmount());
        paymentSchedule.setRepaymentMonth(getCurrentMonth());
        paymentSchedule.setRepaymentYear(getCurrentYear());
        paymentSchedule.setNormalPayment(collectContext.isNormalPayment());
        return paymentSchedule;
    }


    private void handleFailedPayment(CollectContext collectContext, PaymentSchedule paymentSchedule, SBInsurancePaymentsResponse paymentsResponse, String t24Status, String errorMessage) {
        PostCollect.setT24Error(collectContext.getInsurancePolicy(), paymentSchedule, paymentsResponse, t24Status, LOGGER,collectContext.getLogId());
    }

    private void handleUnpaidPayment(String taskName, CollectContext collectContext, PaymentSchedule paymentSchedule, CollectionLog collectionLog, String errorMessage) {
        collectionLog.setStatus(Statuses.UNPAID.toString());

        if (collectContext.isNotifyUnpaid() || Frequencies.YEARLY.toString().equals(collectContext.getInsurancePolicy().getPaymentFrequency().getFrequencyId())) {
            paymentSchedule.setErrorMessage(errorMessage);
            queryUtil.postPaymentScheduleSave(paymentSchedule,collectContext.getLogId());
            buildUnpaidNotification(collectContext, paymentSchedule);
        } else {
            LOGGER.info("{} : Payment {} failed, system will retry until last day of collection period. traceId -> {}", taskName, collectContext.getInsurancePolicy().getPolicyId(), collectContext.getLogId());
        }
    }

    private void saveCollectionLog(String taskName, CollectContext collectContext, CollectionLog collectionLog, String errorMessage, SBInsurancePaymentsResponse paymentsResponse) {
        try {
            collectionLog.setCreatedDate(today());
            collectionLog.setPolicyId(collectContext.getInsurancePolicy().getPolicyId());
            collectionLog.setError(errorMessage);
            collectionLog.setResponse(paymentsResponse.getStatus().toString());
            queryUtil.postCollectionLog(collectionLog, collectContext.getLogId());
        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error("{} : Error while saving collection log. traceId -> {}", taskName, collectContext.getLogId());
        }
    }

    private void handleWebServiceException(String taskName, CollectContext collectContext, WebServiceException wse, String errorMessage) {
        if (wse.getMessage() != null && !wse.getMessage().contains("Connection refused")) {
            setErrorLog(collectContext, collectContext.getInsurancePolicy(), errorMessage, wse);
        }
        LOGGER.error("{} : Error while collection premium. Error -> {}, traceId -> {}", taskName, wse.getMessage(), collectContext.getLogId());
        wse.printStackTrace();
    }

    private void handleException(String taskName, CollectContext collectContext, Exception e, String errorMessage) {
       LOGGER.error(e);
        LOGGER.error("{} : Error while collection premium. Error -> {}, traceId -> {}", taskName, e.getMessage(), collectContext.getLogId());
    }

    private void logOverride(String taskName, SBInsurancePaymentsResponse paymentsResponse, String errorMessage, CollectContext collectContext) {
        LOGGER.info("{} : Transaction has overrides. Id -> {}. Overrides -> {}. ErrorMessage -> {}, traceId -> {}", taskName,
                paymentsResponse.getStatus().getTransactionId(),
                errorMessage, errorMessage, collectContext.getLogId());
    }

    public synchronized boolean applyUnprocessed(CollectContext collectContext, String taskName) {
        Date startProcessing = today();
        String status = Statuses.UNPAID.toString();
        LOGGER.info("{} : Unprocessed Collection to be processed {}", taskName, collectContext);

        PaymentSchedule paymentSchedule = createPaymentSchedule(collectContext);
        CollectionLog collectionLog = new CollectionLog();
        collectionLog.setStatus(Statuses.UNPAID.toString());
        String errorMessage = "";

        if (collectContext.getAccountNumber() == null) {
            collectContext.setAccountNumber(collectContext.getInsurancePolicy().getPolicyHolder().getAccountNumber());
        }

        LOGGER.info("{} : Attempting to send payment to core. Insurance Payload {}. traceId -> {}", taskName, collectContext.getInsurancePolicy(), collectContext.getLogId());

        try {
            if (collectContext.getAccountNumber() != null) {
                SBInsurancePaymentsResponse paymentsResponse = buildPremiumCollection(
                        collectContext.getAccountNumber(), collectContext.getInsurancePolicy(),
                        collectContext, "Apolice - " + paymentSchedule.getRepaymentMonth() + "-" + paymentSchedule.getRepaymentYear(), collectContext.getLogId(),
                        taskName
                );

                String t24Status = paymentsResponse.getStatus().getSuccessIndicator().value();
                LOGGER.info("{} : T24 response -> {}, traceId -> {}", taskName, paymentsResponse.getStatus(), collectContext.getLogId());

                status = handleCoreResponse(taskName, collectContext, paymentSchedule, collectionLog, paymentsResponse, t24Status, errorMessage,paymentsResponse.getStatus());

                collectionLog.setCreatedDate(today());
                collectionLog.setPolicyId(collectContext.getInsurancePolicy().getPolicyId());
                collectionLog.setError(errorMessage);
                collectionLog.setResponse(paymentsResponse.getStatus().toString());

                queryUtil.postCollectionLog(collectionLog, collectContext.getLogId());
            } else {
                LOGGER.info("{} : policy {} has no associated account. traceId -> {}", taskName, collectContext.getInsurancePolicy().getPolicyId(),collectContext.getLogId());
            }

        } catch (WebServiceException wse) {
            handleWebServiceException(taskName, collectContext, wse, errorMessage);
        } catch (Exception e) {
            handleException(taskName, collectContext, e, errorMessage);
        }

        getDelay(LOGGER, startProcessing,collectContext.getLogId());
        return Statuses.PAID.toString().equals(status);
    }

    private String handleCoreResponse(String taskName, CollectContext collectContext, PaymentSchedule paymentSchedule,
                                           CollectionLog collectionLog, SBInsurancePaymentsResponse paymentsResponse, String t24Status, String errorMessage, Status t24StatusResponse) {

        String status = Statuses.UNPAID.toString();
        if (t24Status.equalsIgnoreCase(T24Messages.SUCCESS.toString())) {
            boolean hasOverride = false;
            FUNDSTRANSFERType.GOVERRIDE overrides = paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE();

            if (overrides != null) {
                hasOverride = hasOverride(overrides.getOVERRIDE());
                errorMessage = overrides.getOVERRIDE().toString();
            }

            if (hasOverride) {
                logOverride(taskName, paymentsResponse, errorMessage, collectContext);
            } else {
                collectionLog.setStatus(Statuses.PAID.toString());
                LOGGER.info("{} : Collection successfully processed. Id -> {}, traceId -> {}", taskName, paymentsResponse.getStatus().getTransactionId(), collectContext.getLogId());

                LOGGER.info("{} : Payment schedule to be updated. paidAmount -> {}, status -> {}, charge -> {}, transactionId -> {}, paymentScheduleId -> {}, traceId -> {}",
                        taskName, paymentSchedule.getRepaymentAmount(), Statuses.PAID.toString(), "",
                        t24StatusResponse.getTransactionId(), collectContext.getPaymentScheduleId(),collectContext.getLogId());

                int paymentScheduleUpdated = queryUtil.updatePayment(paymentSchedule.getRepaymentAmount(), setStatus(Statuses.PAID.toString()), "", t24StatusResponse.getTransactionId(), collectContext.getPaymentScheduleId(), true);
                status = Statuses.PAID.toString();
                if (paymentScheduleUpdated > 0) {
                    LOGGER.info("{} : PaymentSchedule successfully updated {}, traceId -> {}", taskName, collectContext.getPaymentScheduleId(),collectContext.getLogId());
                } else {
                    LOGGER.info("{} : Payment schedule not updated, traceId -> {}", taskName,collectContext.getLogId());
                }

            }

        } else {
            handleFailedPayment(collectContext, paymentSchedule, paymentsResponse, t24Status, errorMessage);
            int paymentScheduleUpdated = queryUtil.updatePayment(paymentSchedule.getRepaymentAmount(), paymentSchedule.getStatus(), "", paymentSchedule.getTransactionId(), collectContext.getPaymentScheduleId(), true);
            if (paymentScheduleUpdated > 0) {
                LOGGER.info("{} : PaymentSchedule successfully updated {}. traceId -> {}", taskName, collectContext.getPaymentScheduleId(),collectContext.getLogId());
            } else {
                LOGGER.info("{} : Payment schedule not updated. traceId -> {}", taskName,collectContext.getLogId());
            }
        }


        return status;
    }



    public void setErrorLog(CollectContext collectContext, InsurancePolicy insurancePolicy, String errorMessage, Exception e) {
        ErrorLog errorLog = new ErrorLog();
        errorLog.setErrorLogId(getLogId());
        errorLog.setCreatedDate(today());
        errorLog.setStatus(setStatus(Statuses.PENDING.toString()));
        errorLog.setInsurancePolicyId(insurancePolicy.getPolicyId());
        errorLog.setNormalPayment(collectContext.isNormalPayment());
        if(e.getMessage()!=null) {
            if(e.getMessage().length()>255) {
                errorLog.setLastError(e.getMessage().substring(0,254));
            }
            else {
                errorLog.setLastError(e.getMessage());
            }
        }
        errorLog.setLogId(collectContext.getLogId());
        errorLog.setPaymentScheduleId(collectContext.getPaymentScheduleId());

        try {
            ErrorLog savedErrorLog = queryUtil.postErrorLog(errorLog);
            LOGGER.info("ErrorLog saved due timeout. id -> {}. traceId -> {}", savedErrorLog.getErrorLogId(),collectContext.getLogId());
        } catch (Exception ex) {
            LOGGER.error("Error while saving to ErrorLog table. traceId -> {}",collectContext.getLogId());
            ex.printStackTrace();
        }

        LOGGER.error("Timeout while attempting to perform charge on {}. traceId -> {}", insurancePolicy.getPolicyId(),collectContext.getLogId());
        CollectionLog collectionLog = new CollectionLog();
        if (insurancePolicy.getPolicyHolder() != null) {
            collectionLog.setAccountNumber(insurancePolicy.getPolicyHolder().getAccountNumber());
        }
        else {
            collectionLog.setAccountNumber(collectionLog.getAccountNumber());
        }

        collectionLog.setCreatedDate(today());
        collectionLog.setPolicyId(insurancePolicy.getPolicyId());
        collectionLog.setError(errorMessage);
        collectionLog.setStatus(Statuses.ERROR.toString());
        collectionLog.setResponse("SocketTimeoutException");
       LOGGER.error(e);
        try {
            queryUtil.postCollectionLog(collectionLog,collectContext.getLogId());
        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error("Error while saving collection log. traceId -> {}", collectContext.getLogId());
        }
    }

    public static void setSMSContext(InsurancePolicy insurancePolicy, PaymentSchedule paymentSchedule, String body, Logger logger,
                                     PostSMSCreate postSMSCreate, ExecutorService executorService, QueryUtil queryUtil,String traceId) {
       try {
           if (insurancePolicy.getPolicyHolder().getMobileNumber() != null) {
               SMSContext smsContext = new SMSContext();
               smsContext.setBody(body);

               smsContext.setMobileNumber(insurancePolicy.getPolicyHolder().getMobileNumber().trim());
               smsContext.setLogId(smsContext.getLogId());
               smsContext.setNotificationType(NotificationTypes.MISSED_PAYMENT.toString());
               smsContext.setTransactionId(insurancePolicy.getPolicyId());
               logger.info("Attempting to submit sms. {}. traceId -> {}", smsContext,traceId);

               Callable<String> callable = () -> postSMSCreate.apply(smsContext);
               executorService.submit(callable);
           } else {
               logger.info("SMS Not sent. Mobile number is null. PolicyId -> {}. traceId -> {}", insurancePolicy.getPolicyId(),traceId);

           }
       }
       catch (Exception e){
           LOGGER.error("Error while sending SMS. traceId -> {}",traceId,e);
       }



    }

    public void setPaymentSchedule(InsurancePolicy insurancePolicy, PaymentSchedule paymentSchedule, SBInsurancePaymentsResponse paymentsResponse, Logger logger) {
        paymentSchedule.setPaidAmount(insurancePolicy.getTotalAmount());
        paymentSchedule.setStatus(setStatus(Statuses.PAID.toString()));
        paymentSchedule.setTransactionId(paymentsResponse.getStatus().getTransactionId());
        paymentSchedule.setChargeCode(paymentsResponse.getFUNDSTRANSFERType().getCOMMCHARGE());
        paymentSchedule.setMessageId(paymentsResponse.getStatus().getMessageId());
        paymentSchedule.setPaidAmount(insurancePolicy.getTotalAmount());
    }
    public SBInsurancePaymentsResponse buildPremiumCollection(String insurancePolicy, InsurancePolicy insurancePolicy1, CollectContext collectContext,
                                                              String paymentDetails, String LogId,String taskName) {
        return paymentInterface.postTransaction(
                insurancePolicy,
                insurancePolicy1.getCurrency().getCurrencyId(),
                String.valueOf(insurancePolicy1.getTotalAmount().doubleValue()),
                insurancePolicy1.getPolicyId(),
                insurancePolicy1.getPolicyId(),
                collectContext.getSuspenseAccount(),
                CoreUtil.formatDate(today(), T24_DATE_PATTERN),
                paymentDetails,
                collectContext.getDefaultBranch(),
                LogId,
                taskName

        );
    }

    public void buildUnpaidNotification(CollectContext collectContext, PaymentSchedule paymentSchedule) {
        String body = queryUtil.getNotificationBody(NotificationTypes.MISSED_PAYMENT.toString()).
                replace("[Premium]", formatDouble(collectContext.getInsurancePolicy().getTotalAmount().doubleValue()) + " " +
                        collectContext.getInsurancePolicy().getCurrency().getCurrencyId())
                .replace("[Policy Number]", collectContext.getInsurancePolicy().getPolicyId())
                .replace("[mes]", getMonthName(getCurrentMonth()));


        setSMSContext(collectContext.getInsurancePolicy(), paymentSchedule, body, LOGGER, postSMSCreate, executorService, queryUtil,collectContext.getLogId());
    }
}
