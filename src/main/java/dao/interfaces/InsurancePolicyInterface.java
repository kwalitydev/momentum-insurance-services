package dao.interfaces;


import core.beans.PolicyRequest;
import core.beans.PolicyResponse;
import dao.entities.*;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InsurancePolicyInterface {

    InsurancePolicy save(InsurancePolicy s);
    InsurancePolicy saveAndFlush(InsurancePolicy s);
    Optional<InsurancePolicy> findByPolicyId(String policyId);
    Optional<InsurancePolicy> findBySimulationId(String policyId);

    List<InsurancePolicy> findByDateInterval(Date startDate,Date endDate,String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,SubProduct subProduct,String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, SubProduct subProduct, PolicyHolder policyHolder, String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, SubProduct subProduct, PolicyHolder policyHolder, Users userId, String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Users userId,String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Status status, PolicyHolder policyHolder, String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,SubProduct subProduct,String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,Users userId,String recordType);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Users userId,SubProduct subProduct,String recordType);
    List<InsurancePolicy> getPoliciesToPay(List<String> status,String recordStatus,Date expiryDate);
    List<InsurancePolicy> getPoliciesToPay(List<String> status,String recordStatus,Date expiryDate, Frequency frequency);
   int cancelPolicy(Date lastUpdate, Status status,String userId,String policyId);

    int updatePolicy(Date lastUpdate, String userId, Coverage coverage, BigDecimal totalAmount,SubProduct subProduct,Date expiryDate,String policyId);


    List<InsurancePolicy> findByRecordTypeByOrderByCreatedDateDesc(String recordType,Product product);
    List<InsurancePolicy> getPoliciesToClaim(Status status, String recordType,Date startDate, Date endDate,Status claimStatus);
    List<InsurancePolicy> getPoliciesUnClaimed(Status status, String recordType,Date startDate, Date endDate);


    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Product product, String recordType, Pageable pageable);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Product product,Status status,String recordType,Pageable pageable);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,SubProduct subProduct,String recordType,Pageable pageable);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,SubProduct subProduct,String recordType,Pageable pageable);
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate, Product product, String recordType, Pageable pageable);
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,Product product,Status status,String recordType,Pageable pageable);

    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,SubProduct subProduct,String recordType,Pageable pageable);
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,Status status,SubProduct subProduct,String recordType,Pageable pageable);

    int updatePremium(Date lastUpdate, String users, BigDecimal totalAmount,String policyId);

    int updatePolicyStatus(Date lastUpdate, Status status, String policyId);
    int activatePolicy(Date lastUpdate, Status status,String users,String recordType, String newPolicyId,String policyId);





}
