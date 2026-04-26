package core.beans;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BeneficiaryPartialDTO implements Serializable {
    private Long beneficiaryId;
    private BigDecimal totalCharge;
}
