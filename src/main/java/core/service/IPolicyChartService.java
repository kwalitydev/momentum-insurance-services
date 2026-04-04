package core.service;

import core.beans.PolicyChart;
import core.beans.PolicyDashboardStats;

public interface IPolicyChartService {
    PolicyChart buildYearPolicyChart();
    PolicyDashboardStats getDashboardStats();

}
