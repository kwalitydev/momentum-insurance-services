package dao.repositories;

import dao.entities.Application;
import dao.interfaces.ApplicationInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, String>, ApplicationInterface {


    @Query("SELECT maxUserAttempts FROM Application WHERE appId=?1")
    int getAppMaxAttempts(String appId);


    @Modifying(clearAutomatically = true)
    @Query("update Application set collectionDays=?1,sendSms=?2, testNumber=?3, allowedMissedPayment=?4 ,updatedDate=?5, username=?6")
    int updateApplication(String collectionDays, boolean sendSMS, String testNumber, Integer allowedMissedPayment, Date updatedDate,String username);

}
