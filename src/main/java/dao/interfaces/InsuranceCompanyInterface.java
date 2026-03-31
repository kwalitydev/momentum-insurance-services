package dao.interfaces;


import dao.entities.InsuranceCompany;
import dao.entities.Status;

import java.util.List;
import java.util.Optional;

public interface InsuranceCompanyInterface {
    <S extends InsuranceCompany> S save(S ip);
    List<InsuranceCompany> findByStatus(Status status);
    Optional<InsuranceCompany> findByInsuranceCompanyId(String insuranceCompany);


}
