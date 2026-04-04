package core.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ChartPointPolicy {
    private String label;   // yyyy-MM
    private Long value;
}
