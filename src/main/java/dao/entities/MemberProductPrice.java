package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class MemberProductPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberProductPriceId;
    @OneToOne
    private Currency currency;
    private BigDecimal amount;
    @OneToOne
    private Status status;
    private Date createdDate;
    private Date lastUpdated;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    @OneToOne
    private SubProduct subProduct;
    private int minAge;
    private int maxAge;
    private String beneficiaryDescription; // ex: Child, Overaged Adult
    @OneToOne
    private BenefitCycle benefitCycle;

    public Long getMemberProductPriceId() {
        return memberProductPriceId;
    }

    public void setMemberProductPriceId(Long memberProductPriceId) {
        this.memberProductPriceId = memberProductPriceId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public String getBeneficiaryDescription() {
        return beneficiaryDescription;
    }

    public void setBeneficiaryDescription(String beneficiaryDescription) {
        this.beneficiaryDescription = beneficiaryDescription;
    }

    public BenefitCycle getBenefitCycle() {
        return benefitCycle;
    }

    public void setBenefitCycle(BenefitCycle benefitCycle) {
        this.benefitCycle = benefitCycle;
    }

    @Override
    public String toString() {
        return "MemberProductPrice{" +
                "memberProductPriceId=" + memberProductPriceId +
                ", currency=" + currency +
                ", amount=" + amount +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", processWorkflow=" + processWorkflow +
                ", subProduct=" + subProduct +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", beneficiaryDescription='" + beneficiaryDescription + '\'' +
                ", benefitCycle=" + benefitCycle +
                '}';
    }
}
