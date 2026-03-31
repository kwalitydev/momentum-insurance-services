package core.threads;

import adapter.EmailInterface;
import com.its.stb.services.SendNotificationOut;
import core.beans.EmailContext;
import core.constants.Statuses;
import dao.BeanFactory;
import dao.entities.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.function.Function;

import static core.util.CoreUtil.*;


@ApplicationScoped
@Transactional
public class PostEmailCreate implements Function<EmailContext, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostEmailCreate.class);

    @Inject
    private BeanFactory beanFactory;
    @Inject
    private EmailInterface emailInterface;

    @Override
    public String apply(EmailContext emailContext) {
        Notification notification = createNotification(emailContext);

        try {
          LOGGER.info("Sending Email to {}. traceId -> {}", emailContext.getDestination(),emailContext.getLogId());

          SendNotificationOut notificationOut = emailInterface.sendEmail(emailContext.getBody(),
                    emailContext.getDestination(),
                    emailContext.getSubject(),
                    emailContext.getLogId());

          LOGGER.info("Email Successfully sent. id -> {}, traceId -> {}",notificationOut.getMessageId(),emailContext.getLogId());
          notification.setStatus(Statuses.SENT.toString());

        } catch (Exception e) {
            handleException(notification,emailContext.getLogId(), e);
        } finally {
            saveNotification(notification,emailContext.getLogId());
        }

        return null;
    }

    private Notification createNotification(EmailContext emailContext) {
        Notification notification = new Notification();
        notification.setBody(emailContext.getBody());
        notification.setNotificationDate(today());
        notification.setId(getLogId());
        notification.setNotificationType(setNotificationType(emailContext.getNotificationType()));
        notification.setLastUpdated(today());
        notification.setNotificationMonth(getCurrentMonth());
        notification.setEmailAddress(emailContext.getDestination());
        notification.setTransactionId(emailContext.getPolicyId());

        return notification;
    }



    private void handleException(Notification notification,String traceId, Exception e) {
        LOGGER.error("Error while sending Email. traceId -> {}",traceId, e);
        notification.setErrorDesc(e.getMessage());
        notification.setStatus(Statuses.NOT_SENT.toString());
    }

    private void saveNotification(Notification notification,String traceId) {
        LOGGER.info("Notification to be saved {}. traceId -> {}", notification.toStringMin(),traceId);
        try {
            Notification saved = beanFactory.merge(notification);
            LOGGER.info("Notification saved. Id -> {}. traceId -> {}", saved.getId(),traceId);
        } catch (Exception e) {
            LOGGER.error("Error while saving notification. traceId -> {}",traceId, e);
        }
    }




}
