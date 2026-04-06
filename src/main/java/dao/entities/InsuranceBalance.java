package dao.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class InsuranceBalance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long insuranceBalanceId;
    private BigDecimal currentBalance;
    @OneToOne
    private InsurancePolicy insurancePolicy;
    private Date lastUpdatedDate;

    public Long getInsuranceBalanceId() {
        return insuranceBalanceId;
    }

    public void setInsuranceBalanceId(Long insuranceBalanceId) {
        this.insuranceBalanceId = insuranceBalanceId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public String toString() {
        return "InsuranceBalance{" +
                "insuranceBalanceId=" + insuranceBalanceId +
                ", insurancePolicy=" + insurancePolicy +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}
