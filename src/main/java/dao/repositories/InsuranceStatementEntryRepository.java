package dao.repositories;

import dao.entities.InsuranceStatementEntry;
import dao.interfaces.InsuranceStatementEntryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceStatementEntryRepository extends JpaRepository<InsuranceStatementEntry, String>, InsuranceStatementEntryInterface {



}
