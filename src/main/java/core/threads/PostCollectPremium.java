package core.threads;

import core.beans.CollectContext;
import core.beans.CorePayload;
import core.util.T24Util;
import dao.entities.InsurancePolicy;
import dao.entities.SubProductAccount;
import dao.interfaces.SubProductAccountInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;
import java.util.function.Function;

import static core.util.Util.setActive;

@ApplicationScoped
public class PostCollectPremium implements Function<CollectContext, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostCollectPremium.class);

    @Inject
    private T24Util t24Util;
    @Inject
    private SubProductAccountInterface subProductAccountInterface;

    @Override
    public synchronized String apply(CollectContext collectContext) {

        try {

            CorePayload corePayload = new CorePayload();
            corePayload.setInsurancePolicy(collectContext.getInsurancePolicy());
            corePayload.setTraceId(collectContext.getLogId());
            InsurancePolicy insurancePolicy = collectContext.getInsurancePolicy();
            Optional<SubProductAccount> subProductAccount = subProductAccountInterface.findBySubProductAndCurrencyAndStatus(insurancePolicy.getSubProduct(),insurancePolicy.getCurrency(), setActive());
            subProductAccount.ifPresent(corePayload::setSubProductAccount);

            if(t24Util.postTransaction(corePayload)){
                LOGGER.info("Payment successfully processed. traceId -> {}",collectContext.getLogId());
            }
            else {
                LOGGER.info("Payment not processed. traceId -> {}",collectContext.getLogId());
            }


        } catch (Exception e) {
            LOGGER.error("Error while posting transaction",e);
        }


        return null;
    }



}
