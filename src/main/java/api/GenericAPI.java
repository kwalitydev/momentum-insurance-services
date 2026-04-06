package api;

import core.util.CoreUtil;
import core.util.QueryUtil;
import dao.entities.*;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/generics")
@ApplicationScoped
public class GenericAPI {
    private static final Logger LOGGER = LogManager.getLogger(GenericAPI.class);
    @Inject
    private CurrencyInterface currencyInterface;

    @Inject
    private QueryUtil queryUtil;
    @Inject
    private InsuranceCompanyInterface insuranceCompanyInterface;
    @Inject
    private CoverageTypeInterface coverageTypeInterface;
    @Inject
    private ContractTypeInterface contractTypeInterface;
    @Inject
    private StatusInterface statusInterface;
    @Inject
    private UserInterface userInterface;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private TaskInterface taskInterface;


    @GET
    @Path("/ping")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {

        LOGGER.info("Ping is being called ..");

        return Response.status(Response.Status.OK).entity("Server echoed successfully").build();


    }

    @GET
    @Path("/currency-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCurrency(@QueryParam("sessionId") String sessionId,
                                    @QueryParam("username") String username,
                                    @Context HttpServletRequest headers) {

        String traceId = getLogId();
        Date requestTime = today();
        String methodName = "getCurrency";
        defaultNoParamRequest(LOGGER,traceId,sessionId,username,methodName, headers.getRemoteAddr());
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<Currency> currencies = currencyInterface.findAll();
            defaultSuccess(LOGGER,traceId);

            response = Response.status(Response.Status.OK).entity(currencies).build();
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(traceId,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        return response;

    }




    @GET
    @Path("/insurance-company-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsuranceCompany(@QueryParam("sessionId") String sessionId,
                                @QueryParam("username") String username,
                                @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getInsuranceCompany";
        defaultNoParamRequest(LOGGER,headers.getRemoteAddr(),sessionId,username,methodName, headers.getRemoteAddr());
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<InsuranceCompany> insuranceCompanies = insuranceCompanyInterface.findByStatus(setActive());
            response = Response.status(Response.Status.OK).entity(insuranceCompanies).build();
            defaultSuccess(LOGGER,reqRes);
            queryExecuted = true;

        } catch (Exception e) {
            LOGGER.error(reqRes,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        return response;

    }

    @GET
    @Path("/coverage-type-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoverageType(@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getCoverageType";
        defaultNoParamRequest(LOGGER,headers.getRemoteAddr(),sessionId,username,methodName, headers.getRemoteAddr());
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<CoverageType> coverageTypes = coverageTypeInterface.findByStatus(setActive());
            response = Response.status(Response.Status.OK).entity(coverageTypes).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,reqRes);

        } catch (Exception e) {
            LOGGER.error(reqRes,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        return response;

    }


    @GET
    @Path("/contract-type-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContractType(@QueryParam("sessionId") String sessionId,
                                @QueryParam("username") String username,
                                @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getContractType";
        defaultNoParamRequest(LOGGER,headers.getRemoteAddr(),sessionId,username,methodName, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<ContractType> contractTypes = contractTypeInterface.findByStatus(setActive());
            response = Response.status(Response.Status.OK).entity(contractTypes).build();
            defaultSuccess(LOGGER,reqRes);
            queryExecuted = true;

        } catch (Exception e) {
            LOGGER.error(reqRes,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        return response;

    }


    @GET
    @Path("/status-type-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatusByType(@QueryParam("sessionId") String sessionId,
                                    @QueryParam("username") String username,
                                    @QueryParam("statusType") String statusType,
                                    @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getStatusByType";
        LOGGER.info("{} is being called with parameters {sessionId -> {}, username -> {}, statusType -> {}}",methodName,sessionId,username,statusType);

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Status> statuses = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<Status> status = statusInterface.findByStatusType(statusType);
            response = Response.status(Response.Status.OK).entity(status).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,reqRes);

        } catch (Exception e) {
            LOGGER.error(reqRes,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        LOGGER.info("Response {}, Response Id = {}", statuses, reqRes);
        return response;

    }



    @POST
    @Path("/tasks/cycle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response setTaskPeriod(TaskConfig taskConfig) {

        String reqRes = getLogId();
        String methodName = "taskConfig";
        LOGGER.info("{} is being called with parameters. request -> {}, logId -> {} ",
                taskConfig, methodName, reqRes);

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        try {

            int updated = taskInterface.updatePoolInterval(taskConfig.getPoolInterval(),taskConfig.getTaskId());

            if (updated > 0) {


                LOGGER.info("Task updated");
                Optional<TaskConfig> taskConfig1 = taskInterface.getTasks(taskConfig.getTaskId());
                if(taskConfig1.isPresent()){
                    response = Response.status(Response.Status.OK).entity(taskConfig1.get()).build();
                }

            } else {

                response = Response.status(Response.Status.OK).entity(false).build();
            }

        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return response;

    }


    @GET
    @Path("/tasks/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTasks(@QueryParam("taskId") String taskId) {

        String methodName = "getInsuranceHistory";

        LOGGER.info("{} is being called with parameter.  taskId -> {} ",methodName,taskId);

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        try {

            Optional<TaskConfig> taskConfig1 = taskInterface.getTasks(taskId);
            if(taskConfig1.isPresent()){
                response = Response.status(Response.Status.OK).entity(taskConfig1.get()).build();
            }

        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return response;

    }


}
