package adapter;

import com.its.stb.services.ITSBaseException_Exception;
import com.its.stb.services.ITSBusinessException_Exception;
import com.its.stb.services.ITSInternalException_Exception;
import com.its.stb.services.SendNotificationOut;

public interface EmailInterface {

    void initializeEmailWebservice();
    SendNotificationOut sendEmail(String body, String destination, String subject, String logId) throws ITSBaseException_Exception, ITSInternalException_Exception, ITSBusinessException_Exception;

}
