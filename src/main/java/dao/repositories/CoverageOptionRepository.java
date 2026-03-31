package dao.repositories;

import dao.entities.CoverageOption;
import dao.entities.CoverageType;
import dao.entities.Frequency;
import dao.entities.InsurancePolicy;
import dao.interfaces.CoverageOptionInterface;
import dao.interfaces.CoverageTypeInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Date;

public interface CoverageOptionRepository extends JpaRepository<CoverageOption, String>, CoverageOptionInterface {
    @Modifying(clearAutomatically = true)
    @Query("update CoverageOption set coverageOption=?1,territoryCovered=?2,frequency=?3,directDebitAuth=?4, startDate=?5, endDate=?6, lastUpdated=?7 where insurancePolicy=?8")
    int updateCoverageOption(String coverageOption, String territoryCovered, Frequency frequency, Boolean directDebitAuth,
                             Date startDate, Date endDate,Date lastUpdated,InsurancePolicy insurancePolicy);

}
