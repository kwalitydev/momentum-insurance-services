package dao.repositories;

import dao.entities.PaymentScheduleBeneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentScheduleBeneficiaryRepository
        extends JpaRepository<PaymentScheduleBeneficiary, Long> {
}