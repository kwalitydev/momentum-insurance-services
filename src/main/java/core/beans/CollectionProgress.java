package core.beans;

import java.io.Serializable;

public class CollectionProgress implements Serializable {

    private String product;
    private int toBeCollected;
    private int collected;
    private Double collectedPercentage;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getToBeCollected() {
        return toBeCollected;
    }

    public void setToBeCollected(int toBeCollected) {
        this.toBeCollected = toBeCollected;
    }

    public int getCollected() {
        return collected;
    }

    public void setCollected(int collected) {
        this.collected = collected;
    }

    public Double getCollectedPercentage() {
        return collectedPercentage;
    }

    public void setCollectedPercentage(Double collectedPercentage) {
        this.collectedPercentage = collectedPercentage;
    }
}
