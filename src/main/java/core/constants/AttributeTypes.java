package core.constants;

public enum AttributeTypes {

    HAS_FIXED_FEE ("FF"),
    HAS_STAMP_DUTY ("SD"),
    HAS_FIXED_RISK_RATE ("FRR"),
    HAS_NO_COMMISSION ("NC");

    private final String attribute;

    AttributeTypes(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }


}
