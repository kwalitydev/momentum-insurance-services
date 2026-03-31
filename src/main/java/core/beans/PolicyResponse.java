package core.beans;

import java.io.Serializable;

public class PolicyResponse implements Serializable {
    private String errorMessage;
    private boolean status;
    private String policyId;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    @Override
    public String toString() {
        return "PolicyResponse{" +
                "errorMessage='" + errorMessage + '\'' +
                ", status=" + status +
                ", policyId='" + policyId + '\'' +
                '}';
    }
}
