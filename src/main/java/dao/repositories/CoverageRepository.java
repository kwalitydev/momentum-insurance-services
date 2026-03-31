package dao.repositories;

import dao.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CoverageRepository extends JpaRepository<Coverage, String> {


    @Query("Select c FROM Coverage c WHERE c.productConfig.subProduct = ?1 AND c.status =?2 AND c.productConfig.status =?2 AND c.currency =?3 ORDER BY c.coverAmount ")
    List<Coverage> findBySubProductAndStatusAndCurrencyOrderByCoverAmount(SubProduct subProduct, Status status, Currency currency);

    @Query("Select c FROM Coverage c WHERE c.coverageId =?1")
    Optional<Coverage> findByCoverageId(Long id);

    @Query("Select c FROM Coverage c WHERE c.processWorkflow =?1")
    List<Coverage> findByProcessWorkflow(ProcessWorkflow processWorkflow);

    @Modifying(clearAutomatically = true)
    @Query("update Coverage set status=?1 WHERE coverageId=?2")
    int updateCoverageStatus(Status status,Long coverageId);
    @Query("Select c FROM Coverage c WHERE c.processWorkflow =?1 AND c.processWorkflow.userInput <>?2")
    List<Coverage> findByProcessWorkflow(ProcessWorkflow processWorkflow,Users users);

    @Modifying(clearAutomatically = true)
    @Query("update Coverage set coverAmount=?1, premiumAmount=?2 WHERE coverageId=?3")
    int updateCoverage(BigDecimal coverAmount,BigDecimal premiumAmount,Long coverageId);

}
