package dao.repositories;

import core.constants.PaymentStatus;
import dao.entities.*;
import dao.enums.InvoiceType;
import dao.enums.PaymentMethodStatus;
import dao.interfaces.PaymentScheduleInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentScheduleRepository extends JpaRepository<PaymentSchedule, String>, PaymentScheduleInterface {

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.insurancePolicy = ?1 AND ps.repaymentMonth=?2 AND ps.repaymentYear=?3 AND ps.status IN ?4 AND ps.normalPayment =?5")
    List<PaymentSchedule> findByInsurancePolicyAndMonth(InsurancePolicy insurancePolicy, String month, String year, List<Status> statuses, boolean normalPayment);

    @Query("SELECT count(ps) from PaymentSchedule ps WHERE ps.insurancePolicy.policyId = ?1 AND ps.repaymentMonth=?2 AND ps.repaymentYear=?3 AND ps.status.id IN ?4 AND ps.normalPayment =?5 AND " +
           "ps.insurancePolicy.subProduct.subProductId=?6")
    int findByInsurancePolicyAndMonth(String policyId, String month, String year, List<String> statuses, boolean normalPayment, Long subProductId);

    @Query("SELECT SUM(ps.paidAmount) from PaymentSchedule ps WHERE ps.createdDate BETWEEN ?1 AND ?2 AND ps.status=?3 AND ps.insurancePolicy.subProduct=?4")
    BigDecimal getTotalCollected(Date startDate, Date endDate, Status status, SubProduct subProduct);

    @Query("SELECT SUM(ps.paidAmount) from PaymentSchedule ps WHERE ps.createdDate BETWEEN ?1 AND ?2 AND ps.insurancePolicy.subProduct=?3")
    BigDecimal getTotalCollected(Date startDate, Date endDate, SubProduct subProduct);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.createdDate BETWEEN ?1 AND ?2 AND ps.status=?3 AND ps.insurancePolicy.subProduct=?4")
    List<PaymentSchedule> getCollectionsByInterval(Date startDate, Date endDate, Status status, SubProduct subProduct);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.status IN ?1 AND ps.insurancePolicy.status=?2 ORDER BY ps.createdDate")
    List<PaymentSchedule> getUnprocessedPolicies(List<Status> statuses, Status policyStatus);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.status IN ?1 AND ps.insurancePolicy.status=?2 AND ps.insurancePolicy.subProduct.product=?3 ORDER BY ps.createdDate")
    List<PaymentSchedule> getUnprocessedPolicies(List<Status> statuses, Status policyStatus, Product product);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.status = ?1 ORDER BY ps.createdDate")
    List<PaymentSchedule> getUnprocessedPolicies(Status statuses);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.status IN ?1 AND ps.insurancePolicy.status=?2")
    List<PaymentSchedule> getPaymentSchedulesByPolicy(List<Status> statuses, Status policyStatus);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.paymentScheduleId=?2")
    List<PaymentSchedule> findByPaymentSchedule(Long paymentScheduleId);

    @Modifying(clearAutomatically = true)
    @Query("update PaymentSchedule set paidAmount=?1, lastAttempt=?2, status =?3, chargeCode=?4,transactionId=?5,normalPayment=?6 where paymentScheduleId=?7")
    int updatePayment(BigDecimal paidAmount, Date lastAttempt, Status status, String chargeCode, String transactionId, Boolean normalPayment, Long paymentScheduleId);

    @Query("SELECT ps.paymentScheduleId from PaymentSchedule ps WHERE ps.insurancePolicy.policyId =?1 AND ps.status.id = ?2 ORDER BY ps.createdDate")
    List<Long> getUnpaidPolicy(String policyId, String policyStatus);


    @Query("SELECT ps from PaymentSchedule ps WHERE ps.insurancePolicy =?1 AND ps.repaymentMonth = ?2 AND ps.repaymentYear =?3")
    List<PaymentSchedule> checkPoliceSchedule(InsurancePolicy insurancePolicy, String month, String year);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.insurancePolicy = ?1 AND ps.repaymentYear=?2 AND ps.status IN ?3 AND ps.normalPayment =?4 AND " +
           "ps.insurancePolicy.subProduct.product=?5")
    List<PaymentSchedule> findByInsurancePolicyAndYear(InsurancePolicy insurancePolicy, String year, List<Status> statuses, boolean normalPayment, Product product);


    @Query("SELECT ps FROM PaymentSchedule ps WHERE ps.insurancePolicy = ?1  AND to_char(ps.lastAttempt,'DD-MM-YYYY') =?2")
    List<PaymentSchedule> findByInsurancePolicyAndAttemptDate(InsurancePolicy insurancePolicy, String attemptDate);

    @Query(value = "SELECT ip.SUBPRODUCT_SUBPRODUCTID,ip.TOTALCHARGEABLEDEPENDENTS,ip.COVERAGE_COVERAGEID,ip.POLICYID,s.NAME,ac.CUSTOMERID," +
                   " ac.CUSTOMERNAME,ac.ACCOUNTNUMBER,ip.TOTALAMOUNT,ip.CURRENCY_CURRENCYID,ps.TRANSACTIONID,s.HASCHARGEABLEDEPENDENTS,s.HASSTAMPDUTY,p.DESCRIPTION,ip.NUMBEROFEMPLOYEES," +
                   "p.PRODUCTID,p.ATTRIBUTES,ip.INSUREDAMOUNT,ip.RISKRATE,c.COVERAMOUNT,ip.ANNUALPAYROLL" +
                   " from PAYMENTSCHEDULE ps" +
                   " INNER JOIN INSURANCEPOLICY ip ON (ps.INSURANCEPOLICY_POLICYID = ip.POLICYID)" +
                   " INNER JOIN ACCOUNT ac ON (ac.ID = ip.ACCOUNT_ID)" +
                   " INNER JOIN SUBPRODUCT s ON (s.SUBPRODUCTID = ip.SUBPRODUCT_SUBPRODUCTID)" +
                   " INNER JOIN PRODUCT p ON (s.PRODUCT_PRODUCTID = p.PRODUCTID)" +
                   " RIGHT JOIN COVERAGE c ON  (c.COVERAGEID = ip.COVERAGE_COVERAGEID)" +
                   " WHERE  TRUNC(ps.LASTATTEMPT) BETWEEN TO_DATE(?1,'dd/mm/yyyy') AND TO_DATE(?2,'dd/mm/yyyy')" +
                   " AND ps.STATUS_ID=?3 AND ip.SUBPRODUCT_SUBPRODUCTID=?4 ORDER BY ps.LASTATTEMPT", nativeQuery = true)
    List<Object[]> getCollectionsByInterval(String startDate, String endDate, Status status, Long subProductId);

    @Query(value = "SELECT ip.SUBPRODUCT_SUBPRODUCTID,ip.TOTALCHARGEABLEDEPENDENTS,ip.COVERAGE_COVERAGEID,ip.POLICYID,s.NAME,ac.CUSTOMERID," +
                   "            ac.CUSTOMERNAME,ac.ACCOUNTNUMBER,ip.TOTALAMOUNT,ip.CURRENCY_CURRENCYID,ps.TRANSACTIONID,s.HASCHARGEABLEDEPENDENTS,s.HASSTAMPDUTY,p.DESCRIPTION," +
                   "            ip.NUMBEROFEMPLOYEES,p.PRODUCTID,p.ATTRIBUTES,ip.INSUREDAMOUNT,ip.RISKRATE,c.COVERAMOUNT,ip.ANNUALPAYROLL" +
                   "            from PAYMENTSCHEDULE ps" +
                   "            INNER JOIN INSURANCEPOLICY ip ON (ps.INSURANCEPOLICY_POLICYID = ip.POLICYID)" +
                   "            INNER JOIN ACCOUNT ac ON (ac.ID = ip.ACCOUNT_ID)" +
                   "            INNER JOIN SUBPRODUCT s ON (s.SUBPRODUCTID = ip.SUBPRODUCT_SUBPRODUCTID)" +
                   "            INNER JOIN PRODUCT p ON (s.PRODUCT_PRODUCTID = p.PRODUCTID)" +
                   "            RIGHT JOIN COVERAGE c ON  (c.COVERAGEID = ip.COVERAGE_COVERAGEID)" +
                   "            WHERE  TRUNC(ps.LASTATTEMPT) BETWEEN TO_DATE(?1,'dd/mm/yyyy') AND TO_DATE(?2,'dd/mm/yyyy')" +
                   "            AND ps.STATUS_ID=?4 AND p.PRODUCTID=?3 ORDER BY ps.LASTATTEMPT", nativeQuery = true)
    List<Object[]> getCollectionsByInterval(String startDate, String endDate, String productId, String status);

    @Query(value = "SELECT SUM(ip.TOTALAMOUNT)" +
                   " from PAYMENTSCHEDULE ps" +
                   " INNER JOIN INSURANCEPOLICY ip ON (ps.INSURANCEPOLICY_POLICYID = ip.POLICYID)" +
                   " WHERE  TRUNC(ps.LASTATTEMPT) BETWEEN TO_DATE(?1,'dd/mm/yyyy') AND TO_DATE(?2,'dd/mm/yyyy')" +
                   " AND ps.STATUS_ID=?3 AND ip.SUBPRODUCT_SUBPRODUCTID=?4 ORDER BY ps.LASTATTEMPT", nativeQuery = true)
    BigDecimal getTotalCollectionsByInterval(String startDate, String endDate, Status status, Long subProductId);

    @Query(value = "SELECT SUM(ip.TOTALAMOUNT)" +
                   "            from PAYMENTSCHEDULE ps" +
                   "            INNER JOIN INSURANCEPOLICY ip ON (ps.INSURANCEPOLICY_POLICYID = ip.POLICYID)" +
                   "            INNER JOIN SUBPRODUCT s ON (s.SUBPRODUCTID = ip.SUBPRODUCT_SUBPRODUCTID)" +
                   "            INNER JOIN PRODUCT p ON (s.PRODUCT_PRODUCTID = p.PRODUCTID)" +
                   "            WHERE  TRUNC(ps.LASTATTEMPT) BETWEEN TO_DATE(?1,'dd/mm/yyyy') AND TO_DATE(?2,'dd/mm/yyyy')" +
                   "            AND ps.STATUS_ID=?4 AND p.PRODUCTID=?3 ORDER BY ps.LASTATTEMPT", nativeQuery = true)
    BigDecimal getTotalCollectionsByInterval(String startDate, String endDate, String productId, String status);


    @Query("SELECT ps from PaymentSchedule ps WHERE ps.insurancePolicy.policyId = ?1 AND ps.lastAttempt BETWEEN ?2 AND ?3 ORDER BY ps.createdDate DESC")
    List<PaymentSchedule> getByPolicyId(String policyId, Date startDate, Date endDate);

    @Query("SELECT ps from PaymentSchedule ps WHERE ps.insurancePolicy.policyId = ?1 AND ps.lastAttempt BETWEEN ?2 AND ?3 AND ps.status.id=?4 ORDER BY ps.createdDate DESC")
    List<PaymentSchedule> getByPolicyId(String policyId, Date startDate, Date endDate, String status);


    @Query("SELECT pl FROM PaymentSchedule pl WHERE pl.insurancePolicy.policyId=?1 AND pl.status.id =?2 AND pl.lastAttempt BETWEEN ?3 AND ?4 ")
    List<PaymentSchedule> findByPolicyIdAndStatus(String policyId, String status, Date start, Date end);


    //metrics

    @Query(value = "SELECT P.DESCRIPTION,SUM(PS.PAIDAMOUNT) AS TOTAL_CHARGED " +
                   "FROM PAYMENTSCHEDULE PS " +
                   "JOIN INSURANCEPOLICY IP ON PS.INSURANCEPOLICY_POLICYID = IP.POLICYID " +
                   "JOIN SUBPRODUCT SP ON IP.SUBPRODUCT_SUBPRODUCTID = SP.SUBPRODUCTID " +
                   "INNER JOIN PRODUCT P ON SP.PRODUCT_PRODUCTID = P.PRODUCTID " +
                   "WHERE PS.CREATEDDATE BETWEEN TO_DATE(?1,'dd/mm/yyyy') AND TO_DATE(?2,'dd/mm/yyyy') " +
                   "GROUP BY P.DESCRIPTION ORDER BY P.DESCRIPTION ", nativeQuery = true)
    List<Object[]> getCollectedPremium(String startDate, String endDate);


    @Query(value = "WITH eligible_policies AS ( " +
                   "    SELECT  ip.policyid,sp.PRODUCT_PRODUCTID AS product_id " +
                   "    FROM InsurancePolicy ip " +
                   "             JOIN SubProduct sp ON sp.SUBPRODUCTID = ip.SUBPRODUCT_SUBPRODUCTID " +
                   "             join PRODUCT p ON p.PRODUCTID = sp.PRODUCT_PRODUCTID AND p.PRODUCTTYPE <> 'EMBEDDED' " +
                   "    WHERE ip.RECORDTYPE = 'COMMITTED' " +
                   "      AND ip.STATUS_ID = 'ACTIVE' " +
                   "      AND NOT EXISTS ( " +
                   "            SELECT 1 " +
                   "            FROM PaymentSchedule ps_prev " +
                   "            WHERE ps_prev.INSURANCEPOLICY_POLICYID = ip.POLICYID " +
                   "              AND ps_prev.STATUS_ID = 'UNPAID' " +
                   "        ) " +
                   "), " +
                   "     collected_this_month AS ( " +
                   "         SELECT DISTINCT " +
                   "             ps.INSURANCEPOLICY_POLICYID " +
                   "         FROM PaymentSchedule ps " +
                   "         WHERE ps.CREATEDDATE BETWEEN " +
                   "                   TO_DATE(?1,'dd/mm/yyyy') " +
                   "                   AND TO_DATE(?2,'dd/mm/yyyy') " +
                   "     ), " +
                   "     final_counts AS ( " +
                   "         SELECT " +
                   "             ep.product_id, " +
                   "             COUNT(ep.policyid) AS total_policy, " +
                   "             COUNT(ctm.INSURANCEPOLICY_POLICYID) AS total_policy_collected " +
                   "         FROM eligible_policies ep " +
                   "                  LEFT JOIN collected_this_month ctm " +
                   "                            ON ep.policyid = ctm.INSURANCEPOLICY_POLICYID " +
                   "         GROUP BY ep.product_id " +
                   "     ) " +
                   "SELECT " +
                   "    product_id, " +
                   "    total_policy, " +
                   "    total_policy_collected, " +
                   "    CASE " +
                   "        WHEN total_policy = 0 THEN 0 " +
                   "        ELSE ROUND((total_policy_collected / total_policy) * 100, 2) " +
                   "        END AS collection_progress_percentage " +
                   "FROM final_counts " +
                   "ORDER BY product_id ", nativeQuery = true)
    List<Object[]> getCollectedProgress(String startDate, String endDate);


    @Query(value = " SELECT sp.PRODUCT_PRODUCTID AS product_id,COUNT(*) AS total_records, " +
                   "    SUM(CASE " +
                   "            WHEN ps.STATUS_ID = 'PAID' " +
                   "                THEN 1 " +
                   "            ELSE 0 " +
                   "        END) AS total_paid, " +
                   "    SUM(CASE " +
                   "            WHEN ps.STATUS_ID IN ('FAILED', 'ERROR','UNPAID') " +
                   "                THEN 1 " +
                   "            ELSE 0 " +
                   "        END) AS total_unpaid, " +
                   "    CASE " +
                   "        WHEN COUNT(*) = 0 THEN 0 " +
                   "        ELSE ROUND( " +
                   "                    (SUM(CASE WHEN ps.STATUS_ID = 'PAID' THEN 1 ELSE 0 END) " +
                   "                        / COUNT(*) ) * 100 " +
                   "            , 2) " +
                   "        END                                         AS success_rate_pct, " +
                   "    CASE " +
                   "        WHEN COUNT(*) = 0 THEN 0 " +
                   "        ELSE ROUND( " +
                   "                    (SUM(CASE WHEN ps.STATUS_ID IN ('FAILED', 'ERROR','UNPAID') THEN 1 ELSE 0 END) " +
                   "                        / COUNT(*) ) * 100 " +
                   "            , 2) " +
                   "        END AS error_rate_pct" +
                   " FROM PaymentSchedule ps " +
                   "         JOIN InsurancePolicy ip " +
                   "              ON ip.POLICYID = ps.INSURANCEPOLICY_POLICYID " +
                   "         JOIN SubProduct sp " +
                   "              ON sp.SUBPRODUCTID = ip.SUBPRODUCT_SUBPRODUCTID " +
                   "         JOIN PRODUCT p on p.PRODUCTID = sp.PRODUCT_PRODUCTID and p.PRODUCTTYPE <> 'EMBEDDED' " +
                   " WHERE TRUNC(ps.CREATEDDATE) BETWEEN " +
                   "          TO_DATE(?1,'dd/mm/yyyy')" +
                   "          AND TO_DATE(?2,'dd/mm/yyyy') " +
                   " GROUP BY sp.PRODUCT_PRODUCTID " +
                   " ORDER BY sp.PRODUCT_PRODUCTID ", nativeQuery = true)
    List<Object[]> getCollectionStatus(String startDate, String endDate);


    @Query("SELECT p FROM PaymentSchedule p " +
           "WHERE p.paymentStatus= :status " +
           "ORDER BY p.lastAttempt DESC")
    List<PaymentSchedule> findLastPayments(
            @Param("status") PaymentStatus status,
            Pageable pageable
    );


    @Query("SELECT p.paymentMethodStatus, " +
           "COALESCE(SUM(p.paidAmount), 0) " +
           "FROM PaymentSchedule p " +
           "WHERE p.paymentStatus = :status " +
           "AND FUNCTION('YEAR', p.paymentDate) = :year " +
           "AND FUNCTION('MONTH', p.paymentDate) = :month " +
           "GROUP BY p.paymentMethodStatus")
    List<Object[]> sumPaidAmountByMethodForMonth(
            @Param("status") PaymentStatus status,
            @Param("year") int year,
            @Param("month") int month
    );

    @Query("SELECT COALESCE(SUM(p.paidAmount), 0) " +
           "FROM PaymentSchedule p " +
           "WHERE p.paymentStatus = :status " +
           "AND p.paymentDate >= :startDate " +
           "AND p.paymentDate < :endDate")
    BigDecimal sumPaidAmountForPeriod(
            @Param("status") PaymentStatus status,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );


    @Query("SELECT p.paymentDate, p.paidAmount" +
           "       FROM PaymentSchedule p " +
           "       WHERE p.paymentStatus = :status " +
           "       AND p.paymentDate >= :start " +
           "       AND p.paymentDate < :end")
    List<Object[]> sumPaidAmountByDay(
            @Param("status") PaymentStatus status,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query(" SELECT MONTH(p.paymentDate), COALESCE(SUM(p.paidAmount), 0)" +
           "       FROM PaymentSchedule p " +
           "       WHERE p.paymentStatus = :status " +
           "       AND p.paymentDate >= :start " +
           "       AND p.paymentDate < :end " +
           "       GROUP BY MONTH(p.paymentDate) " +
           "       ORDER BY MONTH(p.paymentDate)")
    List<Object[]> sumPaidAmountByMonth(
            @Param("status") PaymentStatus status,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );

    @Query("SELECT p FROM PaymentSchedule p " +
           "WHERE p.insurancePolicy = :policy " +
           "AND p.repaymentMonth = :month " +
           "AND p.repaymentYear = :year")
    List<PaymentSchedule> findPaymentScheduleAndMonthAndYear(
            @Param("policy") InsurancePolicy policy,
            @Param("month") String month,
            @Param("year") String year);

    @Query("SELECT CASE WHEN COUNT(ps) > 0 THEN true ELSE false END " +
           "FROM PaymentSchedule ps " +
           "WHERE ps.insurancePolicy.insurancePolicyId = :insurancePolicyId " +
           "AND ps.repaymentMonth = :month " +
           "AND ps.invoiceType = :invoiceType " +

           "AND ps.repaymentYear = :year")
    boolean existsByPolicyIdAndMonthAndYear(
            @Param("insurancePolicyId") String insurancePolicyId,
            @Param("month") String month,
            @Param("year") String year,
            @Param("invoiceType") InvoiceType invoiceType
    );

    @Query("SELECT CASE WHEN COUNT(ps) > 0 THEN true ELSE false END " +
           "FROM PaymentSchedule ps " +
           "WHERE ps.insurancePolicy.insurancePolicyId = :insurancePolicyId ")
    boolean existsByPolicyId(@Param("insurancePolicyId") String insurancePolicyId);

    @Query("SELECT ps FROM PaymentSchedule ps " +
           "WHERE ps.insurancePolicy.insurancePolicyId = :insurancePolicyId " +
           "AND ps.paymentStatus IN :paymentStatuses")
    List<PaymentSchedule> findByPolicyAndPaymentStatus(
            @Param("insurancePolicyId") String insurancePolicyId,
            @Param("paymentStatuses") List<PaymentStatus> paymentStatuses);

    @Query("SELECT ps FROM PaymentSchedule ps " +
           "WHERE ps.invoiceType = :status " +
           "ORDER BY ps.createdDate DESC")
    List<PaymentSchedule> findLatestByStatus(
            @Param("status") InvoiceType status);


    @Query("SELECT ps FROM PaymentSchedule ps " +
           "WHERE ps.paymentScheduleId = :id")
    Optional<PaymentSchedule> findByPaymentScheduleId(@Param("id") Long id);


    @Modifying
    @Query("UPDATE PaymentSchedule ps SET " +
           "ps.transactionId = :transactionId, " +
           "ps.paymentDate = :paymentDate, " +
           "ps.paymentMethodStatus = :paymentMethodStatus, " +
           "ps.paymentStatus = :paymentStatus, " +
           "ps.paidAmount = :paidAmount, " +
           "ps.operatorMessage = :operatorMessage, " +
           "ps.externalTransactionId = :externalTransactionId " +
           "WHERE ps.paymentScheduleId = :id")
    int updatePaymentSchedule(
            @Param("id") Long id,
            @Param("transactionId") String transactionId,
            @Param("paymentDate") LocalDateTime paymentDate,
            @Param("paymentMethodStatus") PaymentMethodStatus paymentMethodStatus,
            @Param("paymentStatus") PaymentStatus paymentStatus,
            @Param("paidAmount") BigDecimal paidAmount,
            @Param("operatorMessage") String operatorMessage,
            @Param("externalTransactionId") String externalTransactionId
    );
}
