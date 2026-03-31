package dao.repositories;

import dao.entities.*;
import dao.interfaces.SubProductInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SubProductRepository extends JpaRepository<SubProduct, String>, SubProductInterface {


    @Query("SELECT s.subProductId FROM SubProduct s WHERE s.product IN ?1")
    List<Long> findByProduct(List<Product> products);

    @Query("SELECT s FROM SubProduct s WHERE s.product.productId = ?1")
    List<SubProduct> findByProduct(String productId);
}
