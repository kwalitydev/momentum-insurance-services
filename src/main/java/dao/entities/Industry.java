package dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Industry implements Serializable {

    @Id
    @Column(length = 30)
    private String industryId;
    @Column(length = 50)
    private String name;
    @Column(length = 254)
    private String description;
    private Double riskRate;

    @OneToOne
    private Status status;

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getRiskRate() {
        return riskRate;
    }

    public void setRiskRate(Double riskRate) {
        this.riskRate = riskRate;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "industryId='" + industryId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", riskRate=" + riskRate +
                ", status=" + status +
                '}';
    }
}
