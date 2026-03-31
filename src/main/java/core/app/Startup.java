package core.app;

import adapter.EmailInterface;
import adapter.PaymentInterface;
import core.tasks.*;
import core.util.CoreUtil;
import core.util.FileUtil;
import core.util.QueryUtil;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static core.constants.Tasks.*;
import static core.util.CoreUtil.*;
import static core.util.RequestUtil.*;

@WebListener
@Dependent
public class Startup implements ServletContextListener {

    private static final Logger LOGGER = LogManager.getLogger(Startup.class);
    @Inject
    private PaymentInterface paymentInterface;
    @Inject
    private TaskInterface taskInterface;
    @Inject
    private CoreErrorMappingInterface coreErrorMappingInterface;
    @Inject
    private PaymentScheduleHandler paymentScheduleHandler;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private EmailInterface emailInterface;
    private long defaultInitialDelay = 60;
    private int defaultFrequency = 60*60*24;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Attempting to start Insurance Platform ...");

        try {
            initializeSystemProperties();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
          //  paymentInterface.initialize();
        } catch (Exception e) {
            logError("Payment adapter could not be started", e);
        }
        try {
           // emailInterface.initializeEmailWebservice();
        } catch (Exception e) {
            logError("Email adapter could not be started", e);
        }

        int corePoolSize = Runtime.getRuntime().availableProcessors();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(corePoolSize);
        LOGGER.info("Monthly tasks will be scheduled with pool size of {} threads",corePoolSize);
        List<String> monthlyProducts = Arrays.asList(
                FUNERAL_TASK.toString(),
                HOSPITAL_TASK.toString(),
                LIFE_TASK.toString(),
                SALARY_PROTECT_TASK.toString(),
                EDUCATION_TASK.toString(),
                GROUP_RISK_TASK.toString(),
                BUSINESS_TASK.toString(),
                WORKMEN_COMPENSATION_TASK.toString()
        );

        try {
            scheduleMonthlyTasks(executor, monthlyProducts);
        } catch (Exception e) {
            logError("Error initializing monthly collection", e);
        }

        try {
          //  initializeTask(PROPERTY_TASK);
           // initializeTask(MOTOR_TASK);
           // initializeTask(T24_PRODUCT_SYNC_TASK);
           // initializeTask(POLICY_AGING_CHECK);
            //initializeTask(PAYMENT_SCHEDULE_HANDLER);
            //initializeUnprocessedChargeTask();
           // initializeTask(COLLECTION_SYNC);
           // initializeTask(NOTIFICATION_TASK);
        } catch (Exception e) {
            logError("Error during task initialization", e);
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

    private void scheduleMonthlyTasks(ScheduledExecutorService executor, List<String> monthlyProducts) {
        List<TaskConfig> taskConfigs = taskInterface.findTaskIn(monthlyProducts);
        for (final TaskConfig taskConfig : taskConfigs) {
            LOGGER.info("{} will start in {}s and run every {}s", taskConfig.getTaskId(), taskConfig.getStartDelay(), taskConfig.getPoolInterval());
            executor.scheduleAtFixedRate(() -> {
                if (taskConfig.isEnabled()) {
                //    queryUtil.initiateCollectionProcess(taskConfig.getTaskId().replace("_TASK", ""), taskConfig.getTaskId(), LOGGER);
                } else {
                    logTaskDisabled(taskConfig.getTaskId());
                }
            }, taskConfig.getStartDelay(), taskConfig.getPoolInterval(), TimeUnit.SECONDS);
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

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

    private void setCoreErrors() {
        OVERRIDE_LIST = new ArrayList<>(coreErrorMappingInterface.getCoreMessage("OVERRIDE"));
    }

    private void logError(String message, Exception e) {
       LOGGER.error(message + ". Error -> {}", e.getMessage());
    }



}
