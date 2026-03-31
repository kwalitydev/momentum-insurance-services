package dao.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Application implements Serializable {

    @Id
    @Column(length = 25)
    private String appId;
    @Column(length = 50)
    private String description;
    private Date createdDate;
    private Integer maxUserAttempts;
    private Boolean sendSms;
    private String testNumber;
    private String authRole;
    private String collectionDays;
    private Integer allowedMissedPayment;
    private Date updatedDate;
    @Column(length = 50)
    private String username;
    private String missedPmtNotification;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getMaxUserAttempts() {
        return maxUserAttempts;
    }

    public void setMaxUserAttempts(Integer maxUserAttempts) {
        this.maxUserAttempts = maxUserAttempts;
    }

    public Boolean getSendSms() {
        return sendSms;
    }

    public void setSendSms(Boolean sendSms) {
        this.sendSms = sendSms;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(String testNumber) {
        this.testNumber = testNumber;
    }

    public String getAuthRole() {
        return authRole;
    }

    public void setAuthRole(String authRole) {
        this.authRole = authRole;
    }

    public Integer getAllowedMissedPayment() {
        return allowedMissedPayment;
    }

    public void setAllowedMissedPayment(Integer allowedMissedPayment) {
        this.allowedMissedPayment = allowedMissedPayment;
    }


    public String getCollectionDays() {
        return collectionDays;
    }

    public void setCollectionDays(String collectionDays) {
        this.collectionDays = collectionDays;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMissedPmtNotification() {
        return missedPmtNotification;
    }

    public void setMissedPmtNotification(String missedPmtNotification) {
        this.missedPmtNotification = missedPmtNotification;
    }

    @Override
    public String toString() {
        return "Application{" +
                "appId='" + appId + '\'' +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", maxUserAttempts=" + maxUserAttempts +
                ", sendSms=" + sendSms +
                ", testNumber='" + testNumber + '\'' +
                ", authRole='" + authRole + '\'' +
                ", collectionDays='" + collectionDays + '\'' +
                ", allowedMissedPayment=" + allowedMissedPayment +
                ", updatedDate=" + updatedDate +
                ", username='" + username + '\'' +
                ", missedPmtNotification='" + missedPmtNotification + '\'' +
                '}';
    }
}
