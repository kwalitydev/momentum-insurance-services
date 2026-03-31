package dao.interfaces;


import dao.entities.Currency;
import dao.entities.SubProduct;
import dao.entities.SubProductAccount;
import dao.entities.Status;

import java.util.List;
import java.util.Optional;

public interface SubProductAccountInterface {
    <S extends SubProductAccount> S save(S p);
    List<SubProductAccount> findByStatus(Status status);
    Optional<SubProductAccount> findBySubProductAndCurrencyAndStatus(SubProduct subProduct, Currency currency, Status status);
    List<SubProductAccount> findBySubProductAndCurrencyAndStatusList(SubProduct subProduct, Currency currency, Status status);

    int updateSuProductAccount(String account,Status status,Long productAccountId);

    Optional<SubProductAccount> findBySubProduct(SubProduct subProduct);
    Optional<SubProductAccount> findBySubProductAndCurrencyAndStatus(Long subProductId, String currencyId, String statusId);
}
