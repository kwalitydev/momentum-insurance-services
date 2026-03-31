package core.constants;

public enum StatusType {
   LOCKED(3),
   INACTIVE(2),
    ACTIVATING(3);


    private final int status;

    StatusType(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

   
}
