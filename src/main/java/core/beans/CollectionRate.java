package core.beans;

import java.io.Serializable;

public class CollectionRate implements Serializable {

    private String product;
    private int totalAttempts;
    private int totalPaid;
    private int totalUnpaid;
    private Double paymentRate;
    private Double unpaidRate;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public void setTotalAttempts(int totalAttempts) {
        this.totalAttempts = totalAttempts;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(int totalPaid) {
        this.totalPaid = totalPaid;
    }

    public int getTotalUnpaid() {
        return totalUnpaid;
    }

    public void setTotalUnpaid(int totalUnpaid) {
        this.totalUnpaid = totalUnpaid;
    }

    public Double getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(Double paymentRate) {
        this.paymentRate = paymentRate;
    }

    public Double getUnpaidRate() {
        return unpaidRate;
    }

    public void setUnpaidRate(Double unpaidRate) {
        this.unpaidRate = unpaidRate;
    }
}
