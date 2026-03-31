package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity

public class FileTransferLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;
    private String fileName;
    @OneToOne
    private Claim claim;
    private Boolean fileGenerated;
    @OneToOne
    private Status status;
    private String errorMessage;
    private Date attemptDate;
    private String dir;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public Boolean getFileGenerated() {
        return fileGenerated;
    }

    public void setFileGenerated(Boolean fileGenerated) {
        this.fileGenerated = fileGenerated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Date getAttemptDate() {
        return attemptDate;
    }

    public void setAttemptDate(Date attemptDate) {
        this.attemptDate = attemptDate;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "FileTransferLog{" +
                "fileId=" + fileId +
                ", fileName='" + fileName + '\'' +
                ", claim=" + claim +
                ", fileGenerated=" + fileGenerated +
                ", status=" + status +
                ", errorMessage='" + errorMessage + '\'' +
                ", attemptDate=" + attemptDate +
                ", dir='" + dir + '\'' +
                '}';
    }
}
