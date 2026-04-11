package core.beans;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
@Data
@Builder
public class PaymentScheduleDTO implements Serializable {
    private BigDecimal repaymentAmount;
    private BigDecimal paidAmount;
    private String repaymentMonth;
    private String repaymentYear;
    private String paymentStatus;
    public List<InsuranceOutstandingAmountDTO> outstandingAmounts;
}
