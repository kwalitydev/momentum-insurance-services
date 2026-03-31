package dao.interfaces;


import dao.entities.*;

import java.util.List;
import java.util.Optional;

public interface ProductConfigInterface {
    <S extends ProductConfig> S save(S p);
    Optional<ProductConfig> findBySubProductAndStatus(SubProduct subProduct, Status status);
    List<ProductConfig> findByStatus(Status status);
    Optional<ProductConfig> findByProductConfigId(Long productConfigId);
    List<ProductConfig> findByProcessWorkflow(ProcessWorkflow processWorkflow, Users users);
    int updateProductConfigStatus(Status status, Long productConfigId);
    Integer findBenExitAge(Long subProductId, Status status);
    List<Object[]> findByHolderExitAge(Status status);
    List<Object[]> findByBenExitAge(Status status);
    Integer findNumberOfWorkers(Long subProduct, Status status);

}
