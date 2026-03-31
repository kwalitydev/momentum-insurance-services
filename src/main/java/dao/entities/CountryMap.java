package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CountryMap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryMapId;
    @Column(length = 8)
    private String abbreviation;
    @Column(length = 40)
    private String name;
    private Date lastUpdate;
    @OneToOne
    private Status status;


    public Long getCountryMapId() {
        return countryMapId;
    }

    public void setCountryMapId(Long countryMapId) {
        this.countryMapId = countryMapId;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
