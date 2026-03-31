package dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class IDType implements Serializable {
    @Id
    @Column(length = 20)
    private String idType;
    @Column(length = 100)
    private String description;
    private String idFor;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdFor() {
        return idFor;
    }

    public void setIdFor(String idFor) {
        this.idFor = idFor;
    }

    @Override
    public String toString() {
        return "IDType{" +
                "idType='" + idType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
