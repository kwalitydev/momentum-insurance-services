package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Coverage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coverageId;
    @OneToOne
    private Currency currency;
    private BigDecimal coverAmount;
    private BigDecimal premiumAmount;
    @OneToOne
    private ProductConfig productConfig;
    @OneToOne
    private Status status;
    private Date createdDate;
    private Date lastUpdated;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    private Double coverageRate;
    private BigDecimal adminFee;
    private BigDecimal childBenefitSup;
    private BigDecimal childBenefitMin;



    public Long getCoverageId() {
        return coverageId;
    }

    public void setCoverageId(Long coverageId) {
        this.coverageId = coverageId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(BigDecimal coverAmount) {
        this.coverAmount = coverAmount;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
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

    public Double getCoverageRate() {
        return coverageRate;
    }

    public void setCoverageRate(Double coverageRate) {
        this.coverageRate = coverageRate;
    }

    public BigDecimal getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(BigDecimal adminFee) {
        this.adminFee = adminFee;
    }

    public BigDecimal getChildBenefitSup() {
        return childBenefitSup;
    }

    public void setChildBenefitSup(BigDecimal childBenefitSup) {
        this.childBenefitSup = childBenefitSup;
    }

    public BigDecimal getChildBenefitMin() {
        return childBenefitMin;
    }

    public void setChildBenefitMin(BigDecimal childBenefitMin) {
        this.childBenefitMin = childBenefitMin;
    }

    @Override
    public String toString() {
        return "Coverage{" +
                "coverageId=" + coverageId +
                ", currency=" + currency +
                ", coverAmount=" + coverAmount +
                ", premiumAmount=" + premiumAmount +
                ", productConfig=" + productConfig +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", processWorkflow=" + processWorkflow +
                ", coverageRate=" + coverageRate +
                ", adminFee=" + adminFee +
                ", childBenefitSup=" + childBenefitSup +
                ", childBenefitMin=" + childBenefitMin +
                '}';
    }
}
