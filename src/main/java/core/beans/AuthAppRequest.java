package core.beans;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthAppRequest implements Serializable {
    private Long tokenId;
    private String otpCode;
    private Boolean biometricEnabled;
    private Boolean loginSaved;
}
