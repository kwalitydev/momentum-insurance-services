package core.beans;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class MpesaRequest implements Serializable {
    private String msisdn;
    private BigDecimal amount;
    private String clientTransactionId;
    private String clientAppCode;
    private String partnerCode;
}