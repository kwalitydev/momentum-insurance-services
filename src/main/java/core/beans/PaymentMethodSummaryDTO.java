package core.beans;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PaymentMethodSummaryDTO implements Serializable {

    private String method;
    private BigDecimal total;

    public PaymentMethodSummaryDTO(String method, BigDecimal total) {
        this.method = method;
        this.total = total;
    }


}