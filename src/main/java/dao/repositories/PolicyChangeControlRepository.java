package dao.repositories;

import dao.entities.InsurancePolicy;
import dao.entities.PolicyChangeControl;
import dao.interfaces.PolicyChangeControlInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;


public interface PolicyChangeControlRepository extends JpaRepository<PolicyChangeControl, String>, PolicyChangeControlInterface {


    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM PolicyChangeControl p WHERE p.insurancePolicy = ?1 AND p.changeDate BETWEEN ?2 AND ?3")
    boolean existsPolicyChangeInPeriod(InsurancePolicy insurancePolicy, Date startDate, Date endDate);
}
