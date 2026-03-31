package core.threads;

import core.beans.AccountMin;
import dao.interfaces.PolicyHolderInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.function.Function;

import static core.util.CoreUtil.*;
import static core.util.CoreUtil.today;


@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class PostAccountUpdate implements Function<AccountMin, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostAccountUpdate.class);
    @Inject
    private PolicyHolderInterface policyHolderInterface;

    @Override
    public String apply(AccountMin accountMin) {
        try {

            Long jobTitleId = null;
            if (accountMin.getJobTitleNew() != null) {
                jobTitleId = accountMin.getJobTitleNew().getJobTitleId();
            }
                int updatedAccount = policyHolderInterface.updateAccount(accountMin.getAccountNumber(),
                        accountMin.getCustomerId(),
                        stringToDate(accountMin.getDateOfBirth()),
                        accountMin.getMobileNumber(),
                        today(),
                        accountMin.getCustomerName(),
                        accountMin.getEmail(),
                        accountMin.getVat(),
                        accountMin.getAddress(), jobTitleId, accountMin.getDocumentId(),accountMin.getId());

                if (updatedAccount > 0) {
                    LOGGER.info("Account updated");
                } else {
                    LOGGER.info("Account not updated");
                }


        } catch (Exception e) {
            LOGGER.error("Error while obtaining account details for account {}", accountMin.getAccountNumber(), e);
        }

        return null;
    }



}
