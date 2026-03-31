package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ErrorLog implements Serializable {
    @Id
    private String errorLogId;
    private String insurancePolicyId;
    @OneToOne
    private Status status;
    private Date lastUpdate;
    private Date createdDate;
    private String lastError;
    private String logId;
    private Long paymentScheduleId;
    private boolean normalPayment;


    public String getErrorLogId() {
        return errorLogId;
    }

    public void setErrorLogId(String errorLogId) {
        this.errorLogId = errorLogId;
    }

    public String getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(String insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastError() {
        return lastError;
    }

    public void setLastError(String lastError) {
        this.lastError = lastError;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public Long getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(Long paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public boolean isNormalPayment() {
        return normalPayment;
    }

    public void setNormalPayment(boolean normalPayment) {
        this.normalPayment = normalPayment;
    }

    @Override
    public String toString() {
        return "ErrorLog{" +
                "errorLogId='" + errorLogId + '\'' +
                ", insurancePolicyId='" + insurancePolicyId + '\'' +
                ", status=" + status +
                ", lastUpdate=" + lastUpdate +
                ", createdDate=" + createdDate +
                ", lastError='" + lastError + '\'' +
                ", logId='" + logId + '\'' +
                ", paymentScheduleId=" + paymentScheduleId +
                ", normalPayment=" + normalPayment +
                '}';
    }
}
