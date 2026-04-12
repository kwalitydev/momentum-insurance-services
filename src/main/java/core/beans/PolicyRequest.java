package core.beans;

import dao.entities.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PolicyRequest implements Serializable {

    private List<MemberRequest> memberRequests;
    private List<Long> removedMembers;
    private List<FileRequest> fileRequests;
    private String fullName;
    private String email;
    private String address;
    private String idNumber;
    private String nuit;
    private Long jobTitle;
    private String mainPhone;
    private String altPhone;
    private Long packageId;
    private Long cycleId;
    private String frequencyId;
    private String startDate;
    private String endDate;
    private BigDecimal totalAmount;
    private String sessionId;
    private String policyId;
    private String username;
    private String comments;
    private String dateOfBirth;

    public List<MemberRequest> getMemberRequests() {
        return memberRequests;
    }

    public void setMemberRequests(List<MemberRequest> memberRequests) {
        this.memberRequests = memberRequests;
    }

    public List<FileRequest> getFileRequests() {
        return fileRequests;
    }

    public void setFileRequests(List<FileRequest> fileRequests) {
        this.fileRequests = fileRequests;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Long getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(Long jobTitle) {
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

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getCycleId() {
        return cycleId;
    }

    public void setCycleId(Long cycleId) {
        this.cycleId = cycleId;
    }

    public String getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(String frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Long> getRemovedMembers() {
        return removedMembers;
    }

    public void setRemovedMembers(List<Long> removedMembers) {
        this.removedMembers = removedMembers;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "PolicyRequest{" +
                "memberRequests=" + memberRequests +
                ", removedMembers=" + removedMembers +
                ", fileRequests=" + fileRequests +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", nuit='" + nuit + '\'' +
                ", jobTitle=" + jobTitle +
                ", mainPhone='" + mainPhone + '\'' +
                ", altPhone='" + altPhone + '\'' +
                ", packageId=" + packageId +
                ", cycleId=" + cycleId +
                ", frequencyId='" + frequencyId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", totalAmount=" + totalAmount +
                ", sessionId='" + sessionId + '\'' +
                ", policyId='" + policyId + '\'' +
                ", username='" + username + '\'' +
                ", comments='" + comments + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
