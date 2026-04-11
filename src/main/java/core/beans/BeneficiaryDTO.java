package core.beans;


import lombok.Builder;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;
@Data
@Builder
public class BeneficiaryDTO implements Serializable {
    private String name;
    private BigDecimal totalCharge;
    private String status;
    private String dateOfBirth;
}
