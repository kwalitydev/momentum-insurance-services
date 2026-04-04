package dao.repositories;


import dao.entities.Department;
import dao.entities.UserDetails;
import dao.entities.Users;
import dao.interfaces.UserDetailsInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String>, UserDetailsInterface {



    @Query("SELECT s,ud FROM Users s INNER JOIN UserDetails ud ON (s.userId = ud.users.userId)")
    List getUsersDetails();


    @Modifying(clearAutomatically = true)
    @Query("update UserDetails set email=?1,emailAlt=?2,fullName=?3,surname=?4,mobile=?5,mobileAlt=?6,lastUpdate=?8 where users.userId=?7")
    int updateUserDetails(String email, String emailAlt, String fullName, String surname, String mobile, String mobileAlt, String userId, Date today);
    @Query("SELECT ud FROM UserDetails ud WHERE ud.users.department=?1")
    List<UserDetails> findByDepartment(Department department);

    @Query("SELECT u FROM UserDetails u WHERE u.users = ?1")
    Optional<UserDetails> findByUser(Users user);
}
