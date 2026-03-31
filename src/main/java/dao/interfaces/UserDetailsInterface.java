package dao.interfaces;



import dao.entities.Department;
import dao.entities.UserDetails;
import dao.entities.Users;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserDetailsInterface {
    <S extends UserDetails> S save(S b);
    Optional<UserDetails> findByUsers(Users users);
    List getUsersDetails();
    int updateUserDetails(String email, String emailAlt, String fullName, String surname, String mobile, String mobileAlt, String userId, Date today);
    List<UserDetails> findByDepartment(Department department);

}
