package core.beans;

import dao.entities.Claim;

import java.io.Serializable;

public class ClaimsTATResponse implements Serializable {

    private Claim claim;
    private String TAT;
    private String RAG;

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public String getTAT() {
        return TAT;
    }

    public void setTAT(String TAT) {
        this.TAT = TAT;
    }

    public String getRAG() {
        return RAG;
    }

    public void setRAG(String RAG) {
        this.RAG = RAG;
    }

    @Override
    public String toString() {
        return "ClaimsTATResponse{" +
                "claim=" + claim +
                ", TAT='" + TAT + '\'' +
                ", RAG='" + RAG + '\'' +
                '}';
    }
}
