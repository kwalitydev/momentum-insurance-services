package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MemberRequest implements Serializable {
    private String name;
    private String dateOfBirth;
    private String idTypeId;
    private String benStudent;
    private Long relationShipId;
    private String docNumber;
    private BigDecimal totalCharge;
    private Long beneficiaryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdTypeId() {
        return idTypeId;
    }

    public void setIdTypeId(String idTypeId) {
        this.idTypeId = idTypeId;
    }

    public String getBenStudent() {
        return benStudent;
    }

    public void setBenStudent(String benStudent) {
        this.benStudent = benStudent;
    }

    public Long getRelationShipId() {
        return relationShipId;
    }

    public void setRelationShipId(Long relationShipId) {
        this.relationShipId = relationShipId;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Long beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }


    @Override
    public String toString() {
        return "MemberRequest{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idTypeId='" + idTypeId + '\'' +
                ", benStudent='" + benStudent + '\'' +
                ", relationShipId=" + relationShipId +
                ", docNumber='" + docNumber + '\'' +
                ", totalCharge=" + totalCharge +
                ", beneficiaryId=" + beneficiaryId +
                '}';
    }
}
