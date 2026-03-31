package adapter;

import com.temenos.sbm_insurance.*;


public interface PaymentInterface {
    void initialize();
    SBInsurancePaymentsResponse postTransaction(String accountNumber, String debitCCY, String debitAmount,String debitTheirRef, String creditTheirRef, String creditAccount,String processingDate, String paymentDetails,String company,String logId,String taskProduct);
    SBGetCustomerByAccountResponse getCustomerDetails(String accountId,String traceId) throws Exception;
    SBInsuranceTableResponse updatePolicyStatus(String accountNumber, String migrationStatus, String policyId, String migrationDate) throws Exception;
    SBGetSBSegUpdatesResponse getUpdatedPolicies(String status,String date) throws Exception;
    SBInsuranceGetLoanListResponse getLoanDetails(String policyId) throws Exception;
    SBInsuranceUpdateTableResponse updateMigrationStatus(String migrationStatus, String policyId,String transType) throws Exception;
    SBGetNetTxnDtxResponse  getFTDetails(String logId);
}
