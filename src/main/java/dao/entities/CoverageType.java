package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CoverageType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coverageTypeId;
    private String description;
    private Date createdDate;
    @OneToOne
    private Status status;

    public Long getCoverageTypeId() {
        return coverageTypeId;
    }

    public void setCoverageTypeId(Long coverageTypeId) {
        this.coverageTypeId = coverageTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CoverageType{" +
                "coverageTypeId=" + coverageTypeId +
                ", description='" + description + '\'' +
                ", createdDate=" + createdDate +
                ", status=" + status +
                '}';
    }
}
