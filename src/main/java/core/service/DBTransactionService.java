package core.service;

import core.util.CoreUtil;
import dao.entities.PaymentSchedule;
import dao.enums.insuranceOutstandingEnum;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DBTransactionService {

    @Inject
    private IInsuranceOutstandingAmount IInsuranceOutstandingAmount;

    @Inject
    private IPaymentScheduleService paymentScheduleService;


    @Transactional()
    public void saveDataBase(PaymentSchedule ps, List<Long> outstandingAmountListLisIDs) {
        this.paymentScheduleService.save(ps);

        if (!outstandingAmountListLisIDs.isEmpty()) {
            this.IInsuranceOutstandingAmount.updateInsuranceOutstandingByID(outstandingAmountListLisIDs,
                    insuranceOutstandingEnum.INVOICED.name(), CoreUtil.today(),ps);
        }

    }
}
