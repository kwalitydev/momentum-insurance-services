package core.service;

import core.constants.PaymentStatus;
import core.util.CoreUtil;
import dao.entities.InsuranceOutstandingAmount;
import dao.entities.PaymentSchedule;
import dao.enums.InvoiceType;
import dao.enums.PaymentMethodStatus;
import dao.repositories.PaymentScheduleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DBTransactionService {
    private static final Logger logger = LogManager.getLogger(DBTransactionService.class);

    @Inject
    private IInsuranceOutstandingAmount IInsuranceOutstandingAmount;

    @Inject
    private IPaymentScheduleService paymentScheduleService;

    @Inject
    private PaymentScheduleRepository paymentScheduleRepository;


    @Transactional()
    public void processAndPersistPaymentSchedule(PaymentSchedule newSchedule,
                                                 List<InsuranceOutstandingAmount> outstandingAmountList,
                                                 InvoiceType invoiceType) {

        String method = "processAndPersistPaymentSchedule";
        logger.info("{} - Start - invoiceType: {}", method, invoiceType);

        if (invoiceType == InvoiceType.INVOICE) {
            expireLinkedProformas(outstandingAmountList, method);

        }
        this.paymentScheduleService.save(newSchedule);
        logger.info("{} - New PaymentSchedule saved. id: {}", method, newSchedule.toString());

        List<Long> outstandingIds = getLinkedOutstandingIds(outstandingAmountList);

        if (!outstandingIds.isEmpty()) {

            String status = invoiceType == InvoiceType.INVOICE ?
                    InvoiceType.INVOICE.name() :
                    InvoiceType.PROFORMA.name();

            logger.info("{} - Updating outstanding records. count: {}, status: {}",
                    method, outstandingIds.size(), status);

            this.IInsuranceOutstandingAmount.updateInsuranceOutstandingByID(outstandingIds,
                    status, CoreUtil.today(), newSchedule);
        }

    }

    @Transactional()
    public int updatePaymentSchedule(Long paymentSchedule,
                                     String transactionId,
                                     LocalDateTime paymentDate,
                                     PaymentMethodStatus paymentMethodStatus,
                                     PaymentStatus paymentStatus,
                                     BigDecimal paidAmount,
                                     String operatorMessage,
                                     String externalTransactionId
    ) {

        return this.paymentScheduleRepository
                .updatePaymentSchedule(paymentSchedule,
                        transactionId,
                        paymentDate,
                        paymentMethodStatus,
                        paymentStatus, paidAmount, operatorMessage, externalTransactionId);
    }


    private void expireLinkedProformas(
            List<InsuranceOutstandingAmount> outstandingList,
            String method) {

        List<PaymentSchedule> proformasToExpire = outstandingList.stream()
                .map(InsuranceOutstandingAmount::getPaymentSchedule)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());

        if (proformasToExpire.isEmpty()) {
            logger.info("{} - No PROFORMA schedules to expire", method);
            return;
        }

        for (PaymentSchedule ps : proformasToExpire) {
            logger.info("{} - Expiring scheduleId: {}", method, ps.getPaymentScheduleId());
            ps.setPaymentStatus(PaymentStatus.EXPIRED);
            paymentScheduleService.save(ps);
        }
        logger.info("{} - Expired {} PROFORMA schedules", method, proformasToExpire.size());
    }

    private List<Long> getLinkedOutstandingIds(List<InsuranceOutstandingAmount> outstandingList) {

        if (outstandingList == null || outstandingList.isEmpty()) {
            return Collections.emptyList();
        }
        return outstandingList.stream()
                .map(InsuranceOutstandingAmount::getInsuranceOutstandingAmountId)
                .collect(Collectors.toList());
    }
}
