package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class SubProductResponse implements Serializable {

    private BigDecimal baseAmount;
    private String currency;
    private Double holderAgeLimit;
    private Double holderMinAge;


    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Double getHolderAgeLimit() {
        return holderAgeLimit;
    }

    public void setHolderAgeLimit(Double holderAgeLimit) {
        this.holderAgeLimit = holderAgeLimit;
    }

    public Double getHolderMinAge() {
        return holderMinAge;
    }

    public void setHolderMinAge(Double holderMinAge) {
        this.holderMinAge = holderMinAge;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "SubProductResponse{" +
                "baseAmount=" + baseAmount +
                ", currency='" + currency + '\'' +
                ", holderAgeLimit=" + holderAgeLimit +
                ", holderMinAge=" + holderMinAge +
                '}';
    }
}
