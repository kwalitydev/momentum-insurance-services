package core.service;

import dao.entities.InsuranceOutstandingAmount;

import java.util.Date;
import java.util.List;

public interface IInsuranceOutstandingAmount {
    InsuranceOutstandingAmount save(InsuranceOutstandingAmount ib);
    List<InsuranceOutstandingAmount> findByStatus(String status);

    List<InsuranceOutstandingAmount> findByInsurancePolicyId(String insurancePolicyId, String status);

    int updateInsuranceOutstandingByID(List<Long> ids, String status, Date lastUpdatedDate);

}
