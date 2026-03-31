package dao.repositories;

import dao.entities.*;
import dao.interfaces.ClaimInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public interface ClaimRepository extends JpaRepository<Claim, String>, ClaimInterface {

    @Query("SELECT c FROM Claim c WHERE c.createdDate BETWEEN ?1 AND ?2 ORDER BY c.createdDate DESC")
    List<Claim> findByDates(Date startDate,Date endDate);
    @Query("SELECT c FROM Claim c WHERE c.processWorkflow =?1 AND c.processWorkflow.userInput <> ?2")
    List<Claim> findByProcessWorkflow(ProcessWorkflow processWorkflow, Users users);

    @Modifying(clearAutomatically = true)
    @Query("update Claim set status=?1 where claimId=?2")
    int updateClaimStatus(Status status, Long claimId);


    @Modifying(clearAutomatically = true)
    @Query("update Claim set status=?1,closureDate=?2 where claimId=?3")
    int updateClaimStatus(Status status,Date lastUpdate, Long claimId);

    @Modifying(clearAutomatically = true)
    @Query("update Claim set status=?1,claimProcessId=?2,insurerPaidAmount=?3, closureDate=?4 where claimId=?5")
    int updateClaimStatus(Status status, String claimProcessId, BigDecimal insurerPaidAmount,Date lastUpdate, Long claimId);

    @Query("SELECT c FROM Claim c WHERE c.status IN ?1 AND c.insurancePolicy.subProduct.product=?2 AND c.createdDate BETWEEN ?3 AND ?4 ORDER BY c.createdDate DESC")
    List<Claim> findByStatusProductAndDates(List<Status> statuses,Product product,Date start,Date end);
    @Query("SELECT c FROM Claim c WHERE c.status IN ?1 AND c.insurancePolicy.policyId=?2 AND c.createdDate BETWEEN ?3 AND ?4 ORDER BY c.createdDate DESC")
    List<Claim> findByStatusAndDates(List<Status> statuses,String policyId,Date start,Date end);

    @Query("SELECT c FROM Claim c WHERE c.status IN ?1 AND c.createdDate BETWEEN ?2 AND ?3 AND c.insurancePolicy.subProduct=?4 ORDER BY c.createdDate DESC")
    List<Claim> findByStatusAndDates(List<Status> statuses, Date start, Date end, SubProduct subProduct);

}
