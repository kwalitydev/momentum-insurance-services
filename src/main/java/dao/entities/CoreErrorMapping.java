package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CoreErrorMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int errorCode;
    private String coreMessage;
    private String description;
    private String errorMessage;
    @Column(nullable = true)
    private String errorType;
    private Date createdDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getCoreMessage() {
        return coreMessage;
    }

    public void setCoreMessage(String coreMessage) {
        this.coreMessage = coreMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "CoreErrorMapping{" +
                "id=" + id +
                ", errorCode=" + errorCode +
                ", coreMessage='" + coreMessage + '\'' +
                ", description='" + description + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorType='" + errorType + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
