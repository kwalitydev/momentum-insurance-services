package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PolicySyncHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pshId;
    private String insurancePolicyId;
    private Date syncDate;

    private String syncStatus;
    @Column(length = 1000)
    private String errorDesc;

    public Long getPshId() {
        return pshId;
    }

    public void setPshId(Long pshId) {
        this.pshId = pshId;
    }

    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Override
    public String toString() {
        return "PolicySyncHistory{" +
                "pshId=" + pshId +
                ", insurancePolicyId='" + insurancePolicyId + '\'' +
                ", syncDate=" + syncDate +
                ", syncStatus='" + syncStatus + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                '}';
    }
}
