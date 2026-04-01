package api;

import core.beans.InsuranceSync;
import core.beans.PolicySyncRequest;
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
import java.util.concurrent.Callable;

import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/generics")
@ApplicationScoped
public class GenericAPI {
    private static final Logger LOGGER = LogManager.getLogger(GenericAPI.class);
    @Inject
    private CurrencyInterface currencyInterface;
    @Inject
    private CoverageInterface coverageInterface;
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
    @Inject
    private SubProductAccountInterface subProductAccountInterface;


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
    @Path("/coverage/id")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCoverageById(@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@QueryParam("coverageId") Long coverageId,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getCoverageById";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {}, traceId -> {} ",
                methodName, username, sessionId, reqRes,headers.getRemoteAddr(),reqRes);

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Optional<Coverage> coverage = coverageInterface.findByCoverageId(coverageId);

            if (coverage.isPresent())
                return Response.status(Response.Status.OK).entity(coverage.get()).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,reqRes);
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
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
    @Path("/sync/policy/status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePolicyStatus(PolicySyncRequest policySyncRequest, @Context HttpServletRequest headers) {
        String logId = getLogId();
        Date requestTime = today();
        String methodName = "SyncPolicyStatus";
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String ipAddress = headers.getRemoteAddr();
        String errorCause = "";
        try {
            LOGGER.info("{}} webservice is being called with parameters. Request {}, IpAddress = {}, traceId -> {} ",methodName, policySyncRequest, ipAddress,logId);

            Optional<Users> users = userInterface.findByUserId(policySyncRequest.getUsername());
            if(users.isPresent()) {

                for (InsuranceSync is: policySyncRequest.getPolicies()) {

                    InsuranceSync insuranceSync = new InsuranceSync();
                    insuranceSync.setAccountNumber(is.getAccountNumber());
                    insuranceSync.setPolicyId(is.getPolicyId());
                    insuranceSync.setMigrationStatus(policySyncRequest.getMigrationStatus());
                  //  Callable<String> callable = () -> postInsuranceSync.apply(insuranceSync);
                 //   executorService.submit(callable);

                }


            }
            else {
                LOGGER.info("User {} not found.",policySyncRequest.getUsername());
            }

            queryExecuted = true;
            response = Response.status(Response.Status.OK).entity(true).build();
            defaultSuccess(LOGGER,logId);
        }
        catch (Exception e){
            LOGGER.error(e);
            errorCause = e.getMessage();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        finally {


            queryUtil.saveLog(CoreUtil.setWebserviceLog(logId, requestTime, policySyncRequest.getUsername(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause,
                    null,ipAddress,false,"SyncPolicyStatus",policySyncRequest.toString()));
        }

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

    @POST
    @Path("/sub-product/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response setSubProductAccount(SubProductAccount subProductAccount) {

        String reqRes = getLogId();
        String methodName = "setSubProductAccount";
        LOGGER.info("{} is being called with parameters. request -> {}, logId -> {} ",
                subProductAccount, methodName, reqRes);

        Response response = Response.status(Response.Status.NO_CONTENT).build();


        try {

            int updated = subProductAccountInterface.updateSuProductAccount(subProductAccount.getAccountId(),subProductAccount.getStatus(),subProductAccount.getProductAccountId());

            if (updated > 0) {

                LOGGER.info("SubProduct updated");
                Optional<SubProductAccount> subProductAccount1 = subProductAccountInterface.findBySubProduct(subProductAccount.getSubProduct());

                if(subProductAccount1.isPresent()){
                    response = Response.status(Response.Status.OK).entity(subProductAccount1.get()).build();
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
    @Path("/sub-product/find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubProductAccount(@QueryParam("subproduct") String subproduct,@QueryParam("currency") String currency,@QueryParam("status") String status) {

        String methodName = "getSubProductAccount";

        LOGGER.info("{} is being called with parameter.  taskId -> {} ",methodName,subproduct);

        try {

            List<SubProductAccount> subProductAccount1 = subProductAccountInterface.
                    findBySubProductAndCurrencyAndStatusList(setSubProduct(Long.parseLong(subproduct)),setCurrency(currency),setStatus(status));

            return Response.status(Response.Status.OK).entity(subProductAccount1).build();


        } catch (Exception e) {
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }
}
