package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DocumentFile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileType;
    @OneToOne
    private DocumentType documentType;
    private String title;
    private String description;
    private String notes;
    private String url;
    private String objectId;
    @Column(length = 35)
    private String inputter;
    @OneToOne
    private Users createdBy;
    private Date createdDate;
    private String recordType;

    @OneToOne
    private IDType idType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getInputter() {
        return inputter;
    }

    public void setInputter(String inputter) {
        this.inputter = inputter;
    }

    public Users getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Users createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public IDType getIdType() {
        return idType;
    }

    public void setIdType(IDType idType) {
        this.idType = idType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        return "DocumentFile{" +
                "id=" + id +
                ", fileType='" + fileType + '\'' +
                ", documentType=" + documentType +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", url='" + url + '\'' +
                ", objectId='" + objectId + '\'' +
                ", inputter='" + inputter + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                ", recordType='" + recordType + '\'' +
                ", idType=" + idType +
                '}';
    }
}
