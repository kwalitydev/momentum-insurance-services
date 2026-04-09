package dao.entities;

import core.constants.RecordTypes;
import core.constants.SuspensionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class InsurancePolicy {
    @Id
    private String policyId;
    private String insurancePolicyId;
    @OneToOne
    private SubProduct subProduct;
    @OneToOne
    private PolicyHolder policyHolder;
    @OneToOne
    private Currency currency;
    private BigDecimal totalAmount;
    private String recordType = RecordTypes.SIMULATED.toString();
    @OneToOne
    private Users users;
    private Date createdDate;
    private Date lastUpdated;
    @Column(length = 25)
    private String updatedUser;
    @OneToOne
    private Status status;
    private Date startDate;
    private Date issueDate;
    private Date expiryDate;
    @OneToOne
    private Frequency paymentFrequency;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    private String simulationId;
    @OneToOne
    private BenefitCycle benefitCycle;
    private String suspensionType = SuspensionType.NO_SUSPENSION.toString();


    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
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

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Frequency getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(Frequency paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public ProcessWorkflow getProcessWorkflow() {
        return processWorkflow;
    }

    public void setProcessWorkflow(ProcessWorkflow processWorkflow) {
        this.processWorkflow = processWorkflow;
    }


    public String getSimulationId() {
        return simulationId;
    }

    public void setSimulationId(String simulationId) {
        this.simulationId = simulationId;
    }


    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    public BenefitCycle getBenefitCycle() {
        return benefitCycle;
    }

    public void setBenefitCycle(BenefitCycle benefitCycle) {
        this.benefitCycle = benefitCycle;
    }

    public String getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyId='" + policyId + '\'' +
                ", insurancePolicyId='" + insurancePolicyId + '\'' +
                ", subProduct=" + subProduct +
                ", policyHolder=" + policyHolder +
                ", currency=" + currency +
                ", totalAmount=" + totalAmount +
                ", recordType='" + recordType + '\'' +
                ", users=" + users +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", updatedUser='" + updatedUser + '\'' +
                ", status=" + status +
                ", startDate=" + startDate +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", paymentFrequency=" + paymentFrequency +
                ", processWorkflow=" + processWorkflow +
                ", simulationId='" + simulationId + '\'' +
                ", benefitCycle=" + benefitCycle +
                ", suspensionType='" + suspensionType + '\'' +
                '}';
    }
}
