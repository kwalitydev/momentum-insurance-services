package core.beans;



import java.util.List;

public class LoginResponse {

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

    public List<MenuResponse> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuResponse> menus) {
        this.menus = menus;
    }

    public boolean isActivating() {
        return isActivating;
    }

    public void setActivating(boolean activating) {
        isActivating = activating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlt() {
        return emailAlt;
    }

    public void setEmailAlt(String emailAlt) {
        this.emailAlt = emailAlt;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobileAlt() {
        return mobileAlt;
    }

    public void setMobileAlt(String mobileAlt) {
        this.mobileAlt = mobileAlt;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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
