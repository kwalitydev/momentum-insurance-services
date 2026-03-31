package dao.interfaces;


import dao.entities.Product;
import dao.entities.SubProduct;

import java.util.List;
import java.util.Optional;

public interface SubProductInterface {
    <S extends Product> S save(S p);
    List<SubProduct> findByProductOrderByName(Product product);
    Optional<SubProduct> findBySubProductId(Long subProduct);

    Optional<SubProduct> findByAliasName(String aliasName);

    List<SubProduct> findByProduct(String productId);

}
