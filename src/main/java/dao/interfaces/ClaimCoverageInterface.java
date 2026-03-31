package dao.interfaces;

import dao.entities.ClaimCoverage;
import dao.entities.Product;
import dao.entities.SubProduct;

import java.util.List;


public interface ClaimCoverageInterface {

    List<ClaimCoverage> findByProductAndStatus(Product product, boolean status);
}
