package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class NotificationType implements Serializable {

    @Id
    @Column(length = 50)
    private String id;

    private String defaultMessage;
    private String description;
    private Date lastChangeDate;
    private Boolean enabled;
    @Column(length = 5)
    private String notificationChannel;
    private String subject;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getNotificationChannel() {
        return notificationChannel;
    }

    public void setNotificationChannel(String notificationChannel) {
        this.notificationChannel = notificationChannel;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "NotificationType{" +
                "id='" + id + '\'' +
                ", defaultMessage='" + defaultMessage + '\'' +
                ", description='" + description + '\'' +
                ", lastChangeDate=" + lastChangeDate +
                ", enabled=" + enabled +
                ", notificationChannel='" + notificationChannel + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
