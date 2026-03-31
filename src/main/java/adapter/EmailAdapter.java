package adapter;

import com.its.stb.services.*;
import com.temenos.sbm_insurance.T24WebServicesImpl;
import com.temenos.sbm_insurance.T24WebServicesImplService;
import core.util.RequestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.ws.BindingProvider;
import java.util.Collections;
import java.util.Date;

import static core.util.CoreUtil.*;
import static core.util.RequestUtil.EMAIL_ENDPOINT;

@ApplicationScoped
public class EmailAdapter implements EmailInterface{

    private static final Logger LOGGER = LogManager.getLogger(EmailAdapter.class);

    private STBGenericNotificationService stbGenericNotificationService;

    @Override
    public void initializeEmailWebservice(){

        try {
            Date d = today();
            LOGGER.info("Attempting to initialise STBServices");
            STBGenericNotificationServiceService stbGeneric = new STBGenericNotificationServiceService();
            stbGenericNotificationService = stbGeneric.getSTBGenericNotificationServicePort();
            BindingProvider bindingProvider = (BindingProvider) stbGenericNotificationService;
            bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, EMAIL_ENDPOINT);
            LOGGER.info("T24 Webservices successfully initialised in {} in {} ms", EMAIL_ENDPOINT,getDelay(d));

        }
        catch (Exception e){
            LOGGER.error("Failed to initialise T24 Webservices");
            LOGGER.error(e);
        }

    }



    @Override
    public SendNotificationOut sendEmail(String body, String destination, String subject, String logId) throws ITSBaseException_Exception, ITSInternalException_Exception, ITSBusinessException_Exception {
        ItsRequestContext itsRequestContext = new ItsRequestContext();
        itsRequestContext.setLang("PT");
        itsRequestContext.setChannel("BANCASSURANCE");
        itsRequestContext.setRequestId(logId);

        ItsSessionContext sessionContext = new ItsSessionContext();
        sessionContext.setAuthenticated(false);
        sessionContext.setBusinessModel(BusinessModel.BUSINESS);
        sessionContext.setUsername("GenericWsUser");
        itsRequestContext.setSessionContext(sessionContext);

        SendNotificationIn notificationIn = new SendNotificationIn();
        notificationIn.setBody(body);
        notificationIn.setSubject(subject);
        notificationIn.setType(NotificationTypes.EMAIL);
        notificationIn.setEncryptMessageBody(RequestUtil.ENCRYPTED_BODY);
        notificationIn.setDest(Collections.singletonList(destination));
        notificationIn.setLang("PT");
        notificationIn.setExpirationTimeSeconds(300);


        LOGGER.debug("NotificatioIn {}",notificationIn);
        LOGGER.debug("ItsRequestContext {}",itsRequestContext);
       return stbGenericNotificationService.sendNotification(itsRequestContext,notificationIn);
     }
}
