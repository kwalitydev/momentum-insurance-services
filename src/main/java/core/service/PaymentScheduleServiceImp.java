package core.service;

import core.beans.*;
import core.constants.ChartFilter;
import core.constants.PaymentStatus;
import dao.entities.PaymentSchedule;
import dao.enums.PaymentMethodStatus;
import dao.repositories.PaymentScheduleRepository;
import org.springframework.data.domain.PageRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped

public class PaymentScheduleServiceImp implements IPaymentScheduleService {
    @Inject
    PaymentScheduleRepository paymentScheduleRepository;

    @Override
    public List<RecentPaymentDTO> getLastPayments(int limit) {

        DateTimeFormatter timeFormatter =
                DateTimeFormatter.ofPattern("HH:mm");

        List<PaymentSchedule> payments =
                paymentScheduleRepository.findLastPayments(
                        PaymentStatus.PAID,
                        PageRequest.of(0, limit)
                );

        return payments.stream()
                .map(p -> new RecentPaymentDTO(
                        p.getInsurancePolicy().getInsurancePolicyId(),
                        p.getPaidAmount(),
                        p.getPaymentMethodStatus().name(),
                        p.getPaymentDate().toLocalDate(),
                        p.getPaymentDate()
                                .format(timeFormatter)
                ))
                .collect(Collectors.toList());
    }

    @Override
    public MonthlyCollectionSummaryDTO getCurrentMonthSummary() {
        LocalDate now = LocalDate.now();

        List<Object[]> rows =
                paymentScheduleRepository.sumPaidAmountByMethodForMonth(
                        PaymentStatus.PAID,
                        now.getYear(),
                        now.getMonthValue()
                );

        Map<PaymentMethodStatus, BigDecimal> totals =
                new EnumMap<>(PaymentMethodStatus.class);

        for (Object[] row : rows) {
            PaymentMethodStatus method = (PaymentMethodStatus) row[0];
            BigDecimal amount = (BigDecimal) row[1];
            totals.put(method, amount);
        }

        BigDecimal totalMpesa =
                totals.getOrDefault(PaymentMethodStatus.MPESA, BigDecimal.ZERO);

        BigDecimal totalEmola =
                totals.getOrDefault(PaymentMethodStatus.E_MOLA, BigDecimal.ZERO);

        return MonthlyCollectionSummaryDTO.builder()
                .totalMpesa(totalMpesa)
                .totalEmola(totalEmola)
                .totalAmount(totalMpesa.add(totalEmola))
                .build();
    }

    @Override
    public MonthlySummeryDTO getMonthlySummery() {
        YearMonth currentMonth = YearMonth.now();
        LocalDateTime startDate =
                currentMonth.atDay(1).atStartOfDay();

        LocalDateTime endDate =
                currentMonth.plusMonths(1)
                        .atDay(1)
                        .atStartOfDay();

        BigDecimal totalCollected =
                paymentScheduleRepository.sumPaidAmountForPeriod(
                        PaymentStatus.PAID,
                        startDate,
                        endDate
                );

        return MonthlySummeryDTO.builder()
                .totalCollected(
                        totalCollected != null ? totalCollected : BigDecimal.ZERO
                )
                .month(currentMonth.getMonthValue())
                .year(currentMonth.getYear())
                .build();
    }



    @Override
    public PaymentChartDTO buildMonthOrYearChart(String filter) {

        ChartFilter chartFilter;
        try {
            chartFilter = ChartFilter.valueOf(filter.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Invalid filter. Use MONTH or YEAR"
            );
        }
        switch (chartFilter) {
            case MONTH:
                return buildMonthChart();

            case YEAR:
                return buildYearChart();
            default:
                throw new IllegalArgumentException(
                        "Unsupported filter"
                );
        }
    }
    private PaymentChartDTO buildMonthChart() {

        LocalDate today = LocalDate.now();

        LocalDateTime startOfMonth =
                today.withDayOfMonth(1).atStartOfDay();

        LocalDateTime endOfMonth =
                today.plusMonths(1)
                        .withDayOfMonth(1)
                        .atStartOfDay();

        List<Object[]> rows =
                paymentScheduleRepository.sumPaidAmountByDay(
                        PaymentStatus.PAID,
                        startOfMonth,
                        endOfMonth
                );

        Map<LocalDate, BigDecimal> totals = new LinkedHashMap<>();

        for (Object[] row : rows) {

            LocalDateTime dateTime = (LocalDateTime) row[0];
            BigDecimal amount = (BigDecimal) row[1];

            LocalDate date = dateTime.toLocalDate();

            totals.merge(date, amount, BigDecimal::add);
        }

        List<ChartPointDTO> points = new ArrayList<>();

        LocalDate cursor = startOfMonth.toLocalDate();
        LocalDate endDate = endOfMonth.minusDays(1).toLocalDate();

        while (!cursor.isAfter(endDate)) {
            points.add(new ChartPointDTO(
                    cursor.toString(),
                    totals.getOrDefault(cursor, BigDecimal.ZERO)
            ));

            cursor = cursor.plusDays(1);
        }

        return PaymentChartDTO.builder()
                .filter("MONTH")
                .points(points)
                .build();
    }

    private PaymentChartDTO buildYearChart() {

        int year = LocalDate.now().getYear();

        LocalDateTime startOfYear =
                LocalDate.of(year, 1, 1).atStartOfDay();

        LocalDateTime endOfYear =
                startOfYear.plusYears(1);

        List<Object[]> rows =
                paymentScheduleRepository.sumPaidAmountByMonth(
                        PaymentStatus.PAID,
                        startOfYear,
                        endOfYear
                );

        Map<Integer, BigDecimal> totals = new HashMap<>();

        for (Object[] row : rows) {

            Integer month = ((Number) row[0]).intValue();

            BigDecimal amount = row[1] != null
                    ? (BigDecimal) row[1]
                    : BigDecimal.ZERO;

            totals.put(month, amount);
        }

        List<ChartPointDTO> points = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {

            String labelDate = String.format("%d-%02d", year, month);

            points.add(new ChartPointDTO(
                    labelDate,
                    totals.getOrDefault(month, BigDecimal.ZERO)
            ));
        }

        return PaymentChartDTO.builder()
                .filter("YEAR")
                .points(points)
                .build();
    }
}
