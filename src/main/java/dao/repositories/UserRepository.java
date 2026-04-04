package dao.repositories;


import dao.entities.Status;
import dao.entities.UserAttempts;
import dao.entities.Users;
import dao.interfaces.UserInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<Users, String>, UserInterface {

    @Query("SELECT u,ud,r,m FROM Users u  " +
            "INNER JOIN UserDetails ud ON (u.userId = ud.users.userId) " +
            "INNER JOIN Role r ON (r.idRole = u.idRole)" +
            "INNER JOIN RoleMenu rm ON (r.idRole = rm.idRole) " +
            "INNER JOIN Menu m ON (m.id = rm.idMenu) " +
            "WHERE u.userId =?1 ORDER BY m.menuOrder")
    List<Object[]> getUserMenu(String userId);


    @Query("SELECT s,ud FROM Users s INNER JOIN UserDetails ud ON (s.userId = ud.users.userId)")
    List<Object[]> getUsersDetails();

    @Query("SELECT s FROM Users s WHERE s.userId = ?1")
    Optional<Users> findByUserId(String id);

    @Modifying(clearAutomatically = true)
    @Query("update Users set status.id=?1 where userId=?2")
    int updateStatus(String status, String userId);

    @Modifying(clearAutomatically = true)
    @Query("update Users set lastLogin = ?2,attemptsSuccess=attemptsSuccess+1,overallAttempts=overallAttempts+1 where userId=?1")
    int updateSuccessLogin(String userId,Date date);

    @Modifying(clearAutomatically = true)
    @Query("update Users set lastLogout= ?2 where userId=?1")
    int updateLogout(String userId,Date today);

    @Modifying(clearAutomatically = true)
    @Query("update Users set attemptsFailed=attemptsFailed+1,overallAttempts=overallAttempts+1 where userId=?1")
    int updateFailedLogin(String userId);

    @Modifying(clearAutomatically = true)
    @Query("update Users set attemptsFailed=attemptsFailed+1,overallAttempts=overallAttempts+1,status.id=?1,nextLoginTime=?2 where userId=?3")
    int updateFailedLogin(int status, Date nextLoginTime, String userId);

    @Modifying(clearAutomatically = true)
    @Query("update Users set idRole=?1,department.id=?2,status.id=?3 where userId=?4")
    int updateUser(String roleId, String departmentId, String statusId, String userId);

    @Modifying(clearAutomatically = true)
    @Query("update Users set userKey=?1,lastUpdated=?2,status.id=?3 where userId=?4")
    int updateKey(String key,Date lastUpdate, int statusId, String userId);

    @Modifying(clearAutomatically = true)
    @Query("update UserDetails set email=?1,emailAlt=?2,fullName=?3,surname=?4,mobile=?5,mobileAlt=?6,lastUpdate=?8 where users.userId=?7")
    int updateUserDetails(String email, String emailAlt, String fullName, String surname, String mobile, String mobileAlt, String userId,Date date);

    @Modifying(clearAutomatically = true)
    @Query("update UserAttempts set attempts=attempts+1,loginDate=?4 where users.userId=?1 and CONVERT(date, createdDate)=?2 and (attemptStatus=?3 AND reset=false)")
    int updateUserAttempts(String userId, String date, String attemptStatus,Date today);

    @Query("Select u from UserAttempts u where u.users.userId=?1 and CONVERT(date, createdDate)=?2 and (u.attemptStatus=?3 AND u.reset=false)")
    List<UserAttempts> getUserAttempt(String userId, String date, String attemptStatus);

    @Modifying(clearAutomatically = true)
    @Query("update UserAttempts set reset=1,attempts=0,resetDate=?4 where users.userId=?1 and CONVERT(date, createdDate)=?2 AND (attemptStatus=?3 AND reset=false)")
    int resetUserAttempts(String userId, String date, String attemptStatus,Date today);

    @Query("Select s FROM Status s WHERE s.description <> 'Hidden' order by 1 desc")
    List<Status> findAllStatuses();

    @Query("select u from Users u left join fetch u.department d left join fetch u.status s where u.userId = ?1")
    Optional<Users> findByUserByUserID(String userId);

}
