package dao.interfaces;


import dao.entities.Product;

import java.util.List;
import java.util.Optional;


public interface ProductInterface {
    <S extends Product> S save(S p);
    List<Product> findAllByOrderByNameAsc();
    List<Product> findAllByOrderByName();
    List<Product> findByProductType(String productType);
    Optional<Product> findByProductId(String productId);
    List<Product> findByAttributes(String attr);

}
