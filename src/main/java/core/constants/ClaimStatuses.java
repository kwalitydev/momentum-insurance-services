package core.constants;

public enum ClaimStatuses {

    OPENED("ABERTO"),
    APPROVED("APROVADO"),
    DECLINED("REJEITADO"),
    PENDING_AUTH("PENDENTE");


    private final String status;

    ClaimStatuses(String statues) {
        this.status = statues;
    }

    public String getStatus() {
        return status;
    }
}
