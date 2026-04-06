package dao.interfaces;


import dao.entities.PolicyHolder;

import java.util.Date;


public interface PolicyHolderInterface {

    PolicyHolder save(PolicyHolder policyHolder);
    PolicyHolder saveAndFlush(PolicyHolder policyHolder);
    int updatePolicyHolder(Date dateOfBirth, String mobileNumber, Date lastUpdate, String customerName, String email, String vat, String address, Long id);

    int updatePolicyHolder(Date dateOfBirth, String mobileNumber, Date lastUpdate, String customerName, String email, String vat,
                           String address, Long jobTitleId, String documentId, Long id);

}
