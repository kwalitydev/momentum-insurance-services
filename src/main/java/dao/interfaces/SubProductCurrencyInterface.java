package dao.interfaces;


import dao.entities.SubProduct;
import dao.entities.SubProductCurrency;

import java.util.List;

public interface SubProductCurrencyInterface {
   List<SubProductCurrency> findBySubProductAndAllowed(SubProduct subProduct,boolean allowed);
}
