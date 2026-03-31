package core.beans;

import java.io.Serializable;

public class ProductConfigUpdate implements Serializable {
    private String username;
    private String sessionId;
    private Long currentConfigId;
    private Long newConfigId;
    private String processAction;
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

    public Long getCurrentConfigId() {
        return currentConfigId;
    }

    public void setCurrentConfigId(Long currentConfigId) {
        this.currentConfigId = currentConfigId;
    }

    public Long getNewConfigId() {
        return newConfigId;
    }

    public void setNewConfigId(Long newConfigId) {
        this.newConfigId = newConfigId;
    }

    public String getProcessAction() {
        return processAction;
    }

    public void setProcessAction(String processAction) {
        this.processAction = processAction;
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
        return "ProductConfigUpdate{" +
                "username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", currentConfigId=" + currentConfigId +
                ", newConfigId=" + newConfigId +
                ", processAction='" + processAction + '\'' +
                ", comments='" + comments + '\'' +
                ", workflowId=" + workflowId +
                '}';
    }
}
