package core.util;

import com.temenos.sbm_insurance.SBInsurancePaymentsResponse;
import core.beans.*;
import core.constants.PaymentMethods;
import core.constants.Statuses;
import core.threads.PostReportBuild;
import dao.BeanFactory;
import dao.entities.*;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.Optional;

import static core.constants.ProcessActions.ALTER;
import static core.constants.ProcessStates.AWAITING_APPROVAL;
import static core.constants.ProcessStates.AWAITING_VALIDATION;
import static core.util.CoreUtil.*;
import static core.util.Util.*;

@ApplicationScoped
@Transactional
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
    private BeanFactory beanFactory;
    @Inject
    private PaymentUtil paymentUtil;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private T24Util t24Util;
    @Inject
    private DocumentTypeInterface documentTypeInterface;
    @Inject
    private UserInterface userInterface;
    @Inject
    private ProcessWorkflowInterface processWorkflowInterface;


    public InsurancePolicy postPolicy(PolicyHolder policyHolder, InsurancePolicy insurancePolicy, PolicyRequest policyRequest,String traceId) throws Exception {

        InsurancePolicy savedInsurancePolicy = saveAccountAndInsurancePolicy(policyHolder, insurancePolicy, policyRequest, traceId);
        createProcess(savedInsurancePolicy.getPolicyId());
        saveMemberRequests(policyRequest, savedInsurancePolicy);
        logDocuments(policyRequest, traceId,savedInsurancePolicy.getPolicyId());

        return savedInsurancePolicy;
    }

    private void createProcess(String policyId){
        Optional<Users> users = userInterface.findByUserId("external");
        ProcessWorkflow processWorkflow = new ProcessWorkflow();
        processWorkflow.setProcessAction(setProcessAction(ALTER.toString()));
        processWorkflow.setProcessState(setProcessState(AWAITING_VALIDATION.toString()));
        users.ifPresent(value -> processWorkflow.setCurrentDepartment(value.getDepartment()));
        processWorkflow.setInputDate(today());
        users.ifPresent(processWorkflow::setUserInput);
        processWorkflow.setChangedObjectId(policyId);

        ProcessWorkflow pw = processWorkflowInterface.save(processWorkflow);
        LOGGER.info("ProcessWorkflow saved! id = {}", pw.getWorkflowId());
    }

    private InsurancePolicy saveAccountAndInsurancePolicy(PolicyHolder policyHolder, InsurancePolicy insurancePolicy, PolicyRequest policyRequest, String traceId) {
        if (policyHolder != null) {
            PolicyHolder savedPolicyHolder = policyHolderInterface.saveAndFlush(policyHolder);
            insurancePolicy.setPolicyHolder(savedPolicyHolder);
            LOGGER.info("Policy holder details saved -> {}. traceId -> {}", savedPolicyHolder, traceId);
        }

        InsurancePolicy savedInsurancePolicy = insurancePolicyInterface.saveAndFlush(insurancePolicy);
        LOGGER.info("Policy saved. Policy ID -> {}. traceId -> {}", savedInsurancePolicy.getPolicyId(), traceId);

        return savedInsurancePolicy;
    }

    private void savePaymentSchedule(PaymentSchedule paymentSchedule, InsurancePolicy savedInsurancePolicy, PaymentLog paymentLog, String traceId) {
        paymentSchedule.setInsurancePolicy(savedInsurancePolicy);
        PaymentSchedule savedPaymentSchedule = paymentScheduleInterface.save(paymentSchedule);
        LOGGER.info("PaymentSchedule saved {}. traceId -> {}", savedPaymentSchedule.getPaymentScheduleId(), traceId);

    }

    private void saveCollectionLog(CollectionLog collectionLog, InsurancePolicy savedInsurancePolicy, String traceId) {
        collectionLog.setAccountNumber(savedInsurancePolicy.getPolicyHolder().getAccountNumber());
        CollectionLog savedCollectionLog = collectionLogInterface.save(collectionLog);
        LOGGER.info("CollectionLog saved {}. traceId -> {}", savedCollectionLog.getId(), traceId);
    }

    private void saveMemberRequests(PolicyRequest policyRequest, InsurancePolicy savedInsurancePolicy) throws ParseException {
        for (MemberRequest mr : policyRequest.getMemberRequests()) {
            Status status = new Status();
            status.setId(Statuses.ACTIVE.toString());
            setBeneficiaries(policyRequest, savedInsurancePolicy, mr, status);
        }
    }





    public InsurancePolicy postQuotation(PolicyHolder policyHolder, InsurancePolicy insurancePolicy){

        PolicyHolder savedPolicyHolder = policyHolderInterface.saveAndFlush(policyHolder);
        insurancePolicy.setPolicyHolder(savedPolicyHolder);
        LOGGER.info("Account saved -> {}", savedPolicyHolder);

        return insurancePolicyInterface.save(insurancePolicy);

    }

    public void updatePolicy(PolicyRequest policyRequest,InsurancePolicy insurancePolicy,String traceId) throws Exception{

        CustomerResponse customerResponse = null;
        Date expiryDate;
        int updatedAccount = policyHolderInterface.updateAccount(customerResponse.getCoreCustomer().getAccountId(),
                customerResponse.getCoreCustomer().getCustomerId(),
                stringToDate(customerResponse.getCoreCustomer().getDateOfBirth()),
                customerResponse.getCoreCustomer().getMobileNumber(),
                today(),
                customerResponse.getCoreCustomer().getCustomerName(),
                customerResponse.getCoreCustomer().getEmail(),
                customerResponse.getCoreCustomer().getVat(),
                customerResponse.getCoreCustomer().getAddress(), insurancePolicy.getPolicyHolder().getId());

        if (updatedAccount > 0) {
            LOGGER.info("Account successfully updated. traceId -> {}",traceId);
        } else {
            LOGGER.info("Account not updated. traceId -> {}",traceId);
        }

        if (policyRequest.getEndDate() == null) {
            expiryDate = insurancePolicy.getExpiryDate();
        } else {
            expiryDate = stringToDate(policyRequest.getEndDate());
        }

      /*  int updatePolicy = insurancePolicyInterface.updatePolicy(today(), policyRequest.getUsername(), null,
                policyRequest.getTotalAmount()), setSubProduct(policyRequest.getPackageId()),
                expiryDate, policyRequest.getPolicyId());

        if (updatePolicy > 0) {
            LOGGER.info("Policy successfully updated. traceId -> {}",traceId);
        } else {
            LOGGER.info("Policy not updated. traceId -> {}",traceId);
        } */


        logPolicyHistory(policyRequest,traceId);
        handleBeneficiaries(policyRequest,traceId);
        notificationUtil.postSendAmendmentSMS(traceId, insurancePolicy, customerResponse);

    }







    private void updateCustomerAccount(PolicyRequest policyRequest, InsurancePolicy insurancePolicy, String traceId) throws ParseException {
        CustomerResponse customerResponse = null;


        try {
            Long jobTitleId = null;
            if (customerResponse.getCoreCustomer().getJobTitle() != null) {
                jobTitleId = customerResponse.getCoreCustomer().getJobTitle().getJobTitleId();
            }

            int updatedAccount = policyHolderInterface.updateAccount(customerResponse.getCoreCustomer().getAccountId(),
                    customerResponse.getCoreCustomer().getCustomerId(), stringToDate(customerResponse.getCoreCustomer().getDateOfBirth()), customerResponse.getCoreCustomer().getMobileNumber(), today(),
                    customerResponse.getCoreCustomer().getCustomerName(), customerResponse.getCoreCustomer().getEmail(), customerResponse.getCoreCustomer().getVat(), customerResponse.getCoreCustomer().getAddress(),
                    jobTitleId, customerResponse.getCoreCustomer().getDocumentId(), insurancePolicy.getPolicyHolder().getId());

            if (updatedAccount > 0) {
                LOGGER.info("Account updated. traceId -> {}", traceId);
            } else {
                LOGGER.error("Account not updated. traceId -> {}", traceId);
            }
        }
        catch (Exception e){
            LOGGER.error("Account not update", e.getMessage());
            e.printStackTrace();
        }
    }



    private void handlePolicyAmountDelta(PolicyRequest policyRequest, InsurancePolicy insurancePolicy, PolicyResponse policyResponse, String traceId) throws Exception {
        double currentAmount = insurancePolicy.getTotalAmount().doubleValue();
        double newAmount = policyRequest.getTotalAmount().doubleValue();
        double diff = newAmount - currentAmount;

        if (diff != 0) {
            boolean isRefund = !(diff > 0);
            PaymentSchedule paymentSchedule = setPaymentSchedule(insurancePolicy, BigDecimal.valueOf(Math.abs(diff)));
            PaymentLog paymentLog = new PaymentLog();
            StringBuilder errorMessage = new StringBuilder();

            try {
                SubProductAccount subProductAccount = queryUtil.getSubProductAccount(insurancePolicy);

                if (subProductAccount != null && insurancePolicy.getPolicyHolder() != null) {
                    CollectionLog collectionLog = new CollectionLog();
                    collectionLog.setAccountNumber(insurancePolicy.getPolicyHolder().getAccountNumber());
                    paymentLog.setAttemptDate(today());
                    paymentLog.setErrorMessage(errorMessage.toString());
                    paymentLog.setPaymentMethod(PaymentMethods.NORMAL.getMethod());

                    SBInsurancePaymentsResponse paymentsResponse;
                    String debitAmount = String.valueOf(BigDecimal.valueOf(Math.abs(diff)));

                    if (isRefund) {
                        paymentsResponse = paymentUtil.setCorePayment(traceId, policyResponse, insurancePolicy, paymentSchedule, errorMessage, subProductAccount,
                                subProductAccount.getAccountId(), insurancePolicy.getPolicyHolder().getAccountNumber(), debitAmount, "Devolucao - premio");
                    } else {
                        paymentsResponse = paymentUtil.setCorePayment(traceId, policyResponse, insurancePolicy, paymentSchedule, errorMessage, subProductAccount,
                                insurancePolicy.getPolicyHolder().getAccountNumber(), subProductAccount.getAccountId(), debitAmount, "Actualizacao - premio");
                    }

                    logPayments(errorMessage, paymentLog, insurancePolicy, collectionLog, paymentSchedule, paymentsResponse.getStatus().toString());
                } else {
                    handleErrorInPayment(traceId, insurancePolicy, policyResponse);
                }
            } catch (Exception e) {
                LOGGER.error("Generic error",e);
                policyResponse.setErrorMessage("Core Banking indisponível");
            }
        } else {
            LOGGER.info("No refund needed! Delta is zero");
        }
    }

    private void handleErrorInPayment(String traceId, InsurancePolicy insurancePolicy, PolicyResponse policyResponse) {
        if (insurancePolicy.getPolicyHolder() == null) {
            LOGGER.info("policy {} has not associated account. traceId -> {}", insurancePolicy.getPolicyId(),traceId);
            policyResponse.setErrorMessage("Ocorreu um erro ao emitir a apólice");
        } else {
            LOGGER.info("No accounts found for policy {}", insurancePolicy.getPolicyId());
            policyResponse.setErrorMessage("Ocorreu um erro ao emitir a apólice");
        }
    }



    public void setBeneficiaries(PolicyRequest policyRequest,  InsurancePolicy savedInsurancePolicy, MemberRequest mr, Status status) throws ParseException {
        Beneficiaries beneficiaries = new Beneficiaries();
        beneficiaries.setCreatedDate(today());
        beneficiaries.setPolicy(savedInsurancePolicy);
        try {
            beneficiaries.setDateOfBirth(stringToDate(mr.getDateOfBirth()));
        }
        catch (Exception e){
            LOGGER.error("Could not parse date {}", mr.getDateOfBirth());
        }
        beneficiaries.setLastUpdated(today());
        beneficiaries.setDocumentNumber(mr.getDocNumber());
        beneficiaries.setIdType(setIDType(mr.getIdTypeId()));
        beneficiaries.setName(mr.getName());
        beneficiaries.setRelationShip(setRelationShip(mr.getRelationShipId()));
        beneficiaries.setStudent(mr.getBenStudent());
       // beneficiaries.setTotalCharge(BigDecimal.valueOf(customerResponse.getPricePerMember()));
        beneficiaries.setUserId(policyRequest.getUsername());
        beneficiaries.setTotalCharge(mr.getTotalCharge());
        beneficiaries.setStatus(status);

        Beneficiaries savedBeneficiaries = beneficiariesInterface.save(beneficiaries);
        LOGGER.info("Beneficiaries saved -> {}", savedBeneficiaries);
    }

    public void logPolicyHistory(PolicyRequest policyRequest,String traceId){
        InsurancePolicy ip = new InsurancePolicy();
        ip.setPolicyId(policyRequest.getPolicyId());

        InsurancePolicyHistory insurancePolicyHistory = new InsurancePolicyHistory();
        insurancePolicyHistory.setInsurancePolicy(ip);
        insurancePolicyHistory.setChangeDescription(policyRequest.getComments());
        insurancePolicyHistory.setCreatedDate(today());
        insurancePolicyHistory.setUsers(setUser(policyRequest.getUsername()));
        insurancePolicyHistory.setProcessAction(setProcessAction(ALTER.toString()));

        InsurancePolicyHistory InsurancePolicyHistory = insurancePolicyHistoryInterface.save(insurancePolicyHistory);
        LOGGER.info("InsurancePolicyHistory saved {}. traceId -> {}",InsurancePolicyHistory.getInsurancePolicy(),traceId);
    }

    public void logDocuments(PolicyRequest policyRequest,String traceId,String policyId) throws Exception{
        if(policyRequest.getFileRequests()!=null) {
            LOGGER.info("Attempting to save {} file(s). PolicyId -> {}",policyRequest.getFileRequests().size(),policyId);
            for (FileRequest fl : policyRequest.getFileRequests()) {

                String documentName = getLogId();
                Optional<DocumentType> documentType = documentTypeInterface.findById(fl.getDocumentTypeId());

                if (documentType.isPresent()) {
                    DocumentFile documentFile = new DocumentFile();
                    documentFile.setDocumentType(documentType.get());
                    String subFolder = formatDate(today(), SIMPLE_DATE_PATTERN);

                    documentFile.setInputter(policyRequest.getUsername());
                    documentFile.setCreatedDate(today());
                    documentFile.setTitle(fl.getFileName() + "." + FileUtil.getType(fl.getImage()));
                    documentFile.setUrl(File.separator + DOCUMENT_DIR + File.separator + subFolder + File.separator + documentName + "." + FileUtil.getType(fl.getImage()));
                    documentFile.setDescription(fl.getFileName());
                    documentFile.setObjectId(policyId);
                    documentFile.setFileType(fl.getFileType());

                    DocumentFile savedDocument = queryUtil.saveDocumentFile(documentFile);
                    File f = FileUtil.createFile(fl.getImage(), documentName, DOCUMENT_DIR, subFolder);
                    LOGGER.info("Document saved -> {}, File Created. Name = {}, file = {}. traceId -> {}", savedDocument.getId(), documentName, f.getAbsolutePath(), traceId);

                } else {
                    LOGGER.info("DocumentFile not found. {}. traceId -> {}", fl.getDocumentTypeId(), traceId);
                }
            }
        }
    }

    private void handleBeneficiaries(PolicyRequest policyRequest,String traceId) throws Exception{
        for (MemberRequest mr : policyRequest.getMemberRequests()) {
            Status status = new Status();
            status.setId(Statuses.ACTIVE.toString());

            InsurancePolicy insP = new InsurancePolicy();
            insP.setPolicyId(policyRequest.getPolicyId());

            if (mr.getBeneficiaryId() == null) {
              //  setBeneficiaries(policyRequest, policyRequest.getCustomerResponse(), insP, mr, status);
            } else {
                LOGGER.debug("Beneficiary {} is already added. traceId -> {}", mr.getBeneficiaryId(),traceId);
            }


        }

        if (policyRequest.getRemovedMembers() != null) {
            for (Long removalId : policyRequest.getRemovedMembers()) {
                Status status = new Status();
                status.setId(Statuses.REMOVED.toString());
                int updatedBeneficiary = beneficiariesInterface.updateBeneficiary(today(), policyRequest.getUsername(), status, removalId);

                if (updatedBeneficiary > 0) {
                    LOGGER.info("Policy successfully removed. traceId -> {}",traceId);
                } else {
                    LOGGER.info("Policy not removed. traceId -> {}",traceId);
                }
            }
        } else {
            LOGGER.debug("No members to be removed! traceId -> {}",traceId);
        }

    }

    public void logPayments(StringBuilder errorMessage,PaymentLog paymentLog,InsurancePolicy insurancePolicy,CollectionLog collectionLog,PaymentSchedule paymentSchedule,String t24Response){

        if (errorMessage.toString().isEmpty()) {
            paymentLog.setPaymentStatus(Statuses.SUCCESS.toString());
            collectionLog.setStatus(Statuses.PAID.toString());
            paymentSchedule.setInsurancePolicy(insurancePolicy);

            PaymentSchedule savedPaymentSchedule = paymentScheduleInterface.save(paymentSchedule);
            paymentLog.setPaymentSchedule(savedPaymentSchedule);

            LOGGER.info("PaymentSchedule saved {}", savedPaymentSchedule.getPaymentScheduleId());

            CollectionLog savedCollectionLog = collectionLogInterface.save(collectionLog);
            LOGGER.info("CollectionLog saved {}", savedCollectionLog.getId());



        } else {

            paymentLog.setPaymentStatus(Statuses.FAILED.toString());
            collectionLog.setStatus(Statuses.UNPAID.toString());
            collectionLog.setCreatedDate(today());
            collectionLog.setPolicyId(insurancePolicy.getPolicyId());
            collectionLog.setError(errorMessage.toString());
            collectionLog.setResponse(t24Response);



        }
    }

    public boolean postChargeablePolicy(PolicyHolder policyHolder, InsurancePolicy insurancePolicy, PolicyRequest policyRequest,
                                        SubProductAccount subProductAccount, String traceId) throws Exception{
        InsurancePolicy savedInsurancePolicy;
        if(policyHolder !=null) {
            PolicyHolder savedPolicyHolder = policyHolderInterface.saveAndFlush(policyHolder);
            insurancePolicy.setPolicyHolder(savedPolicyHolder);
            LOGGER.info("Account saved -> {}", savedPolicyHolder);
        }


        savedInsurancePolicy = insurancePolicyInterface.saveAndFlush(insurancePolicy);
        LOGGER.info("Policy saved. Policy ID -> {}", savedInsurancePolicy.getPolicyId());


        CorePayload corePayload = new CorePayload();
        corePayload.setInsurancePolicy(savedInsurancePolicy);
        corePayload.setTraceId(traceId);
        corePayload.setSubProductAccount(subProductAccount);

        logDocuments(policyRequest,traceId,insurancePolicy.getPolicyId());

        return t24Util.postTransaction(corePayload);
    }


}
