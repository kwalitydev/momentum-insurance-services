package dao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Submenu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String description;
    @Column(length = 100)
    private String hint;
    @Column(length = 100)
    private String logo_path;
    @Column(length = 100)
    private String defaultPage;
    private int idMenu;
    @OneToOne
    private Users userCreated;
    private String args;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getDefaultPage() {
        return defaultPage;
    }

    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }


    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public Users getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Users userCreated) {
        this.userCreated = userCreated;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "Submenu{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", hint='" + hint + '\'' +
                ", logo_path='" + logo_path + '\'' +
                ", defaultPage='" + defaultPage + '\'' +
                ", idMenu=" + idMenu +
                ", userCreated=" + userCreated +
                ", args='" + args + '\'' +
                '}';
    }
}
