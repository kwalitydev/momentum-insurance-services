package core.impl;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import core.sms.SendSMSInterface;
import core.util.RequestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.net.URI;

@ApplicationScoped
public class SendSMSImpl implements SendSMSInterface {

    private static final Logger logger = LogManager.getLogger(SendSMSInterface.class);

    @Override
    public void sendSMS(String toPhoneNumber, String body) {

        try {
            logger.info(" Attempt to send  SMS to  : {}", toPhoneNumber);
            Twilio.init(
                    RequestUtil.TWILO_ACCOUNT_SID,
                    RequestUtil.TWILO_AUTH_TOKEN);
            Message
                    .creator(new PhoneNumber("+" + toPhoneNumber),
                            new PhoneNumber("+" + RequestUtil.TWILO_PHONE_NUMBER),
                            body)
                    .setStatusCallback(URI.create("http://postb.in/1234abcd"))
                    .create();
            logger.info(" Successfully to sent  SMS to  : {}", toPhoneNumber);

        } catch (Exception e) {
            logger.error(" Failed to send  SMS to  : {}, errorDetails :", toPhoneNumber, e);
        }



    }
}
