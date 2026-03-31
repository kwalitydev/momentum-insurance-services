package api;


import core.beans.ApplicationRequest;
import core.constants.Products;
import core.constants.RecordTypes;
import core.util.CoreUtil;
import core.util.QueryUtil;
import core.util.RequestUtil;
import dao.BeanFactory;
import dao.entities.*;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static api.QueryAPI.getIpAddress;
import static core.util.CoreUtil.getLogId;
import static core.util.CoreUtil.today;
import static core.util.Util.setActive;


@Path("/system")
public class SystemAPI {
    private static final Logger LOGGER = LogManager.getLogger(SystemAPI.class);
    @Inject
    private ApplicationInterface applicationInterface;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private TaskInterface taskInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;

    @Inject
    private BeanFactory beanFactory;



    @POST
    @Path("/update/application")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateApplication(ApplicationRequest applicationRequest,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "updateApplication";
        LOGGER.info("{} is being called with parameters. request -> {}, logId -> {}, ipAddress -> {} ",
                applicationRequest, methodName, reqRes, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Optional<Application> application = applicationInterface.findByAppId(RequestUtil.APP_ID);
            if (application.isPresent()) {
                String collectionDays;
                boolean sendSMS;
                String testNumber;
                Integer allowedMissedPayment;
                String username = applicationRequest.getUsername();


                if(applicationRequest.getApplication().getAllowedMissedPayment()==null){
                    allowedMissedPayment = application.get().getAllowedMissedPayment();
                }
                else{
                    allowedMissedPayment = applicationRequest.getApplication().getAllowedMissedPayment();
                }

                if(applicationRequest.getApplication().getCollectionDays()==null){
                    collectionDays = application.get().getCollectionDays();
                }
                else{
                    collectionDays = applicationRequest.getApplication().getCollectionDays();
                }


                if(applicationRequest.getApplication().getSendSms()==null){
                    sendSMS = application.get().getSendSms();
                }
                else {
                    sendSMS = applicationRequest.getApplication().getSendSms();
                }

                if(applicationRequest.getApplication().getTestNumber()==null){
                    testNumber = application.get().getTestNumber();
                }
                else{
                    testNumber = applicationRequest.getApplication().getTestNumber();
                }


                applicationInterface.updateApplication(collectionDays,sendSMS,testNumber,allowedMissedPayment,today(),username);
                LOGGER.info("Application updated.");

                if(applicationRequest.getTaskEnabled()!=null){
                    int taskConfigUpdated = taskInterface.updateTaskStatus(applicationRequest.getTaskEnabled(), applicationRequest.getTaskId());
                    if(taskConfigUpdated>0){
                        LOGGER.info("Task {} status updated to {}", applicationRequest.getTaskId(),applicationRequest.getTaskEnabled());
                    }
                    else {
                        LOGGER.info("Task {} not updated",applicationRequest.getTaskId());
                    }
                }
                queryExecuted = true;
                response = Response.status(Response.Status.OK).entity(true).build();


            } else {
                LOGGER.info("User not found. LogId -> {}", reqRes);
            }

        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, applicationRequest.getUsername(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, applicationRequest.getSessionId(), headers.getRemoteAddr()));
        }

        return response;

    }


    @GET
    @Path("/task-config")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskConfig( @QueryParam("sessionId") String sessionId,
                                     @QueryParam("username") String username,
                                     @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getTaskConfig";

        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId, reqRes,getIpAddress(headers));

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<TaskConfig> taskConfigs = taskInterface.findAllByOrderByTaskIdAsc();

            LOGGER.debug("{} returned -> {}, logId -> {}",methodName,taskConfigs,reqRes);
            response = Response.status(Response.Status.OK).entity(taskConfigs).build();

            queryExecuted = true;
        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,getIpAddress(headers)));
        }

        return response;

    }



}
