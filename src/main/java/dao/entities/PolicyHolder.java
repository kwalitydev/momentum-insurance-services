package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PolicyHolder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private Date dateOfBirth;
    @Column(length = 25)
    private String mobileNumber;
    @Column(length = 25)
    private String altMobileNumber;
    private Date lastUpdate;
    private String customerName;
    private String email;
    private String gender;
    private String address;
    private String documentId;
    private String occupation;
    private String documentTypeId;
    private String vat;
    @OneToOne
    private JobTitle jobTitle;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
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

    public String getAltMobileNumber() {
        return altMobileNumber;
    }

    public void setAltMobileNumber(String altMobileNumber) {
        this.altMobileNumber = altMobileNumber;
    }

    @Override
    public String toString() {
        return "PolicyHolder{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", altMobileNumber='" + altMobileNumber + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", customerName='" + customerName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", documentId='" + documentId + '\'' +
                ", occupation='" + occupation + '\'' +
                ", documentTypeId='" + documentTypeId + '\'' +
                ", vat='" + vat + '\'' +
                ", jobTitle=" + jobTitle +
                '}';
    }
}
