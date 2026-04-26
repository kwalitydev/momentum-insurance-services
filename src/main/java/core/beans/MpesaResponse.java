package core.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MpesaResponse implements Serializable {
    private String clientTransactionId;
    private String externalReference;
    private String status;
    private String message;
    private String statusCode;
}