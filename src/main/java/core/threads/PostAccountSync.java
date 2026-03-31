package core.threads;

import adapter.PaymentInterface;
import com.temenos.sbgetcustomerbyaccount.SBGETCUSTOMERBYACCOUNTType;
import com.temenos.sbm_insurance.SBGetCustomerByAccountResponse;
import core.beans.AccountMin;
import core.util.QueryUtil;
import dao.entities.PolicyHolder;
import dao.entities.JobTitle;
import dao.interfaces.JobTitleInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static core.util.CoreUtil.*;



@ApplicationScoped
public class PostAccountSync implements Function<PolicyHolder, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostAccountSync.class);
    @Inject
    private PaymentInterface paymentInterface;
    @Inject
    private JobTitleInterface jobTitleInterface;

    @Inject
    private QueryUtil queryUtil;
    @Inject
    private PostAccountUpdate postAccountUpdate;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;

    @Override
    public String apply(PolicyHolder policyHolder) {
        String traceId = getLogId();
        try {
            LOGGER.info("Sync account {}. traceId -> {}", policyHolder.getAccountNumber(),traceId);

            SBGetCustomerByAccountResponse customer = paymentInterface.getCustomerDetails(policyHolder.getAccountNumber(), traceId);
            if (customer == null) {
                LOGGER.warn("No customer details found for account {}. traceId -> {}", policyHolder.getAccountNumber(),traceId);
                return null;
            }

            List<SBGETCUSTOMERBYACCOUNTType> accounts = customer.getSBGETCUSTOMERBYACCOUNTType();
            LOGGER.debug("T24 returned {}", accounts);
            if (accounts.isEmpty()) {
                LOGGER.warn("No accounts found in T24 response for account {}. traceId -> {}", policyHolder.getAccountNumber(),traceId);
                return null;
            }

            List<SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType.MSBGETCUSTOMERBYACCOUNTDetailType> detailType =
                    accounts.get(0).getGSBGETCUSTOMERBYACCOUNTDetailType().getMSBGETCUSTOMERBYACCOUNTDetailType();
            if (detailType.isEmpty()) {
                LOGGER.warn("No detail type found in T24 response for account {}. traceId -> {}", policyHolder.getAccountNumber(),traceId);
                return null;
            }

            SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType.MSBGETCUSTOMERBYACCOUNTDetailType customerDetails = detailType.get(0);

            JobTitle jobTitle = getJobTitle(customerDetails.getJOBTITLE(), policyHolder.getAccountNumber(),traceId);

            AccountMin accountMin = new AccountMin(policyHolder.getAccountNumber(),
                    customerDetails.getCUSTOMERID(),
                    formatT24Date(customerDetails.getBIRTHINCORPDATE()),
                    customerDetails.getSMS1(),
                    customerDetails.getSHORTNAME(),
                    customerDetails.getEMAIL1(),
                    customerDetails.getTAXID(),
                    customerDetails.getADDRESS(),
                    jobTitle,
                    customerDetails.getLEGALID(),
                    policyHolder.getId());
            /*Callable<String> callable = () -> postAccountUpdate.apply(accountMin);
            executorService.submit(callable); */

            postAccountUpdate.apply(accountMin);

        } catch (Exception e) {
            LOGGER.error("Error while obtaining account details for account {}", policyHolder.getAccountNumber(), e);
        }

        return null;
    }

    private JobTitle getJobTitle(String jobTitleId, String accountNumber,String traceId) {
        try {
            Optional<JobTitle> jobTitle = jobTitleInterface.findByJobTitleId(Long.parseLong(jobTitleId));
            if (jobTitle.isPresent()) {
                return jobTitle.get();
            }
        } catch (NumberFormatException e) {
            LOGGER.warn("Bad format for JobTitle ID for account {}. JobTitle -> {}, traceId -> {}", accountNumber,jobTitleId,traceId);
        } catch (Exception e) {
            LOGGER.error("Error retrieving JobTitle for account {}. JobTitle -> {}, traceId -> {}, error -> {}", accountNumber,jobTitleId,traceId,e.getMessage());
            e.printStackTrace();
        }
        return null;
    }







}
