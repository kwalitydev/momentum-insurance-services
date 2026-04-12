package core.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class PolicyDetailsDTO implements Serializable {
    private String policyNumber;
    private String startDate;
    private String endDate;
    private String nextPaymentInterval;
    private String subProductName;
    private BigDecimal amount;
    private String policyStatus;
    private String currency;
    private String message;
    private String status;
    private String frequencyName;
    private InsuredPersonDTO insuredPerson;
    private List<BeneficiaryDTO> beneficiaries;


}
