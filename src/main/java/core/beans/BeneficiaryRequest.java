package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class BeneficiaryRequest implements Serializable {

    private String username;
    private String sessionId;
    private String operationType;
    private MemberRequest memberRequest;
    private String policyId;




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

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public MemberRequest getMemberRequest() {
        return memberRequest;
    }

    public void setMemberRequest(MemberRequest memberRequest) {
        this.memberRequest = memberRequest;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    @Override
    public String toString() {
        return "BeneficiaryRequest{" +
                "username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", operationType='" + operationType + '\'' +
                ", memberRequest=" + memberRequest +
                '}';
    }
}
