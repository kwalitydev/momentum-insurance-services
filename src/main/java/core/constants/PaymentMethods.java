package core.constants;

public enum PaymentMethods {
    NORMAL("Normal"),
    DELAYED("Atrasado");

    private final String method;

    PaymentMethods(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
