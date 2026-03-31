package dao.repositories;

import dao.entities.BenefitCycle;
import dao.interfaces.BenefitCycleInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitCycleRepository extends JpaRepository<BenefitCycle, String>, BenefitCycleInterface {



}
