package core.threads;

import core.beans.SMSContext;
import core.constants.Statuses;
import core.sms.SendSMSInterface;
import core.util.QueryUtil;
import core.util.RequestUtil;
import core.util.Util;
import dao.BeanFactory;
import dao.entities.Application;
import dao.entities.Notification;
import dao.interfaces.ApplicationInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.function.Function;

import static core.util.CoreUtil.*;



@ApplicationScoped
public class PostSMSCreate implements Function<SMSContext, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostSMSCreate.class);
    @Inject
    private SendSMSInterface smsInterface;
    @Inject
    private ApplicationInterface applicationInterface;
    @Inject
    private QueryUtil queryUtil;


    @Override
    public String apply(SMSContext smsContext) {
        Notification notification = createNotification(smsContext);

        try {
            String mobileNumber = formatMobileNumber(smsContext.getMobileNumber());

            LOGGER.info("Sending SMS to {}. traceId -> {}", mobileNumber,smsContext.getLogId());

            if (Util.isPhoneNumberValid(mobileNumber)) {
                sendSmsNotification(smsContext, notification, mobileNumber,smsContext.getLogId());
            } else {
                handleInvalidNumber(notification,smsContext.getLogId());
            }

        } catch (Exception e) {
            handleException(notification, e);
        } finally {
            saveNotification(notification,smsContext.getLogId());
        }

        return null;
    }

    private Notification createNotification(SMSContext smsContext) {
        Notification notification = new Notification();
        notification.setBody(smsContext.getBody());
        notification.setNotificationDate(today());
        notification.setId(getLogId());
        notification.setNotificationType(setNotificationType(smsContext.getNotificationType()));
        notification.setLastUpdated(today());
        notification.setNotificationMonth(getCurrentMonth());
        notification.setTransactionId(smsContext.getTransactionId());
        return notification;
    }

    private String formatMobileNumber(String mobileNumber) {
        return mobileNumber.startsWith("+") ? mobileNumber : "+" + mobileNumber;
    }

    private void sendSmsNotification(SMSContext smsContext, Notification notification, String mobileNumber,String traceId) throws Exception {
        getApplicationAndSendSMS(smsContext, notification, mobileNumber, applicationInterface, smsInterface, LOGGER,traceId);
    }

    public void getApplicationAndSendSMS(SMSContext smsContext, Notification notification, String mobileNumber,
                                         ApplicationInterface applicationInterface, SendSMSInterface smsInterface, Logger logger,String traceId) throws Exception {
        Optional<Application> application = applicationInterface.findByAppId(RequestUtil.APP_ID);

        if (application.isPresent()) {
            RequestUtil.SEND_SMS = application.get().getSendSms();
            RequestUtil.TEST_NUMBERS = application.get().getTestNumber();
            notification.setMobileNumber(smsContext.getMobileNumber());
            smsInterface.sendSMS(mobileNumber, smsContext.getBody());
            notification.setStatus(Statuses.SENT.toString());
        } else {
            logger.info("Application {} not set. traceId -> {}", RequestUtil.APP_ID,traceId);
        }
    }

    private void handleInvalidNumber(Notification notification,String traceId) {
        LOGGER.info("SMS not sent. Mobile number is invalid. traceId -> {}",traceId);
        notification.setErrorDesc("Mobile number is invalid");
        notification.setStatus(Statuses.NOT_SENT.toString());
    }

    private void handleException(Notification notification, Exception e) {
        LOGGER.error("Error while sending SMS", e);
        notification.setErrorDesc(e.getMessage());
        notification.setStatus(Statuses.NOT_SENT.toString());
    }

    public void saveNotification(Notification notification,String traceId) {
        LOGGER.info("Notification to be saved {}. traceId -> {}", notification,traceId);
        try {
            Notification saved = queryUtil.postNotification(notification);
            LOGGER.info("Notification saved. Id -> {}. traceId -> {}", saved.getId(),traceId);
        } catch (Exception e) {
            LOGGER.error("Error while saving notification. traceId -> {}",traceId, e);
        }
    }




}
