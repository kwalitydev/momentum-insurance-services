package core.tasks;

import core.constants.Statuses;
import core.exception.BusinessException;
import core.service.IPaymentScheduleService;
import core.util.QueryUtil;
import dao.entities.InsurancePolicy;
import dao.entities.TaskConfig;
import dao.enums.InvoiceType;
import dao.interfaces.InsurancePolicyInterface;
import dao.interfaces.TaskInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static core.constants.Tasks.PAYMENT_SCHEDULE_HANDLER;

public class PaymentScheduleHandler extends TimerTask {

    private static final Logger logger = LogManager.getLogger(PaymentScheduleHandler.class);

    @Inject
    private QueryUtil queryUtil;
    @Inject
    private TaskInterface taskInterface;
    @Inject
    private InsurancePolicyInterface getInsurancePolicyInterface;

    @Inject
    private IPaymentScheduleService iPaymentScheduleService;

    @Override
    public void run() {

        logger.info("Starting PaymentScheduleHandler...");

        try {

            Optional<TaskConfig> tasks = taskInterface.getTasks(PAYMENT_SCHEDULE_HANDLER.toString());

            if (!tasks.isPresent() || !isExecutionDay(tasks.get().getNextRunningDate())) {
                logger.warn("Task {} is not scheduled to run today", PAYMENT_SCHEDULE_HANDLER);
                return;
            }

            if (!queryUtil.isTaskEnabled(PAYMENT_SCHEDULE_HANDLER.toString())) {
                logger.warn("Task {} is not enabled", PAYMENT_SCHEDULE_HANDLER);
                return;
            }

            List<InsurancePolicy> insurancePolicyList = getInsurancePolicyInterface.findActivePoliciesByStatus(Statuses.ACTIVE.name());

            if (insurancePolicyList == null || insurancePolicyList.isEmpty()) {
                logger.info("No active policies found.");
                return;
            }

            logger.info("Generating payment schedules for {} policies", insurancePolicyList.size());

            for (InsurancePolicy policy : insurancePolicyList) {

                Arrays.asList(InvoiceType.values()).forEach(invoiceType -> {
                    try {
                        this.iPaymentScheduleService.processInvoice(policy,invoiceType);

                    } catch (BusinessException e) {
                        logger.warn("Business error for policy {}: {}", policy.getPolicyId(), e.getMessage());

                    } catch (Exception e) {
                        logger.error("Unexpected error for policy {}", policy.getPolicyId(), e);
                    }
                });


            }
        } catch (Exception e) {
            logger.error("Fatal error while executing PaymentScheduleHandler", e);
        }

        logger.info("Finished PaymentScheduleHandler.");
    }

    private boolean isExecutionDay(Date nextRunningDate) {
        if (nextRunningDate == null) return false;

        LocalDate nextDate = nextRunningDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return nextDate.getDayOfMonth() == 25 && LocalDate.now().isEqual(nextDate);
    }
}