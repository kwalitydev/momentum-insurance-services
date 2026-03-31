package core.beans;

import dao.entities.InsurancePolicy;
import dao.entities.MemberProductPrice;

import java.io.Serializable;

public class InsurancePolicyResponse implements Serializable {
    private InsurancePolicy insurancePolicy;
    private MemberProductPrice memberProductPrice;
    private String createdByName;

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

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    @Override
    public String toString() {
        return "InsurancePolicyResponse{" +
                "insurancePolicy=" + insurancePolicy +
                ", memberProductPrice=" + memberProductPrice +
                ", createdByName='" + createdByName + '\'' +
                '}';
    }
}
