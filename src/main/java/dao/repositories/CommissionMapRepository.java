package dao.repositories;

import dao.entities.*;
import dao.interfaces.CommissionMapInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CommissionMapRepository extends JpaRepository<CommissionMap, String>, CommissionMapInterface {


    @Query("SELECT cm FROM CommissionMap cm WHERE cm.chargeableDependents =?1 AND cm.subProduct =?2 " +
            " AND cm.status =?3 AND cm.coverage =?4")
    Optional<CommissionMap> findByChargeableDependentsPrice(int chargeableDependents, SubProduct subProduct,
                                                            Status status, Coverage coverage);

    @Query("SELECT cm.chargeableDependents,cm.netCommissionPercentage,cm.customFee,cm.insurerPremium,cm.netGPIRatio,cm.specialCommission,cm.sbFee " +
            "FROM CommissionMap cm WHERE cm.chargeableDependents =?1 AND cm.subProduct.subProductId =?2 " +
            " AND cm.status =?3 AND cm.coverage.coverageId =?4 AND cm.chargeableDependents IS NOT NULL")
    List<Object[]> findByChargeableDependents(int chargeableDependents, Long subProduct,Status status, Long coverage);

    @Query("SELECT cm FROM CommissionMap cm WHERE cm.subProduct =?1 " +
            " AND cm.status =?2")
    Optional<CommissionMap> findBySubProduct(SubProduct subProduct,Status status);

    @Query("SELECT cm.chargeableDependents,cm.netCommissionPercentage,cm.customFee,cm.insurerPremium,cm.netGPIRatio,cm.specialCommission,cm.sbFee FROM CommissionMap cm WHERE cm.subProduct.subProductId =?1 " +
            " AND cm.status =?2 AND cm.chargeableDependents IS NOT NULL")
    List<Object[]> findCommissionBySubProduct(Long subProduct, Status status);

    @Query("SELECT cm.chargeableDependents,cm.netCommissionPercentage,cm.customFee,cm.insurerPremium,cm.netGPIRatio,cm.specialCommission,cm.subProduct,cm.coverage " +
            "FROM CommissionMap cm WHERE cm.chargeableDependents =?1 AND cm.subProduct =?2 " +
            " AND cm.status =?3 AND cm.coverage =?4 AND cm.chargeableDependents IS NOT NULL")
    List<Object[]> findByChargeableDependents(Status status);

    @Query("SELECT cm.netCommissionPercentage,cm.netGPIRatio,cm.specialCommission " +
            "FROM CommissionMap cm WHERE cm.status =?1 AND cm.productId =?2")
    List<Object[]> findByChargeableDependents(Status status,String productId);

}
