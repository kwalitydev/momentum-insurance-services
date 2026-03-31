package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private Date createdDate;
    @Column(length = 100)
    private String description;
    @Column(length = 50)
    private String hint;
    @Column(length = 150)
    private String logoPath;
    @Column(length = 100)
    private String defaultPage;

    private Integer menuOrder;


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

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getDefaultPage() {
        return defaultPage;
    }

    public void setDefaultPage(String defaultPage) {
        this.defaultPage = defaultPage;
    }


    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", description='" + description + '\'' +
                ", hint='" + hint + '\'' +
                ", logoPath='" + logoPath + '\'' +
                ", defaultPage='" + defaultPage + '\'' +
                ", menuOrder=" + menuOrder +
                '}';
    }
}
