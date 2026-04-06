package dao.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class InsuranceOutstandingAmount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceOutstandingAmountId;
    private BigDecimal amount;
    @OneToOne
    private InsurancePolicy insurancePolicy;
    private String transactionType; // e.g "creditor" or "debtor"
    private String description;
    private Date lastUpdatedDate;
    private Date entryDate;
    @OneToOne
    private Status status;

    public Long getInsuranceOutstandingAmountId() {
        return insuranceOutstandingAmountId;
    }

    public void setInsuranceOutstandingAmountId(Long insuranceOutstandingAmountId) {
        this.insuranceOutstandingAmountId = insuranceOutstandingAmountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }


    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InsuranceOutstandingAmount{" +
                "insuranceOutstandingAmountId=" + insuranceOutstandingAmountId +
                ", amount=" + amount +
                ", insurancePolicy=" + insurancePolicy +
                ", transactionType='" + transactionType + '\'' +
                ", description=" + description +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", entryDate=" + entryDate +
                ", status=" + status +
                '}';
    }
}
