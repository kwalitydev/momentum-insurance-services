package core.beans;

public class Members {

    private String name;
    private String documentId;
    private String relationShip;
    private String percent;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Members{" +
                "name='" + name + '\'' +
                ", documentId='" + documentId + '\'' +
                ", relationShip='" + relationShip + '\'' +
                ", percent='" + percent + '\'' +
                '}';
    }
}
