package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Beneficiaries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long beneficiaryId;
    @Column(length = 50)
    private String name;
    private Date dateOfBirth;
    @OneToOne
    private IDType idType;
    @Column(length = 3)
    private String student;
    @OneToOne
    private RelationShip relationShip;
    @Column(length = 35)
    private String documentNumber;
    private Date createdDate;
    private Date lastUpdated;
    @Column(length = 20)
    private String userId;
    private BigDecimal totalCharge;
    @OneToOne
    private InsurancePolicy insurancePolicy;
    @OneToOne
    private Status status;
    private Date effectiveDate;



    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public IDType getIdType() {
        return idType;
    }

    public void setIdType(IDType idType) {
        this.idType = idType;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public RelationShip getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(RelationShip relationShip) {
        this.relationShip = relationShip;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public InsurancePolicy getPolicy() {
        return insurancePolicy;
    }

    public void setPolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
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

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public String toString() {
        return "Beneficiaries{" +
                "beneficiaryId=" + beneficiaryId +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", idType=" + idType +
                ", student='" + student + '\'' +
                ", relationShip=" + relationShip +
                ", documentNumber='" + documentNumber + '\'' +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", userId='" + userId + '\'' +
                ", totalCharge=" + totalCharge +
                ", insurancePolicy=" + insurancePolicy +
                ", status=" + status +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
