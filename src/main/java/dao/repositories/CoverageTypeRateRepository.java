package dao.repositories;

import dao.entities.CoverageTypeRate;
import dao.interfaces.CoverageTypeRateInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverageTypeRateRepository extends JpaRepository<CoverageTypeRate, String>, CoverageTypeRateInterface {


}
