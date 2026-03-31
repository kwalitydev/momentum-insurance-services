package dao.interfaces;


import dao.entities.Currency;

import java.util.List;

public interface CurrencyInterface {
    <S extends Currency> S save(S c);
    List<Currency> findAll();
    List<String> findCurrencies();
}
