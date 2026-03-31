package core.beans;


import java.io.Serializable;

public class SubProductUpdate implements Serializable {
    private Double memberAgeLimit;
    private Double childNumberLimit;
    private Double childAgeLimit;
    private Double parentsMaxAge;
    private Double childMinAge;
    private Double memberMinAge;
    private String username;
    private String sessionId;
    private Long subProductId;
    private Long productConfigId;

    private Double holderMinAge;
    private Double holderAgeLimit;
    private Double parentsNumberLimit;
    private Double studentMinAge;
    private Double studentMaxAge;
    private Double partnerMinAge;
    private Double partnerMaxAge;
    private Double partnerNumberLimit;
    private Double memberNumberLimit;
    private Integer maxBenNumber;

    public Double getMemberAgeLimit() {
        return memberAgeLimit;
    }

    public void setMemberAgeLimit(Double memberAgeLimit) {
        this.memberAgeLimit = memberAgeLimit;
    }

    public Double getChildNumberLimit() {
        return childNumberLimit;
    }

    public void setChildNumberLimit(Double childNumberLimit) {
        this.childNumberLimit = childNumberLimit;
    }

    public Double getChildAgeLimit() {
        return childAgeLimit;
    }

    public void setChildAgeLimit(Double childAgeLimit) {
        this.childAgeLimit = childAgeLimit;
    }

    public Double getParentsMaxAge() {
        return parentsMaxAge;
    }

    public void setParentsMaxAge(Double parentsMaxAge) {
        this.parentsMaxAge = parentsMaxAge;
    }

    public Double getChildMinAge() {
        return childMinAge;
    }

    public void setChildMinAge(Double childMinAge) {
        this.childMinAge = childMinAge;
    }

    public Double getMemberMinAge() {
        return memberMinAge;
    }

    public void setMemberMinAge(Double memberMinAge) {
        this.memberMinAge = memberMinAge;
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

    public Long getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(Long subProductId) {
        this.subProductId = subProductId;
    }

    public Long getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(Long productConfigId) {
        this.productConfigId = productConfigId;
    }

    public Double getHolderMinAge() {
        return holderMinAge;
    }

    public void setHolderMinAge(Double holderMinAge) {
        this.holderMinAge = holderMinAge;
    }

    public Double getHolderAgeLimit() {
        return holderAgeLimit;
    }

    public void setHolderAgeLimit(Double holderAgeLimit) {
        this.holderAgeLimit = holderAgeLimit;
    }

    public Double getParentsNumberLimit() {
        return parentsNumberLimit;
    }

    public void setParentsNumberLimit(Double parentsNumberLimit) {
        this.parentsNumberLimit = parentsNumberLimit;
    }

    public Double getStudentMinAge() {
        return studentMinAge;
    }

    public void setStudentMinAge(Double studentMinAge) {
        this.studentMinAge = studentMinAge;
    }

    public Double getStudentMaxAge() {
        return studentMaxAge;
    }

    public void setStudentMaxAge(Double studentMaxAge) {
        this.studentMaxAge = studentMaxAge;
    }

    public Double getPartnerMinAge() {
        return partnerMinAge;
    }

    public void setPartnerMinAge(Double partnerMinAge) {
        this.partnerMinAge = partnerMinAge;
    }

    public Double getPartnerMaxAge() {
        return partnerMaxAge;
    }

    public void setPartnerMaxAge(Double partnerMaxAge) {
        this.partnerMaxAge = partnerMaxAge;
    }

    public Double getPartnerNumberLimit() {
        return partnerNumberLimit;
    }

    public void setPartnerNumberLimit(Double partnerNumberLimit) {
        this.partnerNumberLimit = partnerNumberLimit;
    }

    public Double getMemberNumberLimit() {
        return memberNumberLimit;
    }

    public void setMemberNumberLimit(Double memberNumberLimit) {
        this.memberNumberLimit = memberNumberLimit;
    }

    public Integer getMaxBenNumber() {
        return maxBenNumber;
    }

    public void setMaxBenNumber(Integer maxBenNumber) {
        this.maxBenNumber = maxBenNumber;
    }

    @Override
    public String toString() {
        return "SubProductUpdate{" +
                "memberAgeLimit=" + memberAgeLimit +
                ", childNumberLimit=" + childNumberLimit +
                ", childAgeLimit=" + childAgeLimit +
                ", parentsMaxAge=" + parentsMaxAge +
                ", childMinAge=" + childMinAge +
                ", memberMinAge=" + memberMinAge +
                ", username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", subProductId=" + subProductId +
                ", productConfigId=" + productConfigId +
                ", holderMinAge=" + holderMinAge +
                ", holderAgeLimit=" + holderAgeLimit +
                ", parentsNumberLimit=" + parentsNumberLimit +
                ", studentMinAge=" + studentMinAge +
                ", studentMaxAge=" + studentMaxAge +
                ", partnerMinAge=" + partnerMinAge +
                ", partnerMaxAge=" + partnerMaxAge +
                ", partnerNumberLimit=" + partnerNumberLimit +
                ", memberNumberLimit=" + memberNumberLimit +
                ", maxBenNumber=" + maxBenNumber +
                '}';
    }
}
