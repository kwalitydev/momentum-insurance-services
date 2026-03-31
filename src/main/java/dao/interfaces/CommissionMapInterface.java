package dao.interfaces;


import dao.entities.CommissionMap;
import dao.entities.Coverage;
import dao.entities.Status;
import dao.entities.SubProduct;

import java.util.List;
import java.util.Optional;

public interface CommissionMapInterface {
    CommissionMap save(CommissionMap commissionMap);
    Optional<CommissionMap> findByChargeableDependentsPrice(int chargeableDependents, SubProduct subProduct,
                                                            Status status, Coverage coverage);
    List<Object[]> findByChargeableDependents(int chargeableDependents, Long subProduct,Status status, Long coverage);

    Optional<CommissionMap> findBySubProduct(SubProduct subProduct,Status status);
    List<Object[]> findCommissionBySubProduct(Long subProduct, Status status);
    List<Object[]> findByChargeableDependents(Status status);
    List<Object[]> findByChargeableDependents(Status status,String productId);

}
