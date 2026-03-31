package dao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Frequency implements Serializable {
    @Id
    private String frequencyId;
    @Column(length = 15)
    private String name;
    private Integer nrOfMonths;

    public String getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(String frequencyId) {
        this.frequencyId = frequencyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNrOfMonths() {
        return nrOfMonths;
    }

    public void setNrOfMonths(Integer nrOfMonths) {
        this.nrOfMonths = nrOfMonths;
    }

    @Override
    public String toString() {
        return "Frequency{" +
                "frequencyId='" + frequencyId + '\'' +
                ", name='" + name + '\'' +
                ", nrOfMonths=" + nrOfMonths +
                '}';
    }
}
