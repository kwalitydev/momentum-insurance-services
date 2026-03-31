package core.beans;

import dao.entities.InsurancePolicy;
import dao.entities.PaymentLog;

import java.io.Serializable;
import java.math.BigDecimal;

public class CommissionResponse implements Serializable {

    private InsurancePolicy insurancePolicy;
    private Double insurerPremium;
    private double netGPIRatio;
    private double netCommissionPercentage;
    private double customFee;
    private int chargeableDependents;
    private Boolean specialCommission;
    private String subProductName;
    private String customerId;
    private String customerName;
    private String accountNumber;
    private String transactionId;
    private boolean hasChargeableDependents;
    private boolean hasStampDuty = false;
    private Double stbCommission;
    private Double netPremium;
    private Double stampDuty;
    private Double groupPremium;
    private String productName;
    private int totalChargeableDependents;
    private BigDecimal numberOfEmployees;
    private BigDecimal subProductId;
    private String productId;
    private BigDecimal sbFee;
    private String attributes;
    private BigDecimal coverAmount;
    private BigDecimal annualPayroll;

    public Double getInsurerPremium() {
        return insurerPremium;
    }

    public void setInsurerPremium(Double insurerPremium) {
        this.insurerPremium = insurerPremium;
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

    public int getChargeableDependents() {
        return chargeableDependents;
    }

    public void setChargeableDependents(int chargeableDependents) {
        this.chargeableDependents = chargeableDependents;
    }

    public Boolean getSpecialCommission() {
        return specialCommission;
    }

    public void setSpecialCommission(Boolean specialCommission) {
        this.specialCommission = specialCommission;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getSubProductName() {
        return subProductName;
    }

    public void setSubProductName(String subProductName) {
        this.subProductName = subProductName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public boolean isHasChargeableDependents() {
        return hasChargeableDependents;
    }

    public void setHasChargeableDependents(boolean hasChargeableDependents) {
        this.hasChargeableDependents = hasChargeableDependents;
    }

    public boolean isHasStampDuty() {
        return hasStampDuty;
    }

    public void setHasStampDuty(boolean hasStampDuty) {
        this.hasStampDuty = hasStampDuty;
    }

    public Double getStbCommission() {
        return stbCommission;
    }

    public void setStbCommission(Double stbCommission) {
        this.stbCommission = stbCommission;
    }

    public Double getNetPremium() {
        return netPremium;
    }

    public void setNetPremium(Double netPremium) {
        this.netPremium = netPremium;
    }

    public Double getStampDuty() {
        return stampDuty;
    }

    public void setStampDuty(Double stampDuty) {
        this.stampDuty = stampDuty;
    }

    public Double getGroupPremium() {
        return groupPremium;
    }

    public void setGroupPremium(Double groupPremium) {
        this.groupPremium = groupPremium;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getTotalChargeableDependents() {
        return totalChargeableDependents;
    }

    public void setTotalChargeableDependents(int totalChargeableDependents) {
        this.totalChargeableDependents = totalChargeableDependents;
    }

    public BigDecimal getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(BigDecimal numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public BigDecimal getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(BigDecimal subProductId) {
        this.subProductId = subProductId;
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

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(BigDecimal coverAmount) {
        this.coverAmount = coverAmount;
    }

    public BigDecimal getAnnualPayroll() {
        return annualPayroll;
    }

    public void setAnnualPayroll(BigDecimal annualPayroll) {
        this.annualPayroll = annualPayroll;
    }

    @Override
    public String toString() {
        return "CommissionResponse{" +
                "insurancePolicy=" + insurancePolicy +
                ", insurerPremium=" + insurerPremium +
                ", netGPIRatio=" + netGPIRatio +
                ", netCommissionPercentage=" + netCommissionPercentage +
                ", customFee=" + customFee +
                ", chargeableDependents=" + chargeableDependents +
                ", specialCommission=" + specialCommission +
                ", subProductName='" + subProductName + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", hasChargeableDependents=" + hasChargeableDependents +
                ", hasStampDuty=" + hasStampDuty +
                ", stbCommission=" + stbCommission +
                ", netPremium=" + netPremium +
                ", stampDuty=" + stampDuty +
                ", groupPremium=" + groupPremium +
                ", productName='" + productName + '\'' +
                ", totalChargeableDependents=" + totalChargeableDependents +
                ", numberOfEmployees=" + numberOfEmployees +
                ", subProductId=" + subProductId +
                ", productId='" + productId + '\'' +
                ", sbFee=" + sbFee +
                ", attributes='" + attributes + '\'' +
                ", coverAmount=" + coverAmount +
                ", annualPayroll=" + annualPayroll +
                '}';
    }
}
