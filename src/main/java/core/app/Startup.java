package core.app;

import core.tasks.PaymentScheduleHandler;
import core.util.CoreUtil;
import core.util.FileUtil;
import dao.entities.TaskConfig;
import dao.interfaces.CoreErrorMappingInterface;
import dao.interfaces.TaskInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.*;

import static core.constants.Tasks.*;
import static core.util.CoreUtil.formatDateTime;
import static core.util.CoreUtil.toMs;
import static core.util.RequestUtil.*;

@WebListener
@Dependent
public class Startup implements ServletContextListener {

    private static final Logger LOGGER = LogManager.getLogger(Startup.class);
    @Inject
    private CoreErrorMappingInterface coreErrorMappingInterface;
    @Inject
    private PaymentScheduleHandler paymentScheduleHandler;
    @Inject
    private TaskInterface taskInterface;
    private long defaultInitialDelay = 60;
    private int defaultFrequency = 60*60*24;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Attempting to start Momentum Insurance Platform ...");

        try {
            initializeSystemProperties();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            initializeTask(PAYMENT_SCHEDULE_HANDLER);
        } catch (Exception e) {
            logError("Error during task initialization", e);
        }
    }

    private void initializeTask(Enum<?> taskEnum) {
        TaskConfig task = getTask(taskEnum.toString());
        if (task != null) {
            if (task.isEnabled()) {
                setTaskParameters(task);
                Timer timer = new Timer();
                timer.scheduleAtFixedRate((TimerTask) getTaskRunnable(taskEnum), toMs((int) defaultInitialDelay), toMs(defaultFrequency));
            } else {
                logTaskDisabled(taskEnum.toString());
            }
        } else {
            logTaskNotFound(taskEnum.toString());
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

    private TaskConfig getTask(String task) {
        Optional<TaskConfig> tc = taskInterface.getTasks(task);
        return tc.orElse(null);
    }

    void logTaskNotFound(String task) {
        LOGGER.warn("Task {} not found.", task);
    }

    void logTaskDisabled(String task) {
        LOGGER.warn("Task {} is not enabled.", task);
    }


    private Runnable getTaskRunnable(Enum<?> taskEnum) {
        switch (taskEnum.toString()) {
            //case "PROPERTY_TASK":
              //  return propertyTask;
            case "PAYMENT_SCHEDULE_HANDLER":
                return paymentScheduleHandler;
            default:
                throw new IllegalArgumentException("Unknown task: " + taskEnum);
        }
    }

    void setTaskParameters(TaskConfig task) {
        if (task.getNextRunningDate() != null) {
            defaultInitialDelay = CoreUtil.getStartDelay(task.getNextRunningDate());
            LOGGER.info("Next run date is {}", formatDateTime(task.getNextRunningDate()));
        } else if (task.getStartDelay() >= 0) {
            defaultInitialDelay = task.getStartDelay();
        } else {
            LOGGER.info("Setting default initial delay to {}", defaultInitialDelay);
        }

        if (task.getPoolInterval() >= 0) {
            defaultFrequency = task.getPoolInterval();
        } else {
            LOGGER.info("Setting default frequency to {}", defaultFrequency);
        }

        LOGGER.info("{} will start in {} s", task.getTaskId(), defaultInitialDelay);
    }
}
