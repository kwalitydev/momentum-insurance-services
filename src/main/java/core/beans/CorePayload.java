package core.beans;

import dao.entities.InsurancePolicy;

public class CorePayload {

    private InsurancePolicy insurancePolicy;
    private String traceId;
    private SubProductAccount subProductAccount;


    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public SubProductAccount getSubProductAccount() {
        return subProductAccount;
    }

    public void setSubProductAccount(SubProductAccount subProductAccount) {
        this.subProductAccount = subProductAccount;
    }
}
