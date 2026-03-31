package dao.entities;

import javax.persistence.*;

@Entity
public class BenefitMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long benefitId;

    @OneToOne
    private SubProduct subProduct;
    @ManyToOne
    @JoinColumn(name = "document_file_id")
    private DocumentFile documentFile; //link of the document

    public Long getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(Long benefitId) {
        this.benefitId = benefitId;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    public DocumentFile getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(DocumentFile documentFile) {
        this.documentFile = documentFile;
    }

    @Override
    public String toString() {
        return "BenefitMap{" +
                "benefitId=" + benefitId +
                ", subProduct=" + subProduct +
                ", documentFile=" + documentFile +
                '}';
    }
}
