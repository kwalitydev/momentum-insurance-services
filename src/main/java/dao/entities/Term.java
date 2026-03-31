package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Term implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long termId;
    private int term;
    private int minAge;
    private int maxAge;
    private BigDecimal premium;
    @OneToOne
    private Status status;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    private Date createdDate;
    private String userCreated;
    private BigDecimal coverAmount;
    @OneToOne
    private SubProduct subProduct;

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
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

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ProcessWorkflow getProcessWorkflow() {
        return processWorkflow;
    }

    public void setProcessWorkflow(ProcessWorkflow processWorkflow) {
        this.processWorkflow = processWorkflow;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(String userCreated) {
        this.userCreated = userCreated;
    }

    public BigDecimal getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(BigDecimal coverAmount) {
        this.coverAmount = coverAmount;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    @Override
    public String toString() {
        return "Term{" +
                "termId=" + termId +
                ", term=" + term +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", premium=" + premium +
                ", status=" + status +
                ", processWorkflow=" + processWorkflow +
                ", createdDate=" + createdDate +
                ", userCreated='" + userCreated + '\'' +
                ", coverAmount=" + coverAmount +
                ", subProduct=" + subProduct +
                '}';
    }
}
