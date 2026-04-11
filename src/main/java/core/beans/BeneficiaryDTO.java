package core.beans;


import lombok.Builder;
import lombok.Data;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Builder
public class BeneficiaryDTO implements Serializable {
    private String name;
    private BigDecimal totalCharge;
    private String status;
    private Date dateOfBirth;
}
