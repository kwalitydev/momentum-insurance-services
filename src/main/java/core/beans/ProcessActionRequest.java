package core.beans;

import java.io.Serializable;

public class ProcessActionRequest implements Serializable {

    private Long processWorkflowId;
    private String username;
    private String comment;
    private String action;
    private String sessionId;
    private String newPolicyNumber;
    private String oldPolicyNumber;

    public Long getProcessWorkflowId() {
        return processWorkflowId;
    }

    public void setProcessWorkflowId(Long processWorkflowId) {
        this.processWorkflowId = processWorkflowId;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getNewPolicyNumber() {
        return newPolicyNumber;
    }

    public void setNewPolicyNumber(String newPolicyNumber) {
        this.newPolicyNumber = newPolicyNumber;
    }

    public String getOldPolicyNumber() {
        return oldPolicyNumber;
    }

    public void setOldPolicyNumber(String oldPolicyNumber) {
        this.oldPolicyNumber = oldPolicyNumber;
    }

    @Override
    public String toString() {
        return "ProcessActionRequest{" +
                "processWorkflowId=" + processWorkflowId +
                ", username='" + username + '\'' +
                ", comment='" + comment + '\'' +
                ", action='" + action + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", newPolicyNumber='" + newPolicyNumber + '\'' +
                ", oldPolicyNumber='" + oldPolicyNumber + '\'' +
                '}';
    }
}
