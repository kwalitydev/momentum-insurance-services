package core.beans;

import java.io.Serializable;

public class ClaimAuthRequest implements Serializable {

    private String username;
    private String sessionId;
    private Long claimId;

    private String processActionId;
    private String comments;
    private Long workflowId;

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



    public String getProcessActionId() {
        return processActionId;
    }

    public void setProcessActionId(String processActionId) {
        this.processActionId = processActionId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Long workflowId) {
        this.workflowId = workflowId;
    }

    @Override
    public String toString() {
        return "ClaimAuthRequest{" +
                "username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", claimId=" + claimId +
                ", processActionId='" + processActionId + '\'' +
                ", comments='" + comments + '\'' +
                ", workflowId=" + workflowId +
                '}';
    }
}
