package core.beans;



import java.io.Serializable;

public class EmailContext implements Serializable {
    private String body;
    private String destination;
    private String subject;
    private String logId;
    private String notificationType;
    private String policyId;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    @Override
    public String toString() {
        return "EmailContext{" +
                "body='" + body + '\'' +
                ", destination='" + destination + '\'' +
                ", subject='" + subject + '\'' +
                ", logId='" + logId + '\'' +
                ", notificationType='" + notificationType + '\'' +
                '}';
    }
}
