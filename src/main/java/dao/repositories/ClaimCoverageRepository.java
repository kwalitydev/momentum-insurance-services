package dao.repositories;

import dao.entities.ClaimCoverage;
import dao.interfaces.ClaimCoverageInterface;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClaimCoverageRepository extends JpaRepository<ClaimCoverage, String>, ClaimCoverageInterface {



}
