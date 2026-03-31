package core.constants;

public enum Relationships {

    SON("Filho"),
    DAUGHTER("Filha"),
    MOTHER("Mãe"),
    FATHER("Pai"),
    FATHER_IN_LAW("Sogro"),
    MOTHER_IN_LAW("Sogra"),
    SPOUSE("Esposo(a)"),
    OTHER("Beneficiario");


    private final String relationship;

    Relationships(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
}
