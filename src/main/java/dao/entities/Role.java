package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Role implements Serializable {

    @Id
    private String idRole;
    private Date createdDate;
    @OneToOne
    private Users userCreated;
    @Column(length = 100)
    private String description;
    private boolean visibility;
    private String restrictions;


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Users getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Users userCreated) {
        this.userCreated = userCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public String toString() {
        return "Role{" +
                "idRole='" + idRole + '\'' +
                ", createdDate=" + createdDate +
                ", userCreated=" + userCreated +
                ", description='" + description + '\'' +
                ", visibility=" + visibility +
                ", restrictions='" + restrictions + '\'' +
                '}';
    }
}
