package dao.repositories;

import dao.entities.*;
import dao.interfaces.BeneficiariesInterface;
import dao.interfaces.InsuranceBalanceInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface InsuranceBalanceRepository extends JpaRepository<InsuranceBalance, String>, InsuranceBalanceInterface {



}
