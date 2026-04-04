package api;


import core.beans.*;
import core.service.IPaymentScheduleService;
import core.service.IPolicyChartService;
import core.util.Util;
import io.swagger.v3.oas.annotations.Operation;

import javax.inject.Inject;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path(Util.API_V2)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DashboardAPI {

    @Inject
    IPolicyChartService policyChartService;

    @Inject
    IPaymentScheduleService iPaymentScheduleService;

    @GET
    @Path("/payments/monthly-summary")
    @Operation(summary = "Get month summery", description = "Returns monthlySummery")
    public MonthlySummeryDTO getMonthlySummery() {

        return iPaymentScheduleService.getMonthlySummery();
    }

    @GET
    @Path("/payments/summary/chart")
    public PaymentChartDTO getChart(

            @QueryParam("filter")
            @DefaultValue("MONTH")
            @Pattern(
                    regexp = "MONTH|YEAR",
                    message = "filter must be MONTH or YEAR"
            )
            String filter
    ) {
        return iPaymentScheduleService.buildMonthOrYearChart(filter);
    }

    @GET
    @Path("/payments/monthly-channel-summary")
    public MonthlyCollectionSummaryDTO getSummary() {
        return iPaymentScheduleService.getCurrentMonthSummary();
    }

    @GET
    @Path("/payments/recent")
    public List<RecentPaymentDTO> getRecentPayments(
            @QueryParam("limit")
            @DefaultValue("5")
            @Min(1)
            int limit
    ) {
        return iPaymentScheduleService.getLastPayments(limit);
    }

    @GET
    @Path("/policies/summary")
    public PolicyDashboardStats getPolicyStats() {
        return policyChartService.getDashboardStats();
    }

    @GET
    @Path("/policies/summary/chart")
    public PolicyChart getYearPolicyChart() {
        return policyChartService.buildYearPolicyChart();
    }
}
