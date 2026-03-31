package dao.entities;

import core.constants.PaymentMethods;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class PaymentLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentLogId;
    @OneToOne
    private PaymentSchedule paymentSchedule;
    private Date attemptDate;
    private String errorMessage;
    private String paymentStatus;
    private String paymentMethod = PaymentMethods.NORMAL.getMethod();

    public Long getPaymentLogId() {
        return paymentLogId;
    }

    public void setPaymentLogId(Long paymentLogId) {
        this.paymentLogId = paymentLogId;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public Date getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(Date attemptDate) {
        this.attemptDate = attemptDate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "PaymentLog{" +
                "paymentLogId=" + paymentLogId +
                ", paymentSchedule=" + paymentSchedule +
                ", attemptDate=" + attemptDate +
                ", errorMessage='" + errorMessage + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
