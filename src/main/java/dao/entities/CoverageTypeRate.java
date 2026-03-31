package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CoverageTypeRate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coverageTypeRateId;
    private double coverRate;
    @OneToOne
    private CoverageType coverageType;
    private Date createdDate;
    private int age;


    public Long getCoverageTypeRateId() {
        return coverageTypeRateId;
    }

    public void setCoverageTypeRateId(Long coverageTypeRateId) {
        this.coverageTypeRateId = coverageTypeRateId;
    }

    public double getCoverRate() {
        return coverRate;
    }

    public void setCoverRate(double coverRate) {
        this.coverRate = coverRate;
    }

    public CoverageType getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(CoverageType coverageType) {
        this.coverageType = coverageType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CoverageTypeRate{" +
                "coverageTypeRateId=" + coverageTypeRateId +
                ", coverRate=" + coverRate +
                ", coverageType=" + coverageType +
                ", createdDate=" + createdDate +
                ", age=" + age +
                '}';
    }
}
