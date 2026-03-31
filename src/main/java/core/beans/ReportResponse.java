package core.beans;

public class ReportResponse {
    private String file;
    private String fileName;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "ReportResponse{" +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}
