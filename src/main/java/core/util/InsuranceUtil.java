package core.util;


import core.beans.CustomerResponse;
import core.beans.FileRequest;
import core.beans.MemberRequest;
import core.beans.PolicyRequest;
import core.constants.ProcessActions;
import core.constants.ProcessStates;
import core.constants.Statuses;
import core.threads.PostReportBuild;
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
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import static core.constants.ProcessActions.ALTER;
import static core.util.CoreUtil.*;
import static core.util.Util.*;

//@ApplicationScoped

public class InsuranceUtil implements Serializable {
    private static final Logger LOGGER = LogManager.getLogger(InsuranceUtil.class);
    @Inject
    private PolicyHolderInterface policyHolderInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;

    @Inject
    private PaymentScheduleInterface paymentScheduleInterface;
    @Inject
    private CollectionLogInterface collectionLogInterface;
    @Inject
    private PaymentLogInterface paymentLogInterface;
    @Inject
    private PostReportBuild postReportBuild;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private InsurancePolicyHistoryInterface insurancePolicyHistoryInterface;
    @Inject
    private BeneficiariesInterface beneficiariesInterface;
    @Inject
    private NotificationUtil notificationUtil;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private DocumentTypeInterface documentTypeInterface;
    @Inject
    private UserInterface userInterface;
    @Inject
    private ProcessWorkflowInterface processWorkflowInterface;
    @Inject
    BeanFactory beanFactory;


    @Transactional(Transactional.TxType.REQUIRED)
    public InsurancePolicy postPolicy(PolicyHolder policyHolder,
                                      InsurancePolicy insurancePolicy,
                                      PolicyRequest policyRequest,
                                      String traceId) throws Exception {

        InsurancePolicy savedInsurancePolicy =
                saveAccountAndInsurancePolicy(policyHolder, insurancePolicy, traceId);

        createProcess(savedInsurancePolicy.getPolicyId());

        saveBeneficiaries(policyRequest, savedInsurancePolicy);

        logDocuments(policyRequest, traceId, savedInsurancePolicy.getPolicyId());

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

    public void updatePolicy(PolicyRequest policyRequest, InsurancePolicy insurancePolicy, String traceId) throws Exception {
        CustomerResponse customerResponse = null;
        Date expiryDate;
        int updatedAccount = policyHolderInterface.updateAccount(customerResponse.getCoreCustomer().getAccountId(), customerResponse.getCoreCustomer().getCustomerId(), stringToDate(customerResponse.getCoreCustomer().getDateOfBirth()), customerResponse.getCoreCustomer().getMobileNumber(), today(), customerResponse.getCoreCustomer().getCustomerName(), customerResponse.getCoreCustomer().getEmail(), customerResponse.getCoreCustomer().getVat(), customerResponse.getCoreCustomer().getAddress(), insurancePolicy.getPolicyHolder().getId());
        if (updatedAccount > 0) {
            LOGGER.info("Account successfully updated. traceId -> {}", traceId);
        } else {
            LOGGER.info("Account not updated. traceId -> {}", traceId);
        }
        if (policyRequest.getEndDate() == null) {
            expiryDate = insurancePolicy.getExpiryDate();
        } else {
            expiryDate = stringToDate(policyRequest.getEndDate());
        } /* int updatePolicy = insurancePolicyInterface.updatePolicy(today(), policyRequest.getUsername(), null, policyRequest.getTotalAmount()), setSubProduct(policyRequest.getPackageId()), expiryDate, policyRequest.getPolicyId()); if (updatePolicy > 0) { LOGGER.info("Policy successfully updated. traceId -> {}",traceId); } else { LOGGER.info("Policy not updated. traceId -> {}",traceId); } */
        logPolicyHistory(policyRequest, traceId);
        handleBeneficiaries(policyRequest, traceId);
        notificationUtil.postSendAmendmentSMS(traceId, insurancePolicy, customerResponse);
    }

    public void logPolicyHistory(PolicyRequest policyRequest,String traceId){
        InsurancePolicy ip = new InsurancePolicy(); ip.setPolicyId(policyRequest.getPolicyId());
        InsurancePolicyHistory insurancePolicyHistory = new InsurancePolicyHistory(); insurancePolicyHistory.setInsurancePolicy(ip);
        insurancePolicyHistory.setChangeDescription(policyRequest.getComments()); insurancePolicyHistory.setCreatedDate(today());
        insurancePolicyHistory.setUsers(setUser(policyRequest.getUsername()));
        insurancePolicyHistory.setProcessAction(setProcessAction(ALTER.toString()));
        InsurancePolicyHistory InsurancePolicyHistory = insurancePolicyHistoryInterface.save(insurancePolicyHistory);
        LOGGER.info("InsurancePolicyHistory saved {}. traceId -> {}",InsurancePolicyHistory.getInsurancePolicy(),traceId); }



    private void handleBeneficiaries(PolicyRequest policyRequest,String traceId) throws Exception {
        for (MemberRequest mr : policyRequest.getMemberRequests()) {
            Status status = new Status();
            status.setId(Statuses.ACTIVE.toString());
            InsurancePolicy insP = new InsurancePolicy();
            insP.setPolicyId(policyRequest.getPolicyId());
            if (mr.getBeneficiaryId() == null) {
                // setBeneficiaries(policyRequest, policyRequest.getCustomerResponse(), insP, mr, status);
                // } else { LOGGER.debug("Beneficiary {} is already added. traceId -> {}", mr.getBeneficiaryId(),traceId);
                // } } if (policyRequest.getRemovedMembers() != null)
                // { for (Long removalId : policyRequest.getRemovedMembers())
                // { Status status = new Status(); status.setId(Statuses.REMOVED.toString());
                // int updatedBeneficiary = beneficiariesInterface.updateBeneficiary(today(), policyRequest.getUsername(), status, removalId);
                // if (updatedBeneficiary > 0) { LOGGER.info("Policy successfully removed. traceId -> {}",traceId);
                // } else { LOGGER.info("Policy not removed. traceId -> {}",traceId);
                // }
                // }
                // }
                //
                // else {
                // LOGGER.debug("No members to be removed! traceId -> {}",traceId); } }
            }
        }
    }
}
