package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CoverageOption implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coverageOptionId;
    private String coverageOption;
    private String territoryCovered;
    private Date startDate;
    private Date endDate;
    @OneToOne
    private Frequency frequency;
    private Boolean directDebitAuth;
    private Date createdDate;
    private Date lastUpdated;
    @OneToOne
    private InsurancePolicy insurancePolicy;

    public Long getCoverageOptionId() {
        return coverageOptionId;
    }

    public void setCoverageOptionId(Long coverageOptionId) {
        this.coverageOptionId = coverageOptionId;
    }

    public String getCoverageOption() {
        return coverageOption;
    }

    public void setCoverageOption(String coverageOption) {
        this.coverageOption = coverageOption;
    }

    public String getTerritoryCovered() {
        return territoryCovered;
    }

    public void setTerritoryCovered(String territoryCovered) {
        this.territoryCovered = territoryCovered;
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

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Boolean getDirectDebitAuth() {
        return directDebitAuth;
    }

    public void setDirectDebitAuth(Boolean directDebitAuth) {
        this.directDebitAuth = directDebitAuth;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "CoverageOption{" +
                "coverageOptionId=" + coverageOptionId +
                ", coverageOption='" + coverageOption + '\'' +
                ", territoryCovered='" + territoryCovered + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", frequency=" + frequency +
                ", directDebitAuth=" + directDebitAuth +
                ", createdDate=" + createdDate +
                ", lastUpdated=" + lastUpdated +
                ", insurancePolicy=" + insurancePolicy +
                '}';
    }
}
