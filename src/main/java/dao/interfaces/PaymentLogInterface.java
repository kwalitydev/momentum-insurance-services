package dao.interfaces;


import dao.entities.PaymentLog;
import dao.entities.Product;
import dao.entities.SubProduct;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PaymentLogInterface {
    List<PaymentLog> findByPolicyId(String policyId, Date startDate, Date endDate);
    List<PaymentLog> findByPolicyId(String policyId, Date startDate, Date endDate, String status);


    List<PaymentLog> findBySubProduct(SubProduct subProduct,Date startDate, Date endDate);
    List<PaymentLog> findBySubProduct(SubProduct subProduct);
    List<PaymentLog> findBySubProductAndPaymentStatus(SubProduct subProduct,String paymentStatus);
    List<PaymentLog> findBySubProduct(SubProduct subProduct,Date startDate, Date endDate,String paymentStatus);
    List<PaymentLog> findByProduct(Product product, Date startDate, Date endDate);

    List<PaymentLog> findByProduct(Product product,Date startDate, Date endDate,String paymentStatus);
    List<PaymentLog> findByPolicyId(String policyId);

    List<PaymentLog> findByProduct(Product product, Date startDate, Date endDate, Pageable pageable);
    List<PaymentLog> findByProduct(Product product, Date startDate, Date endDate,String paymentStatus,Pageable pageable);
    List<PaymentLog> findBySubProduct(SubProduct subProduct, Date startDate, Date endDate,String paymentStatus,Pageable pageable);
    List<PaymentLog> findBySubProduct(SubProduct subProduct, Date startDate, Date endDate,Pageable pageable);
    List<Object[]> findByProduct(String productId, String startDate, String endDate,Pageable pageable);
    List<Object[]> findByProduct(String productId, String startDate, String endDate,String paymentStatus,Pageable pageable);
    List<Object[]> findBySubProduct(Long subProductId, String startDate, String endDate,Pageable pageable);
    List<Object[]> findBySubProduct(Long subProductId, String startDate, String endDate,String paymentStatus,Pageable pageable);

    List<Object[]> findByPolicyId(String policyId,String startDate, String endDate,Pageable pageable);
}
