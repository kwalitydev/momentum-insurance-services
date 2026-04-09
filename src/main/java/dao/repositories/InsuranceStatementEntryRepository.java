package dao.repositories;

import dao.entities.InsurancePolicy;
import dao.entities.InsuranceStatementEntry;
import dao.interfaces.InsuranceStatementEntryInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface InsuranceStatementEntryRepository extends JpaRepository<InsuranceStatementEntry, String>, InsuranceStatementEntryInterface {


    @Query("SELECT e FROM InsuranceStatementEntry e WHERE e.insuranceBalance.insurancePolicy = ?1 AND e.entryDate BETWEEN ?2 AND ?3 ORDER BY e.entryDate desc")
    List<InsuranceStatementEntry> findByInsurancePolicyAndEntryDateBetween(InsurancePolicy insurancePolicy, Date startDate, Date endDate);

}
