package dao.interfaces;



import dao.entities.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CoverageInterface {
   /* <S extends Coverage> S save(S c); */
    Optional<Coverage> findByCoverageId(Long id);
    List<Coverage> findBySubProductAndStatusAndCurrencyOrderByCoverAmount(SubProduct subProduct, Status status,Currency currency);

    Coverage save(Coverage coverage);

    int updateCoverageStatus(Status status,Long coverageId);

    List<Coverage> findByProcessWorkflow(ProcessWorkflow processWorkflow,Users users);

    int updateCoverage(BigDecimal coverAmount, BigDecimal premiumAmount, Long coverageId);
}
