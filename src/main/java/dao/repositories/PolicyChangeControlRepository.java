package dao.repositories;

import dao.entities.InsurancePolicy;
import dao.entities.PolicyChangeControl;
import dao.interfaces.PolicyChangeControlInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PolicyChangeControlRepository extends JpaRepository<PolicyChangeControl, String>, PolicyChangeControlInterface {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PolicyChangeControl p WHERE p.insurancePolicy.insurancePolicyId = ?1 AND  CONVERT(date, p.changeDate) BETWEEN ?2 AND ?3")
    boolean existsPolicyChangeInPeriod(String insurancePolicy, String startDate, String endDate);
}
