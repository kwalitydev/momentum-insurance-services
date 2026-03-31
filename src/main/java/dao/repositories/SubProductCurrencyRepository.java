package dao.repositories;


import dao.entities.SubProductCurrency;
import dao.interfaces.SubProductCurrencyInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;



@Transactional
public interface SubProductCurrencyRepository extends JpaRepository<SubProductCurrency, String>, SubProductCurrencyInterface {


}
