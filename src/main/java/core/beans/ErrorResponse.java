package core.beans;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class ErrorResponse implements Serializable {
    private String message;
    private int status;
}