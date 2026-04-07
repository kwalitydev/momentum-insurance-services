package core.beans;

import dao.entities.DocumentFile;

public class SFTPContext {

    private DocumentFile documentFile;
    private String traceId;


    public DocumentFile getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(DocumentFile documentFile) {
        this.documentFile = documentFile;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }


}
