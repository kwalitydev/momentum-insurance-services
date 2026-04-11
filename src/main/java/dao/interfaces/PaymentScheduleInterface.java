package dao.interfaces;


import core.constants.PaymentStatus;
import dao.entities.*;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface PaymentScheduleInterface {

    BigDecimal getTotalCollected(Date startDate, Date endDate, Status status,SubProduct subProduct);
    BigDecimal getTotalCollected(Date startDate,Date endDate, SubProduct subProduct);

    List<PaymentSchedule> getCollectionsByInterval(Date startDate, Date endDate, Status status, SubProduct subProduct);

    List<PaymentSchedule> getUnprocessedPolicies(List<Status> statuses,Status policyStatus);
    List<PaymentSchedule> getPaymentSchedulesByPolicy(List<Status> statuses,Status policyStatus);
    int updatePayment(BigDecimal paidAmount, Date lastAttempt,Status status,String chargeCode,String transactionId,Boolean normalPayment,Long paymentScheduleId);
    List<PaymentSchedule> getUnprocessedPolicies(Status statuses);


    List<PaymentSchedule> getUnprocessedPolicies(List<Status> statuses, Status policyStatus, Product product);

    List<PaymentSchedule> checkPoliceSchedule(InsurancePolicy insurancePolicy,String month, String year);

    List<PaymentSchedule> findByInsurancePolicyAndYear(InsurancePolicy insurancePolicy, String year, List<Status> statuses, boolean normalPayment,Product product);

    List<PaymentSchedule> findByInsurancePolicyAndAttemptDate(InsurancePolicy insurancePolicy, String attemptDate);
    List<Long> getUnpaidPolicy(String policyId,String policyStatus);
    int findByInsurancePolicyAndMonth(String policyId, String month,String year, List<String> statuses, boolean normalPayment,Long subProductId);
    List<Object[]> getCollectionsByInterval(String startDate,String endDate,Status status,Long subProductId);
    List<Object[]> getCollectionsByInterval(String startDate,String endDate,String productId,String status);
    BigDecimal getTotalCollectionsByInterval(String startDate,String endDate,Status status,Long subProductId);
    BigDecimal getTotalCollectionsByInterval(String startDate,String endDate,String productId,String status);
    List<PaymentSchedule> getByPolicyId(String policyId,Date startDate, Date endDate);
    List<PaymentSchedule> getByPolicyId(String policyId,Date startDate, Date endDate,String status);

    List<PaymentSchedule> findByPolicyIdAndStatus(String policyId, String status,Date start,Date end);
    List<Object[]> getCollectedPremium(String startDate,String endDate);
    List<Object[]> getCollectedProgress(String startDate,String endDate);
    List<Object[]> getCollectionStatus(String startDate,String endDate);
    List<PaymentSchedule> findPaymentScheduleAndMonthAndYear(InsurancePolicy policy, String month, String year);
    boolean existsByPolicyIdAndMonthAndYear(String policyId, String month, String year);

    boolean existsByPolicyId( String policyId);

    List<PaymentSchedule> findByPolicyAndPaymentStatus(String insurancePolicyId, List<PaymentStatus> paymentStatuses);

}
