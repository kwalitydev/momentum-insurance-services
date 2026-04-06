package dao.service;

import dao.entities.InsurancePolicy;
import dao.entities.Token;
import dao.repositories.TokenRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TokenServiceImp implements ITokenService {

    @Inject
    TokenRepository tokenRepository;

    @Override
    public Token findByToken(String token) {
        return this.tokenRepository.findByToken(token);
    }

    @Transactional
    @Override
    public Token saveToken(Token token) {
        return this.tokenRepository.saveAndFlush(token);
    }

    @Override
    public Optional<Token> findFirstByInsurancePolicyAndIsUsedFalseOrderByExpiryDateDesc(InsurancePolicy insurancePolicy) {
        return this.tokenRepository.findFirstByInsurancePolicyAndIsUsedFalseOrderByExpiryDateDesc(insurancePolicy);
    }

    @Override
    public Optional<Token> fetchByTokenId(Long id) {
        return tokenRepository.fetchByTokenId(id);
    }
    @Transactional
    @Override
    public int markAsUsed(Long id) {
        return tokenRepository.markAsUsed(id);
    }
}
