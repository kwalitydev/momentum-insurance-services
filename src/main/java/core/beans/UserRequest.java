package core.beans;



import dao.entities.UserDetails;
import dao.entities.Users;

import java.io.Serializable;

public class UserRequest implements Serializable {
    private Users user;
    private UserDetails userDetails;
    private String sessionId;
    private String username;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "user=" + user +
                ", userDetails=" + userDetails +
                '}';
    }
}
