package core.service;

import dao.entities.InsurancePolicy;
import dao.entities.Token;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ITokenService {

    Token findByToken(String token);

    Token  saveToken(Token token);
    Optional<Token> findFirstByInsurancePolicyAndIsUsedFalseOrderByExpiryDateDesc(InsurancePolicy insurancePolicy);
    Optional<Token> fetchByTokenId(@Param("id") Long id);
    int markAsUsed(@Param("id") Long id);

}
