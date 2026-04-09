package core.constants;

public enum ObjectTypes {
    PRODUCT_CONFIG_CHANGE("Parâmetos de validação"),
    ACCOUNT("Contas"),
    MEMBER_PRICE("Preço por membro"),
    COVERAGE("Cobertura");


    private final String objectTye;

    ObjectTypes(String objectTye) {
        this.objectTye = objectTye;
    }

    public String getObjectTye() {
        return objectTye;
    }
}
