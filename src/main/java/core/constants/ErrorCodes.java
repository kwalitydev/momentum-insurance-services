package core.constants;

public enum ErrorCodes {
    INVALID_CREDENTIALS ("Credenciais Inválidas!"),
    USER_LOCKED("Utilizador bloqueado, contacte o administrador do sistema!"),
    INACTIVE_USER ("Utilizador inactivo, contacte o administrador do sistema!"),
    LOGIN_MAX_ATTEMPTS_REACHED ("Tentativas de login erradas excedido!"),

    ACCOUNT_HAS_ACTIVE_POLICY ("ACCOUNT_HAS_ACTIVE_POLICY"),
    ACCOUNT_NOT_FOUND ("Conta inexistente"),
    ACCOUNT_DETAILS_NOT_FOUND("ACCOUNT_NOT_FOUND");

    private final String errorCode;

    ErrorCodes(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
