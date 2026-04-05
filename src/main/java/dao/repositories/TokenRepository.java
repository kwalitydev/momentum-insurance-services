package dao.repositories;

import dao.entities.InsurancePolicy;
import dao.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, String>{
    Optional<Token> findFirstByInsurancePolicyAndIsUsedFalseOrderByExpiryDateDesc(InsurancePolicy insurancePolicy);
    Token findByToken(String token);

    @Query("SELECT t FROM Token t " +
           "JOIN FETCH t.insurancePolicy " +
           "WHERE t.id = :id")
    Optional<Token> fetchByTokenId(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Token t SET t.isUsed = true WHERE t.id = :id")
    int markAsUsed(@Param("id") Long id);
}
