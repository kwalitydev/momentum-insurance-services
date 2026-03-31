package dao.interfaces;


import dao.entities.Department;
import dao.entities.Status;
import dao.entities.UserAttempts;
import dao.entities.Users;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserInterface {

    List<Object[]> getUserMenu(String userId);

    List<Users> findAll();
    Optional<Users> findByUserId(String id);
    int updateStatus(String status, String userId);
    <S extends Users> S save(S b);
    int updateSuccessLogin(String userId,Date date);
    int updateFailedLogin(String userId);
    int updateFailedLogin(int status, Date nextLoginTime, String userId);
    int updateLogout(String userId,Date today);
    List<Object[]> getUsersDetails();
    int updateUser(String roleId, String departmentId, String statusId, String userId);
    int updateUserDetails(String email, String emailAlt, String fullName, String surname, String mobile, String mobileAlt, String userId,Date date);
    int updateKey(String key,Date lastUpdate, int statusId, String userId);


    /// for test purpose

    List<UserAttempts> getUserAttempt(String userId, String date, String attemptStatus);

    int updateUserAttempts(String userId, String date, String attemptStatus,Date today);
    int
    resetUserAttempts(String userId, String date, String attemptStatus,Date today);
    List<Status> findAllStatuses();
    List<Users> findByStatus(Status status);

    List<Users> findByDepartment(Department department);
}
