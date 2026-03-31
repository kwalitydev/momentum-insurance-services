package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class BenefitCycle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;
    private String cycleType; //SAME_YEAR, CROSS_YEAR
    private String cycleStatus; //ACTIVE, EXPIRED

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getCycleStatus() {
        return cycleStatus;
    }

    public void setCycleStatus(String cycleStatus) {
        this.cycleStatus = cycleStatus;
    }

    @Override
    public String toString() {
        return "BenefitCycle{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", cycleType='" + cycleType + '\'' +
                ", cycleStatus='" + cycleStatus + '\'' +
                '}';
    }
}
