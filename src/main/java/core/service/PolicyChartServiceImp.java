package core.service;

import core.beans.ChartPointPolicy;
import core.beans.PolicyChart;
import core.beans.PolicyCountByMonth;
import core.beans.PolicyDashboardStats;
import dao.repositories.InsurancePolicyRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class PolicyChartServiceImp implements IPolicyChartService {

    @Inject
    private InsurancePolicyRepository insurancePolicyRepository;

    @Override
    public PolicyChart buildYearPolicyChart() {

        int year = LocalDate.now().getYear();

        List<PolicyCountByMonth> rows =
                this.insurancePolicyRepository.countPoliciesByMonth(year);

        Map<Integer, Long> totals = rows.stream()
                .collect(Collectors.toMap(
                        PolicyCountByMonth::getMonth,
                        PolicyCountByMonth::getTotal
                ));

        List<ChartPointPolicy> points = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {

            String label = String.format("%d-%02d", year, month);

            points.add(new ChartPointPolicy(
                    label,
                    totals.getOrDefault(month, 0L)
            ));
        }

        return PolicyChart.builder()
                .filter("YEAR")
                .points(points)
                .build();
    }

    @Override
    public PolicyDashboardStats getDashboardStats() {
        return insurancePolicyRepository.countDashboardStatsDTO();
    }
}
