package core.sms;

import core.util.RequestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static core.util.Util.getRandomNumberInRange;


public class SendSMSImpl implements SendSMSInterface{
    private static final Logger LOGGER = LogManager.getLogger(SendSMSImpl.class);

    @Override
    public void sendSMS(String to, String body) {
        if (RequestUtil.TEST_NUMBERS != null) {
            to = getTestNumber(to);
        }

        LOGGER.info("Send SMS status: {}", RequestUtil.SEND_SMS);

        if (RequestUtil.SEND_SMS) {
            submitSms(to, body);
        } else {
            LOGGER.info("SMS Submission disabled. SMS not sent");
        }
    }

    private String getTestNumber(String to) {
        String[] toList = RequestUtil.TEST_NUMBERS.split(";");
        if(toList.length == 0 || RequestUtil.TEST_NUMBERS.isEmpty()){
            return to;
        }
        else if (toList.length > 1) {
            int index = getRandomNumberInRange(0, toList.length - 1);
            to = toList[index];
        } else {
            to = RequestUtil.TEST_NUMBERS;
        }
        LOGGER.info("SMS submitted for test number: {}", to);
        return to;
    }

    private void submitSms(String to, String body) {
        LOGGER.info("SMS is being submitted to: {}", to);
        ApiGet apiGet = new ApiGet("sendSms")
                .set("user", RequestUtil.USER)
                .set("channel", RequestUtil.CHANNEL)
                .set("text", body)
                .set("to", to);
        try {
            apiGet.send();
        } catch (Exception e) {
            LOGGER.error("Error sending SMS: ", e);
        }
    }

    private int getRandomNumberInRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }






}
