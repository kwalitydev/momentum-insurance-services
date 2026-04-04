package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class BeneficiaryPriceResponse implements Serializable {

    private String memberType;
    private BigDecimal price;

    public BeneficiaryPriceResponse(BigDecimal price, String memberType) {
        this.price = price;
        this.memberType = memberType;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BeneficiaryPriceResponse{" +
                "memberType='" + memberType + '\'' +
                ", price=" + price +
                '}';
    }
}
