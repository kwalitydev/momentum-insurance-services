package dao.repositories;

import dao.entities.Currency;
import dao.interfaces.CurrencyInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency, String>, CurrencyInterface {

    @Query("SELECT c.currencyId FROM Currency c")
    List<String> findCurrencies();


}
