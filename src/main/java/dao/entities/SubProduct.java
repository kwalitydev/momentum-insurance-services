package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class SubProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subProductId;
    @Column(length = 35)
    private String name;
    @Column(length = 255)
    private String description;
    private Date createdDate;
    private String userId;
    @OneToOne
    private Product product;
    private Boolean hasCoverageType;
    @Column(nullable = true)
    private int maxConcurrentPolicies;
    private Boolean requiresBeneficiary;
    private Boolean blockBeneficiary;
    private Double SLAInHours;
    @OneToOne
    private InsuranceCompany insuranceCompany;
    private Boolean hasChargeableDependents;
    private Boolean hasStampDuty;
    private Integer quotationValidity = 14;
    private String subProductType;
    private String aliasName;


    public Boolean getBlockBeneficiary() {
        return blockBeneficiary;
    }

    public void setBlockBeneficiary(Boolean blockBeneficiary) {
        this.blockBeneficiary = blockBeneficiary;
    }

    public Long getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(Long subProductId) {
        this.subProductId = subProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getHasCoverageType() {
        return hasCoverageType;
    }

    public void setHasCoverageType(Boolean hasCoverageType) {
        this.hasCoverageType = hasCoverageType;
    }

    public int getMaxConcurrentPolicies() {
        return maxConcurrentPolicies;
    }

    public void setMaxConcurrentPolicies(int maxConcurrentPolicies) {
        this.maxConcurrentPolicies = maxConcurrentPolicies;
    }

    public Boolean getRequiresBeneficiary() {
        return requiresBeneficiary;
    }

    public void setRequiresBeneficiary(Boolean requiresBeneficiary) {
        this.requiresBeneficiary = requiresBeneficiary;
    }

    public Double getSLAInHours() {
        return SLAInHours;
    }

    public void setSLAInHours(Double SLAInHours) {
        this.SLAInHours = SLAInHours;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Boolean getHasChargeableDependents() {
        return hasChargeableDependents;
    }

    public void setHasChargeableDependents(Boolean hasChargeableDependents) {
        this.hasChargeableDependents = hasChargeableDependents;
    }

    public Integer getQuotationValidity() {
        return quotationValidity;
    }

    public void setQuotationValidity(Integer quotationValidity) {
        this.quotationValidity = quotationValidity;
    }

    public String getSubProductType() {
        return subProductType;
    }

    public void setSubProductType(String subProductType) {
        this.subProductType = subProductType;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Boolean getHasStampDuty() {
        return hasStampDuty;
    }

    public void setHasStampDuty(Boolean hasStampDuty) {
        this.hasStampDuty = hasStampDuty;
    }

    @Override
    public String toString() {
        return "SubProduct{" +
                "subProductId=" + subProductId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", userId='" + userId + '\'' +
                ", product=" + product +
                ", hasCoverageType=" + hasCoverageType +
                ", maxConcurrentPolicies=" + maxConcurrentPolicies +
                ", requiresBeneficiary=" + requiresBeneficiary +
                ", blockBeneficiary=" + blockBeneficiary +
                ", SLAInHours=" + SLAInHours +
                ", insuranceCompany=" + insuranceCompany +
                ", hasChargeableDependents=" + hasChargeableDependents +
                ", hasStampDuty=" + hasStampDuty +
                ", quotationValidity=" + quotationValidity +
                ", subProductType='" + subProductType + '\'' +
                ", aliasName='" + aliasName + '\'' +
                '}';
    }
}
