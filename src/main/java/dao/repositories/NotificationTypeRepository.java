package dao.repositories;

import dao.entities.NotificationType;
import dao.interfaces.NotificationTypeInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NotificationTypeRepository extends JpaRepository<NotificationType, String>, NotificationTypeInterface {

    @Query("SELECT n from NotificationType n where n.id=?1")
    Optional<NotificationType> findByType(String notificationTye);

}
