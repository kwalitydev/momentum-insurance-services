package core.threads;

import core.beans.SMSContext;
import core.constants.Statuses;
import core.sms.SendSMSInterface;
import core.util.RequestUtil;
import core.util.Util;
import dao.entities.Application;
import dao.entities.Notification;
import dao.interfaces.ApplicationInterface;
import dao.interfaces.NotificationInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static core.util.CoreUtil.*;


@Dependent
@Transactional
public class PostCustomSMSCreate implements Function<SMSContext, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostCustomSMSCreate.class);

    @Inject
    private SendSMSInterface smsInterface;
    @Inject
    private NotificationInterface notificationInterface;
    @Inject
    private ApplicationInterface applicationInterface;
    @Inject
    private PostSMSCreate postSMSCreate;

    @Override
    public String apply(SMSContext smsContext) {


        Notification notification = new Notification();
        notification.setBody(smsContext.getBody());
        notification.setNotificationDate(today());
        notification.setId(smsContext.getLogId());
        notification.setNotificationType(setNotificationType(smsContext.getNotificationType()));
        notification.setLastUpdated(today());
        notification.setNotificationMonth(getCurrentMonth());
        notification.setTransactionId(smsContext.getTransactionId());

        try {
            String mobileNumber = smsContext.getMobileNumber();
            if (!mobileNumber.startsWith("+")) {
                mobileNumber = "+" + mobileNumber;
            }


            List<Notification> notifications = notificationInterface.findByTransactionIdAndNotification(smsContext.getTransactionId(),
                    setNotificationType(smsContext.getNotificationType()),getCurrentMonth());
            if(notifications.size()==0 ){




                LOGGER.info("Sending SMS to {}", mobileNumber);

                if (Util.isPhoneNumberValid(mobileNumber)) {

                    postSMSCreate.getApplicationAndSendSMS(smsContext, notification, mobileNumber, applicationInterface, smsInterface, LOGGER,smsContext.getLogId());


                } else {
                    LOGGER.info("SMS not sent. Mobile number is invalid");
                    notification.setErrorDesc("Mobile number is invalid");
                    notification.setStatus(Statuses.NOT_SENT.toString());
                }
            }

            else {
            LOGGER.info("{} notification already sent to {}",smsContext.getNotificationType(),mobileNumber);
        }

        }
        catch (Exception e){
            LOGGER.error("Error while saving SMS");
           LOGGER.error(e);
            notification.setStatus(Statuses.NOT_SENT.toString());
        }
        finally {
          Notification saved = notificationInterface.save(notification);
            LOGGER.info("Notification saved. Id -> {}",saved.getId());
        }


        return null;
    }



}
