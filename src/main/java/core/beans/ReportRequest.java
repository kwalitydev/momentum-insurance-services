package core.beans;

import dao.entities.InsurancePolicy;

import java.io.Serializable;
import java.util.List;

public class ReportRequest implements Serializable {
    private String policyId;
    private String username;
    private String sessionId;
    private String description;
    private List<FileRequest> fileRequests;
    private boolean regenerate;
    private String traceId;
    private InsurancePolicy insurancePolicy;

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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FileRequest> getFileRequests() {
        return fileRequests;
    }

    public void setFileRequests(List<FileRequest> fileRequests) {
        this.fileRequests = fileRequests;
    }

    public boolean isRegenerate() {
        return regenerate;
    }

    public void setRegenerate(boolean regenerate) {
        this.regenerate = regenerate;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public String toString() {
        return "ReportRequest{" +
                "policyId='" + policyId + '\'' +
                ", username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", description='" + description + '\'' +
                ", fileRequests=" + fileRequests +
                ", regenerate=" + regenerate +
                ", traceId='" + traceId + '\'' +
                ", insurancePolicy=" + insurancePolicy +
                '}';
    }
}
