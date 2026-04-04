package dao.entities;

import core.constants.PaymentStatus;
import dao.enums.PaymentMethodStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
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

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMethodStatus paymentMethodStatus;
    private LocalDate startPaymentDate;
    private LocalDate endPaymentDate;
    private LocalDateTime paymentDate;

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
