package dao.interfaces;


import dao.entities.InsurancePolicy;
import dao.entities.InsurancePolicyHistory;
import dao.entities.ProcessAction;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface InsurancePolicyHistoryInterface {
    <S extends InsurancePolicyHistory> S save(S a);
    List<InsurancePolicyHistory> findByInsurancePolicyOrderByCreatedDateDesc(InsurancePolicy insurancePolicy);

    List<InsurancePolicyHistory> findByProcessActionAndInsurancePolicy(ProcessAction processAction,InsurancePolicy insurancePolicy);

    List<InsurancePolicyHistory> getFirstInsurancePolicy(InsurancePolicy insurancePolicy, Pageable pageable);


}
