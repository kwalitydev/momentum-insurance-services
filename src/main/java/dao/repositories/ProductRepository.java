package dao.repositories;

import dao.entities.Product;
import dao.interfaces.ProductInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String>, ProductInterface {

    @Query("SELECT p FROM Product p WHERE p.productStatus = true")
    List<Product> findAllByOrderByName();

    @Query("SELECT p FROM Product p WHERE p.attributes LIKE %?1%")
    List<Product> findByAttributes(String attr);


}
