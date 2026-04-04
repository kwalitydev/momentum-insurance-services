package core.beans;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class LoginResponseDTO {
    private String fullName;
    private String surname;
    private String roleId;
    private String department;
    private List<MenuDTO> menus;
}
