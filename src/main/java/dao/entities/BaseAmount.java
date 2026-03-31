package dao.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class BaseAmount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long baseAmountId;
    @OneToOne
    private Currency currency;
    @OneToOne
    private ProductConfig productConfig;
    @OneToOne
    private Status status;
    private Date createdDate;
    private Date lastUpdated;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    private BigDecimal baseAmount;
    @OneToOne
    private BenefitCycle benefitCycle;


    public Long getBaseAmountId() {
        return baseAmountId;
    }

    public void setBaseAmountId(Long baseAmountId) {
        this.baseAmountId = baseAmountId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public ProductConfig getProductConfig() {
        return productConfig;
    }

    public void setProductConfig(ProductConfig productConfig) {
        this.productConfig = productConfig;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ProcessWorkflow getProcessWorkflow() {
        return processWorkflow;
    }

    public void setProcessWorkflow(ProcessWorkflow processWorkflow) {
        this.processWorkflow = processWorkflow;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BenefitCycle getBenefitCycle() {
        return benefitCycle;
    }

    public void setBenefitCycle(BenefitCycle benefitCycle) {
        this.benefitCycle = benefitCycle;
    }

    @Override
    public String toString() {
        return "BaseAmount{" +
                "baseAmountId=" + baseAmountId +
                ", currency=" + currency +
                ", productConfig=" + productConfig +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", processWorkflow=" + processWorkflow +
                ", baseAmount=" + baseAmount +
                ", benefitCycle=" + benefitCycle +
                '}';
    }
}
