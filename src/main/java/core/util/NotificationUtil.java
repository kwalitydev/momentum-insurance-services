package core.util;

import core.beans.SMSContext;
import core.constants.NotificationTypes;
import core.threads.PostSMSCreate;
import dao.entities.InsurancePolicy;
import dao.entities.PolicyHolder;
import dao.interfaces.InsurancePolicyInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.Callable;

@ApplicationScoped
public class NotificationUtil {
    private static final Logger LOGGER = LogManager.getLogger(NotificationUtil.class);
    @Inject
    private PostSMSCreate postSMSCreate;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;

    public void postSendSMS(String traceId, InsurancePolicy insurancePolicy) {
        try {

            PolicyHolder policyHolder = insurancePolicy.getPolicyHolder();

            String body = queryUtil.getNotificationBody(NotificationTypes.POLICY_ISSUE.toString()).replace("[First Name]",
                            policyHolder.getCustomerName()
                    ).replace("[Insurance Type]", insurancePolicy.getSubProduct().getDescription())
                    .replace("[Policy Number]", insurancePolicy.getPolicyId());

            setSMSContext(policyHolder.getMobileNumber(), body, traceId, NotificationTypes.POLICY_ISSUE.toString(), insurancePolicy.getPolicyId());
        }
        catch (Exception e){

            LOGGER.error(e);
        }
    }

    public void postSendSMS(String traceId, String insurancePolicyId, String mobileNumber, String customerName) {
        try {

            Optional<InsurancePolicy> insurancePolicy = insurancePolicyInterface.findByPolicyId(insurancePolicyId);
            if(insurancePolicy.isPresent()) {
                String body = queryUtil.getNotificationBody(NotificationTypes.POLICY_ISSUE.toString()).replace("[First Name]", customerName
                        ).replace("[Insurance Type]", insurancePolicy.get().getSubProduct().getDescription())
                        .replace("[Policy Number]", insurancePolicyId);
                setSMSContext(mobileNumber, body, traceId, NotificationTypes.POLICY_ISSUE.toString(), insurancePolicyId);
            }
            else {
                LOGGER.warn("Policy not found for id -> {}",insurancePolicyId);
            }
        }
        catch (Exception e){
            LOGGER.error(e);
        }
    }

    public void postSendAmendmentSMS(String traceId, InsurancePolicy savedInsurancePolicy, String mobileNumber) {
        String body = queryUtil.getNotificationBody(NotificationTypes.AMENDMENT.toString()).
                replace("[Insurance Type]", savedInsurancePolicy.getSubProduct().getDescription())
                .replace("[Police Number]", savedInsurancePolicy.getPolicyId());
             setSMSContext(mobileNumber, body, traceId, NotificationTypes.POLICY_ISSUE.toString(), savedInsurancePolicy.getPolicyId());
    }

    public void setSMSContext(String mobileNumber, String body, String logId, String notificationType, String transactionId) {
        try {
            SMSContext smsContext = new SMSContext();
            smsContext.setBody(body);
            smsContext.setMobileNumber(mobileNumber);
            smsContext.setLogId(logId);
            smsContext.setNotificationType(notificationType);
            smsContext.setTransactionId(transactionId);
            LOGGER.info("Attempting to submit sms. {}", smsContext);

            Callable<String> callable = () -> postSMSCreate.apply(smsContext);
            executorService.submit(callable);
        }
        catch (Exception e){
            LOGGER.error("Error while sending SMS.",e);
        }
    }

}
