package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class UserDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date createdDate;
    private Date lastUpdate;
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String emailAlt;
    @Column(length = 35)
    private String fullName;
    @Column(length = 25)
    private String mobile;
    @Column(length = 25)
    private String mobileAlt;
    @Column(length = 35)
    private String surname;
    @OneToOne
    private Users users;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlt() {
        return emailAlt;
    }

    public void setEmailAlt(String emailAlt) {
        this.emailAlt = emailAlt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileAlt() {
        return mobileAlt;
    }

    public void setMobileAlt(String mobileAlt) {
        this.mobileAlt = mobileAlt;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", lastUpdate=" + lastUpdate +
                ", email='" + email + '\'' +
                ", emailAlt='" + emailAlt + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mobileAlt='" + mobileAlt + '\'' +
                ", surname='" + surname + '\'' +
                ", users=" + users +
                '}';
    }
}
