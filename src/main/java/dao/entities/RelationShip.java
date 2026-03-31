package dao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class RelationShip implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long relationShipId;
    @Column(length = 20)
    private String description;
    @OneToOne
    private Status status;
    @OneToOne
    private Product product;
    private Boolean isChargeable;

    public Long getRelationShipId() {
        return relationShipId;
    }

    public void setRelationShipId(Long relationShipId) {
        this.relationShipId = relationShipId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Boolean getChargeable() {
        return isChargeable;
    }

    public void setChargeable(Boolean chargeable) {
        isChargeable = chargeable;
    }

    @Override
    public String toString() {
        return "RelationShip{" +
                "relationShipId=" + relationShipId +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", product=" + product +
                ", isChargeable=" + isChargeable +
                '}';
    }


}
