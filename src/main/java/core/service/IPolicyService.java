package core.service;

import core.beans.PolicyChart;
import core.beans.PolicyDashboardStats;
import core.beans.PolicyDetailsDTO;

public interface IPolicyService {
    PolicyChart buildYearPolicyChart();
    PolicyDashboardStats getDashboardStats();
    PolicyDetailsDTO findPaymentDetailsByAccountNumber(String accountNumber);

}
