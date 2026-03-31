package core.beans;

import java.io.Serializable;

public class JSONRequest implements Serializable {

    private String objectId;
    private String sessionId;
    private String username;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
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

    @Override
    public String toString() {
        return "JSONRequest{" +
                "objectId='" + objectId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
