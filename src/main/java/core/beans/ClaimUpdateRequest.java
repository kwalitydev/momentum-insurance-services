package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class ClaimUpdateRequest implements Serializable {
    private String username;
    private String sessionId;
    private Long claimId;
    private String description;
    private String statusId;
    private String claimProcessId;
    private BigDecimal insurerPaidAmount;

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

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getClaimProcessId() {
        return claimProcessId;
    }

    public void setClaimProcessId(String claimProcessId) {
        this.claimProcessId = claimProcessId;
    }

    public BigDecimal getInsurerPaidAmount() {
        return insurerPaidAmount;
    }

    public void setInsurerPaidAmount(BigDecimal insurerPaidAmount) {
        this.insurerPaidAmount = insurerPaidAmount;
    }

    @Override
    public String toString() {
        return "ClaimUpdateRequest{" +
                "username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", claimId=" + claimId +
                ", description='" + description + '\'' +
                ", statusId='" + statusId + '\'' +
                '}';
    }
}
