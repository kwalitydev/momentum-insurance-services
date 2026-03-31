package core.threads;

import core.beans.CancellationContext;
import core.beans.SMSContext;
import core.constants.NotificationTypes;
import core.util.QueryUtil;
import dao.entities.InsurancePolicy;
import dao.interfaces.InsurancePolicyInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Function;



@ApplicationScoped
public class PostCancellation implements Function<CancellationContext, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostCancellation.class);

    @Inject
    private PostSMSCreate postSMSCreate;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;

    @Override
    public String apply(CancellationContext cancellationContext) {
        String logId = cancellationContext.getLogId();
        String policyId = cancellationContext.getPolicyId();

        try {
            LOGGER.info("Notification to be sent due to cancellation. LogId -> {}", logId);

            String body = createNotificationBody(cancellationContext);
            Optional<InsurancePolicy> dbPolicy = insurancePolicyInterface.findByPolicyId(policyId);

            if (dbPolicy.isPresent()) {
                String mobileNumber = dbPolicy.get().getPolicyHolder().getMobileNumber();

                if (mobileNumber != null) {
                    sendSMSNotification(cancellationContext, body, mobileNumber.trim());
                } else {
                    LOGGER.warn("Customer does not have a mobile number. Skipping notification. Policy Id -> {}", policyId);
                }
            } else {
                LOGGER.warn("Policy with Id {} not found.", policyId);
            }
        } catch (Exception e) {
            LOGGER.error("Error while sending SMS. Cause -> {}", e.getMessage(), e);
        }

        return null;
    }

    private String createNotificationBody(CancellationContext cancellationContext) {
        return queryUtil.getNotificationBody(NotificationTypes.MANUAL_CANCELLATION.toString())
                .replace("[Reason]", cancellationContext.getComments())
                .replace("[Policy Number]", cancellationContext.getPolicyId());
    }

    private void sendSMSNotification(CancellationContext cancellationContext, String body, String mobileNumber) {
        SMSContext smsContext = new SMSContext();
        smsContext.setBody(body);
        smsContext.setMobileNumber(mobileNumber);
        smsContext.setLogId(cancellationContext.getLogId());
        smsContext.setNotificationType(NotificationTypes.MANUAL_CANCELLATION.toString());
        smsContext.setTransactionId(cancellationContext.getPolicyId());

        LOGGER.info("Attempting to submit SMS. {}", smsContext);

        Callable<String> callable = () -> postSMSCreate.apply(smsContext);
        executorService.submit(callable);
    }




}
