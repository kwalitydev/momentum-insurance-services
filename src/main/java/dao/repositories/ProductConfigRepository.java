package dao.repositories;

import dao.entities.*;
import dao.interfaces.ProductConfigInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductConfigRepository extends JpaRepository<ProductConfig, String>, ProductConfigInterface {

    @Modifying(clearAutomatically = true)
    @Query("update ProductConfig set status=?1 where productConfigId=?2")
    int updateProductConfigStatus(Status status, Long productConfigId);

    @Query("SELECT pc FROM ProductConfig pc WHERE pc.processWorkflow=?1 AND pc.processWorkflow.userInput <> ?2")
    List<ProductConfig> findByProcessWorkflow(ProcessWorkflow processWorkflow, Users users);

    @Query("SELECT pc FROM ProductConfig pc WHERE pc.subProduct = ?1 AND pc.status=?2")
    Optional<ProductConfig> findBySubProductAndStatus(SubProduct subProduct, Status status);

    @Query("SELECT pc.benExitAge FROM ProductConfig pc WHERE pc.subProduct.subProductId = ?1 AND pc.status=?2")
    Integer findBenExitAge(Long subProduct, Status status);

    @Query("SELECT pc.holderExitAge,pc.subProduct FROM ProductConfig pc WHERE pc.holderExitAge IS NOT NULL and pc.status =?1")
    List<Object[]> findByHolderExitAge(Status status);

    @Query("SELECT pc.benExitAge,pc.subProduct FROM ProductConfig pc WHERE pc.benExitAge IS NOT NULL and pc.status =?1")
    List<Object[]> findByBenExitAge(Status status);

    @Query("SELECT pc.numberOfWorkers FROM ProductConfig pc WHERE pc.subProduct.subProductId = ?1 AND pc.status=?2")
    Integer findNumberOfWorkers(Long subProduct, Status status);

}
