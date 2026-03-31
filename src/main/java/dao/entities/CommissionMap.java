package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class CommissionMap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 13)
    private int chargeableDependents;
    private BigDecimal insurerPremium;
    private Date createdDate;
    @OneToOne
    private InsuranceCompany insuranceCompany;
    @OneToOne
    private Coverage coverage;
    @OneToOne
    private SubProduct subProduct;
    @OneToOne
    private Status status;
    private double netGPIRatio;
    private double netCommissionPercentage;
    private double customFee;
    @OneToOne
    private Users users;
    private Boolean specialCommission;
    private String productId;
    private BigDecimal sbFee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getChargeableDependents() {
        return chargeableDependents;
    }

    public void setChargeableDependents(int chargeableDependents) {
        this.chargeableDependents = chargeableDependents;
    }

    public BigDecimal getInsurerPremium() {
        return insurerPremium;
    }

    public void setInsurerPremium(BigDecimal insurerPremium) {
        this.insurerPremium = insurerPremium;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public Coverage getCoverage() {
        return coverage;
    }

    public void setCoverage(Coverage coverage) {
        this.coverage = coverage;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getNetGPIRatio() {
        return netGPIRatio;
    }

    public void setNetGPIRatio(double netGPIRatio) {
        this.netGPIRatio = netGPIRatio;
    }

    public double getNetCommissionPercentage() {
        return netCommissionPercentage;
    }

    public void setNetCommissionPercentage(double netCommissionPercentage) {
        this.netCommissionPercentage = netCommissionPercentage;
    }

    public double getCustomFee() {
        return customFee;
    }

    public void setCustomFee(double customFee) {
        this.customFee = customFee;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Boolean getSpecialCommission() {
        return specialCommission;
    }

    public void setSpecialCommission(Boolean specialCommission) {
        this.specialCommission = specialCommission;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getSbFee() {
        return sbFee;
    }

    public void setSbFee(BigDecimal sbFee) {
        this.sbFee = sbFee;
    }

    @Override
    public String toString() {
        return "CommissionMap{" +
                "id=" + id +
                ", chargeableDependents=" + chargeableDependents +
                ", insurerPremium=" + insurerPremium +
                ", createdDate=" + createdDate +
                ", insuranceCompany=" + insuranceCompany +
                ", coverage=" + coverage +
                ", subProduct=" + subProduct +
                ", status=" + status +
                ", netGPIRatio=" + netGPIRatio +
                ", netCommissionPercentage=" + netCommissionPercentage +
                ", customFee=" + customFee +
                ", users=" + users +
                ", specialCommission=" + specialCommission +
                ", productId='" + productId + '\'' +
                ", sbFee=" + sbFee +
                '}';
    }
}
