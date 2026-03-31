package dao.repositories;

import dao.entities.BenefitMap;
import dao.interfaces.BenefitInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface BenefitRepository extends JpaRepository<BenefitMap, String>, BenefitInterface {




}
