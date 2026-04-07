package dao.repositories;

import core.beans.PolicyCountByMonth;
import core.beans.PolicyDashboardStats;
import dao.entities.*;
import dao.interfaces.InsurancePolicyInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, String>, InsurancePolicyInterface {


    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 ORDER BY ip.issueDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct =?3 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, SubProduct subProduct);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Status status);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.policyHolder =?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Status status, PolicyHolder policyHolder);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.subProduct =?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Status status, SubProduct subProduct);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.users =?3 AND ip.subProduct =?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Users users, SubProduct subProduct);


    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, status =?2, updatedUser=?3 where policyId=?4")
    int cancelPolicy(Date lastUpdate, Status status, String users, String policyId);

    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, updatedUser=?2,coverage=?3, totalAmount=?4, subProduct =?5,expiryDate=?6 where policyId=?7")
    int updatePolicy(Date lastUpdate, String users, Coverage coverage, BigDecimal totalAmount, SubProduct subProduct, Date expiryDate, String policyId);

    @Query("SELECT ip FROM InsurancePolicy ip INNER JOIN Claim c ON (ip <> c.insurancePolicy AND c.status = ?4) " +
           "WHERE ip.status = ?1 AND ip.createdDate BETWEEN ?2 AND ?3")
    List<InsurancePolicy> getPoliciesToClaim(Status status, Date startDate, Date endDate, Status claimStatus);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.status = ?1 AND ip.createdDate BETWEEN ?2 AND ?3")
    List<InsurancePolicy> getPoliciesUnClaimed(Status status, Date startDate, Date endDate);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct.product =?3 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Product product, Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct =?3 AND ip.status =?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, SubProduct subProduct, Status status);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.subProduct =?3 ORDER BY ip.issueDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, SubProduct subProduct, Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.issueDate BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.subProduct =?4 ORDER BY ip.createdDate DESC")
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Status status, SubProduct subProduct, Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.subProduct.product =?3 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate, Product product, Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.subProduct.product =?3 AND ip.status =?4 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate, Product product, Status status, Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.subProduct =?3 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate, SubProduct subProduct, Pageable pageable);

    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.lastUpdated BETWEEN ?1 AND ?2 AND ip.status =?3 AND ip.subProduct =?4 ORDER BY ip.lastUpdated DESC")
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate, Status status, SubProduct subProduct, Pageable pageable);


    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, updatedUser=?2, totalAmount=?3 where policyId=?4")
    int updatePremium(Date lastUpdate, String users, BigDecimal totalAmount, String policyId);

    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1,status=?2 where policyId=?3")
    int updatePolicyStatus(Date lastUpdate, Status status, String policyId);


    @Query("SELECT ip.policyId,ip.subProduct FROM InsurancePolicy ip WHERE ip.status = ?1 AND ip.recordType = ?2 AND ip.subProduct.product.productId =?3")
    List<Object[]> findByProductId(Status status, String recordType, String productId);


    @Modifying(clearAutomatically = true)
    @Query("update InsurancePolicy set lastUpdated=?1, status =?2, updatedUser=?3, recordType=?4,insurancePolicyId=?5 where policyId=?6")
    int activatePolicy(Date lastUpdate, Status status, String users, String recordType, String newPolicyId, String policyId);

    @Query("SELECT new core.beans.PolicyCountByMonth(" +
           "MONTH(p.createdDate), COUNT(p)) " +
           "FROM InsurancePolicy p " +
           "WHERE YEAR(p.createdDate) = ?1 " +
           "GROUP BY MONTH(p.createdDate) " +
           "ORDER BY MONTH(p.createdDate)")
    List<PolicyCountByMonth> countPoliciesByMonth(int year);

    @Query("SELECT new core.beans.PolicyDashboardStats(" +
           "COUNT(p), " +
           "COALESCE(SUM(CASE WHEN p.status.id = 'ACTIVE' THEN 1 ELSE 0 END),0), " +
           "COALESCE(SUM(CASE WHEN p.status.id = 'CANCELLED' THEN 1 ELSE 0 END),0), " +
           "COALESCE(SUM(CASE WHEN p.status.id = 'SUSPENDED' THEN 1 ELSE 0 END),0)) " +
           "FROM InsurancePolicy p")
    PolicyDashboardStats countDashboardStatsDTO();


    @Query("SELECT p FROM InsurancePolicy p " +
           "WHERE p.insurancePolicyId = :insurancePolicyId AND p.policyHolder.mobileNumber = :mobile")
    InsurancePolicy findByPolicyIdAndPolicyHolderMobileNumber(@Param("insurancePolicyId") String insurancePolicyId,
                                         @Param("mobile") String mobile);

    @Query("SELECT p FROM InsurancePolicy p " +
           "JOIN FETCH p.policyHolder ph " +
           "WHERE ph.mobileNumber = :mobile")
    List<InsurancePolicy> findByMobileNumber(@Param("mobile") String mobile);

    @Query("SELECT p FROM InsurancePolicy p " +
           "JOIN FETCH p.policyHolder ph " +
           "WHERE ph.mobileNumber = :mobile " +
           "AND p.insurancePolicyId = :insurancePolicyId")
    Optional<InsurancePolicy> findOneWithPolicyHolder(@Param("mobile") String mobile,
                                                      @Param("insurancePolicyId") String insurancePolicyId);

    @Query("SELECT p FROM InsurancePolicy p " +
           "JOIN FETCH p.benefitCycle bc " +
           "JOIN FETCH p.policyHolder ph " +
           "WHERE p.expiryDate > CURRENT_TIMESTAMP " +
           "AND p.status.id = :status " )
    List<InsurancePolicy> findActivePoliciesByStatus(@Param("status") String status);

    @Query("SELECT p FROM InsurancePolicy p WHERE p.insurancePolicyId = :insurancePolicyId")
    Optional<InsurancePolicy> findByInsurancePolicyId(@Param("insurancePolicyId") String insurancePolicyId);

}
