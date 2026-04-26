package dao.interfaces;


import dao.entities.*;
import org.springframework.data.repository.query.Param;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.util.Optional;

@Local
public interface BaseAmountInterface {
    <S extends BaseAmount> S save(S c);
    Optional<BaseAmount> findBySubProductAndStatus(SubProduct subProduct, Status status, Currency currency);
    int updateProductConfig(ProductConfig productConfig, ProductConfig oldProductConfig);

    Optional<BaseAmount> findBySubProductAndStatus(SubProduct subProduct, Status status, Currency currency, BenefitCycle benefitCycle);
    BigDecimal findBaseAmountByPolicyId( String policyId);

}
