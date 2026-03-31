package core.impl;

import dao.entities.*;
import dao.interfaces.CoverageInterface;
import dao.repositories.CoverageRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CoverageImpl implements CoverageInterface {

    @Inject
    private CoverageRepository coverageRepository;

    @Override
    public Optional<Coverage> findByCoverageId(Long id) {
        return coverageRepository.findByCoverageId(id);
    }

    @Override
    public List<Coverage> findBySubProductAndStatusAndCurrencyOrderByCoverAmount(SubProduct subProduct, Status status, Currency currency) {
        return coverageRepository.findBySubProductAndStatusAndCurrencyOrderByCoverAmount(subProduct,status,currency);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public Coverage save(Coverage coverage) {
        return coverageRepository.saveAndFlush(coverage);
    }

    @Override
    public int updateCoverageStatus(Status status, Long coverageId) {
        return coverageRepository.updateCoverageStatus(status,coverageId);
    }

    @Override
    public List<Coverage> findByProcessWorkflow(ProcessWorkflow processWorkflow, Users users) {
        return coverageRepository.findByProcessWorkflow(processWorkflow,users);
    }

    @Override
    public int updateCoverage(BigDecimal coverAmount, BigDecimal premiumAmount, Long coverageId) {
        return coverageRepository.updateCoverage(coverAmount,premiumAmount,coverageId);
    }
}
