package core.beans;

import dao.entities.Role;
import dao.entities.UserDetails;
import dao.entities.Users;

import java.io.Serializable;
import java.util.List;

public class UserInformation implements Serializable {
    private Users users;
    private Role role;
    private List<MenuResponse> menus;
    private UserDetails userDetails;
    private boolean activating;
    private String errorCode;
    private String sessionId;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<MenuResponse> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuResponse> menus) {
        this.menus = menus;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public boolean isActivating() {
        return activating;
    }

    public void setActivating(boolean activating) {
        this.activating = activating;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "users=" + users +
                ", role=" + role +
                ", menus=" + menus +
                ", userDetails=" + userDetails +
                ", activating=" + activating +
                ", errorCode='" + errorCode + '\'' +
                ", sessionId='" + sessionId + '\'' +
                '}';
    }


}
