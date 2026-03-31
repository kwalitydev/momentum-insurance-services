package core.beans;

import dao.entities.Claim;

import java.io.Serializable;
import java.util.List;

public class ClaimResponse implements Serializable {

    private Claim claim;
    private List<DocumentResponse> documentResponses;

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public List<DocumentResponse> getDocumentResponses() {
        return documentResponses;
    }

    public void setDocumentResponses(List<DocumentResponse> documentResponses) {
        this.documentResponses = documentResponses;
    }

    @Override
    public String toString() {
        return "ClaimResponse{" +
                "claim=" + claim +
                ", documentResponses=" + documentResponses +
                '}';
    }

    public static class DocumentResponse implements Serializable{
        public String documentName;
        public String documentImage;
        private String documentType;

        public String getDocumentName() {
            return documentName;
        }

        public void setDocumentName(String documentName) {
            this.documentName = documentName;
        }

        public String getDocumentImage() {
            return documentImage;
        }

        public void setDocumentImage(String documentImage) {
            this.documentImage = documentImage;
        }

        public String getDocumentType() {
            return documentType;
        }

        public void setDocumentType(String documentType) {
            this.documentType = documentType;
        }

        @Override
        public String toString() {
            return "DocumentResponse{" +
                    "documentName='" + documentName + '\'' +
                    ", documentImage='" + documentImage + '\'' +
                    ", documentType='" + documentType + '\'' +
                    '}';
        }
    }
}
