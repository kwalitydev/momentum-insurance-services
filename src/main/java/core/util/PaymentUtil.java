package core.util;

import adapter.PaymentInterface;
import com.temenos.sbm_insurance.SBInsurancePaymentsResponse;
import core.beans.PolicyResponse;
import core.constants.Statuses;
import core.constants.T24Messages;
import dao.entities.InsurancePolicy;
import dao.entities.PaymentSchedule;
import dao.entities.SubProductAccount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;

import static core.util.CoreUtil.hasOverride;
import static core.util.CoreUtil.today;
import static core.util.Util.T24_DATE_PATTERN;
import static core.util.Util.setStatus;

@ApplicationScoped
public class PaymentUtil {

    private static final Logger LOGGER = LogManager.getLogger(PaymentUtil.class);
    @Inject
    private PaymentInterface paymentInterface;

    public SBInsurancePaymentsResponse setCorePayment(String reqRes, PolicyResponse policyResponse, InsurancePolicy insurancePolicy, PaymentSchedule paymentSchedule,
                                                      StringBuilder errorMessage, SubProductAccount subProductAccount,
                                                      String debitAccount, String creditAccount, String debitAmount, String debitTheirRef) {

        SBInsurancePaymentsResponse paymentsResponse = paymentInterface.postTransaction(debitAccount, insurancePolicy.getCurrency().getCurrencyId(), debitAmount,
                insurancePolicy.getPolicyId(), insurancePolicy.getPolicyId(), creditAccount, CoreUtil.formatDate(today(), T24_DATE_PATTERN),
                debitTheirRef, subProductAccount.getCompanyCode(), reqRes,"Manual_Task");

        String t24Status = paymentsResponse.getStatus().getSuccessIndicator().value();
        LOGGER.info("T24 response -> {}", paymentsResponse.getStatus());

        switch (t24Status.toUpperCase()) {
            case "SUCCESS":
                handleSuccessResponse(paymentsResponse, policyResponse, insurancePolicy, paymentSchedule);
                break;
            case "T_24_ERROR":
            case "T24ERROR":
                handleErrorResponse(paymentsResponse, policyResponse, insurancePolicy, paymentSchedule, errorMessage);
                break;
            default:
                handleUnknownStatus(paymentsResponse, policyResponse, paymentSchedule, errorMessage, t24Status);
                break;
        }

        return paymentsResponse;
    }

    private void handleSuccessResponse(SBInsurancePaymentsResponse paymentsResponse, PolicyResponse policyResponse, InsurancePolicy insurancePolicy, PaymentSchedule paymentSchedule) {
        boolean hasOverride = paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE() != null
                && hasOverride(paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE().getOVERRIDE());

        if (hasOverride) {
            LOGGER.info("Transaction has overrides. Id -> {}, overrides -> {}", paymentsResponse.getStatus().getTransactionId(),
                    paymentsResponse.getFUNDSTRANSFERType().getGOVERRIDE().getOVERRIDE());
            policyResponse.setErrorMessage("A conta contém restrições!");
        } else {
            LOGGER.info("Payment successfully processed. Id -> {}", paymentsResponse.getStatus().getTransactionId());

            if (paymentsResponse.getFUNDSTRANSFERType() != null) {
                String chargeCode = paymentsResponse.getFUNDSTRANSFERType().getCOMMISSIONCODE();
                String transactionId = paymentsResponse.getStatus().getTransactionId();
                BigDecimal paidAmount = paymentSchedule.getRepaymentAmount();

                paymentSchedule.setStatus(setStatus(Statuses.PAID.toString()));
                paymentSchedule.setTransactionId(transactionId);
                paymentSchedule.setPaidAmount(paidAmount);
                paymentSchedule.setChargeCode(chargeCode);

                if (paymentsResponse.getStatus() != null) {
                    paymentSchedule.setMessageId(paymentsResponse.getStatus().getMessageId());
                }
            }
        }
    }

    private void handleErrorResponse(SBInsurancePaymentsResponse paymentsResponse, PolicyResponse policyResponse, InsurancePolicy insurancePolicy, PaymentSchedule paymentSchedule, StringBuilder errorMessage) {
        paymentSchedule.setMessageId(paymentSchedule.getMessageId());
        paymentsResponse.getStatus().getMessages().forEach(msg -> errorMessage.append(msg).append(" "));

        paymentSchedule.setStatus(setStatus(Statuses.UNPAID.toString()));
        policyResponse.setErrorMessage("Core Banking indisponível");
        LOGGER.error("T24 returned an error. id -> {}", insurancePolicy.getPolicyId());
    }

    private void handleUnknownStatus(SBInsurancePaymentsResponse paymentsResponse, PolicyResponse policyResponse, PaymentSchedule paymentSchedule, StringBuilder errorMessage, String t24Status) {
        errorMessage.append("Unknown T24 Status: ").append(t24Status);
        paymentSchedule.setStatus(setStatus(Statuses.UNPAID.toString()));
        LOGGER.warn("Unknown status -> {}", t24Status);
        policyResponse.setErrorMessage("Core Banking indisponível");
    }

}
