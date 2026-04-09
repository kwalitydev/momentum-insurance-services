package core.util;


import core.beans.FileRequest;
import core.beans.MemberRequest;
import core.beans.PolicyRequest;
import core.constants.ProcessStates;
import core.constants.Statuses;
import dao.BeanFactory;
import dao.entities.*;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;

import static core.constants.ProcessActions.ALTER;
import static core.util.CoreUtil.*;
import static core.util.Util.*;


public class InsuranceUtil implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(InsuranceUtil.class);
    @Inject
    private PolicyHolderInterface policyHolderInterface;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private InsurancePolicyHistoryInterface insurancePolicyHistoryInterface;
    @Inject
    private InsuranceOutstandingAmountInterface outstandingAmountInterface;
    @Inject
    BeanFactory beanFactory;


    @Transactional(Transactional.TxType.REQUIRED)
    public InsurancePolicy postPolicy(PolicyHolder policyHolder,
                                      InsurancePolicy insurancePolicy,
                                      PolicyRequest policyRequest,
                                      String traceId) throws Exception {

        InsurancePolicy savedInsurancePolicy = saveAccountAndInsurancePolicy(policyHolder, insurancePolicy, traceId);
        createProcess(savedInsurancePolicy.getPolicyId());
        saveBeneficiaries(policyRequest, savedInsurancePolicy);
        logDocuments(policyRequest, traceId, savedInsurancePolicy.getPolicyId());
        logInsuranceBalance(insurancePolicy,traceId);

        return savedInsurancePolicy;
    }


    private InsurancePolicy saveAccountAndInsurancePolicy(PolicyHolder policyHolder,
                                                          InsurancePolicy insurancePolicy,
                                                          String traceId) {

        if (policyHolder != null) {
            PolicyHolder savedPolicyHolder = policyHolderInterface.saveAndFlush(policyHolder);
            insurancePolicy.setPolicyHolder(savedPolicyHolder);
            LOGGER.info("Policy holder saved -> {}. traceId -> {}", savedPolicyHolder, traceId);
        }

        InsurancePolicy savedInsurancePolicy = beanFactory.merge(insurancePolicy);
        LOGGER.info("Policy saved -> {}. traceId -> {}", savedInsurancePolicy.getPolicyId(), traceId);


        return savedInsurancePolicy;
    }


    private void createProcess(String policyId) {

        ProcessWorkflow processWorkflow = new ProcessWorkflow();
        processWorkflow.setProcessAction(setProcessAction(ALTER.toString()));
        processWorkflow.setProcessState(setProcessState(ProcessStates.AWAITING_VALIDATION.toString()));
        processWorkflow.setInputDate(today());
        processWorkflow.setChangedObjectId(policyId);
        processWorkflow.setUserInput(setUser("web"));
        ProcessWorkflow saved = beanFactory.merge(processWorkflow);

        LOGGER.info("ProcessWorkflow saved! id = {}", saved.getWorkflowId());
    }


    private void saveBeneficiaries(PolicyRequest policyRequest,
                                   InsurancePolicy savedInsurancePolicy)  {

        for (MemberRequest mr : policyRequest.getMemberRequests()) {

            Beneficiaries b = new Beneficiaries();
            b.setPolicy(savedInsurancePolicy);
            b.setName(mr.getName());
            b.setDocumentNumber(mr.getDocNumber());
            b.setRelationShip(setRelationShip(mr.getRelationShipId()));
            b.setIdType(setIDType(mr.getIdTypeId()));
            b.setStudent(mr.getBenStudent());
            b.setTotalCharge(mr.getTotalCharge());
            b.setCreatedDate(today());
            b.setLastUpdated(today());
            b.setStatus(setActive());

            try {
                b.setDateOfBirth(stringToDate(mr.getDateOfBirth()));
            } catch (ParseException e) {
                LOGGER.error("Invalid DOB {}", mr.getDateOfBirth());
            }

            beanFactory.merge(b);

            LOGGER.info("Beneficiary saved -> {}", b.getName());
        }
    }


    private void logDocuments(PolicyRequest policyRequest,
                              String traceId,
                              String policyId) throws Exception {

        if (policyRequest.getFileRequests() == null) return;

        LOGGER.info("Saving {} document(s). PolicyId -> {}",
                policyRequest.getFileRequests().size(), policyId);

        for (FileRequest fl : policyRequest.getFileRequests()) {

            String documentName = getLogId();
            String subFolder = formatDate(today(), SIMPLE_DATE_PATTERN);

            DocumentFile df = new DocumentFile();
            df.setDocumentType(setDocumentType(fl.getDocumentTypeId()));
            df.setCreatedDate(today());
            df.setInputter(policyRequest.getUsername());
            df.setTitle(fl.getFileName());
            df.setDescription(fl.getFileName());
            df.setObjectId(policyId);
            df.setFileType(fl.getFileType());

            df.setUrl(File.separator + DOCUMENT_DIR + File.separator +
                    subFolder + File.separator + documentName + ".pdf");

            beanFactory.merge(df);

            FileUtil.createFile(fl.getImage(), documentName, DOCUMENT_DIR, subFolder);

            LOGGER.info("Document saved -> {}. traceId -> {}", documentName, traceId);
        }
    }


    public void logPolicyHistory(PolicyRequest policyRequest,String traceId,String ...narrative){
        InsurancePolicy ip = new InsurancePolicy();
        ip.setPolicyId(policyRequest.getPolicyId());
        InsurancePolicyHistory insurancePolicyHistory = new InsurancePolicyHistory();
        insurancePolicyHistory.setInsurancePolicy(ip);
        insurancePolicyHistory.setChangeDescription(policyRequest.getComments());
        insurancePolicyHistory.setCreatedDate(today());
        insurancePolicyHistory.setUsers(setUser(policyRequest.getUsername()));
        insurancePolicyHistory.setProcessAction(setProcessAction(ALTER.toString()));
        insurancePolicyHistory.setNarrative(narrative[0]);
        InsurancePolicyHistory InsurancePolicyHistory = insurancePolicyHistoryInterface.save(insurancePolicyHistory);
        LOGGER.info("InsurancePolicyHistory saved {}. traceId -> {}",InsurancePolicyHistory.getInsurancePolicy(),traceId);
    }

        public void logInsuranceBalance(InsurancePolicy insurancePolicy,String traceId) {
            InsuranceBalance insuranceBalance = new InsuranceBalance();
            insuranceBalance.setInsurancePolicy(insurancePolicy);
            insuranceBalance.setCurrentBalance(BigDecimal.ZERO);
            insuranceBalance.setLastUpdatedDate(today());

            InsuranceBalance savedBalance = beanFactory.merge(insuranceBalance);
            LOGGER.info("InsuranceBalance saved for policy {}. Id ->{} traceId -> {}", insurancePolicy.getPolicyId(),savedBalance.getInsuranceBalanceId(), traceId);
        }

        public void saveOutstandingAmount(String insurancePolicyId, BigDecimal amount, String traceId,String description,String transactionType) {

        try {
            InsuranceOutstandingAmount insuranceOutstandingAmount = new InsuranceOutstandingAmount();
            insuranceOutstandingAmount.setInsurancePolicy(setInsurancePolicy(insurancePolicyId));
            insuranceOutstandingAmount.setAmount(amount);
            insuranceOutstandingAmount.setDescription(description);
            insuranceOutstandingAmount.setStatus(setStatus(Statuses.NEW.toString()));
            insuranceOutstandingAmount.setEntryDate(today());
            insuranceOutstandingAmount.setTransactionType(transactionType);
            insuranceOutstandingAmount.setLastUpdatedDate(today());
            LOGGER.info("Attempting to save InsuranceOutstandingAmount for policy {}. Amount -> {} traceId -> {}", insurancePolicyId, amount, traceId);
            InsuranceOutstandingAmount saved = beanFactory.merge(insuranceOutstandingAmount);
            LOGGER.info("InsuranceOutstandingAmount saved for policy {}. Id ->{} traceId -> {}", insurancePolicyId, saved.getInsuranceOutstandingAmountId(), traceId);
        }
        catch (Exception e){
            LOGGER.error("Error while saving InsuranceOutstandingAmount for policy {}. Amount -> {} traceId -> {}", insurancePolicyId, amount, traceId,e);
        }

        }


}
