package core.beans;

import lombok.*;

import java.io.Serializable;
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class createPaymentScheduleRequest implements Serializable {
    private String sessionId;
    private String insurancePolicyId;
}
