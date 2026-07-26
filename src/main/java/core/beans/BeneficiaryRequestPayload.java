package core.beans;

import java.io.Serializable;
import java.math.BigDecimal;

public class BeneficiaryRequestPayload implements Serializable {

    private String name;
    private String dateOfBirth;
    private String idTypeId;
    private String benStudent;
    private String relationShipId;
    private String relationShipText;
    private String docNumber;
    private Integer index;
    private BigDecimal totalCharge;
    private Long beneficiaryId;
    private String effectiveDate;
    private String comment;

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

    public String getRelationShipId() {
        return relationShipId;
    }

    public void setRelationShipId(String relationShipId) {
        this.relationShipId = relationShipId;
    }

    public String getRelationShipText() {
        return relationShipText;
    }

    public void setRelationShipText(String relationShipText) {
        this.relationShipText = relationShipText;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "BeneficiaryRequestPayload{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idTypeId='" + idTypeId + '\'' +
                ", benStudent='" + benStudent + '\'' +
                ", relationShipId='" + relationShipId + '\'' +
                ", relationShipText='" + relationShipText + '\'' +
                ", docNumber='" + docNumber + '\'' +
                ", index=" + index +
                ", totalCharge=" + totalCharge +
                ", beneficiaryId=" + beneficiaryId +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
