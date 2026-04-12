package core.service;

import core.beans.*;
import core.constants.ChartFilter;
import core.constants.FrequenciesEnum;
import core.constants.PaymentStatus;
import core.exception.BusinessException;
import core.util.Util;
import dao.entities.*;
import dao.enums.InvoiceType;
import dao.enums.PaymentMethodStatus;
import dao.enums.TransactionType;
import dao.enums.insuranceOutstandingEnum;
import dao.interfaces.InsurancePolicyInterface;
import dao.interfaces.PaymentScheduleInterface;
import dao.interfaces.PolicyChangeControlInterface;
import dao.repositories.BeneficiariesRepository;
import dao.repositories.InsuranceOutstandingAmountRepository;
import dao.repositories.PaymentScheduleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped

public class PaymentScheduleServiceImp implements IPaymentScheduleService {
    private static final Logger logger = LogManager.getLogger(PaymentScheduleServiceImp.class);

    @Inject
    PaymentScheduleRepository paymentScheduleRepository;

    @Inject
    private PaymentScheduleInterface paymentScheduleInterface;


    @Inject
    private IInsuranceOutstandingAmount IInsuranceOutstandingAmount;


    @Inject
    private InsuranceOutstandingAmountRepository insuranceOutstandingAmountRepository;

    @Inject
    private BeneficiariesRepository beneficiariesRepository;

    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;


    @Inject
    private DBTransactionService dBTransactionService;

    @Inject
    private PolicyChangeControlInterface policyChangeControlInterface;

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

    @Transactional
    @Override
    public PaymentSchedule save(PaymentSchedule paymentSchedule) {
        return paymentScheduleRepository.save(paymentSchedule);
    }

    /****
     * Generate payment schedule to be paid
     * @param insurancePolicy
     */
    @Override
    public void processInvoice(InsurancePolicy insurancePolicy, InvoiceType invoiceType) {

        String method = "processInvoice";
        String insurancePolicyId = insurancePolicy.getInsurancePolicyId();
        String policyId = insurancePolicyId;

        logger.info("{} - Start - policyId: {}, invoiceType: {}", method, policyId, invoiceType);

        LocalDate today = LocalDate.now();
        String month = String.valueOf(today.getMonthValue());
        String year = String.valueOf(today.getYear());

        logger.debug("{} - Current date info - month: {}, year: {}", method, month, year);

        if (invoiceType.equals(InvoiceType.PROFORMA)) {

            logger.info("{} - Processing PROFORMA validation for policyId: {}", method, policyId);

            PaymentSchedule paymentSchedule = paymentScheduleInterface
                    .findLatestByStatus(InvoiceType.INVOICE)
                    .stream()
                    .findFirst()
                    .orElse(null);

            Date lastPaidDate;

            if (paymentSchedule == null || paymentSchedule.getPaymentDate() == null) {
                logger.warn("{} - No previous PAID schedule found, using today as lastPaidDate", method);
                lastPaidDate = insurancePolicy.getStartDate();
            } else {
                lastPaidDate = Util.convertToDate(
                        paymentSchedule.getPaymentDate().toLocalDate());
                logger.debug("{} - Last paid date found: {}", method, lastPaidDate);
            }

            boolean existsPolicyChangeInPeriod = policyChangeControlInterface
                    .existsPolicyChangeInPeriod(insurancePolicyId, lastPaidDate, Util.convertToDate(today));

            logger.debug("{} - Policy change exists in period: {}", method, existsPolicyChangeInPeriod);

            if (!existsPolicyChangeInPeriod) {
                logger.error("{} - No policy change found for PROFORMA. policyId: {}", method, policyId);
                throw new BusinessException(Response.Status.BAD_REQUEST.getStatusCode(),
                        "Payment schedule: " + policyId + " has no policy change.");
            }
        }

        boolean exists = paymentScheduleInterface
                .existsByPolicyIdAndMonthAndYear(policyId, month, year);

        logger.debug("{} - Payment already exists for month/year: {}", method, exists);

        if (exists) {
            logger.error("{} - Payment already exists for policyId: {}, month: {}, year: {}",
                    method, policyId, month, year);

            throw new BusinessException(Response.Status.BAD_REQUEST.getStatusCode(),
                    "Payment schedule: " + policyId + " already exists for this month");
        }

        boolean isFirstPayment = isFirstPayment(insurancePolicy);
        boolean shouldGenerate = shouldGenerate(
                insurancePolicy.getPaymentFrequency(),
                today,
                insurancePolicy.getBenefitCycle()
        );

        logger.debug("{} - isFirstPayment: {}, shouldGenerate: {}", method, isFirstPayment, shouldGenerate);

        if (!isFirstPayment && !shouldGenerate) {
            logger.warn("{} - Skipping generation. policyId: {}", method, policyId);

            throw new BusinessException(Response.Status.BAD_REQUEST.getStatusCode(),
                    "Payment schedule for policy: " + policyId + " is not due this cycle");
        }

        List<InsuranceOutstandingAmount> outstandingAmountList =
                IInsuranceOutstandingAmount.findByInsurancePolicyId(
                        policyId,
                        insuranceOutstandingEnum.NEW.name()
                );

        logger.info("{} - Outstanding records found: {}", method, outstandingAmountList.size());

        List<Long> outstandingAmountListLisIDs = outstandingAmountList.stream()
                .filter(outstandingAmount -> outstandingAmount.getPaymentSchedule() != null)
                .map(InsuranceOutstandingAmount::getInsuranceOutstandingAmountId)
                .collect(Collectors.toList());

        BigDecimal amount = calculateInstallment(insurancePolicy, outstandingAmountList);

        logger.info("{} - Calculated installment amount: {}", method, amount);

        PaymentSchedule ps = new PaymentSchedule();
        ps.setInsurancePolicy(insurancePolicy);
        ps.setRepaymentAmount(amount);
        ps.setCreatedDate(new Date());
        ps.setInvoiceType(invoiceType);
        ps.setRepaymentMonth(month);
        ps.setRepaymentYear(year);
        ps.setPaymentStatus(PaymentStatus.PENDING);
        ps.setNormalPayment(true);

        logger.debug("{} - PaymentSchedule prepared: policyId={}, amount={}, month={}, year={}",
                method, policyId, amount, month, year);

        dBTransactionService.saveDataBase(ps, outstandingAmountListLisIDs);

        logger.info("{} - Success - Payment schedule created for policyId: {}", method, policyId);
    }

    @Override
    public PaymentScheduleDetails findPaymentDetailsByInsurancePolicy(
            String insurancePolicyId,
            List<PaymentStatus> paymentStatuses) {

        String method = "findPaymentDetailsByInsurancePolicy";
        logger.info("{} - Start - insurancePolicyId: {}, paymentStatuses: {}",
                method, insurancePolicyId, paymentStatuses);

        try {

            Optional<InsurancePolicy> insurancePolicyOpt =
                    insurancePolicyInterface.findByInsurancePolicyId(insurancePolicyId);

            if (!insurancePolicyOpt.isPresent()) {
                logger.warn("{} - No InsurancePolicy found for id: {}", method, insurancePolicyId);
                return null;
            }

            InsurancePolicy insurancePolicy = insurancePolicyOpt.get();
            logger.info("{} - InsurancePolicy found: {}", method, insurancePolicy.getInsurancePolicyId());

            List<Beneficiaries> beneficiariesList =
                    beneficiariesRepository.findByInsurancePolicyId(insurancePolicyId);

            logger.info("{} - Beneficiaries fetched: {}", method, beneficiariesList.size());

            List<BeneficiaryDTO> beneficiaries = beneficiariesList.stream()
                    .map(b -> BeneficiaryDTO.builder()
                            .name(b.getName())
                            .totalCharge(b.getTotalCharge())
                            .status(b.getStatus().getDescription())
                            .dateOfBirth(Util.formatDate(b.getDateOfBirth()))
                            .build()
                    )
                    .collect(Collectors.toList());

            List<PaymentSchedule> paymentSchedules =
                    paymentScheduleInterface.findByPolicyAndPaymentStatus(
                            insurancePolicyId,
                            paymentStatuses
                    );

            logger.info("{} - PaymentSchedules fetched: {}", method, paymentSchedules.size());

            List<PaymentScheduleDTO> paymentScheduleDTOList = paymentSchedules.stream()
                    .map(ps -> {

                        logger.debug("{} - Processing PaymentScheduleId: {}",
                                method, ps.getPaymentScheduleId());

                        List<InsuranceOutstandingAmount> outstandingList =
                                insuranceOutstandingAmountRepository
                                        .findByPaymentScheduleId(ps.getPaymentScheduleId());

                        logger.debug("{} - Outstanding fetched for schedule {}: {}",
                                method, ps.getPaymentScheduleId(), outstandingList.size());

                        List<InsuranceOutstandingAmountDTO> outstandingDTOList =
                                outstandingList.stream()
                                        .map(o -> InsuranceOutstandingAmountDTO.builder()
                                                .amount(o.getAmount())
                                                .transactionType(o.getTransactionType())
                                                .description(o.getDescription())
                                                .entryDate(o.getEntryDate())
                                                .build()
                                        ).collect(Collectors.toList());

                        return PaymentScheduleDTO.builder()
                                .repaymentAmount(ps.getRepaymentAmount())
                                .paidAmount(ps.getPaidAmount())
                                .repaymentMonth(ps.getRepaymentMonth())
                                .repaymentYear(ps.getRepaymentYear())
                                .paymentStatus(ps.getPaymentStatus().name())
                                .outstandingAmounts(outstandingDTOList)
                                .build();

                    }).collect(Collectors.toList());

            PaymentScheduleDetails result = PaymentScheduleDetails.builder()
                    .policyId(insurancePolicy.getPolicyId())
                    .insurancePolicyId(insurancePolicy.getInsurancePolicyId())
                    .totalAmount(insurancePolicy.getTotalAmount())
                    .paymentSchedules(paymentScheduleDTOList)
                    .beneficiaries(beneficiaries)
                    .build();

            logger.info("{} - Success - schedules: {}, beneficiaries: {}",
                    method, paymentScheduleDTOList.size(), beneficiaries.size());

            return result;

        } catch (Exception e) {
            logger.error("{} - Error: {}", method, e.getMessage(), e);
            throw e;
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

    private boolean isFirstPayment(InsurancePolicy policy) {
        return !paymentScheduleInterface.existsByPolicyId(policy.getInsurancePolicyId());
    }

    private BigDecimal calculateInstallment(
            InsurancePolicy policy,
            List<InsuranceOutstandingAmount> outstandingAmountList) {

        BigDecimal totalPolicyAmount = policy.getTotalAmount();

        if (outstandingAmountList == null || outstandingAmountList.isEmpty()) {
            return totalPolicyAmount;
        }

        BigDecimal calculatedTotal = calculateTotal(outstandingAmountList);

        if (calculatedTotal == null || calculatedTotal.compareTo(BigDecimal.ZERO) == 0) {
            return totalPolicyAmount;
        }

        BigDecimal result = totalPolicyAmount.add(calculatedTotal);

        return result.compareTo(BigDecimal.ZERO) < 0
                ? BigDecimal.ZERO
                : result;
    }

    public BigDecimal calculateTotal(List<InsuranceOutstandingAmount> list) {
        return list.stream()
                .filter(item -> item.getAmount() != null && item.getTransactionType() != null)
                .map(item -> item.getTransactionType() == TransactionType.CREDIT
                        ? item.getAmount()
                        : item.getAmount().negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private boolean shouldGenerate(Frequency frequency,
                                   LocalDate today,
                                   BenefitCycle benefitCycle) {

        LocalDate start = getCycleStart(benefitCycle, today);

        int monthsFromStart =
                (today.getYear() - start.getYear()) * 12
                + (today.getMonthValue() - start.getMonthValue());

        if (monthsFromStart < 0 || monthsFromStart >= 12) {
            return false;
        }

        FrequenciesEnum freq = FrequenciesEnum
                .valueOf(frequency.getFrequencyId());

        switch (freq) {

            case MONTHLY:
                return true;

            case QUARTERLY:
                return monthsFromStart % 3 == 0;

            case SEMESTERLY:
                return monthsFromStart % 6 == 0;

            case YEARLY:
                return monthsFromStart == 0;

            default:
                throw new IllegalArgumentException("Invalid Frequency: " + frequency);
        }
    }

    private LocalDate getCycleStart(BenefitCycle benefitCycle, LocalDate today) {

        int year = today.getYear();

        switch (benefitCycle.getCycleType()) {

            case "ANNUAL":
                return LocalDate.of(year, 1, 1);

            case "TRANSANUAL":
                return (today.getMonthValue() >= 6)
                        ? LocalDate.of(year, 6, 1)
                        : LocalDate.of(year - 1, 6, 1);
            default:
                throw new IllegalArgumentException("Invalid BenefitCycle: " + benefitCycle.getCycleType());
        }
    }

}
