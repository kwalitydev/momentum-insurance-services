package dao.interfaces;



import dao.entities.UserAttempts;

import java.util.Date;
import java.util.Optional;

public interface UserAttemptInterface {

    <S extends UserAttempts> S save(S b);
    int updateUserAttempts(String userId, String date, String attemptStatus, Date today);
    Optional<UserAttempts> getUserAttempt(String userId, String date, String attemptStatus);
    int resetUserAttempts(String userId, String date, String attemptStatus,Date today);
}
