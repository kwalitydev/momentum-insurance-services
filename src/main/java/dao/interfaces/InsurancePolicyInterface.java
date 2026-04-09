package dao.interfaces;


import core.beans.PolicyRequest;
import core.beans.PolicyResponse;
import dao.entities.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InsurancePolicyInterface {

    InsurancePolicy save(InsurancePolicy s);
    InsurancePolicy saveAndFlush(InsurancePolicy s);
    Optional<InsurancePolicy> findByPolicyId(String policyId);
    Optional<InsurancePolicy> findBySimulationId(String policyId);
    List<InsurancePolicy> findByDateInterval(Date startDate,Date endDate);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,SubProduct subProduct);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Status status, PolicyHolder policyHolder);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,SubProduct subProduct);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Users userId,SubProduct subProduct);

   int cancelPolicy(Date lastUpdate, Status status,String userId,String policyId);

    int updatePolicy(Date lastUpdate, String userId, Coverage coverage, BigDecimal totalAmount,SubProduct subProduct,Date expiryDate,String policyId);


    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate, Product product, Pageable pageable);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,SubProduct subProduct,Pageable pageable);
    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,Status status,SubProduct subProduct,Pageable pageable);
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate, Product product,  Pageable pageable);
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,Product product,Status status,Pageable pageable);

    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,SubProduct subProduct,Pageable pageable);
    List<InsurancePolicy> findByDateIntervalCancel(Date startDate, Date endDate,Status status,SubProduct subProduct,Pageable pageable);

    int updatePremium(Date lastUpdate, String users, BigDecimal totalAmount,String policyId);

    int updatePolicyStatus(Date lastUpdate, Status status, String policyId);
    int activatePolicy(Date lastUpdate, Status status,String users,String recordType, String newPolicyId,String policyId);

    List<InsurancePolicy> findByDateInterval(Date startDate, Date endDate,SubProduct subProduct,Status status);


    List<InsurancePolicy> findByMobileNumber( String mobile);

    Optional<InsurancePolicy> findOneWithPolicyHolder(String mobile, String insurancePolicyId);

    int updatePolicy(BigDecimal totalAmount, Date lastUpdate,String users, String policyId);

}
