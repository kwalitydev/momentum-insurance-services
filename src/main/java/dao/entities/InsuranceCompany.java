package dao.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class InsuranceCompany implements Serializable {
    @Id
    private String insuranceCompanyId;
    private String companyName;
    private Date createdDate;
    private String sftpDir;
    @OneToOne
    private Status status;

    public String getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public void setInsuranceCompanyId(String insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSftpDir() {
        return sftpDir;
    }

    public void setSftpDir(String sftpDir) {
        this.sftpDir = sftpDir;
    }

    @Override
    public String toString() {
        return "InsuranceCompany{" +
                "insuranceCompanyId='" + insuranceCompanyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", createdDate=" + createdDate +
                ", sftpDir='" + sftpDir + '\'' +
                ", status=" + status +
                '}';
    }
}
