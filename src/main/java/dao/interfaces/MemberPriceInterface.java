package dao.interfaces;


import dao.entities.Currency;
import dao.entities.MemberProductPrice;
import dao.entities.Status;
import dao.entities.SubProduct;

import java.util.Optional;

public interface MemberPriceInterface {
    <S extends MemberProductPrice> S save(S p);
    Optional<MemberProductPrice> findByCurrencyAndSubProductAndStatus(Currency currency, SubProduct subProduct, Status status);

}
