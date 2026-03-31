package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Claim implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLAIM_SEQ")
    @SequenceGenerator(sequenceName = "claims_seq", allocationSize = 1, name = "CLAIM_SEQ")
    private Long claimId;
    @OneToOne
    private InsurancePolicy insurancePolicy;
    @OneToOne
    private Status status;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    private Date createdDate;
    private String description;
    @OneToOne
    private InsuranceCompany insuranceCompany;
    private String sinisterPlace;
    private Date sinisterDate;
    private Date admissionDate;
    private Date exitDate;
    private BigDecimal benefitAmount;
    private String sinisterType;
    @OneToOne
    private Users users;
    @Column(length = 35)
    private String claimant;
    private Date closureDate;
    private String qmsProcessNr;
    private String claimProcessId;
    private BigDecimal insurerPaidAmount;
    private String coverType;
    private String sinisterStatus;
    private BigDecimal franchiseAmount;


    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getSinisterPlace() {
        return sinisterPlace;
    }

    public void setSinisterPlace(String sinisterPlace) {
        this.sinisterPlace = sinisterPlace;
    }

    public Date getSinisterDate() {
        return sinisterDate;
    }

    public void setSinisterDate(Date sinisterDate) {
        this.sinisterDate = sinisterDate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    public BigDecimal getBenefitAmount() {
        return benefitAmount;
    }

    public void setBenefitAmount(BigDecimal benefitAmount) {
        this.benefitAmount = benefitAmount;
    }

    public String getSinisterType() {
        return sinisterType;
    }

    public void setSinisterType(String sinisterType) {
        this.sinisterType = sinisterType;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getClaimant() {
        return claimant;
    }

    public void setClaimant(String claimant) {
        this.claimant = claimant;
    }

    public Date getClosureDate() {
        return closureDate;
    }

    public void setClosureDate(Date closureDate) {
        this.closureDate = closureDate;
    }

    public String getQmsProcessNr() {
        return qmsProcessNr;
    }

    public void setQmsProcessNr(String qmsProcessNr) {
        this.qmsProcessNr = qmsProcessNr;
    }

    public String getClaimProcessId() {
        return claimProcessId;
    }

    public void setClaimProcessId(String claimProcessId) {
        this.claimProcessId = claimProcessId;
    }

    public BigDecimal getInsurerPaidAmount() {
        return insurerPaidAmount;
    }

    public void setInsurerPaidAmount(BigDecimal insurerPaidAmount) {
        this.insurerPaidAmount = insurerPaidAmount;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getSinisterStatus() {
        return sinisterStatus;
    }

    public void setSinisterStatus(String sinisterStatus) {
        this.sinisterStatus = sinisterStatus;
    }

    public BigDecimal getFranchiseAmount() {
        return franchiseAmount;
    }

    public void setFranchiseAmount(BigDecimal franchiseAmount) {
        this.franchiseAmount = franchiseAmount;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimId=" + claimId +
                ", insurancePolicy=" + insurancePolicy +
                ", status=" + status +
                ", processWorkflow=" + processWorkflow +
                ", createdDate=" + createdDate +
                ", description='" + description + '\'' +
                ", insuranceCompany=" + insuranceCompany +
                ", sinisterPlace='" + sinisterPlace + '\'' +
                ", sinisterDate=" + sinisterDate +
                ", admissionDate=" + admissionDate +
                ", exitDate=" + exitDate +
                ", benefitAmount=" + benefitAmount +
                ", sinisterType='" + sinisterType + '\'' +
                ", users=" + users +
                ", claimant='" + claimant + '\'' +
                ", closureDate=" + closureDate +
                ", qmsProcessNr='" + qmsProcessNr + '\'' +
                ", claimProcessId='" + claimProcessId + '\'' +
                ", insurerPaidAmount=" + insurerPaidAmount +
                ", coverType='" + coverType + '\'' +
                ", sinisterStatus='" + sinisterStatus + '\'' +
                ", franchiseAmount=" + franchiseAmount +
                '}';
    }
}
