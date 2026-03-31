package core.threads;

import adapter.PaymentInterface;
import com.temenos.sbm_insurance.SBInsuranceTableResponse;
import com.temenos.sbm_insurance.SBInsuranceUpdateTableResponse;
import core.beans.InsuranceSync;
import core.constants.Statuses;
import core.constants.T24Messages;
import dao.BeanFactory;
import dao.entities.PolicySyncHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.function.Function;

import static core.util.CoreUtil.*;
import static core.util.Util.T24_DATE_PATTERN;

@Dependent
@Transactional
public class PostInsuranceSync implements Function<InsuranceSync, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostInsuranceSync.class);
    @Inject
    private PaymentInterface paymentInterface;
    @Inject
    private BeanFactory beanFactory;

    @Override
    public String apply(InsuranceSync insuranceSync) {
        String policyId = insuranceSync.getPolicyId();
        String migrationStatus = insuranceSync.getMigrationStatus();
        String transType = insuranceSync.getTransType();
        String accountNumber = insuranceSync.getAccountNumber();

        try {
            updateMigrationStatusOnSBSEG(policyId, migrationStatus, transType);
        } catch (Exception e) {
            LOGGER.error("EB.SB.SEG.UPDATE table not updated for policy {}. Error: {}", policyId, e.getMessage(), e);
        }

        try {
            updateMigrationStatusOnEBSBSEGUROS(policyId, migrationStatus, accountNumber);
        } catch (Exception e) {
            LOGGER.error("Policy {} not updated. Error: {}", policyId, e.getMessage(), e);
            updateHistoryTable(policyId, Statuses.ERROR.toString(), e.getMessage());
        }

        return null;
    }

    private void updateMigrationStatusOnSBSEG(String policyId, String migrationStatus, String transType) throws Exception {
        LOGGER.info("Updating policy {} migration status on SB.SEG.UPDATE", policyId);
        SBInsuranceUpdateTableResponse updateTableResponse = paymentInterface.updateMigrationStatus(migrationStatus, policyId, transType);
        LOGGER.info("Core response -> {}", updateTableResponse);
    }

    private void updateMigrationStatusOnEBSBSEGUROS(String policyId, String migrationStatus, String accountNumber) throws Exception {
        LOGGER.info("Updating policy {} migration status on EB.SB.SEGUROS", policyId);
        SBInsuranceTableResponse coreResponse = paymentInterface.updatePolicyStatus(accountNumber, migrationStatus, policyId, formatDate(today(), T24_DATE_PATTERN));
        LOGGER.info("Core response -> {}", coreResponse);

        String t24Status = coreResponse.getStatus().getSuccessIndicator().value();
        if (t24Status.equalsIgnoreCase(T24Messages.SUCCESS.toString())) {
            updateHistoryTable(policyId, Statuses.SUCCESS.toString(), null);
        } else {
            String errorMessage = String.join(" ", coreResponse.getStatus().getMessages());
            updateHistoryTable(policyId, Statuses.FAILED.toString(), errorMessage);
        }
    }




    public void updateHistoryTable(String policyId,String status,String errorDesc){
        PolicySyncHistory policySyncHistory = new PolicySyncHistory();
        policySyncHistory.setInsurancePolicyId(policyId);
        policySyncHistory.setSyncDate(today());
        policySyncHistory.setSyncStatus(status);
        policySyncHistory.setErrorDesc(errorDesc);
        try {
            PolicySyncHistory saved = beanFactory.merge(policySyncHistory);
            LOGGER.info("Policy History Table Successfully updated. Id -> {}",saved.getPshId());
        }
        catch (Exception e){
            LOGGER.error("Error updating history table for policy {}",policyId,e);
        }

    }




}
