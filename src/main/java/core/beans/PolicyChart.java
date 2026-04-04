package core.beans;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PolicyChart {
    private String filter; // YEAR
    private List<ChartPointPolicy> points;
}
