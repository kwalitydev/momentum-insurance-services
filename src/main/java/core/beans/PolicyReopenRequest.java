package core.beans;

import java.io.Serializable;

public class PolicyReopenRequest implements Serializable {
    private String policyId;
    private String sessionId;
    private String username;
    private String comment;

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



    @Override
    public String toString() {
        return "PolicyCancelRequest{" +
                "policyId='" + policyId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
