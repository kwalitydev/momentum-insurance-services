package dao.repositories;

import dao.entities.InsurancePolicy;
import dao.entities.InsurancePolicyHistory;
import dao.interfaces.InsurancePolicyHistoryInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface InsurancePolicyHistoryRepository extends JpaRepository<InsurancePolicyHistory, String>, InsurancePolicyHistoryInterface {

    @Query("SELECT iph FROM InsurancePolicyHistory iph where iph.insurancePolicy=?1 ORDER BY iph.createdDate desc")
    List<InsurancePolicyHistory> getFirstInsurancePolicy(InsurancePolicy insurancePolicy, Pageable pageable);

}
