package core.beans;


import java.io.Serializable;

public class CancellationContext implements Serializable {
    private String policyId;
    private String comments;
    private String logId;


    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    @Override
    public String toString() {
        return "CancellationContext{" +
                "policyId='" + policyId + '\'' +
                ", comments='" + comments + '\'' +
                ", logId='" + logId + '\'' +
                '}';
    }
}
