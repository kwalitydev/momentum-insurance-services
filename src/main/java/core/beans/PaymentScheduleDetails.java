package core.beans;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Data
@Builder
public class PaymentScheduleDetails implements Serializable {
    private String insurancePolicyId;
    private String policyId;
    private BigDecimal totalAmount;
    public List<PaymentScheduleDTO> PaymentSchedules;
    public List<BeneficiaryDTO> beneficiaries;
}
