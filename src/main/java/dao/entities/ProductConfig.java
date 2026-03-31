package dao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ProductConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productConfigId;
    private Double memberAgeLimit;
    private Double childNumberLimit;
    private Double childAgeLimit;
    private Double parentsMaxAge;
    private Double childMinAge;
    private Double memberMinAge; //others
    private Double holderAgeLimit;
    private Double holderMinAge;
    private Double parentsNumberLimit;
    private Double studentMinAge;
    private Double studentMaxAge;
    private Double extParentMinAge;
    private Double extParentMaxAge;
    private Double partnerMinAge;
    private Double partnerMaxAge;
    private Double partnerNumberLimit;
    private Double memberNumberLimit;
    @OneToOne
    private Status status;
    @OneToOne
    private ProcessWorkflow processWorkflow;
    private Integer maxBenNumber;
    private Integer holderExitAge;
    @OneToOne
    private SubProduct subProduct;
    private Integer numberOfWorkers;
    private Integer benExitAge;

    public Long getProductConfigId() {
        return productConfigId;
    }

    public void setProductConfigId(Long productConfigId) {
        this.productConfigId = productConfigId;
    }

    public Double getMemberAgeLimit() {
        return memberAgeLimit;
    }

    public void setMemberAgeLimit(Double memberAgeLimit) {
        this.memberAgeLimit = memberAgeLimit;
    }

    public Double getChildNumberLimit() {
        return childNumberLimit;
    }

    public void setChildNumberLimit(Double childNumberLimit) {
        this.childNumberLimit = childNumberLimit;
    }

    public Double getChildAgeLimit() {
        return childAgeLimit;
    }

    public void setChildAgeLimit(Double childAgeLimit) {
        this.childAgeLimit = childAgeLimit;
    }

    public Double getParentsMaxAge() {
        return parentsMaxAge;
    }

    public void setParentsMaxAge(Double parentsMaxAge) {
        this.parentsMaxAge = parentsMaxAge;
    }

    public Double getChildMinAge() {
        return childMinAge;
    }

    public void setChildMinAge(Double childMinAge) {
        this.childMinAge = childMinAge;
    }

    public Double getMemberMinAge() {
        return memberMinAge;
    }

    public void setMemberMinAge(Double memberMinAge) {
        this.memberMinAge = memberMinAge;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ProcessWorkflow getProcessWorkflow() {
        return processWorkflow;
    }

    public void setProcessWorkflow(ProcessWorkflow processWorkflow) {
        this.processWorkflow = processWorkflow;
    }

    public Integer getMaxBenNumber() {
        return maxBenNumber;
    }

    public void setMaxBenNumber(Integer maxBenNumber) {
        this.maxBenNumber = maxBenNumber;
    }

    public Double getHolderAgeLimit() {
        return holderAgeLimit;
    }

    public void setHolderAgeLimit(Double holderAgeLimit) {
        this.holderAgeLimit = holderAgeLimit;
    }

    public Double getHolderMinAge() {
        return holderMinAge;
    }

    public void setHolderMinAge(Double holderMinAge) {
        this.holderMinAge = holderMinAge;
    }

    public Double getParentsNumberLimit() {
        return parentsNumberLimit;
    }

    public void setParentsNumberLimit(Double parentsNumberLimit) {
        this.parentsNumberLimit = parentsNumberLimit;
    }

    public Double getStudentMinAge() {
        return studentMinAge;
    }

    public void setStudentMinAge(Double studentMinAge) {
        this.studentMinAge = studentMinAge;
    }

    public Double getStudentMaxAge() {
        return studentMaxAge;
    }

    public void setStudentMaxAge(Double studentMaxAge) {
        this.studentMaxAge = studentMaxAge;
    }

    public Double getExtParentMinAge() {
        return extParentMinAge;
    }

    public void setExtParentMinAge(Double extParentMinAge) {
        this.extParentMinAge = extParentMinAge;
    }

    public Double getExtParentMaxAge() {
        return extParentMaxAge;
    }

    public void setExtParentMaxAge(Double extParentMaxAge) {
        this.extParentMaxAge = extParentMaxAge;
    }

    public Double getPartnerMinAge() {
        return partnerMinAge;
    }

    public void setPartnerMinAge(Double partnerMinAge) {
        this.partnerMinAge = partnerMinAge;
    }

    public Double getPartnerMaxAge() {
        return partnerMaxAge;
    }

    public void setPartnerMaxAge(Double partnerMaxAge) {
        this.partnerMaxAge = partnerMaxAge;
    }



    public Double getPartnerNumberLimit() {
        return partnerNumberLimit;
    }

    public void setPartnerNumberLimit(Double partnerNumberLimit) {
        this.partnerNumberLimit = partnerNumberLimit;
    }

    public Double getMemberNumberLimit() {
        return memberNumberLimit;
    }

    public void setMemberNumberLimit(Double memberNumberLimit) {
        this.memberNumberLimit = memberNumberLimit;
    }

    public Integer getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(Integer numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public Integer getBenExitAge() {
        return benExitAge;
    }

    public void setBenExitAge(Integer benExitAge) {
        this.benExitAge = benExitAge;
    }

    public Integer getHolderExitAge() {
        return holderExitAge;
    }

    public void setHolderExitAge(Integer holderExitAge) {
        this.holderExitAge = holderExitAge;
    }



    @Override
    public String toString() {
        return "ProductConfig{" +
                "productConfigId=" + productConfigId +
                ", memberAgeLimit=" + memberAgeLimit +
                ", childNumberLimit=" + childNumberLimit +
                ", childAgeLimit=" + childAgeLimit +
                ", parentsMaxAge=" + parentsMaxAge +
                ", childMinAge=" + childMinAge +
                ", memberMinAge=" + memberMinAge +
                ", holderAgeLimit=" + holderAgeLimit +
                ", holderMinAge=" + holderMinAge +
                ", parentsNumberLimit=" + parentsNumberLimit +
                ", studentMinAge=" + studentMinAge +
                ", studentMaxAge=" + studentMaxAge +
                ", extParentMinAge=" + extParentMinAge +
                ", extParentMaxAge=" + extParentMaxAge +
                ", partnerMinAge=" + partnerMinAge +
                ", partnerMaxAge=" + partnerMaxAge +
                ", partnerNumberLimit=" + partnerNumberLimit +
                ", memberNumberLimit=" + memberNumberLimit +
                ", status=" + status +
                ", processWorkflow=" + processWorkflow +
                ", maxBenNumber=" + maxBenNumber +
                ", holderExitAge=" + holderExitAge +
                ", subProduct=" + subProduct +
                ", numberOfWorkers=" + numberOfWorkers +
                ", benExitAge=" + benExitAge +
                '}';
    }
}
