package dao.repositories;

import dao.entities.*;
import dao.interfaces.BeneficiariesInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;
@Repository
public interface BeneficiariesRepository extends JpaRepository<Beneficiaries, String>, BeneficiariesInterface {


    @Modifying(clearAutomatically = true)
    @Query("update Beneficiaries set lastUpdated=?1, userId=?2, status=?3 where beneficiaryId=?4")
    int updateBeneficiary(Date lastUpdated, String userId, Status status, Long beneficiaryId);

    @Query("SELECT b FROM Beneficiaries b WHERE (b.insurancePolicy.policyId =?1 OR b.insurancePolicy.insurancePolicyId =?1) AND b.status = ?2 ORDER BY b.createdDate")
    List<Beneficiaries> findByInsurancePolicyAndStatus(String policyId,Status status);
    @Query("SELECT b FROM Beneficiaries b WHERE b.insurancePolicy =?1 AND b.relationShip.description IN ?2 AND b.status = ?3 ORDER BY b.name")
    List<Beneficiaries> findByRelationship(InsurancePolicy insurancePolicy,List<String> relationShips,Status status);

    @Modifying(clearAutomatically = true)
    @Query("update Beneficiaries set name=?1, dateOfBirth=?2, idType=?3, student =?4, relationShip=?5," +
            " lastUpdated=?6, userId=?7, insurancePolicy=?8, percentageAllocated=?9 where beneficiaryId=?10")
    int updateBeneficiary(String name, Date dateOfBirth, IDType idType,String student,RelationShip relationShip,
                          Date lastUpdated,String userId,InsurancePolicy insurancePolicy,Double percentageAllocated,Long beneficiaryId);


    @Modifying(clearAutomatically = true)
    @Query("update Beneficiaries set name=?1, dateOfBirth=?2, idType=?3, student =?4, relationShip=?5," +
            " lastUpdated=?6, userId=?7, insurancePolicy=?8 where beneficiaryId=?9")
    int updateBeneficiary(String name, Date dateOfBirth, IDType idType,String student,RelationShip relationShip,
                          Date lastUpdated,String userId,InsurancePolicy insurancePolicy,Long beneficiaryId);


    @Query("SELECT b FROM Beneficiaries b WHERE b.insurancePolicy.subProduct =?1 AND b.status =?2 AND b.relationShip IN ?3 ORDER BY b.dateOfBirth")
    List<Beneficiaries> findByProduct(SubProduct subProduct,Status status,List<RelationShip> relationShip);


    @Query("SELECT b FROM Beneficiaries b WHERE b.status =?1")
    List<Beneficiaries> findByProduct(Status status);


    @Query("SELECT b FROM Beneficiaries b WHERE TRUNC(b.dateOfBirth) = TO_DATE(?1,'dd/mm/yyyy') and b.insurancePolicy.status =?2 AND b.relationShip.relationShipId IN ?3 AND b.insurancePolicy.subProduct.subProductId =?4")
    List<Beneficiaries> findByDOB(String dob,Status status,List<Long> relationShips,Long subProductId);

    @Query("SELECT b FROM Beneficiaries b " +
           "WHERE b.insurancePolicy.insurancePolicyId = :insurancePolicyId")
    List<Beneficiaries> findByInsurancePolicyId(
            @Param("insurancePolicyId") String insurancePolicyId);

    @Query("SELECT b FROM Beneficiaries b WHERE b.beneficiaryId IN :ids")
    List<Beneficiaries> findByIds(@Param("ids") List<Long> ids);


}
