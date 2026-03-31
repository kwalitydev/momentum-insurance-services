package core.util;

import core.beans.CustomerResponse;
import core.beans.SMSContext;
import core.constants.NotificationTypes;
import core.threads.PostSMSCreate;
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

    public void postSendSMS(String traceId, InsurancePolicy savedInsurancePolicy) {
        /*try {

            String body = queryUtil.getNotificationBody(NotificationTypes.POLICY_ISSUE.toString()).replace("[First Name]", customerResponse.getCoreCustomer().getCustomerName()
                    ).replace("[Insurance Type]", savedInsurancePolicy.getSubProduct().getDescription())
                    .replace("[Policy Number]", savedInsurancePolicy.getPolicyId());
            setSMSContext(customerResponse, body, traceId, NotificationTypes.POLICY_ISSUE.toString(), savedInsurancePolicy.getPolicyId());
        }
        catch (Exception e){

            LOGGER.error(e);
        } */
    }

    public void postSendSMS(String traceId, String insurancePolicyId, CustomerResponse customerResponse) {
        try {

            Optional<InsurancePolicy> insurancePolicy = insurancePolicyInterface.findByPolicyId(insurancePolicyId);
            if(insurancePolicy.isPresent()) {
                String body = queryUtil.getNotificationBody(NotificationTypes.POLICY_ISSUE.toString()).replace("[First Name]", customerResponse.getCoreCustomer().getCustomerName()
                        ).replace("[Insurance Type]", insurancePolicy.get().getSubProduct().getDescription())
                        .replace("[Policy Number]", insurancePolicyId);
                setSMSContext(customerResponse, body, traceId, NotificationTypes.POLICY_ISSUE.toString(), insurancePolicyId);
            }
            else {
                LOGGER.warn("Policy not found for id -> {}",insurancePolicyId);
            }
        }
        catch (Exception e){
            LOGGER.error(e);
        }
    }

    public void postSendAmendmentSMS(String traceId, InsurancePolicy savedInsurancePolicy, CustomerResponse customerResponse) {
        String body = queryUtil.getNotificationBody(NotificationTypes.AMENDMENT.toString()).
                replace("[Insurance Type]", savedInsurancePolicy.getSubProduct().getDescription())
                .replace("[Police Number]", savedInsurancePolicy.getPolicyId());
             setSMSContext(customerResponse, body, traceId, NotificationTypes.POLICY_ISSUE.toString(), savedInsurancePolicy.getPolicyId());
    }

    public void setSMSContext(CustomerResponse customerResponse, String body, String logId, String notificationType, String transactionId) {
        try {
            SMSContext smsContext = new SMSContext();
            smsContext.setBody(body);
            smsContext.setMobileNumber(customerResponse.getCoreCustomer().getMobileNumber().trim());
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
