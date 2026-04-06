package core.beans;

import dao.entities.InsurancePolicy;
import dao.entities.MemberProductPrice;

import java.io.Serializable;

public class InsurancePolicyResponse implements Serializable {
    private InsurancePolicy insurancePolicy;
    private MemberProductPrice memberProductPrice;
    private String collectionDays;
    private String nextMonthCollectionDays;
    private String createdByName;
    private boolean isCollectionDay;
    private boolean isAfterCollectionDay;

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public MemberProductPrice getMemberProductPrice() {
        return memberProductPrice;
    }

    public void setMemberProductPrice(MemberProductPrice memberProductPrice) {
        this.memberProductPrice = memberProductPrice;
    }

    public String getCollectionDays() {
        return collectionDays;
    }

    public void setCollectionDays(String collectionDays) {
        this.collectionDays = collectionDays;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getNextMonthCollectionDays() {
        return nextMonthCollectionDays;
    }

    public void setNextMonthCollectionDays(String nextMonthCollectionDays) {
        this.nextMonthCollectionDays = nextMonthCollectionDays;
    }

    public boolean isCollectionDay() {
        return isCollectionDay;
    }

    public void setCollectionDay(boolean collectionDay) {
        isCollectionDay = collectionDay;
    }

    public boolean isAfterCollectionDay() {
        return isAfterCollectionDay;
    }

    public void setAfterCollectionDay(boolean afterCollectionDay) {
        isAfterCollectionDay = afterCollectionDay;
    }

    @Override
    public String toString() {
        return "InsurancePolicyResponse{" +
                "insurancePolicy=" + insurancePolicy +
                ", memberProductPrice=" + memberProductPrice +
                ", collectionDays='" + collectionDays + '\'' +
                ", nextMonthCollectionDays='" + nextMonthCollectionDays + '\'' +
                ", createdByName='" + createdByName + '\'' +
                ", isCollectionDay=" + isCollectionDay +
                ", isAfterCollectionDay=" + isAfterCollectionDay +
                '}';
    }
}
