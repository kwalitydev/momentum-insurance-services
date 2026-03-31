package dao.repositories;

import dao.entities.BenefitCycle;
import dao.entities.MemberProductPrice;
import dao.entities.SubProduct;
import dao.interfaces.MemberProductPriceInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberProductPriceRepository extends JpaRepository<MemberProductPrice, String>, MemberProductPriceInterface {




    @Query("SELECT mp from MemberProductPrice mp WHERE mp.subProduct=?1 AND mp.maxAge>=?2 AND mp.minAge<=?2 AND mp.benefitCycle=?3")
    Optional<MemberProductPrice> findBySubProduct(SubProduct subProduct, int age, BenefitCycle benefitCycle);

}
