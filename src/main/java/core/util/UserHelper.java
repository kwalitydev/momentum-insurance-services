package core.util;

import dao.entities.UserAttempts;
import dao.interfaces.UserAttemptInterface;
import dao.interfaces.UserInterface;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;

import static core.util.CoreUtil.today;

@Transactional
public class UserHelper implements Serializable {

    @Inject
    private UserInterface userInterface;
    @Inject
    private UserAttemptInterface userAttemptInterface;



    public void updateSuccessLogin(String userId, Date date) {
         userInterface.updateSuccessLogin(userId, date);
    }


    public void updateUserAttempts(String username, String date,String status,Date d){
         userInterface.updateUserAttempts(username, date, status, d);
    }

    public void logUserAttempt(UserAttempts userAttempts){
        userAttemptInterface.save(userAttempts);
    }

    public void resetUserAttempt(String username, String date,String status,Date d){
         userInterface.resetUserAttempts(username, date, status, d);
    }

    public void updateFailedLogin(String username){

         userInterface.updateFailedLogin(username);
    }

    public int doLogout(String userId){
        return userInterface.updateLogout(userId, today());
    }


}
