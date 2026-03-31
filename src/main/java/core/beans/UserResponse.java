package core.beans;



import dao.entities.UserDetails;
import dao.entities.Users;

import java.io.Serializable;

public class UserResponse implements Serializable {
    private Users users;
    private UserDetails userDetails;
    private String next_login_time;
    private String last_login;
    private String last_logout;
    private String created_date;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getNext_login_time() {
        return next_login_time;
    }

    public void setNext_login_time(String next_login_time) {
        this.next_login_time = next_login_time;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getLast_logout() {
        return last_logout;
    }

    public void setLast_logout(String last_logout) {
        this.last_logout = last_logout;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "users=" + users +
                ", userDetails=" + userDetails +
                ", next_login_time='" + next_login_time + '\'' +
                ", last_login='" + last_login + '\'' +
                ", last_logout='" + last_logout + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
