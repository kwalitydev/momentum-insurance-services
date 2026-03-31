package dao.interfaces;


import dao.entities.CoverageOption;
import dao.entities.Frequency;
import dao.entities.InsurancePolicy;

import java.util.Date;
import java.util.Optional;

public interface CoverageOptionInterface {

    CoverageOption save(CoverageOption coverageOption);
    CoverageOption saveAndFlush(CoverageOption coverageOption);
    Optional<CoverageOption> findByInsurancePolicy(InsurancePolicy insurancePolicy);
    int updateCoverageOption(String coverageOption,String territoryCovered,Frequency frequency,Boolean directDebitAuth,Date startDate,Date endDate,Date lastUpdated, InsurancePolicy insurancePolicy);

}
