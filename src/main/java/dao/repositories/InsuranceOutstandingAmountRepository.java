package dao.repositories;

import dao.entities.InsuranceOutstandingAmount;

import dao.entities.PaymentSchedule;
import dao.interfaces.InsuranceOutstandingAmountInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InsuranceOutstandingAmountRepository extends JpaRepository<InsuranceOutstandingAmount, String>, InsuranceOutstandingAmountInterface {

    @Query("SELECT i FROM InsuranceOutstandingAmount i WHERE i.status = :status")
    List<InsuranceOutstandingAmount> findByStatus(@Param("status") String status);


    @Query(" SELECT i FROM InsuranceOutstandingAmount i WHERE i.insurancePolicy.insurancePolicyId = :insurancePolicyId " +
           " AND i.status.id = :status  ORDER BY i.entryDate DESC")
    List<InsuranceOutstandingAmount> findByInsurancePolicyId( @Param("insurancePolicyId") String insurancePolicyId,
                                                              @Param("status") String status);


    @Modifying
    @Query("UPDATE InsuranceOutstandingAmount i " +
           "SET i.status = :status, " +
           "i.lastUpdatedDate = :lastUpdatedDate, " +
           "i.paymentSchedule = :paymentSchedule " +
           "WHERE i.insuranceOutstandingAmountId IN :ids")
    int updateInsuranceOutstandingByID(
            @Param("ids") List<Long> ids,
            @Param("status") String status,
            @Param("lastUpdatedDate") Date lastUpdatedDate,
            @Param("paymentSchedule") PaymentSchedule paymentSchedule);

    @Query("SELECT i FROM InsuranceOutstandingAmount i " +
           "WHERE i.paymentSchedule.paymentScheduleId = :paymentScheduleId")
    List<InsuranceOutstandingAmount> findByPaymentScheduleId(
            @Param("paymentScheduleId") Long paymentScheduleId);

}
