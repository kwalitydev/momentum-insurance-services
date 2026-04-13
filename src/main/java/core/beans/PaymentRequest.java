package core.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import dao.enums.PaymentMethodStatus;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest implements Serializable {
    private String sessionId;
    private String username;
    private Long paymentScheduleId;
    private BigDecimal amount;
    private String mobileNumber;
    private String policeNumber;
    private PaymentMethodStatus paymentMethod;
}
