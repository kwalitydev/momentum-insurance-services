package dao.repositories;

import dao.entities.*;
import dao.interfaces.BaseAmountInterface;
import dao.interfaces.CoverageInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BaseAmountRepository extends JpaRepository<BaseAmount, String>, BaseAmountInterface {


    @Query("Select b FROM BaseAmount b WHERE b.productConfig.subProduct = ?1 AND b.status =?2 AND b.currency =?3")
    Optional<BaseAmount> findBySubProductAndStatus(SubProduct subProduct, Status status, Currency currency);

    @Modifying(clearAutomatically = true)
    @Query("update BaseAmount set productConfig=?1 where productConfig=?2")
    int updateProductConfig(ProductConfig productConfig, ProductConfig oldProductConfig);


    @Query("Select b FROM BaseAmount b WHERE b.productConfig.subProduct = ?1 AND b.status =?2 AND b.currency =?3 AND b.benefitCycle=?4 ")
    Optional<BaseAmount> findBySubProductAndStatus(SubProduct subProduct, Status status, Currency currency, BenefitCycle benefitCycle);
}
