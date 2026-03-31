package dao.repositories;

import core.beans.PolicyRequest;
import core.beans.PolicyResponse;
import dao.entities.*;
import dao.interfaces.InsurancePolicyInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, String>, InsurancePolicyInterface {


    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.recordType=?3 ORDER BY ip.issueDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct =?3 AND ip.recordType=?4 ORDER BY ip.issueDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,SubProduct subProduct,String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct =?3 AND ip.policyHolder =?4 AND ip.recordType=?5 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, SubProduct subProduct, PolicyHolder policyHolder, String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct =?3 AND ip.policyHolder =?4 AND ip.users =?5 AND ip.recordType=?6 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, SubProduct subProduct, PolicyHolder policyHolder, Users userId, String recordType);


    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.users =?3 AND ip.recordType=?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Users userId,String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.recordType=?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.policyHolder =?4 AND ip.recordType=?5 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Status status, PolicyHolder policyHolder, String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.subProduct =?4 AND ip.recordType=?5 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,SubProduct subProduct,String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.users =?4 AND ip.recordType=?5 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,Users users,String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.users =?3 AND ip.subProduct =?4 AND ip.recordType=?5 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Users users,SubProduct subProduct,String recordType);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.status.id IN ?1 AND ip.recordType = ?2 AND (ip.expiryDate>=?3 OR ip.expiryDate IS NULL)")
    List<InsurancePolicy> getPoliciesToPay(List<String> status,String recordStatus,Date expiryDate);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.status.id IN ?1 AND ip.recordType = ?2 AND (ip.expiryDate>=?3 OR ip.expiryDate IS NULL) AND ip.paymentFrequency=?4")
    List<InsurancePolicy> getPoliciesToPay(List<String> status,String recordStatus,Date expiryDate,Frequency frequency);

    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, status =?2, updatedUser=?3 where policyId=?4")
    int cancelPolicy(Date lastUpdate, Status status,String users,String policyId);

    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, updatedUser=?2,coverage=?3, totalAmount=?4, subProduct =?5,expiryDate=?6 where policyId=?7")
    int updatePolicy(Date lastUpdate, String users, Coverage coverage, BigDecimal totalAmount,SubProduct subProduct,Date expiryDate,String policyId);


    @Query("SELECT ip FROM InsurancePolicy ip " +
            "WHERE ip.recordType = ?1 " +
            "AND ip.subProduct.product = ?2 "+
            "ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByRecordTypeByOrderByCreatedDateDesc(String recordType,Product subProduct);


    @Query("SELECT ip FROM InsurancePolicy ip INNER JOIN Claim c ON (ip <> c.insurancePolicy AND c.status = ?5) " +
            "WHERE ip.status = ?1 AND ip.recordType = ?2 AND ip.createdDate BETWEEN ?3 AND ?4")
    List<InsurancePolicy> getPoliciesToClaim(Status status, String recordType,Date startDate, Date endDate,Status claimStatus);


    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.status = ?1 AND ip.recordType = ?2 AND ip.createdDate BETWEEN ?3 AND ?4")
    List<InsurancePolicy> getPoliciesUnClaimed(Status status, String recordType,Date startDate, Date endDate);


    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct.product =?3 AND ip.recordType=?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Product product, String recordType, Pageable pageable);
    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct.product =?3 AND ip.status =?4 AND ip.recordType=?5 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Product product,Status status,String recordType,Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct =?3 AND ip.recordType=?4 ORDER BY ip.issueDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,SubProduct subProduct,String recordType,Pageable pageable);
    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.subProduct =?4 AND ip.recordType=?5 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,SubProduct subProduct,String recordType,Pageable pageable);




    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.subProduct.product =?3 AND ip.recordType=?4 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate, Product product, String recordType, Pageable pageable);
    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.subProduct.product =?3 AND ip.status =?4 AND ip.recordType=?5 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,Product product,Status status,String recordType,Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.subProduct =?3 AND ip.recordType=?4 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,SubProduct subProduct,String recordType,Pageable pageable);
    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.subProduct =?4 AND ip.recordType=?5 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,Status status,SubProduct subProduct,String recordType,Pageable pageable);


    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, updatedUser=?2, totalAmount=?3 where policyId=?4")
    int updatePremium(Date lastUpdate, String users, BigDecimal totalAmount,String policyId);

    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1,status=?2 where policyId=?3")
    int updatePolicyStatus(Date lastUpdate, Status status, String policyId);


    @Query("SELECT ip.policyId,ip.subProduct FROM InsurancePolicy ip WHERE ip.status = ?1 AND ip.recordType = ?2 AND ip.subProduct.product.productId =?3")
    List<Object[]> findByProductId(Status status,String recordType, String productId);


    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, status =?2, updatedUser=?3, recordType=?4,insurancePolicyId=?5 where policyId=?6")
    int activatePolicy(Date lastUpdate, Status status,String users,String recordType, String newPolicyId,String policyId);


}
