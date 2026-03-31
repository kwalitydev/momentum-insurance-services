package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;


public class CoverageUpdate implements Serializable {

    private Long coverageId;
    private String currencyId;
    private BigDecimal coverAmount;
    private BigDecimal premiumAmount;
    private String username;
    private String sessionId;
    private Long subProductId;
    private Long productConfigId;
    private String processActionId;
    private String comments;
    private Long workflowId;

    public Long getCoverageId() {
        return coverageId;
    }

    public void setCoverageId(Long coverageId) {
        this.coverageId = coverageId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public BigDecimal getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(BigDecimal coverAmount) {
        this.coverAmount = coverAmount;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Long getSubProductId() {
        return subProductId;
    }

    public void setSubProductId(Long subProductId) {
        this.subProductId = subProductId;
    }

    public Long getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(Long productConfigId) {
        this.productConfigId = productConfigId;
    }


    public String getProcessActionId() {
        return processActionId;
    }

    public void setProcessActionId(String processActionId) {
        this.processActionId = processActionId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Long workflowId) {
        this.workflowId = workflowId;
    }

    @Override
    public String toString() {
        return "CoverageUpdate{" +
                "coverageId=" + coverageId +
                ", currencyId='" + currencyId + '\'' +
                ", coverAmount=" + coverAmount +
                ", premiumAmount=" + premiumAmount +
                ", username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", subProductId=" + subProductId +
                ", productConfigId=" + productConfigId +
                ", processAction='" + processActionId + '\'' +
                ", comments='" + comments + '\'' +
                ", workflowId=" + workflowId +
                '}';
    }
}
