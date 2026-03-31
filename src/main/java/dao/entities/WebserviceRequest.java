package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class WebserviceRequest implements Serializable {

    @Id
    @Column(length = 50)
    private String requestId;
    @OneToOne
    private Users userRequested;
    @Column(length = 50)
    private String methodName;
    private Date requestTime;
    private Date responseTime;
    private long delay;
    @Column(length = 25)
    private String responseStatus;
    private boolean queryExecuted;
    @Column(length = 6)
    private String requestMethod;
    @Column(length = 6)
    private String requestAction;
    private String errorCause;
    @Column(length = 100)
    private String sessionId;
    @Column(length = 40)
    private String ipAddress;
    private Boolean internal = true;
    private String friendlyName;
    private String payloadDetails;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Users getUserRequested() {
        return userRequested;
    }

    public void setUserRequested(Users userRequested) {
        this.userRequested = userRequested;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public boolean isQueryExecuted() {
        return queryExecuted;
    }

    public void setQueryExecuted(boolean queryExecuted) {
        this.queryExecuted = queryExecuted;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestAction() {
        return requestAction;
    }

    public void setRequestAction(String requestAction) {
        this.requestAction = requestAction;
    }

    public String getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(String errorCause) {
        this.errorCause = errorCause;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public String getPayloadDetails() {
        return payloadDetails;
    }

    public void setPayloadDetails(String payloadDetails) {
        this.payloadDetails = payloadDetails;
    }

    @Override
    public String toString() {
        return "WebserviceRequest{" +
                "requestId='" + requestId + '\'' +
                ", userRequested=" + userRequested +
                ", methodName='" + methodName + '\'' +
                ", requestTime=" + requestTime +
                ", responseTime=" + responseTime +
                ", delay=" + delay +
                ", responseStatus='" + responseStatus + '\'' +
                ", queryExecuted=" + queryExecuted +
                ", requestMethod='" + requestMethod + '\'' +
                ", requestAction='" + requestAction + '\'' +
                ", errorCause='" + errorCause + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", internal=" + internal +
                ", friendlyName='" + friendlyName + '\'' +
                ", payloadDetails='" + payloadDetails + '\'' +
                '}';
    }
}
