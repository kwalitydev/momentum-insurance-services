package core.service;

import core.beans.BeneficiaryPartialDTO;
import core.beans.PaymentRequest;
import core.exception.BusinessException;
import dao.entities.Beneficiaries;
import dao.entities.PaymentSchedule;
import dao.entities.PaymentScheduleBeneficiary;
import dao.enums.RecordStatus;
import dao.repositories.BeneficiariesRepository;
import dao.repositories.PaymentScheduleBeneficiaryRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class PartialPaymentService {

    private static final Logger logger = LogManager.getLogger(PartialPaymentService.class);

    @Inject
    BeneficiariesRepository beneficiariesRepository;

    @Inject
    PaymentScheduleBeneficiaryRepository paymentScheduleBeneficiaryRepository;

    @Transactional
    public void processPartialPayment(PaymentRequest paymentRequest,
                                      PaymentSchedule paymentSchedule,
                                      String method) {

        logger.info("{} - Processing PARTIAL payment for scheduleId: {}",
                method, paymentSchedule.getPaymentScheduleId());

        if (paymentRequest.getBeneficiaries() == null ||
            paymentRequest.getBeneficiaries().isEmpty()) {

            throw new BusinessException(400, "Beneficiaries required for PARTIAL payment");
        }

        List<Long> ids = paymentRequest.getBeneficiaries()
                .stream()
                .map(BeneficiaryPartialDTO::getBeneficiaryId)
                .collect(Collectors.toList());

        List<Beneficiaries> beneficiaries = beneficiariesRepository.findByIds(ids);

        Map<Long, Beneficiaries> map = beneficiaries.stream()
                .collect(Collectors.toMap(Beneficiaries::getBeneficiaryId, b -> b));

        List<PaymentScheduleBeneficiary> list = new ArrayList<>();

        for (BeneficiaryPartialDTO dto : paymentRequest.getBeneficiaries()) {

            Beneficiaries beneficiary = map.get(dto.getBeneficiaryId());

            if (beneficiary == null) {
                throw new BusinessException(404,
                        "Beneficiary not found: " + dto.getBeneficiaryId());
            }

            PaymentScheduleBeneficiary psb = new PaymentScheduleBeneficiary();
            psb.setPaymentSchedule(paymentSchedule);
            psb.setBeneficiary(beneficiary);
            psb.setStatus(RecordStatus.ACTIVE);
            psb.setPaymentDate(LocalDateTime.now());
            psb.setPaidAmount(dto.getTotalCharge());
            list.add(psb);
        }
        this.paymentScheduleBeneficiaryRepository.saveAll(list);
        logger.info("{} - PARTIAL payment saved - {} beneficiaries",
                method, list.size());
    }
}