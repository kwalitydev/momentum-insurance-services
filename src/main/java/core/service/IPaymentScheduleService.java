package core.service;

import core.beans.*;
import core.constants.PaymentStatus;
import dao.entities.InsurancePolicy;
import dao.entities.PaymentSchedule;

import java.util.List;

public interface IPaymentScheduleService {
    List<RecentPaymentDTO> getLastPayments(int limit);

    MonthlyCollectionSummaryDTO getCurrentMonthSummary();

    MonthlySummeryDTO getMonthlySummery();

    PaymentChartDTO buildMonthOrYearChart(String filter);

    PaymentSchedule save(PaymentSchedule paymentSchedule);

    void createPaymentSchedule(InsurancePolicy insurancePolicy);

    PaymentScheduleDetails findPaymentDetailsByInsurancePolicy(String insurancePolicyId, List<PaymentStatus> paymentStatuses);


}