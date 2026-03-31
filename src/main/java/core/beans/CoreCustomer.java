package core.beans;

import dao.entities.JobTitle;

import java.io.Serializable;

public class CoreCustomer implements Serializable {
    private String accountId;
    private String customerId;
    private String customerName;
    private String dateOfBirth;
    private String mobileNumber;
    private String currency;

    private String email;

    private String gender;
    private String documentId;
    private String address;
    private String vat;
    private JobTitle jobTitle;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "CoreCustomer{" +
                "accountId='" + accountId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", documentId='" + documentId + '\'' +
                ", address='" + address + '\'' +
                ", vat='" + vat + '\'' +
                ", jobTitle=" + jobTitle +
                '}';
    }
}
