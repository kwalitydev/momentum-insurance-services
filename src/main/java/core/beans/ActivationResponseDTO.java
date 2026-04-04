package core.beans;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivationResponseDTO {
    private String fullName;
    private String surname;
    private String mobile;
    private String roleId;
    private String department;
    private String status;
}
