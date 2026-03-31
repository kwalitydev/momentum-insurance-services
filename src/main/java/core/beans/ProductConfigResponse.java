package core.beans;

import java.io.Serializable;

public class ProductConfigResponse implements Serializable {
    private boolean status;
    private String errorMessage;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ProductConfigResponse{" +
                "status=" + status +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
