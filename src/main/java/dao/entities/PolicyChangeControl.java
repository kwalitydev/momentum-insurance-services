package dao.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PolicyChangeControl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long policyChangeHistoryId;
    private Date changeDate;
    private String Description;
    @ManyToOne
    private InsurancePolicy insurancePolicy;

    public Long getPolicyChangeHistoryId() {
        return policyChangeHistoryId;
    }

    public void setPolicyChangeHistoryId(Long policyChangeHistoryId) {
        this.policyChangeHistoryId = policyChangeHistoryId;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    @Override
    public String toString() {
        return "PolicyChangeControl{" +
                "policyChangeHistoryId='" + policyChangeHistoryId + '\'' +
                ", changeDate=" + changeDate +
                ", Description='" + Description + '\'' +
                ", insurancePolicy=" + insurancePolicy +
                '}';
    }
}
