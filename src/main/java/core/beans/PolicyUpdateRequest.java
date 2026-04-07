package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class PolicyUpdateRequest implements Serializable {

    private String policyId;
    private String fullName;
    private String surname;
    private String email;
    private String address;
    private String idNumber;
    private String nuit;
    private String jobTitle;
    private String mainPhone;
    private String altPhone;
    private String packageId;
    private Integer cycleId;
    private String frequencyId;
    private BigDecimal totalAmount;
    private String username;
    private String sessionId;
    private Long holderId;
    private String comments;

    private BenefRequest benefRequest;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getAltPhone() {
        return altPhone;
    }

    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public String getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(String frequencyId) {
        this.frequencyId = frequencyId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public BenefRequest getBenefRequest() {
        return benefRequest;
    }

    public void setBenefRequest(BenefRequest benefRequest) {
        this.benefRequest = benefRequest;
    }

    public Long getHolderId() {
        return holderId;
    }

    public void setHolderId(Long holderId) {
        this.holderId = holderId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "PolicyUpdateRequest{" +
                "policyId='" + policyId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", nuit='" + nuit + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", mainPhone='" + mainPhone + '\'' +
                ", altPhone='" + altPhone + '\'' +
                ", packageId='" + packageId + '\'' +
                ", cycleId=" + cycleId +
                ", frequencyId='" + frequencyId + '\'' +
                ", totalAmount=" + totalAmount +
                ", username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", holderId=" + holderId +
                ", comments='" + comments + '\'' +
                ", benefRequest=" + benefRequest +
                '}';
    }


}
