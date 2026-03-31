package dao.interfaces;



import dao.entities.NotificationType;

import java.util.Optional;

public interface NotificationTypeInterface {
    Optional<NotificationType> findById(String notificationTye);

  }
