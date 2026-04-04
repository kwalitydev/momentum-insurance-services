package dao.interfaces;


import dao.entities.*;

import java.util.List;
import java.util.Optional;

public interface MemberPriceInterface {
    <S extends MemberProductPrice> S save(S p);
    Optional<MemberProductPrice> findByCurrencyAndSubProductAndStatus(Currency currency, SubProduct subProduct, Status status);

    List<MemberProductPrice> findBySubProductAndBenefitCycleAndStatus(SubProduct subProduct, BenefitCycle benefitCycle, Status status);
}

