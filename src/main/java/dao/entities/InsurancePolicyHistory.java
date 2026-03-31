package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class InsurancePolicyHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iphId;
    @OneToOne
    private InsurancePolicy insurancePolicy;
    private String changeDescription;
    private Date createdDate;
    @OneToOne
    private Users users;
    @OneToOne
    private ProcessAction processAction;
    @OneToOne
    private Department department;
    private String processId;
    private String narrative;

    public Long getIphId() {
        return iphId;
    }

    public void setIphId(Long iphId) {
        this.iphId = iphId;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getChangeDescription() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription = changeDescription;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public ProcessAction getProcessAction() {
        return processAction;
    }

    public void setProcessAction(ProcessAction processAction) {
        this.processAction = processAction;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    @Override
    public String toString() {
        return "InsurancePolicyHistory{" +
                "iphId=" + iphId +
                ", insurancePolicy=" + insurancePolicy +
                ", changeDescription='" + changeDescription + '\'' +
                ", createdDate=" + createdDate +
                ", users=" + users +
                ", processAction=" + processAction +
                ", department=" + department +
                ", processId='" + processId + '\'' +
                ", narrative='" + narrative + '\'' +
                '}';
    }
}
