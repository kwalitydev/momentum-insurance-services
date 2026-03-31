package core.beans;

import dao.entities.Role;
import dao.entities.UserDetails;
import dao.entities.Users;

import java.io.Serializable;
import java.util.List;

public class UserInfoResponse implements Serializable {

    private UserInformation userInformation;
    private boolean isActivating;
    private String nextLoginTime;
    private String lastLogin;
    private String lastLogout;
    private String createdDate;

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public boolean isActivating() {
        return isActivating;
    }

    public void setActivating(boolean activating) {
        isActivating = activating;
    }

    public String getNextLoginTime() {
        return nextLoginTime;
    }

    public void setNextLoginTime(String nextLoginTime) {
        this.nextLoginTime = nextLoginTime;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastLogout() {
        return lastLogout;
    }

    public void setLastLogout(String lastLogout) {
        this.lastLogout = lastLogout;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "UserInfoResponse{" +
                "userInformation=" + userInformation +
                ", isActivating=" + isActivating +
                ", nextLoginTime='" + nextLoginTime + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", lastLogout='" + lastLogout + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
