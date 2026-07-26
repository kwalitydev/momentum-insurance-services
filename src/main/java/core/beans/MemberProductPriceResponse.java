package core.beans;

import dao.entities.*;

import javax.persistence.OneToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberProductPriceResponse implements Serializable {

    private Currency currency;
    private BigDecimal amount;
    private String beneficiaryDescription;
    private boolean isAfterCollectionDays;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBeneficiaryDescription() {
        return beneficiaryDescription;
    }

    public void setBeneficiaryDescription(String beneficiaryDescription) {
        this.beneficiaryDescription = beneficiaryDescription;
    }

    public boolean isAfterCollectionDays() {
        return isAfterCollectionDays;
    }

    public void setAfterCollectionDays(boolean afterCollectionDays) {
        isAfterCollectionDays = afterCollectionDays;
    }
}
