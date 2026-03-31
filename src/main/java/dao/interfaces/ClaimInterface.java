package dao.interfaces;


import dao.entities.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ClaimInterface {
    <S extends Claim> S save(S c);
    List<Claim> findAll();
    Optional<Claim> findByClaimId(Long claimId);
    List<Claim> findByDates(Date startDate, Date endDate);

    List<Claim> findByProcessWorkflow(ProcessWorkflow processWorkflow, Users users);
    int updateClaimStatus(Status status, Long claimId);
    int updateClaimStatus(Status status,Date lastUpdate, Long claimId);

    List<Claim> findByStatusProductAndDates(List<Status> statuses,Product product,Date start,Date end);
    List<Claim> findByStatusAndDates(List<Status> statuses,String policyId,Date start,Date end);
    List<Claim> findByStatusAndDates(List<Status> statuses,Date start,Date end,SubProduct subProduct);
    int updateClaimStatus(Status status, String claimProcessId, BigDecimal insurerPaidAmount, Date lastUpdate, Long claimId);
}
