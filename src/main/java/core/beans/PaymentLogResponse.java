package core.beans;

import dao.entities.InsuranceBalance;

import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;

public class PaymentLogResponse {

    private Long insuranceStatementEntryId ;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private BigDecimal outstandingBalance;
    private String policyId;
    private String entryDescription;
    private Date entryDate;
    private BigDecimal currentBalance;
    private String clientName;

    public Long getInsuranceStatementEntryId() {
        return insuranceStatementEntryId;
    }

    public void setInsuranceStatementEntryId(Long insuranceStatementEntryId) {
        this.insuranceStatementEntryId = insuranceStatementEntryId;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getEntryDescription() {
        return entryDescription;
    }

    public void setEntryDescription(String entryDescription) {
        this.entryDescription = entryDescription;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "PaymentLogResponse{" +
                "insuranceStatementEntryId=" + insuranceStatementEntryId +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                ", outstandingBalance=" + outstandingBalance +
                ", policyId='" + policyId + '\'' +
                ", entryDescription='" + entryDescription + '\'' +
                ", entryDate=" + entryDate +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
