package dao.entities;

import dao.enums.TransactionType;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class InsuranceOutstandingAmount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceOutstandingAmountId;
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;

    @ManyToOne
    @JoinColumn
    private PaymentSchedule paymentSchedule;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType; // e.g "creditor" or "debtor"
    private String description;
    private Date lastUpdatedDate;
    private Date entryDate;
    @OneToOne
    private Status status;


    @Override
    public String toString() {
        return "InsuranceOutstandingAmount{" +
               "insuranceOutstandingAmountId=" + insuranceOutstandingAmountId +
               ", amount=" + amount +
               ", insurancePolicy=" + insurancePolicy +
               ", PaymentSchedule=" + paymentSchedule +
               ", transactionType=" + transactionType +
               ", description='" + description + '\'' +
               ", lastUpdatedDate=" + lastUpdatedDate +
               ", entryDate=" + entryDate +
               ", status=" + status +
               '}';
    }
}
