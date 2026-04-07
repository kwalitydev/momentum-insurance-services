package core.exception;

import lombok.Data;

import java.io.Serializable;
@Data
public class ErrorResponse implements Serializable {

    private int code;
    private String message;
    private String timestamp;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    // getters
}