package core.beans;

import java.io.Serializable;

public class SMSContext implements Serializable {
    private String mobileNumber;
    private String body;
    private String logId;
    private String notificationType;
    private String transactionId;

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "SMSContext{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", body='" + body + '\'' +
                ", logId='" + logId + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }
}
