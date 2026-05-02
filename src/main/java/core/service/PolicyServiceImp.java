package core.service;

import core.beans.*;
import core.exception.BusinessException;
import core.mapper.MapperUtils;
import core.util.RequestUtil;
import core.util.Util;
import dao.entities.Application;
import dao.entities.Beneficiaries;
import dao.entities.InsurancePolicy;
import dao.interfaces.ApplicationInterface;
import dao.repositories.BeneficiariesRepository;
import dao.repositories.InsurancePolicyRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class PolicyServiceImp implements IPolicyService {
    private static final Logger logger = LogManager.getLogger(PolicyServiceImp.class);

    @Inject
    private InsurancePolicyRepository insurancePolicyRepository;

    @Inject
    private BeneficiariesRepository beneficiariesRepository;
    @Inject
    private ApplicationInterface applicationInterface;


    @Override
    public PolicyChart buildYearPolicyChart() {

        int year = LocalDate.now().getYear();

        List<PolicyCountByMonth> rows =
                this.insurancePolicyRepository.countPoliciesByMonth(year);

        Map<Integer, Long> totals = rows.stream()
                .collect(Collectors.toMap(
                        PolicyCountByMonth::getMonth,
                        PolicyCountByMonth::getTotal
                ));

        List<ChartPointPolicy> points = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {

            String label = String.format("%d-%02d", year, month);

            points.add(new ChartPointPolicy(
                    label,
                    totals.getOrDefault(month, 0L)
            ));
        }

        return PolicyChart.builder()
                .filter("YEAR")
                .points(points)
                .build();
    }

    @Override
    public PolicyDashboardStats getDashboardStats() {
        return insurancePolicyRepository.countDashboardStatsDTO();
    }

    @Override
    public PolicyDetailsDTO findPaymentDetailsByAccountNumber(String accountNumber) {

        String method = "findPaymentDetailsByAccountNumber";

        logger.info("{} - Start - accountNumber: {}", method, accountNumber);

        List<InsurancePolicy> policies = insurancePolicyRepository.findByMobileNumber(accountNumber);

        if (policies == null || policies.isEmpty()) {
            logger.error("{} - No policy found for accountNumber: {}", method, accountNumber);

            throw new BusinessException(
                    Response.Status.NOT_FOUND.getStatusCode(),
                    "No policy found for account number: " + accountNumber
            );
        }

        InsurancePolicy insurancePolicy = policies.get(0);

        logger.info("{} - Policy found - insurancePolicyId: {}", method,
                insurancePolicy.getInsurancePolicyId());

        List<Beneficiaries> beneficiariesList =
                beneficiariesRepository.findByInsurancePolicyId(
                        insurancePolicy.getInsurancePolicyId()
                );

        logger.debug("{} - Beneficiaries fetched - count: {}", method, beneficiariesList.size());

        List<BeneficiaryDTO> beneficiaries = beneficiariesList.stream()
                .map(b -> {
                    logger.debug("{} - Mapping beneficiaryId: {}", method, b.getBeneficiaryId());

                    return BeneficiaryDTO.builder()
                            .beneficiaryId(b.getBeneficiaryId())
                            .name(b.getName())
                            .totalCharge(b.getTotalCharge())
                            .status(b.getStatus() != null ? b.getStatus().getDescription() : null)
                            .description(b.getRelationShip() != null ? b.getRelationShip().getDescription() : null)
                            .dateOfBirth(Util.formatDate(b.getDateOfBirth()))
                            .build();
                })
                .collect(Collectors.toList());

        logger.debug("{} - Beneficiaries mapped - count: {}", method, beneficiaries.size());

        PolicyDetailsDTO policyDetailsDTO;
        Optional<Application> application = applicationInterface.findByAppId(RequestUtil.APP_ID);
        if(application.isPresent()) {

            policyDetailsDTO = MapperUtils
                    .mapToPolicyDetailsDTO(insurancePolicy, beneficiaries,application.get().getCollectionDays());

            logger.info("{} - Successfully built PolicyDetailsDTO for policyId: {}",
                    method, insurancePolicy.getInsurancePolicyId());
        } else {
            logger.error("{} - Application with appId {} not found", method, RequestUtil.APP_ID);

            throw new BusinessException(
                    Response.Status.NOT_FOUND.getStatusCode(),
                    "Application not found for appId: " + RequestUtil.APP_ID
            );
        }


        return policyDetailsDTO;
    }
}
