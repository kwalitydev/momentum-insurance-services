package core.service;

import core.beans.MonthlyCollectionSummaryDTO;
import core.beans.MonthlySummeryDTO;
import core.beans.PaymentChartDTO;
import core.beans.RecentPaymentDTO;

import java.util.List;

public interface IPaymentScheduleService {
    List<RecentPaymentDTO> getLastPayments(int limit);
    MonthlyCollectionSummaryDTO getCurrentMonthSummary();
    MonthlySummeryDTO getMonthlySummery();
    PaymentChartDTO buildMonthOrYearChart(String filter);

}