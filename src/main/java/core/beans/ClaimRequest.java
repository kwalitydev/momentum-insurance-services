package core.beans;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ClaimRequest implements Serializable {
    private String description;
    private String policyId;
    private String username;
    private String sessionId;
    private String insuranceCompanyId;
    private String sinisterPlace;
    private String sinisterDate;
    private String admissionDate;
    private String exitDate;
    private String sinisterType;
    private BigDecimal benefitAmount;
    private List<FileRequest> fileRequests;
    private String claimant;
    private String qmsProcessNr;
    private String claimProcessId;
    private String sinisterStatus;
    private String coverType;
    private BigDecimal insurerPaidAmount;
    private BigDecimal franchiseAmount;
    private String status;




    public String getDescription() {
        return description;
    }

    public String getPolicyId() {
        return policyId;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getInsuranceCompanyId() {
        return insuranceCompanyId;
    }

    public String getSinisterPlace() {
        return sinisterPlace;
    }

    public String getSinisterDate() {
        return sinisterDate;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public String getSinisterType() {
        return sinisterType;
    }

    public BigDecimal getBenefitAmount() {
        return benefitAmount;
    }

    public List<FileRequest> getFileRequests() {
        return fileRequests;
    }

    public String getClaimant() {
        return claimant;
    }

    public String getQmsProcessNr() {
        return qmsProcessNr;
    }

    public String getClaimProcessId() {
        return claimProcessId;
    }

    public String getSinisterStatus() {
        return sinisterStatus;
    }

    public String getCoverType() {
        return coverType;
    }

    public BigDecimal getInsurerPaidAmount() {
        return insurerPaidAmount;
    }

    public BigDecimal getFranchiseAmount() {
        return franchiseAmount;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ClaimRequest{" +
                "description='" + description + '\'' +
                ", policyId='" + policyId + '\'' +
                ", username='" + username + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", insuranceCompanyId='" + insuranceCompanyId + '\'' +
                ", sinisterPlace='" + sinisterPlace + '\'' +
                ", sinisterDate='" + sinisterDate + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", exitDate='" + exitDate + '\'' +
                ", sinisterType='" + sinisterType + '\'' +
                ", benefitAmount=" + benefitAmount +
                ", fileRequests=" + fileRequests +
                ", claimant='" + claimant + '\'' +
                ", qmsProcessNr='" + qmsProcessNr + '\'' +
                ", claimProcessId='" + claimProcessId + '\'' +
                ", sinisterStatus='" + sinisterStatus + '\'' +
                ", coverType='" + coverType + '\'' +
                ", insurerPaidAmount=" + insurerPaidAmount +
                ", franchiseAmount=" + franchiseAmount +
                ", status='" + status + '\'' +
                '}';
    }
}
