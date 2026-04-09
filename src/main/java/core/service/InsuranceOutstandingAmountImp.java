package core.service;

import dao.entities.InsuranceOutstandingAmount;
import dao.repositories.InsuranceOutstandingAmountRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class InsuranceOutstandingAmountImp implements IInsuranceOutstandingAmount {

    @Inject
    private InsuranceOutstandingAmountRepository insuranceOutstandingAmountRepository;

    @Transactional
    @Override
    public InsuranceOutstandingAmount save(InsuranceOutstandingAmount ib) {
        return insuranceOutstandingAmountRepository.save(ib);
    }

    @Override
    public List<InsuranceOutstandingAmount> findByStatus(String status) {
        return insuranceOutstandingAmountRepository.findByStatus(status);
    }

    @Override
    public List<InsuranceOutstandingAmount> findByInsurancePolicyId(String insurancePolicyId, String status) {
        return insuranceOutstandingAmountRepository.findByInsurancePolicyId(insurancePolicyId, status);
    }

    @Transactional
    @Override
    public int updateInsuranceOutstandingByID(List<Long> ids, String status, Date lastUpdatedDate) {
        return insuranceOutstandingAmountRepository.updateInsuranceOutstandingByID(ids, status, lastUpdatedDate);
    }


}
