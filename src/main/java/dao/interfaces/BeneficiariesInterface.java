package dao.interfaces;


import dao.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BeneficiariesInterface {
    Beneficiaries save(Beneficiaries b);
    List<Beneficiaries> findByInsurancePolicyAndStatus(InsurancePolicy policy,Status status);
    List<Beneficiaries> findByInsurancePolicyAndStatus(String policyId,Status status);
    int updateBeneficiary(Date lastUpdated, String userId, Status status, Long beneficiaryId);
    List<Beneficiaries> findByRelationship(InsurancePolicy insurancePolicy,List<String> relationShips,Status status);
    int updateBeneficiary(String name, Date dateOfBirth, IDType idType, String student, RelationShip relationShip,
                          Date lastUpdated, String userId, InsurancePolicy insurancePolicy, Double percentageAllocated, Long beneficiaryId);

    Optional<Beneficiaries> findByBeneficiaryId(Long beneficiaryId);

    @Modifying(clearAutomatically = true)
    @Query("update Beneficiaries set name=?1, dateOfBirth=?2, idType=?3, student =?4, relationShip=?5," +
            " lastUpdated=?6, userId=?7, insurancePolicy=?8 where beneficiaryId=?9")
    int updateBeneficiary(String name, Date dateOfBirth, IDType idType,String student,RelationShip relationShip,
                          Date lastUpdated,String userId,InsurancePolicy insurancePolicy,Long beneficiaryId);

    List<Beneficiaries> findByProduct(SubProduct subProduct,Status status,List<RelationShip> relationShip);

    List<Beneficiaries> findByProduct(Status status);
    List<Beneficiaries> findByDOB(String dob,Status status,List<Long> relationShips,Long subProductId);

    List<Beneficiaries> findByInsurancePolicyId(String insurancePolicyId);
    List<Beneficiaries> findByIds( List<Long> ids);
}
