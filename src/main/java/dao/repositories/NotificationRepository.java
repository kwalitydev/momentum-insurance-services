package dao.repositories;

import dao.entities.Notification;
import dao.entities.NotificationType;
import dao.entities.Status;
import dao.interfaces.NotificationInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String>, NotificationInterface {

    @Query("SELECT nt FROM Notification nt WHERE nt.transactionId=?1 AND nt.notificationType=?2 AND nt.notificationMonth=?3")
    List<Notification> findByTransactionIdAndNotification(String transactionId,NotificationType notificationType,String month);

    @Query("SELECT nt FROM Notification nt WHERE (nt.notificationDate BETWEEN ?1 AND ?2) AND (nt.notificationType.notificationChannel=?3) ORDER BY nt.notificationDate desc ")
    List<Notification> findByNotification(Date sd, Date ed, String channel,Pageable pageable);

    @Query("SELECT nt FROM Notification nt WHERE (nt.notificationDate BETWEEN ?1 AND ?2) AND nt.mobileNumber LIKE %?3% and nt.notificationType.notificationChannel=?4 ORDER BY nt.notificationDate desc ")
    List<Notification> findByNotification(Date sd, Date ed,String mobile,String channel, Pageable pageable);
    @Query("SELECT nt FROM Notification nt WHERE (nt.notificationDate BETWEEN ?1 AND ?2) AND nt.status =?3 AND nt.notificationType.notificationChannel=?4 ORDER BY nt.notificationDate desc ")
    List<Notification> findByNotificationStatus(Date sd, Date ed, String status,String channel, Pageable pageable);

    @Query("SELECT nt FROM Notification nt WHERE (nt.notificationDate BETWEEN ?1 AND ?2) AND nt.emailAddress LIKE %?3% AND nt.notificationType.notificationChannel=?4 ORDER BY nt.notificationDate desc ")
    List<Notification> findByNotificationByEmail(Date sd, Date ed,String email,String channel, Pageable pageable);
    @Query("SELECT nt FROM Notification nt WHERE (nt.notificationDate BETWEEN ?1 AND ?2) AND nt.emailAddress LIKE %?3% AND nt.notificationType.notificationChannel=?4 ORDER BY nt.notificationDate desc ")
    List<Notification> findByNotificationByStatusAndEmail(Date sd, Date ed,String email,String channel, Pageable pageable);

    @Query(value = "SELECT NOTIFICATIONTYPE_ID,COUNT(*) FROM NOTIFICATION WHERE NOTIFICATIONDATE BETWEEN ?1 AND ?2 GROUP BY NOTIFICATIONTYPE_ID ORDER BY NOTIFICATIONTYPE_ID ",nativeQuery = true)
    List<Object[]> getNotificationByStatus(Date sd, Date ed);
}
