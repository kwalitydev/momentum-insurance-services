package dao.interfaces;


import dao.entities.InsurancePolicy;
import dao.entities.InsuranceStatementEntry;

import java.util.Date;
import java.util.List;

public interface InsuranceStatementEntryInterface {
    InsuranceStatementEntry save(InsuranceStatementEntry ise);
    List<InsuranceStatementEntry> findByInsurancePolicyAndEntryDateBetween(InsurancePolicy insurancePolicy, Date startDate, Date endDate);
}
