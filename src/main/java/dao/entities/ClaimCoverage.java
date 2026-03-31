package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ClaimCoverage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimCoverageId;
    private String description;
    @OneToOne
    private Product product;
    private boolean status;

    public Long getClaimCoverageId() {
        return claimCoverageId;
    }

    public String getDescription() {
        return description;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ClaimCoverage{" +
                "claimCoverageId=" + claimCoverageId +
                ", description='" + description + '\'' +
                ", product=" + product +
                ", status=" + status +
                '}';
    }
}
