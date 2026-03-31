package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Notification implements Serializable {

    @Id
    @Column(length = 50)
    private String id;
    private String errorDesc;
    private String body;
    private Date lastUpdated;
    private Date notificationDate;
    @Column(length = 50)
    private String status;
    @Column(length = 25)
    private String mobileNumber;
    private int retries;
    @Column(length = 60)
    private String notificationId;
    @OneToOne
    private NotificationType notificationType;
    @Column(length = 2)
    private String notificationMonth;
    @Column(length = 50)
    private String transactionId;
    @Column(length = 50)
    private String emailAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationMonth() {
        return notificationMonth;
    }

    public void setNotificationMonth(String notificationMonth) {
        this.notificationMonth = notificationMonth;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", body='" + body + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", notificationDate=" + notificationDate +
                ", status='" + status + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", retries=" + retries +
                ", notificationId='" + notificationId + '\'' +
                ", notificationType=" + notificationType +
                ", notificationMonth='" + notificationMonth + '\'' +
                ", transactionId='" + transactionId + '\'' +
                '}';
    }


    public String toStringMin() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", lastUpdated=" + lastUpdated +
                ", notificationDate=" + notificationDate +
                ", status='" + status + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", retries=" + retries +
                ", notificationId='" + notificationId + '\'' +
                ", notificationType=" + notificationType +
                ", notificationMonth='" + notificationMonth + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
