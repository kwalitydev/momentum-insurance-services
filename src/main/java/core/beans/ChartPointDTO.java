package core.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class ChartPointDTO {
    private String label;     // yyyy-MM-dd
    private BigDecimal value; // saldo pago
}
