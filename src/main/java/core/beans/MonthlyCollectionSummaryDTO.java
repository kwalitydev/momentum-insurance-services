package core.beans;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class MonthlyCollectionSummaryDTO {

    private BigDecimal totalAmount;
    private BigDecimal totalMpesa;
    private BigDecimal totalEmola;
}
