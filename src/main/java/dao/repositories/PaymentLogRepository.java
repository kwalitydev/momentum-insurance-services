package dao.repositories;

import dao.entities.*;
import dao.interfaces.PaymentLogInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PaymentLogRepository extends JpaRepository<PaymentLog, String>, PaymentLogInterface {


    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.policyId=?1")
    List<PaymentLog> findByPolicyId(String policyId);
    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.policyId=?1 AND pl.attemptDate BETWEEN ?2 AND ?3")
    List<PaymentLog> findByPolicyId(String policyId, Date startDate, Date endDate);

    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.policyId=?1 AND pl.attemptDate BETWEEN ?2 AND ?3 AND pl.paymentStatus =?4")
    List<PaymentLog> findByPolicyId(String policyId, Date startDate, Date endDate, String status);


    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct=?1 AND pl.attemptDate BETWEEN ?2 AND ?3")
    List<PaymentLog> findBySubProduct(SubProduct subProduct,Date startDate, Date endDate);

    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct=?1 ")
    List<PaymentLog> findBySubProduct(SubProduct subProduct);

    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct=?1 AND pl.paymentStatus =?2 ")
    List<PaymentLog> findBySubProductAndPaymentStatus(SubProduct subProduct,String paymentStatus);

    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct=?1 AND pl.attemptDate BETWEEN ?2 AND ?3 AND pl.paymentStatus=?4 ")
    List<PaymentLog> findBySubProduct(SubProduct subProduct,Date startDate, Date endDate,String paymentStatus);
    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct.product=?1 AND pl.attemptDate BETWEEN ?2 AND ?3")
    List<PaymentLog> findByProduct(Product product, Date startDate, Date endDate);

    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct.product=?1 AND pl.attemptDate BETWEEN ?2 AND ?3 AND pl.paymentStatus=?4")
    List<PaymentLog> findByProduct(Product product,Date startDate, Date endDate,String paymentStatus);



    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct.product=?1 AND" +
            " pl.attemptDate BETWEEN ?2 AND ?3")
    List<PaymentLog> findByProduct(Product product, Date startDate, Date endDate,Pageable pageable);

    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct.product=?1 AND" +
            " pl.attemptDate BETWEEN ?2 AND ?3 AND pl.paymentStatus =?4 ")
    List<PaymentLog> findByProduct(Product product, Date startDate, Date endDate,String paymentStatus,Pageable pageable);


    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct=?1 AND" +
            " pl.attemptDate BETWEEN ?2 AND ?3  AND pl.paymentStatus =?4")
    List<PaymentLog> findBySubProduct(SubProduct subProduct, Date startDate, Date endDate,String paymentStatus,Pageable pageable);

    @Query("SELECT pl FROM PaymentLog pl WHERE pl.paymentSchedule.insurancePolicy.subProduct=?1 AND" +
            " pl.attemptDate BETWEEN ?2 AND ?3")
    List<PaymentLog> findBySubProduct(SubProduct subProduct, Date startDate, Date endDate,Pageable pageable);


    @Query(value = "SELECT PS.INSURANCEPOLICY_POLICYID,S.DESCRIPTION,A.CUSTOMERID,A.CUSTOMERNAME,A.ACCOUNTNUMBER,PS.LASTATTEMPT,PS.REPAYMENTMONTH," +
            "PS.REPAYMENTYEAR,PS.TRANSACTIONID,ST.DESCRIPTION AS STATUSDESC,PS.ERRORMESSAGE,PS.PAIDAMOUNT,PS.NORMALPAYMENT FROM PAYMENTSCHEDULE PS" +
            "    INNER JOIN INSURANCE.INSURANCEPOLICY I on I.POLICYID = PS.INSURANCEPOLICY_POLICYID" +
            "    INNER JOIN SUBPRODUCT S ON (S.SUBPRODUCTID = I.SUBPRODUCT_SUBPRODUCTID)" +
            "    INNER JOIN ACCOUNT A ON (A.ID = I.ACCOUNT_ID)" +
            "    INNER JOIN STATUS ST ON (ST.ID = PS.STATUS_ID)" +
            "    INNER JOIN PRODUCT P ON (P.PRODUCTID = S.PRODUCT_PRODUCTID)   " +
            " WHERE P.PRODUCTID = ?1 AND TRUNC(PS.LASTATTEMPT) BETWEEN TO_DATE(?2,'dd/mm/yyyy') AND TO_DATE(?3,'dd/mm/yyyy')",nativeQuery = true)
    List<Object[]> findByProduct(String productId, String startDate, String endDate,Pageable pageable);

    @Query(value = "SELECT PS.INSURANCEPOLICY_POLICYID,S.DESCRIPTION,A.CUSTOMERID,A.CUSTOMERNAME,A.ACCOUNTNUMBER,PS.LASTATTEMPT,PS.REPAYMENTMONTH," +
            "PS.REPAYMENTYEAR,PS.TRANSACTIONID,ST.DESCRIPTION AS STATUSDESC,PS.ERRORMESSAGE,PS.PAIDAMOUNT,PS.NORMALPAYMENT FROM PAYMENTSCHEDULE PS" +
            "    INNER JOIN INSURANCE.INSURANCEPOLICY I on I.POLICYID = PS.INSURANCEPOLICY_POLICYID" +
            "    INNER JOIN SUBPRODUCT S ON (S.SUBPRODUCTID = I.SUBPRODUCT_SUBPRODUCTID)" +
            "    INNER JOIN ACCOUNT A ON (A.ID = I.ACCOUNT_ID)" +
            "    INNER JOIN STATUS ST ON (ST.ID = PS.STATUS_ID)" +
            "    INNER JOIN PRODUCT P ON (P.PRODUCTID = S.PRODUCT_PRODUCTID)   " +
            " WHERE P.PRODUCTID = ?1 AND TRUNC(PS.LASTATTEMPT) BETWEEN TO_DATE(?2,'dd/mm/yyyy') AND TO_DATE(?3,'dd/mm/yyyy') AND PS.STATUS_ID=?4",nativeQuery = true)
    List<Object[]> findByProduct(String productId, String startDate, String endDate,String paymentStatus,Pageable pageable);

    @Query(value = "SELECT PS.INSURANCEPOLICY_POLICYID,S.DESCRIPTION,A.CUSTOMERID,A.CUSTOMERNAME,A.ACCOUNTNUMBER,PS.LASTATTEMPT,PS.REPAYMENTMONTH," +
            "PS.REPAYMENTYEAR,PS.TRANSACTIONID,ST.DESCRIPTION AS STATUSDESC,PS.ERRORMESSAGE,PS.PAIDAMOUNT,PS.NORMALPAYMENT FROM PAYMENTSCHEDULE PS" +
            "    INNER JOIN INSURANCE.INSURANCEPOLICY I on I.POLICYID = PS.INSURANCEPOLICY_POLICYID" +
            "    INNER JOIN SUBPRODUCT S ON (S.SUBPRODUCTID = I.SUBPRODUCT_SUBPRODUCTID)" +
            "    INNER JOIN ACCOUNT A ON (A.ID = I.ACCOUNT_ID)" +
            "    INNER JOIN STATUS ST ON (ST.ID = PS.STATUS_ID)" +
            "    INNER JOIN PRODUCT P ON (P.PRODUCTID = S.PRODUCT_PRODUCTID)   " +
            " WHERE S.SUBPRODUCTID = ?1 AND TRUNC(PS.LASTATTEMPT) BETWEEN TO_DATE(?2,'dd/mm/yyyy') AND TO_DATE(?3,'dd/mm/yyyy')",nativeQuery = true)
    List<Object[]> findBySubProduct(Long subProductId, String startDate, String endDate,Pageable pageable);

    @Query(value = "SELECT PS.INSURANCEPOLICY_POLICYID,S.DESCRIPTION,A.CUSTOMERID,A.CUSTOMERNAME,A.ACCOUNTNUMBER,PS.LASTATTEMPT,PS.REPAYMENTMONTH," +
            "PS.REPAYMENTYEAR,PS.TRANSACTIONID,ST.DESCRIPTION AS STATUSDESC,PS.ERRORMESSAGE,PS.PAIDAMOUNT,PS.NORMALPAYMENT FROM PAYMENTSCHEDULE PS" +
            "    INNER JOIN INSURANCE.INSURANCEPOLICY I on I.POLICYID = PS.INSURANCEPOLICY_POLICYID" +
            "    INNER JOIN SUBPRODUCT S ON (S.SUBPRODUCTID = I.SUBPRODUCT_SUBPRODUCTID)" +
            "    INNER JOIN ACCOUNT A ON (A.ID = I.ACCOUNT_ID)" +
            "    INNER JOIN STATUS ST ON (ST.ID = PS.STATUS_ID)" +
            "    INNER JOIN PRODUCT P ON (P.PRODUCTID = S.PRODUCT_PRODUCTID)   " +
            " WHERE S.SUBPRODUCTID = ?1 AND TRUNC(PS.LASTATTEMPT) BETWEEN TO_DATE(?2,'dd/mm/yyyy') AND TO_DATE(?3,'dd/mm/yyyy') AND PS.STATUS_ID=?4",nativeQuery = true)
    List<Object[]> findBySubProduct(Long subProductId, String startDate, String endDate,String paymentStatus,Pageable pageable);



    @Query(value = "SELECT PS.INSURANCEPOLICY_POLICYID,S.DESCRIPTION,A.CUSTOMERID,A.CUSTOMERNAME,A.ACCOUNTNUMBER,PS.LASTATTEMPT,PS.REPAYMENTMONTH," +
            "PS.REPAYMENTYEAR,PS.TRANSACTIONID,ST.DESCRIPTION AS STATUSDESC,PS.ERRORMESSAGE,PS.PAIDAMOUNT,PS.NORMALPAYMENT FROM PAYMENTSCHEDULE PS" +
            "    INNER JOIN INSURANCE.INSURANCEPOLICY I on I.POLICYID = PS.INSURANCEPOLICY_POLICYID" +
            "    INNER JOIN SUBPRODUCT S ON (S.SUBPRODUCTID = I.SUBPRODUCT_SUBPRODUCTID)" +
            "    INNER JOIN ACCOUNT A ON (A.ID = I.ACCOUNT_ID)" +
            "    INNER JOIN STATUS ST ON (ST.ID = PS.STATUS_ID)" +
            "    INNER JOIN PRODUCT P ON (P.PRODUCTID = S.PRODUCT_PRODUCTID)   " +
            " WHERE PS.INSURANCEPOLICY_POLICYID = ?1 AND TRUNC(PS.LASTATTEMPT) BETWEEN TO_DATE(?2,'dd/mm/yyyy') AND TO_DATE(?3,'dd/mm/yyyy')",nativeQuery = true)
    List<Object[]> findByPolicyId(String policyId,String startDate, String endDate,Pageable pageable);




}
