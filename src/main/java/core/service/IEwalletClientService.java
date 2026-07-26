package core.service;

import core.beans.EwalletRequest;
import core.beans.EwalletResponse;
import dao.enums.PaymentMethodStatus;

public interface IEwalletClientService {
     EwalletResponse transferToEwallet(EwalletRequest requestDto, PaymentMethodStatus paymentMethod);
}
