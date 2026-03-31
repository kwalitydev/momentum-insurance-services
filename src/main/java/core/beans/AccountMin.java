package core.beans;

import dao.entities.JobTitle;

import java.io.Serializable;

public class AccountMin implements Serializable {
    private String accountNumber;
    private String customerId;
    private String dateOfBirth;
    private String mobileNumber;
    private String customerName;
    private String email;
    private String vat;
    private String address;
    private JobTitle jobTitleNew;
    private String documentId;
    private Long id;

    public AccountMin(String accountNumber, String customerId, String dateOfBirth, String mobileNumber, String customerName, String email, String vat, String address, JobTitle jobTitleNew, String documentId,  Long id) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.customerName = customerName;
        this.email = email;
        this.vat = vat;
        this.address = address;
        this.jobTitleNew = jobTitleNew;
        this.documentId = documentId;
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public JobTitle getJobTitleNew() {
        return jobTitleNew;
    }

    public void setJobTitleNew(JobTitle jobTitleNew) {
        this.jobTitleNew = jobTitleNew;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccountMin{" +
                "accountNumber='" + accountNumber + '\'' +
                ", customerId='" + customerId + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", vat='" + vat + '\'' +
                ", address='" + address + '\'' +
                ", jobTitleNew=" + jobTitleNew +
                ", documentId='" + documentId + '\'' +
                ", id=" + id +
                '}';
    }
}
