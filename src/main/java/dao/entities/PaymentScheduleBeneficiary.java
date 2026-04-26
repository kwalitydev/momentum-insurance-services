package dao.entities;

import dao.enums.RecordStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "payment_schedule_beneficiary")
public class PaymentScheduleBeneficiary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_schedule_id", nullable = false)
    private PaymentSchedule paymentSchedule;

    @ManyToOne
    @JoinColumn(name = "beneficiary_id", nullable = false)
    private Beneficiaries beneficiary;

    @Enumerated(EnumType.STRING)
    private RecordStatus status;

    private BigDecimal paidAmount;

    private LocalDateTime paymentDate;

}