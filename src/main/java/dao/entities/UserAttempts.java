package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserAttempts implements Serializable {

    @Id
    @Column(length = 50)
    private String id;
    private int attempts;
    private Date createdDate;
    private Date loginDate;
    private Date resetDate;
    @Column(length = 25)
    private String ipAddress;
    @Column(length = 25)
    private String attemptStatus;
    @Column(nullable = true)
    private boolean reset;
    @ManyToOne
    private Users users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getResetDate() {
        return resetDate;
    }

    public void setResetDate(Date resetDate) {
        this.resetDate = resetDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAttemptStatus() {
        return attemptStatus;
    }

    public void setAttemptStatus(String attemptStatus) {
        this.attemptStatus = attemptStatus;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserAttempts{" +
                "id='" + id + '\'' +
                ", attempts=" + attempts +
                ", createdDate=" + createdDate +
                ", loginDate=" + loginDate +
                ", resetDate=" + resetDate +
                ", ipAddress='" + ipAddress + '\'' +
                ", attemptStatus='" + attemptStatus + '\'' +
                ", reset=" + reset +
                ", users=" + users +
                '}';
    }
}
