package core.beans;

import dao.entities.Claim;
import dao.entities.DocumentFile;

public class SFTPContext {
    private Claim claim;
    private DocumentFile documentFile;
    private String traceId;

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

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
