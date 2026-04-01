package core.tasks;


import core.constants.Statuses;
import core.util.QueryUtil;
import dao.entities.*;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.*;
import static core.constants.Tasks.PAYMENT_SCHEDULE_HANDLER;
import static core.util.CoreUtil.*;
import static core.util.Util.*;

public class PaymentScheduleHandler extends TimerTask {
    private static final Logger LOGGER = LogManager.getLogger(PaymentScheduleHandler.class);

    @Inject
    private ErrorLogInterface errorLogInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private PaymentScheduleInterface paymentScheduleInterface;


    @Override
    public void run() {
        try {
            LOGGER.info("Starting timeout exception handler ...");

            if (!queryUtil.isTaskEnabled(PAYMENT_SCHEDULE_HANDLER.toString())) {
                LOGGER.warn("Task {} is not enabled", PAYMENT_SCHEDULE_HANDLER);
                return;
            }

            List<ErrorLog> errorLogs = errorLogInterface.findByStatus(setStatus(Statuses.PENDING.toString()));
            LOGGER.info("Found {} errors to be handled", errorLogs.size());

            for (ErrorLog error : errorLogs) {
                String traceId = getLogId();
            }
        } catch (Exception e) {
            LOGGER.error("Error while executing PaymentScheduleHandler Task", e);
        }
    }


    private PaymentSchedule createPaymentSchedule(ErrorLog error, InsurancePolicy insurancePolicy, String transactionId, String messageId) {
        PaymentSchedule paymentSchedule = new PaymentSchedule();
        paymentSchedule.setCreatedDate(today());
        paymentSchedule.setInsurancePolicy(insurancePolicy);
        paymentSchedule.setLastAttempt(today());
        paymentSchedule.setRepaymentAmount(insurancePolicy.getTotalAmount());
        paymentSchedule.setRepaymentMonth(getCurrentMonth());
        paymentSchedule.setRepaymentYear(getCurrentYear());
        paymentSchedule.setNormalPayment(error.isNormalPayment());
        paymentSchedule.setMessageId(messageId);
        paymentSchedule.setPaidAmount(insurancePolicy.getTotalAmount());
        paymentSchedule.setStatus(setStatus(Statuses.PAID.toString()));
        paymentSchedule.setTransactionId(transactionId);
        return paymentSchedule;
    }

    private void updatePaymentSchedule(ErrorLog error, InsurancePolicy insurancePolicy, String transactionId) {
        int paymentScheduleUpdated = queryUtil.updatePayment(
                insurancePolicy.getTotalAmount(),
                setStatus(Statuses.PAID.toString()), null, transactionId,
                error.getPaymentScheduleId(), error.isNormalPayment()
        );

        if (paymentScheduleUpdated > 0) {
            LOGGER.info("PaymentSchedule {} updated to PAID", paymentScheduleUpdated);
        } else {
            LOGGER.info("PaymentSchedule {} not updated", paymentScheduleUpdated);
        }
    }

    private void savePaymentSchedule(ErrorLog error, InsurancePolicy insurancePolicy, PaymentSchedule paymentSchedule,String traceId) {
        List<String> statuses = Arrays.asList(Statuses.PAID.toString(), Statuses.UNPAID.toString());
        int alreadyAttempted = paymentScheduleInterface.findByInsurancePolicyAndMonth(
                insurancePolicy.getPolicyId(),
                getCurrentMonth(),
                getCurrentYear(),
                statuses,
                error.isNormalPayment(),
                insurancePolicy.getSubProduct().getSubProductId()
        );

        if (alreadyAttempted == 0) {
            queryUtil.postPaymentScheduleSave(paymentSchedule,traceId);
        } else {
            LOGGER.info("{} already sync.", insurancePolicy.getPolicyId());
        }
    }



}
