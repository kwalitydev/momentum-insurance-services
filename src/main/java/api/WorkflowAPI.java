package api;

import core.beans.*;
import core.constants.*;
import core.util.CoreUtil;
import core.util.QueryUtil;
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
import java.util.*;

import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/workflow")
public class WorkflowAPI {
    private static final Logger LOGGER = LogManager.getLogger(ReportAPI.class);
    @Inject
    private ProcessWorkflowInterface processWorkflowInterface;
    @Inject
    private ProductConfigInterface productConfigInterface;
    @Inject
    private UserInterface userInterface;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private UserDetailsInterface userDetailsInterface;
    @Inject
    private ClaimInterface claimInterface;
    @Inject
    private CoverageInterface coverageInterface;
    @Inject
    private BaseAmountInterface baseAmountInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;



    @GET
    @Path("/auth/pending")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPendingRequests(@QueryParam("username") String username,
                                       @QueryParam("processState") String processState,
                                       @QueryParam("sessionId") String sessionId,
                                @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getPendingRequests";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";
        List<WorkflowResponse> workflowResponses = new ArrayList<>();

        try {
            Optional<Users> users = userInterface.findByUserId(username);

            if(users.isPresent()){
                LOGGER.info("searching for department {}",users.get().getDepartment());
                List<ProcessWorkflow> processWorkflows = processWorkflowInterface.findByCurrentDepartmentAndProcessState(users.get().getDepartment(),
                        setProcessState(processState));

                for (ProcessWorkflow pw:processWorkflows) {

                    LOGGER.info("ProcessWorkflow -> {}",pw.getWorkflowId());
                    WorkflowResponse workflowResponse = new WorkflowResponse();
                    workflowResponse.setProcessWorkflow(pw);

                    Optional<InsurancePolicy> ip = insurancePolicyInterface.findByPolicyId(pw.getChangedObjectId());
                    if(ip.isPresent()){
                        workflowResponse.setSubProduct(ip.get().getSubProduct());
                        workflowResponse.setClientName(ip.get().getPolicyHolder().getCustomerName());
                    }

                        workflowResponse.setObjectChanged(pw.getChangedObjectId());

                        workflowResponse.setObjectType(WorkflowObjects.PARAMETERS.toString());
                        Optional<UserDetails> userDetails = userDetailsInterface.findByUsers(pw.getUserInput());
                        userDetails.ifPresent(details -> workflowResponse.setCreatorName(details.getFullName() + " " + details.getSurname()));
                        workflowResponses.add(workflowResponse);


                }

                response = Response.status(Response.Status.OK).entity(workflowResponses).build();
                queryExecuted = true;
            }


        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        LOGGER.info("Response {}, Response Id = {}", workflowResponses, reqRes);
        return response;

    }



    @GET
    @Path("/auth/pending/details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPendingRequestDetails(@QueryParam("username") String username,
                                       @QueryParam("objectId") String objectId,
                                       @QueryParam("processAction") String processAction,
                                       @QueryParam("objectType") String objectType,
                                       @QueryParam("sessionId") String sessionId,
                                       @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getPendingRequestDetails";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, processAction -> {},objectType -> {}, objectId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId,processAction,objectType,objectId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";
        List<WorkflowResponse> workflowResponses = new ArrayList<>();

        try {
            Optional<Users> users = userInterface.findByUserId(username);

            if(users.isPresent()){

                if(objectType.equals(WorkflowObjects.PARAMETERS.toString())){
                    ProductConfigAuthResponse productConfigAuthResponse = new ProductConfigAuthResponse();

                    if(processAction.equals(ProcessActions.ALTER.toString())){

                        Optional<ProductConfig> newProductConfig = productConfigInterface.findByProductConfigId(Long.parseLong(objectId));
                        if(newProductConfig.isPresent()){

                            Optional<ProductConfig> currentProductConfig = productConfigInterface.findBySubProductAndStatus(
                                    newProductConfig.get().getSubProduct(),
                                    setActive()
                            );
                            if(currentProductConfig.isPresent()){
                                productConfigAuthResponse.setCurrentProductConfig(currentProductConfig.get());
                                productConfigAuthResponse.setNewProductConfig(newProductConfig.get());
                                return Response.status(Response.Status.OK).entity(productConfigAuthResponse).build();
                            }
                            else {
                                LOGGER.info("Current Product Config not found");
                            }

                        }
                        else {
                            LOGGER.info("New Product not found {}",objectId);
                        }

                    }

                }
                else if(objectType.equals(WorkflowObjects.COVERAGE.toString())){
                    CoverageUpdateResponse coverageUpdateResponse = new CoverageUpdateResponse();
                    if(processAction.equals(ProcessActions.ALTER.toString())){
                        Optional<Coverage> coverage = coverageInterface.findByCoverageId(Long.parseLong(objectId));
                        if(coverage.isPresent()){
                            Optional<Coverage> currentCoverage = coverageInterface.findByCoverageId(
                                    Long.parseLong(coverage.get().getProcessWorkflow().getChangedObjectId())
                            );
                            if(currentCoverage.isPresent()){
                                coverageUpdateResponse.setCurrentCoverage(currentCoverage.get());
                                coverageUpdateResponse.setNewCoverage(coverage.get());
                                return Response.status(Response.Status.OK).entity(coverageUpdateResponse).build();

                            }
                            else {
                                LOGGER.info("Current coverage not found");
                            }

                        }
                        else {
                            LOGGER.info("New Coverage not found");
                        }

                    }
                }

                response = Response.status(Response.Status.OK).entity(workflowResponses).build();
                queryExecuted = true;
            }


        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        LOGGER.info("Response {}, Response Id = {}", workflowResponses, reqRes);
        return response;

    }


    @POST
    @Path("/auth/config/approve")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response approveProductConfiguration(ProductConfigUpdate productConfigUpdate, @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "approveProductConfiguration";
        LOGGER.info("{} is being called with parameter. request -> {}, logId -> {}, ipAddress -> {} ",
                methodName,productConfigUpdate, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";


        try {
            Optional<Users> users = userInterface.findByUserId(productConfigUpdate.getUsername());

            if(users.isPresent()){

                ProcessState processState = new ProcessState();

                if(productConfigUpdate.getProcessAction().equals(ProcessActions.APPROVE.toString())) {
                    int currentUpdated = productConfigInterface.updateProductConfigStatus(setStatus(Statuses.INACTIVE.toString()), productConfigUpdate.getCurrentConfigId());
                    if (currentUpdated > 0) {
                        LOGGER.info("Current Product config updated. id -> {}", productConfigUpdate.getCurrentConfigId());
                    } else {
                        LOGGER.warn("Current Product config not updated. id -> {}", productConfigUpdate.getCurrentConfigId());
                    }
                    int newUpdated = productConfigInterface.updateProductConfigStatus(setStatus(Statuses.ACTIVE.toString()), productConfigUpdate.getNewConfigId());
                    if (newUpdated > 0) {
                        LOGGER.info("New Product config updated. id -> {}", productConfigUpdate.getNewConfigId());
                    } else {
                        LOGGER.warn("New Product config not updated. id -> {}", productConfigUpdate.getNewConfigId());
                    }
                    processState = setProcessState(ProcessStates.APPROVED.toString());


                    int baseAmount = baseAmountInterface.updateProductConfig(setProductConfig(productConfigUpdate.getNewConfigId()),
                            setProductConfig(productConfigUpdate.getCurrentConfigId()));
                    if(baseAmount>0){
                        LOGGER.info("Base amount updated");
                    }
                    queryExecuted = true;
                    response = Response.status(Response.Status.OK).entity(true).build();


                }
                else if(productConfigUpdate.getProcessAction().equals(ProcessActions.DECLINE.toString())){
                    int currentUpdated = productConfigInterface.updateProductConfigStatus(setStatus(Statuses.CANCELLED.toString()), productConfigUpdate.getNewConfigId());
                    if (currentUpdated > 0) {
                        LOGGER.info("New Current Product config updated. id -> {}", productConfigUpdate.getNewConfigId());
                    } else {
                        LOGGER.warn("New Current Product config not updated. id -> {}", productConfigUpdate.getNewConfigId());

                    }
                    processState = setProcessState(ProcessStates.DECLINED.toString());
                }


                int updatedWorkflow = processWorkflowInterface.updateProcessWorkflow(processState,setUser(productConfigUpdate.getUsername()), today(), setProcessAction(productConfigUpdate.getProcessAction()),
                        productConfigUpdate.getComments(),productConfigUpdate.getWorkflowId());
                if(updatedWorkflow>0){
                    LOGGER.info("ProcessWorkflow updated. id -> {}",productConfigUpdate.getWorkflowId());
                }
                else {
                    LOGGER.info("ProcessWorkflow not updated. id -> {}",productConfigUpdate.getWorkflowId());
                }

                response = Response.status(Response.Status.OK).entity(true).build();
                queryExecuted = true;
            }


        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, productConfigUpdate.getUsername(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, productConfigUpdate.getSessionId(),headers.getRemoteAddr()));
        }

        return response;

    }

    @POST
    @Path("/auth/coverage/approve")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response approveCoverage(CoverageUpdate coverageUpdate, @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "approveCoverage";
        LOGGER.info("{} is being called with parameter. request -> {}, logId -> {}, ipAddress -> {} ",
                methodName,coverageUpdate, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";


        try {
            Optional<Users> users = userInterface.findByUserId(coverageUpdate.getUsername());

            if(users.isPresent()){

                ProcessState processState = new ProcessState();

                if(coverageUpdate.getProcessActionId().equals(ProcessActions.APPROVE.toString())) {
                    int newUpdated = coverageInterface.updateCoverageStatus(setStatus(Statuses.ACTIVE.toString()), coverageUpdate.getCoverageId());
                    if (newUpdated > 0) {
                        LOGGER.info("New Coverage updated. id -> {}", coverageUpdate.getCoverageId());
                    } else {
                        LOGGER.warn("Current Product config not updated. id -> {}", coverageUpdate.getCoverageId());
                    }
                    Optional<Coverage> coverage = coverageInterface.findByCoverageId(coverageUpdate.getCoverageId());
                    if ((coverage.isPresent())){
                        int currentUpdated = coverageInterface.updateCoverageStatus(setStatus(Statuses.INACTIVE.toString()),
                                Long.parseLong(coverage.get().getProcessWorkflow().getChangedObjectId()));
                        if (currentUpdated > 0) {
                            LOGGER.info("Current coverage updated. id -> {}",coverage.get().getProcessWorkflow().getChangedObjectId());
                        } else {
                            LOGGER.warn("Current coverage not updated. id -> {}", coverage.get().getProcessWorkflow().getChangedObjectId());
                        }
                    }

                    processState = setProcessState(ProcessStates.APPROVED.toString());


                }
                else if(coverageUpdate.getProcessActionId().equals(ProcessActions.DECLINE.toString())){
                    Optional<Coverage> coverage = coverageInterface.findByCoverageId(coverageUpdate.getCoverageId());
                    if ((coverage.isPresent())){
                        int currentUpdated = coverageInterface.updateCoverageStatus(setStatus(Statuses.CANCELLED.toString()),
                                Long.parseLong(coverage.get().getProcessWorkflow().getChangedObjectId()));
                        if (currentUpdated > 0) {
                            LOGGER.info("Current coverage cancelled. id -> {}",coverage.get().getProcessWorkflow().getChangedObjectId());
                        } else {
                            LOGGER.warn("Current coverage not cancelled. id -> {}", coverage.get().getProcessWorkflow().getChangedObjectId());
                        }
                    }
                    processState = setProcessState(ProcessStates.DECLINED.toString());
                }


                int updatedWorkflow = processWorkflowInterface.updateProcessWorkflow(processState,setUser(coverageUpdate.getUsername()), today(), setProcessAction(coverageUpdate.getProcessActionId()),
                        coverageUpdate.getComments(),coverageUpdate.getWorkflowId());
                if(updatedWorkflow>0){
                    LOGGER.info("ProcessWorkflow updated. id -> {}",coverageUpdate.getWorkflowId());
                }
                else {
                    LOGGER.info("ProcessWorkflow not updated. id -> {}",coverageUpdate.getWorkflowId());
                }

                response = Response.status(Response.Status.OK).entity(true).build();
                queryExecuted = true;
            }


        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, coverageUpdate.getUsername(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, coverageUpdate.getSessionId(),headers.getRemoteAddr()));
        }

        return response;

    }



    @POST
    @Path("/action/change")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response changeProcessStatus(ProcessActionRequest processActionRequest, @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "changeProcessStatus";
        LOGGER.info("{} is being called with parameter. request -> {}, logId -> {}, ipAddress -> {} ",
                methodName,processActionRequest, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";


        try {
            Optional<Users> users = userInterface.findByUserId(processActionRequest.getUsername());

            if(users.isPresent()){

                ProcessAction processAction = setProcessAction(processActionRequest.getAction());
                ProcessState processState;
                if(processActionRequest.getAction().equals(ProcessActions.APPROVE.toString())){
                    processState = setProcessState(ProcessStates.AWAITING_POLICY.toString());
                    if(processActionRequest.getNewPolicyNumber()!=null){
                        processState = setProcessState(ProcessStates.APPROVED.toString());
                    }
                }
                else {
                    processState = setProcessState(ProcessStates.DECLINED.toString());
                }

                int updatedWorkflow = processWorkflowInterface.updateProcessWorkflow(processState,setUser(processActionRequest.getUsername()), today(), processAction,
                        processActionRequest.getComment(),processActionRequest.getProcessWorkflowId());
                if(updatedWorkflow>0){
                    LOGGER.info("ProcessWorkflow updated. id -> {}",processActionRequest.getProcessWorkflowId());

                    if(processActionRequest.getNewPolicyNumber()!=null){
                        //update insurance policy
                        LOGGER.info("New policy is being set");

                        insurancePolicyInterface.activatePolicy(today(),setActive(), processActionRequest.getUsername(),RecordTypes.COMMITTED.toString(), processActionRequest.getNewPolicyNumber(),
                                processActionRequest.getOldPolicyNumber());
                    }
                }
                else {
                    LOGGER.info("ProcessWorkflow not updated. id -> {}",processActionRequest.getProcessWorkflowId());
                }

                response = Response.status(Response.Status.OK).entity(true).build();
                queryExecuted = true;
            }


        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, processActionRequest.getUsername(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, processActionRequest.getSessionId(),headers.getRemoteAddr()));
        }

        return response;

    }

}
