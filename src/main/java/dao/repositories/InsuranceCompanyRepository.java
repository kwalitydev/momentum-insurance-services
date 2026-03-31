package dao.repositories;

import dao.entities.InsuranceCompany;
import dao.interfaces.InsuranceCompanyInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany, String>, InsuranceCompanyInterface {



}
