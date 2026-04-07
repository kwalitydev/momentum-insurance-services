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
    @Query("update PolicyHolder set  dateOfBirth =?1, mobileNumber=?2,lastUpdate=?3,customerName=?4,email=?5, vat=?6, address=?7 where id=?8")
    int updatePolicyHolder( Date dateOfBirth, String mobileNumber, Date lastUpdate, String customerName, String email, String vat, String address, Long id);


    @Modifying(clearAutomatically = true)
    @Query("update PolicyHolder set dateOfBirth =?1, mobileNumber=?2,lastUpdate=?3,customerName=?4,email=?5, vat=?6, address=?7,jobTitle=?8, documentId=?9  where id=?10")
    int updatePolicyHolder(Date dateOfBirth, String mobileNumber, Date lastUpdate, String customerName, String email, String vat, String address, JobTitle j, String documentId, Long id);


    @Modifying(clearAutomatically = true)
    @Query("update PolicyHolder set dateOfBirth =?1, mobileNumber=?2,lastUpdate=?3,customerName=?4,email=?5, vat=?6, address=?7" +
            ",jobTitle.jobTitleId=?8, documentId=?9  where id=?10")
    int updatePolicyHolder( Date dateOfBirth, String mobileNumber, Date lastUpdate, String customerName, String email,String vat, String address, Long jobTitleId, String documentId, Long id);




}
