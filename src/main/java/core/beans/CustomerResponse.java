package core.beans;


import java.io.Serializable;

public class CustomerResponse implements Serializable {
    private CoreCustomer coreCustomer;
    private double baseAmount;
    private double pricePerMember;
    private String errorMessage;
    private Boolean benRequired;
    private Boolean blockBeneficiary;
    private String target;
    private String targetDescription;
    private String customerType;


    public CoreCustomer getCoreCustomer() {
        return coreCustomer;
    }

    public void setCoreCustomer(CoreCustomer coreCustomer) {
        this.coreCustomer = coreCustomer;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public double getPricePerMember() {
        return pricePerMember;
    }

    public void setPricePerMember(double pricePerMember) {
        this.pricePerMember = pricePerMember;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getBenRequired() {
        return benRequired;
    }

    public void setBenRequired(Boolean benRequired) {
        this.benRequired = benRequired;
    }

    public Boolean getBlockBeneficiary() {
        return blockBeneficiary;
    }

    public void setBlockBeneficiary(Boolean blockBeneficiary) {
        this.blockBeneficiary = blockBeneficiary;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetDescription() {
        return targetDescription;
    }

    public void setTargetDescription(String targetDescription) {
        this.targetDescription = targetDescription;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "coreCustomer=" + coreCustomer +
                ", baseAmount=" + baseAmount +
                ", pricePerMember=" + pricePerMember +
                ", errorMessage='" + errorMessage + '\'' +
                ", benRequired=" + benRequired +
                ", blockBeneficiary=" + blockBeneficiary +
                ", target='" + target + '\'' +
                ", targetDescription='" + targetDescription + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
