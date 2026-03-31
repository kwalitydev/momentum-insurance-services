package core.beans;

import java.io.Serializable;

public class FileRequest implements Serializable {

    private Long documentTypeId;
    private String image;
    private String fileType;
    private String fileName;

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileRequest{" +
                "documentTypeId=" + documentTypeId +
                ", fileType='" + fileType + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
