package dao.interfaces;


import dao.entities.Notification;
import dao.entities.NotificationType;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface NotificationInterface {
      <T extends Notification> T save(T save);
    List<Notification> findByTransactionIdAndNotification(String transactionId,NotificationType notificationType,String month);
    List<Notification> findByNotification(Date sd, Date ed,String channel, Pageable pageable);
    List<Notification> findByNotification(Date sd, Date ed,String mobile, String channel,Pageable pageable);
    List<Notification> findByNotificationStatus(Date sd, Date ed, String status,String channel, Pageable pageable);

    List<Notification> findByNotificationByEmail(Date sd, Date ed,String email, String channel,Pageable pageable);
    List<Notification> findByNotificationByStatusAndEmail(Date sd, Date ed,String email,String channel, Pageable pageable);
    List<Object[]> getNotificationByStatus(Date sd, Date ed);

}
