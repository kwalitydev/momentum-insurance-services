package dao.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Fees implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feesId;
    private String feeType; //ADMIN FEE
    private BigDecimal amount;
    @OneToOne
    private ProductConfig productConfig;
    @OneToOne
    private ProcessWorkflow processWorkflow;

    public Long getFeesId() {
        return feesId;
    }

    public void setFeesId(Long feesId) {
        this.feesId = feesId;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ProductConfig getProductConfig() {
        return productConfig;
    }

    public void setProductConfig(ProductConfig productConfig) {
        this.productConfig = productConfig;
    }

    public ProcessWorkflow getProcessWorkflow() {
        return processWorkflow;
    }

    public void setProcessWorkflow(ProcessWorkflow processWorkflow) {
        this.processWorkflow = processWorkflow;
    }

    @Override
    public String toString() {
        return "Fees{" +
                "feesId=" + feesId +
                ", feeType='" + feeType + '\'' +
                ", amount=" + amount +
                ", productConfig=" + productConfig +
                ", processWorkflow=" + processWorkflow +
                '}';
    }
}
