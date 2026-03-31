package dao.interfaces;


import dao.entities.Application;

import java.util.Date;
import java.util.Optional;

public interface ApplicationInterface {
    int getAppMaxAttempts(String appId);
    Optional<Application> findByAppId(String id);

    int updateApplication(String collectionDays, boolean sendSMS, String testNumber, Integer allowedMissedPayment, Date updatedDate,String username);
    Application save(Application s);
}
