package core.beans;



import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Builder
@Data
public class LoginResponse  implements Serializable {

    private List<MenuResponse> menus;
    private boolean isActivating;
    private String userId;
    private String departmentId;
    private String departmentName;
    private String roleId;
    private String roleName;
    private String email;
    private String emailAlt;
    private String fullName;
    private String mobile;
    private String mobileAlt;
    private String surname;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "menus=" + menus +
                ", isActivating=" + isActivating +
                ", userId='" + userId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", email='" + email + '\'' +
                ", emailAlt='" + emailAlt + '\'' +
                ", fullName='" + fullName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mobileAlt='" + mobileAlt + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
