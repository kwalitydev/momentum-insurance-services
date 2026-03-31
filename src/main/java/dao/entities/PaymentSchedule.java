package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class PaymentSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentScheduleId;
    private BigDecimal repaymentAmount;
    private BigDecimal paidAmount;
    private Date createdDate;
    private Date lastAttempt;
    @OneToOne
    private Status status;
    @Column(length = 25)
    private String chargeCode;
    @OneToOne
    private InsurancePolicy insurancePolicy;
    @Column(length = 25)
    private String transactionId;
    private String repaymentMonth;
    private String repaymentYear;
    private String messageId;
    private Boolean normalPayment = true;
    private String errorMessage;

    public Long getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(Long paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public BigDecimal getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(BigDecimal repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastAttempt() {
        return lastAttempt;
    }

    public void setLastAttempt(Date lastAttempt) {
        this.lastAttempt = lastAttempt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getRepaymentMonth() {
        return repaymentMonth;
    }

    public void setRepaymentMonth(String repaymentMonth) {
        this.repaymentMonth = repaymentMonth;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRepaymentYear() {
        return repaymentYear;
    }

    public void setRepaymentYear(String repaymentYear) {
        this.repaymentYear = repaymentYear;
    }

    public Boolean getNormalPayment() {
        return normalPayment;
    }

    public void setNormalPayment(Boolean normalPayment) {
        this.normalPayment = normalPayment;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "PaymentSchedule{" +
                "paymentScheduleId=" + paymentScheduleId +
                ", repaymentAmount=" + repaymentAmount +
                ", paidAmount=" + paidAmount +
                ", createdDate=" + createdDate +
                ", lastAttempt=" + lastAttempt +
                ", status=" + status +
                ", chargeCode='" + chargeCode + '\'' +
                ", insurancePolicy=" + insurancePolicy +
                ", transactionId='" + transactionId + '\'' +
                ", repaymentMonth='" + repaymentMonth + '\'' +
                ", repaymentYear='" + repaymentYear + '\'' +
                ", messageId='" + messageId + '\'' +
                ", normalPayment=" + normalPayment +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
