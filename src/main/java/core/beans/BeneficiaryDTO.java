package core.beans;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;


import java.io.Serializable;
import java.math.BigDecimal;
@Data
@Builder
@ToString
public class BeneficiaryDTO implements Serializable {
    private String name;
    private BigDecimal totalCharge;
    private String description;
    private String status;
    private String dateOfBirth;
}
