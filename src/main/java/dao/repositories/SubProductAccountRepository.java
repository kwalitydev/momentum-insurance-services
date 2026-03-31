package dao.repositories;

import dao.entities.Currency;
import dao.entities.Status;
import dao.entities.SubProduct;
import dao.entities.SubProductAccount;
import dao.interfaces.SubProductAccountInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubProductAccountRepository extends JpaRepository<SubProductAccount, String>, SubProductAccountInterface {

    @Query("SELECT sp FROM SubProductAccount sp WHERE sp.subProduct=?1 AND sp.currency =?2 AND sp.status =?3")
    Optional<SubProductAccount> findBySubProductAndCurrencyAndStatus(SubProduct subProduct, Currency currency, Status status);

    @Query("SELECT sp FROM SubProductAccount sp WHERE sp.subProduct=?1 AND sp.currency =?2 AND sp.status =?3")
    List<SubProductAccount> findBySubProductAndCurrencyAndStatusList(SubProduct subProduct, Currency currency, Status status);

    @Modifying(clearAutomatically = true)
    @Query("update SubProductAccount set accountId=?1,status=?2 where productAccountId=?3")
    int updateSuProductAccount(String account,Status status,Long productAccountId);

    @Query("SELECT sp FROM SubProductAccount sp WHERE sp.subProduct.subProductId=?1 AND sp.currency.currencyId =?2 AND sp.status.id =?3")
    Optional<SubProductAccount> findBySubProductAndCurrencyAndStatus(Long subProductId, String currencyId, String statusId);

}
