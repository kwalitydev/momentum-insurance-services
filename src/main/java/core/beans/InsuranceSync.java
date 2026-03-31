package core.beans;

import java.io.Serializable;

public class InsuranceSync implements Serializable {

    private String policyId;
    private String accountNumber;
    private String migrationStatus;
    private String transType;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(String migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "InsuranceSync{" +
                "policyId='" + policyId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", migrationStatus='" + migrationStatus + '\'' +
                ", transType='" + transType + '\'' +
                '}';
    }
}
