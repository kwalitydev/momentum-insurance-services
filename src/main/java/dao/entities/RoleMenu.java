package dao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RoleMenu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String permission;
    private int idMenu;
    @Column(length = 6)
    private String idRole;
    @OneToOne
    private Users userCreated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public Users getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Users userCreated) {
        this.userCreated = userCreated;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", idMenu=" + idMenu +
                ", idRole='" + idRole + '\'' +
                ", userCreated=" + userCreated +
                '}';
    }
}
