package dao.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class InsuranceStatementEntry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceStatementEntryId ;
    private BigDecimal debitAmount;
    private BigDecimal creditAmount;
    private BigDecimal outstandingBalance;
    @OneToOne
    private InsuranceBalance insuranceBalance;
    private String entryDescription;
    private Date entryDate;

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

    public InsuranceBalance getInsuranceBalance() {
        return insuranceBalance;
    }

    public void setInsuranceBalance(InsuranceBalance insuranceBalance) {
        this.insuranceBalance = insuranceBalance;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public BigDecimal getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public String getEntryDescription() {
        return entryDescription;
    }

    public void setEntryDescription(String entryDescription) {
        this.entryDescription = entryDescription;
    }

    @Override
    public String toString() {
        return "InsuranceStatementEntry{" +
                "insuranceStatementEntryId=" + insuranceStatementEntryId +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                ", outstandingBalance=" + outstandingBalance +
                ", insuranceBalance=" + insuranceBalance +
                ", entryDate=" + entryDate +
                '}';
    }
}
