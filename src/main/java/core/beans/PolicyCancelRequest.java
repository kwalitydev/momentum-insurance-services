package core.beans;

import java.io.Serializable;

public class PolicyCancelRequest implements Serializable {
    private String policyId;
    private String sessionId;
    private String username;
    private String comment;
    private String processNumber;
    private String requestBranch;
    private String narrative;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getRequestBranch() {
        return requestBranch;
    }

    public void setRequestBranch(String requestBranch) {
        this.requestBranch = requestBranch;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    @Override
    public String toString() {
        return "PolicyCancelRequest{" +
                "policyId='" + policyId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", processNumber='" + processNumber + '\'' +
                ", requestBranch='" + requestBranch + '\'' +
                ", narrative='" + narrative + '\'' +
                '}';
    }
}
