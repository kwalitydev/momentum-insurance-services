package core.app;

import core.util.FileUtil;
import dao.interfaces.CoreErrorMappingInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.*;
import static core.util.RequestUtil.*;

@WebListener
@Dependent
public class Startup implements ServletContextListener {

    private static final Logger LOGGER = LogManager.getLogger(Startup.class);
    @Inject
    private CoreErrorMappingInterface coreErrorMappingInterface;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Attempting to start Momentum Insurance Platform ...");

        try {
            initializeSystemProperties();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void initializeSystemProperties(){
        API_CONNECT_TIMEOUT = Integer.parseInt(System.getProperty("ins.platform.sms.connect.timeout"));
        API_URL = System.getProperty("ins.platform.sms.endpoint");
        USER = System.getProperty("ins.platform.sms.user");
        CHANNEL = System.getProperty("ins.platform.sms.channel");
        APP_ID = System.getProperty("ins.platform.sms.application.id");
        TWS_USERNAME = System.getProperty("ins.platform.t24.username");
        TWS_ENDPOINT = System.getProperty("ins.platform.t24.endpoint");
        TWS_PASSWORD = System.getProperty("ins.platform.t24.password");
        EMAIL_ENDPOINT = System.getProperty("ins.platform.email.endpoint");
        try{
            ENCRYPTED_BODY = Boolean.parseBoolean(System.getProperty("ins.platform.email.body.encryption"));
        }
        catch (Exception e){
            LOGGER.warn("ins.platform.email.body.encryption could be parsed. Setting to default");
            ENCRYPTED_BODY = true;
        }
        setCoreErrors();
        FileUtil.BASE_DIRECTORY = System.getProperty("ins.platform.base.dir");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private void setCoreErrors() {
        OVERRIDE_LIST = new ArrayList<>(coreErrorMappingInterface.getCoreMessage("OVERRIDE"));
    }

    private void logError(String message, Exception e) {
       LOGGER.error(message + ". Error -> {}", e.getMessage());
    }



}
