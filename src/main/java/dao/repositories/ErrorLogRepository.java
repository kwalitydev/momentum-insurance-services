package dao.repositories;

import dao.entities.*;
import dao.interfaces.BeneficiariesInterface;
import dao.interfaces.ErrorLogInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, String>, ErrorLogInterface {



    @Modifying(clearAutomatically = true)
    @Query("delete from ErrorLog where errorLogId=?1")
    int removeErrorLog(String id);



}
