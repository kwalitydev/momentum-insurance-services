package dao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ReportFieldMap implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String fieldId;
    private String fieldName;
    private String fieldValue;
    private String description;
    @OneToOne
    private Status status;
    @OneToOne
    private SubProduct subProduct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
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

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    @Override
    public String toString() {
        return "ReportFieldMap{" +
                "id=" + id +
                ", fieldId='" + fieldId + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", fieldValue='" + fieldValue + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", subProduct=" + subProduct +
                '}';
    }
}
