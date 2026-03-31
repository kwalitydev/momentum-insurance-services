package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SubProductAccount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productAccountId;
    @Column(length = 13)
    private String accountId;
    @OneToOne
    private Currency currency;
    @OneToOne
    private Status status;
    private Date createdDate;
    private Date lastUpdated;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    @Column(length = 9)
    private String companyCode;
    @OneToOne
    private SubProduct subProduct;


    public Long getProductAccountId() {
        return productAccountId;
    }

    public void setProductAccountId(Long productAccountId) {
        this.productAccountId = productAccountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    @Override
    public String toString() {
        return "SubProductAccount{" +
                "productAccountId=" + productAccountId +
                ", accountId='" + accountId + '\'' +
                ", currency=" + currency +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", processWorkflow=" + processWorkflow +
                ", companyCode='" + companyCode + '\'' +
                ", subProduct=" + subProduct +
                '}';
    }
}
