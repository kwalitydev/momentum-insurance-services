package dao.interfaces;


import dao.entities.*;

import java.util.List;
import java.util.Optional;

public interface MemberProductPriceInterface {
    <S extends MemberProductPrice> S save(S c);
    List<MemberProductPrice> findBySubProduct(SubProduct subProduct);
    Optional<MemberProductPrice> findBySubProduct(SubProduct subProduct, int age, BenefitCycle benefitCycle);
}
