package core.beans;

import dao.entities.ProductConfig;

import java.io.Serializable;

public class ProductConfigAuthResponse implements Serializable {
    private ProductConfig newProductConfig;
    private ProductConfig currentProductConfig;


    public ProductConfig getNewProductConfig() {
        return newProductConfig;
    }

    public void setNewProductConfig(ProductConfig newProductConfig) {
        this.newProductConfig = newProductConfig;
    }

    public ProductConfig getCurrentProductConfig() {
        return currentProductConfig;
    }

    public void setCurrentProductConfig(ProductConfig currentProductConfig) {
        this.currentProductConfig = currentProductConfig;
    }


    @Override
    public String toString() {
        return "ProductConfigAuthResponse{" +
                "newProductConfig=" + newProductConfig +
                ", currentProductConfig=" + currentProductConfig +
                '}';
    }
}
