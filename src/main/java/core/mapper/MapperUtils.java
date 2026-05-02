package core.mapper;

import core.beans.BeneficiaryDTO;
import core.beans.InsuredPersonDTO;
import core.beans.PolicyDetailsDTO;
import dao.entities.InsurancePolicy;
import dao.entities.PolicyHolder;

import java.util.List;

import static core.util.Util.formatDate;
import static core.util.Util.getCurrentMonthInterval;

public class MapperUtils {

    public static PolicyDetailsDTO mapToPolicyDetailsDTO(InsurancePolicy policy,
                                                         List<BeneficiaryDTO> beneficiaries,String collectionDays) {
        if (policy == null) return null;

        PolicyHolder holder = policy.getPolicyHolder();

        InsuredPersonDTO insuredPerson = null;

        if (holder != null) {
            insuredPerson = InsuredPersonDTO.builder()
                    .fullName(holder.getCustomerName())
                    .nationalId(holder.getDocumentId())
                    .gender(holder.getGender())
                    .birthDate(formatDate(holder.getDateOfBirth()))
                    .phoneNumber(holder.getMobileNumber())
                    .altPhoneNumber(holder.getAltMobileNumber())
                    .email(holder.getEmail())
                    .address(holder.getAddress())
                    .build();
        }

        return PolicyDetailsDTO.builder()
                .policyNumber(policy.getInsurancePolicyId())
                .startDate(formatDate(policy.getStartDate()))
                .endDate(formatDate(policy.getExpiryDate()))
                .nextPaymentInterval(
                        getCurrentMonthInterval(collectionDays)  != null
                                ? collectionDays
                                : null
                )
                .subProductName(
                        policy.getSubProduct() != null
                                ? policy.getSubProduct().getName()
                                : null
                )
                .amount(policy.getTotalAmount())
                .policyStatus(
                        policy.getStatus() != null
                                ? policy.getStatus().getDescription()
                                : null
                )
                .currency(
                        policy.getCurrency() != null
                                ? policy.getCurrency().getDescription()
                                : null
                )
                .frequencyName(
                        policy.getPaymentFrequency() != null
                                ? policy.getPaymentFrequency().getName()
                                : null
                )
                .insuredPerson(insuredPerson)
                .beneficiaries(beneficiaries)
                .build();
    }
}
