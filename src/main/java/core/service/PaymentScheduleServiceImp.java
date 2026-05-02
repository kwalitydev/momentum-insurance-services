package core.service;

import core.beans.*;
import core.constants.ChartFilter;
import core.constants.FrequenciesEnum;
import core.constants.PaymentStatus;
import core.exception.BusinessException;
import core.util.CoreUtil;
import core.util.Util;
import dao.entities.*;
import dao.enums.*;
import dao.interfaces.BaseAmountInterface;
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

    @Inject
    private IMpesaClientService iMpesaClientService;

    @Inject
    private PartialPaymentService partialPaymentService;

    @Inject
    private BaseAmountInterface baseAmountInterface;

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

        logger.info("{} - Start - insurancePolicyId: {}, invoiceType: {}", method, insurancePolicyId, invoiceType);

        LocalDate today = LocalDate.now();
        String month = String.valueOf(today.getMonthValue());
        String year = String.valueOf(today.getYear());

        logger.debug("{} - Current date info - month: {}, year: {}", method, month, year);

        if (invoiceType.equals(InvoiceType.PROFORMA)) {

            logger.info("{} - Processing PROFORMA validation for insurancePolicyId: {}", method, insurancePolicyId);

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
                    .existsPolicyChangeInPeriod(insurancePolicyId, Util.formatDate(lastPaidDate), Util.formatDate(CoreUtil.today()));

            logger.debug("{} - Policy change exists in period: {}", method, existsPolicyChangeInPeriod);

            if (!existsPolicyChangeInPeriod) {
                logger.error("{} - No policy change found for PROFORMA. insurancePolicyId: {}", method, insurancePolicyId);
                throw new BusinessException(Response.Status.BAD_REQUEST.getStatusCode(),
                        "Payment schedule: " + insurancePolicyId + " has no policy change.");
            }
        }

        boolean exists = paymentScheduleInterface
                .existsByPolicyIdAndMonthAndYear(insurancePolicyId, month, year, invoiceType);

        logger.debug("{} - Payment already exists for month/year: {}", method, exists);

        if (exists) {
            logger.error("{} - Payment already exists for insurancePolicyId: {}, month: {}, year: {}",
                    method, insurancePolicyId, month, year);

            throw new BusinessException(Response.Status.BAD_REQUEST.getStatusCode(),
                    "Payment schedule: " + insurancePolicyId + " already exists for this month");
        }

        boolean isFirstPayment = isFirstPayment(insurancePolicy);
        boolean shouldGenerate = shouldGenerate(
                insurancePolicy.getPaymentFrequency(),
                today,
                insurancePolicy.getBenefitCycle()
        );

        logger.debug("{} - isFirstPayment: {}, shouldGenerate: {}", method, isFirstPayment, shouldGenerate);

        if (!isFirstPayment && !shouldGenerate) {
            logger.warn("{} - Skipping generation. insurancePolicyId: {}", method, insurancePolicyId);

            throw new BusinessException(Response.Status.BAD_REQUEST.getStatusCode(),
                    "Payment schedule for policy: " + insurancePolicyId + " is not due this cycle");
        }

        String status = invoiceType == InvoiceType.PROFORMA ?
                insuranceOutstandingEnum.NEW.name() :
                InvoiceType.PROFORMA.name();

        List<InsuranceOutstandingAmount> outstandingAmountList =
                IInsuranceOutstandingAmount.findByInsurancePolicyId(
                        insurancePolicyId,
                        status
                );

        logger.info("{} - Outstanding records found: {}", method, outstandingAmountList.size());


        BigDecimal amount = calculateInstallment(insurancePolicy, outstandingAmountList);

        logger.info("{} - Calculated installment amount: {}", method, amount);

        PaymentSchedule newSchedule = new PaymentSchedule();
        newSchedule.setInsurancePolicy(insurancePolicy);
        newSchedule.setRepaymentAmount(amount);
        newSchedule.setCreatedDate(new Date());
        newSchedule.setInvoiceType(invoiceType);
        newSchedule.setRepaymentMonth(month);
        newSchedule.setRepaymentYear(year);
        newSchedule.setPaymentStatus(PaymentStatus.PENDING);
        newSchedule.setNormalPayment(true);

        logger.debug("{} - PaymentSchedule prepared: insurancePolicyId={}, amount={}, month={}, year={}",
                method, insurancePolicyId, amount, month, year);

        dBTransactionService.processAndPersistPaymentSchedule(newSchedule, outstandingAmountList, invoiceType);

        logger.info("{} - Success - Payment schedule created for insurancePolicyId: {}", method, insurancePolicyId);
    }

    @Override
    public PaymentScheduleDetails findPaymentDetailsByInsurancePolicy(
            String insurancePolicyId,
            List<PaymentStatus> paymentStatuses,Long paymentScheduleId) {

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

            BigDecimal baseAmountByPolicyId = baseAmountInterface.findBaseAmountByPolicyId(insurancePolicy.getPolicyId());

            logger.info("{} - BaseAmount  found for policy: {}", method, insurancePolicy.getPolicyId());

            List<Beneficiaries> beneficiariesList =
                    beneficiariesRepository.findByInsurancePolicyId(insurancePolicyId);

            logger.info("{} - Beneficiaries fetched: {}", method, beneficiariesList.size());

            List<BeneficiaryDTO> beneficiaries = beneficiariesList.stream()
                    .map(b -> BeneficiaryDTO.builder()
                            .name(b.getName())
                            .beneficiaryId(b.getBeneficiaryId())
                            .totalCharge(b.getTotalCharge())
                            .status(b.getStatus().getDescription())
                            .description(b.getRelationShip().getDescription())
                            .dateOfBirth(Util.formatDate(b.getDateOfBirth()))
                            .build()
                    )
                    .collect(Collectors.toList());

            List<PaymentSchedule> paymentSchedules;
            if(paymentScheduleId != null){
                paymentSchedules =
                        paymentScheduleInterface.findByPaymentSchedule(
                                paymentScheduleId
                        );

            }
            else{
                paymentSchedules =
                        paymentScheduleInterface.findByPolicyAndPaymentStatus(
                                insurancePolicyId,
                                paymentStatuses
                        );
            }


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
                                .paymentId(ps.getPaymentScheduleId())
                                .repaymentAmount(ps.getRepaymentAmount())
                                .paidAmount(ps.getPaidAmount())
                                .repaymentMonth(ps.getRepaymentMonth())
                                .invoiceType(ps.getInvoiceType() == null ? null : ps.getInvoiceType().name())
                                .repaymentYear(ps.getRepaymentYear())
                                .paymentStatus(ps.getPaymentStatus().name())
                                .outstandingAmounts(outstandingDTOList)
                                .build();

                    }).collect(Collectors.toList());

            PaymentScheduleDetails result = PaymentScheduleDetails.builder()
                    .policyId(insurancePolicy.getPolicyId())
                    .policyBaseAmount(baseAmountByPolicyId)
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

    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {

        String method = "processPayment";

        logger.info("{} - Start - paymentScheduleId: {}, paymentMethod: {}, amount: {}",
                method,
                paymentRequest.getPaymentScheduleId(),
                paymentRequest.getPaymentMethod(),
                paymentRequest.getAmount());

        PaymentSchedule paymentSchedule = paymentScheduleRepository
                .findByPaymentScheduleId(paymentRequest.getPaymentScheduleId())
                .orElseThrow(() -> {
                    logger.error("{} - PaymentSchedule not found for id: {}",
                            method, paymentRequest.getPaymentScheduleId());

                    return new BusinessException(
                            Response.Status.NOT_FOUND.getStatusCode(),
                            "PaymentSchedule not found for id : " + paymentRequest.getPaymentScheduleId()
                    );
                });

        logger.info("{} - PaymentSchedule found - id: {}, currentStatus: {}",
                method,
                paymentSchedule.getPaymentScheduleId(),
                paymentSchedule.getPaymentStatus());

        String transactionId = CoreUtil.generateTransaction();

        if (PaymentMethodStatus.MPESA.equals(paymentRequest.getPaymentMethod())) {

            logger.info("{} - Processing MPESA payment for scheduleId: {}",
                    method, paymentSchedule.getPaymentScheduleId());

            MpesaRequest mpesaRequest = MpesaRequest.builder()
                    .msisdn(paymentRequest.getMobileNumber())
                    .clientTransactionId(transactionId)
                    .amount(paymentRequest.getAmount())
                    .partnerCode("momentum")
                    .clientAppCode("momentum#JMQRJ2S2")
                    .build();

            MpesaResponse mpesaResponse;

            try {
                mpesaResponse = this.iMpesaClientService.callMpesa(mpesaRequest);
            } catch (Exception e) {
                logger.error("{} - Error calling M-Pesa", method, e);

                throw new BusinessException(502, "Error calling payment provider");
            }

            PaymentStatus status = mpesaResponse.getStatus()
                    .equalsIgnoreCase(Util.SUCCESS)
                    ? PaymentStatus.PAID
                    : PaymentStatus.FAILED;

            int updated = dBTransactionService.updatePaymentSchedule(
                    paymentSchedule.getPaymentScheduleId(),
                    transactionId,
                    LocalDateTime.now(),
                    PaymentMethodStatus.MPESA,
                    status,
                    paymentRequest.getAmount(),
                    mpesaResponse.getMessage(),
                    mpesaResponse.getExternalReference()
            );

            logger.info("{} - Update result: {} row(s) affected for scheduleId: {}",
                    method, updated, paymentSchedule.getPaymentScheduleId());

            if (updated == 0) {
                logger.warn("{} - No rows updated for scheduleId: {}", method,
                        paymentSchedule.getPaymentScheduleId());
            }
            // update partial payments
            if (PaymentType.PARTIAL.equals(paymentRequest.getPaymentType())
                && PaymentStatus.PAID.equals(status)) {
                partialPaymentService.processPartialPayment(paymentRequest, paymentSchedule, method);
            }

            logger.info("{} - End - paymentScheduleId: {}", method,
                    paymentRequest.getPaymentScheduleId());

            return PaymentResponse.builder()
                    .responseCode(PaymentStatus.PAID.equals(status) ? Util.SUCCESS : Util.FAILED)
                    .description(mpesaResponse.getMessage())
                    .build();

        }
        throw new BusinessException(400, "Unsupported payment method");
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
