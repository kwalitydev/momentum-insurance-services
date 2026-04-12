package dao.interfaces;

import dao.entities.InsurancePolicy;
import dao.entities.PolicyChangeControl;

import java.util.Date;


public interface PolicyChangeControlInterface {

    PolicyChangeControl save(PolicyChangeControl pcc);
    boolean existsPolicyChangeInPeriod(String insurancePolicy, Date startDate, Date endDate);

}
