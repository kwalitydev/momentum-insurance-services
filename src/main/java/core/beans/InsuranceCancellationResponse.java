package core.beans;

import dao.entities.InsurancePolicy;
import dao.entities.InsurancePolicyHistory;

import java.io.Serializable;

public class InsuranceCancellationResponse implements Serializable {

    private InsurancePolicy insurancePolicy;
    private InsurancePolicyHistory insurancePolicyHistory;


    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public InsurancePolicyHistory getInsurancePolicyHistory() {
        return insurancePolicyHistory;
    }

    public void setInsurancePolicyHistory(InsurancePolicyHistory insurancePolicyHistory) {
        this.insurancePolicyHistory = insurancePolicyHistory;
    }

    @Override
    public String toString() {
        return "InsuranceCancellationResponse{" +
                "insurancePolicy=" + insurancePolicy +
                ", insurancePolicyHistory=" + insurancePolicyHistory +
                '}';
    }
}
