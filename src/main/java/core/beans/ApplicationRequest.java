package core.beans;

import dao.entities.Application;

import java.io.Serializable;

public class ApplicationRequest implements Serializable {
    private Application application;
    private String username;
    private String sessionId;
    private Boolean taskEnabled;
    private String taskId;

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
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

    public Boolean getTaskEnabled() {
        return taskEnabled;
    }

    public void setTaskEnabled(Boolean taskEnabled) {
        this.taskEnabled = taskEnabled;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "ApplicationRequest{" +
                "application=" + application +
                ", username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", taskEnabled=" + taskEnabled +
                ", taskId='" + taskId + '\'' +
                '}';
    }
}
