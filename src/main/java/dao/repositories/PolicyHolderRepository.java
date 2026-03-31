package dao.repositories;

import dao.entities.PolicyHolder;
import dao.entities.JobTitle;
import dao.interfaces.PolicyHolderInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Date;


@Transactional
public interface PolicyHolderRepository extends JpaRepository<PolicyHolder, String>, PolicyHolderInterface {

    @Modifying(clearAutomatically = true)
    @Query("update PolicyHolder set accountNumber=?1, customerId=?2, dateOfBirth =?3, mobileNumber=?4,lastUpdate=?5,customerName=?6,email=?7, vat=?8, address=?9 where id=?10")
    int updateAccount(String accountNumber, String customerId,Date dateOfBirth,String mobileNumber,Date lastUpdate,String customerName,String email,String vat,String address,Long id);


    @Modifying(clearAutomatically = true)
    @Query("update PolicyHolder set accountNumber=?1, customerId=?2, dateOfBirth =?3, mobileNumber=?4,lastUpdate=?5,customerName=?6,email=?7, vat=?8, address=?9,jobTitle=?10, documentId=?11  where id=?12")
    int updateAccount(String accountNumber, String customerId, Date dateOfBirth, String mobileNumber, Date lastUpdate, String customerName, String email, String vat, String address, JobTitle j,String documentId, Long id);


    @Modifying(clearAutomatically = true)
    @Query("update PolicyHolder set accountNumber=?1, customerId=?2, dateOfBirth =?3, mobileNumber=?4,lastUpdate=?5,customerName=?6,email=?7, vat=?8, address=?9" +
            ",jobTitle.jobTitleId=?10, documentId=?11  where id=?12")
    int updateAccount(String accountNumber, String customerId, Date dateOfBirth, String mobileNumber, Date lastUpdate, String customerName, String email,
                      String vat, String address, Long jobTitleId, String documentId, Long id);




}
