package dao.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Users implements Serializable {

    @Id
    @Column(length = 25)
    private String userId;
    private String idRole;
    @OneToOne
    private Department department;
    @OneToOne
    private Status status;
    private Integer attemptsSuccess = 0;
    private Integer attemptsFailed = 0;
    private Integer overallAttempts = 0;
    private Date nextLoginTime;
    private Date lastLogin;
    private Date lastLogout;
    private Date createdDate;
    @Column(length = 15)
    private String createdBy;
    private Boolean activeDirectory;
    private String userKey;
    private Date lastUpdated;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getAttemptsSuccess() {
        return attemptsSuccess;
    }

    public void setAttemptsSuccess(Integer attemptsSuccess) {
        this.attemptsSuccess = attemptsSuccess;
    }

    public Integer getAttemptsFailed() {
        return attemptsFailed;
    }

    public void setAttemptsFailed(Integer attemptsFailed) {
        this.attemptsFailed = attemptsFailed;
    }

    public Integer getOverallAttempts() {
        return overallAttempts;
    }

    public void setOverallAttempts(Integer overallAttempts) {
        this.overallAttempts = overallAttempts;
    }

    public Date getNextLoginTime() {
        return nextLoginTime;
    }

    public void setNextLoginTime(Date nextLoginTime) {
        this.nextLoginTime = nextLoginTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(Date lastLogout) {
        this.lastLogout = lastLogout;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getActiveDirectory() {
        return activeDirectory;
    }

    public void setActiveDirectory(Boolean activeDirectory) {
        this.activeDirectory = activeDirectory;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }




    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", idRole='" + idRole + '\'' +
                ", department=" + department +
                ", status=" + status +
                ", attemptsSuccess=" + attemptsSuccess +
                ", attemptsFailed=" + attemptsFailed +
                ", overallAttempts=" + overallAttempts +
                ", nextLoginTime=" + nextLoginTime +
                ", lastLogin=" + lastLogin +
                ", lastLogout=" + lastLogout +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", activeDirectory=" + activeDirectory +
                ", userKey='" + userKey + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
