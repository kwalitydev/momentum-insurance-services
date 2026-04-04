package core.beans;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class MonthlySummeryDTO {

    private BigDecimal totalCollected;
    private int month;
    private int year;
}
