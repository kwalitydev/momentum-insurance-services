package dao.repositories;


import dao.entities.UserAttempts;
import dao.interfaces.UserAttemptInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;

public interface UserAttemptRepository extends JpaRepository<UserAttempts, String>, UserAttemptInterface {

    
    @Modifying(clearAutomatically = true)
    @Query("update UserAttempts set attempts=attempts+1,loginDate=?4 where users.userId=?1 and TO_CHAR(createdDate,'yyyy-MM-dd')=?2 and (attemptStatus=?3 AND reset=false)")
    int updateUserAttempts(String userId, String date, String attemptStatus, Date today);

    @Query("Select u from UserAttempts u where u.users.userId=?1 and TO_CHAR(u.createdDate,'yyyy-MM-dd')=?2 and (u.attemptStatus=?3 AND u.reset=false)")
    Optional<UserAttempts> getUserAttempt(String userId, String date, String attemptStatus);

    @Modifying(clearAutomatically = true)
    @Query("update UserAttempts set reset=1,attempts=0,resetDate=?4 where users.userId=?1 and TO_CHAR(createdDate,'yyyy-MM-dd')=?2 AND (attemptStatus=?3 AND reset=false)")
    int resetUserAttempts(String userId, String date, String attemptStatus,Date today);

}
