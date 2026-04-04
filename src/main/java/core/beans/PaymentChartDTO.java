package core.beans;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Builder
public class PaymentChartDTO {

    private String filter; // MONTH | YEAR
    private List<ChartPointDTO> points;
}
