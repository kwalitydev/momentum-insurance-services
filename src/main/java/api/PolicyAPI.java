package api;

import core.beans.*;
import core.constants.*;
import core.impl.ProcessWorkflowImpl;
import core.threads.PostCancellation;
import core.threads.PostReportBuild;
import core.util.*;
import dao.BeanFactory;
import dao.entities.Currency;
import dao.entities.*;
import dao.interfaces.*;
import dao.repositories.SubProductAccountRepository;
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
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import static core.constants.ProcessActions.*;
import static core.constants.ProcessStates.*;
import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/policies")
@ApplicationScoped
public class PolicyAPI {
    private static final Logger LOGGER = LogManager.getLogger(PolicyAPI.class);
    @Inject
    private ProductInterface productInterface;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private SubProductInterface subProductInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;
    @Inject
    private BeneficiariesInterface beneficiariesInterface;
    @Inject
    private ProductConfigInterface productConfigInterface;
    @Inject
    private MemberProductPriceInterface memberProductPriceInterface;
    @Inject
    private PaymentLogInterface paymentLogInterface;
    @Inject
    private UserInterface userInterface;
    @Inject
    private ProcessWorkflowImpl processWorkflowInterface;
    @Inject
    private SubProductAccountInterface subProductAccountInterface;
    @Inject
    private InsurancePolicyHistoryInterface insurancePolicyHistoryInterface;
    @Inject
    private UserDetailsInterface userDetailsInterface;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private RelationshipInterface relationshipInterface;
    @Inject
    private SubProductAccountRepository subProductAccountRepository;
    @Inject
    private TermInterface termInterface;
    @Inject
    private FrequencyInterface frequencyInterface;

    @Inject
    private CoverageOptionInterface coverageOptionInterface;
    @Inject
    private BeanFactory beanFactory;
    @Inject
    private InsuranceUtil insuranceUtil;
    @Inject
    private NotificationUtil notificationUtil;
    @Inject
    private PostReportBuild postReportBuild;
    @Inject
    private PostCancellation postCancellation;
    @Inject
    private PaymentScheduleInterface paymentScheduleInterface;
    @Inject
    private MemberPriceInterface memberPriceInterface;



    @GET
    @Path("/products-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "getProducts";
        defaultNoParamRequest(LOGGER,traceId,sessionId,username,methodName, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<Product> products = productInterface.findAllByOrderByName();
            response = Response.status(Response.Status.OK).entity(products).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,traceId);
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }

        return response;

    }

    @GET
    @Path("/products-list/attr")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@QueryParam("attr") String attr,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "getProducts";
        defaultNoParamRequest(LOGGER,traceId,sessionId,username,methodName, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<Product> products = productInterface.findByAttributes(attr);
            response = Response.status(Response.Status.OK).entity(products).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,traceId);

        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }

        return response;

    }

    @GET
    @Path("/sub-products-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSubProducts(@QueryParam("productId") String productId,@QueryParam("sessionId") String sessionId,
                                   @QueryParam("username") String username,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "getSubProducts";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. productId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, productId, username, sessionId, traceId, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<SubProduct> subProducts;
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Product product = new Product();
            product.setProductId(productId);
            subProducts = subProductInterface.findByProductOrderByName(product);
            response = Response.status(Response.Status.OK).entity(subProducts).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,traceId);
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }

        return response;

    }


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPolicy(PolicyRequest policyRequest,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "createPolicy";
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        if(policyRequest!=null){

        defaultObjectRequest(LOGGER,traceId,policyRequest.toString(),methodName,headers.getRemoteAddr());

        Date requestTime = today();
        boolean queryExecuted = false;
        String errorCause = "";
        PolicyResponse policyResponse = new PolicyResponse();
        InsurancePolicy savedInsurancePolicy;

        try {
                PolicyHolder policyHolder = new PolicyHolder();
                policyHolder.setLastUpdate(today());
                policyHolder.setMobileNumber(policyRequest.getMainPhone());
                policyHolder.setCustomerName(policyRequest.getFullName()+" "+policyRequest.getSurname());
                policyHolder.setEmail(policyRequest.getEmail());
                policyHolder.setDocumentId(policyRequest.getIdNumber());
                policyHolder.setVat(policyRequest.getNuit());
                policyHolder.setAddress(policyRequest.getAddress());
                policyHolder.setJobTitle(setJobTitle(policyRequest.getJobTitle()));
                policyHolder.setAltMobileNumber(policyRequest.getAltPhone());

                InsurancePolicy insurancePolicy = new InsurancePolicy();
                insurancePolicy.setPolicyId(genPolicyId("M"));
                insurancePolicy.setCreatedDate(today());
                insurancePolicy.setLastUpdated(today());
                insurancePolicy.setPaymentFrequency(setFrequency(policyRequest.getFrequencyId()));
                insurancePolicy.setBenefitCycle(setBenefitCycle(policyRequest.getCycleId()));

                insurancePolicy.setStatus(setStatus(Statuses.ACTIVATING.toString()));
                insurancePolicy.setSubProduct(setSubProduct(policyRequest.getPackageId()));
                insurancePolicy.setTotalAmount(policyRequest.getTotalAmount());
                insurancePolicy.setIssueDate(today());
                insurancePolicy.setStartDate(stringToDate(policyRequest.getStartDate()));
                insurancePolicy.setExpiryDate(stringToDate(policyRequest.getEndDate()));

                savedInsurancePolicy = insuranceUtil.postPolicy(policyHolder,insurancePolicy,policyRequest,traceId);
                policyResponse.setPolicyId(savedInsurancePolicy.getPolicyId());
                policyResponse.setStatus(true);

                response = Response.status(Response.Status.OK).entity(policyResponse).build();
                queryExecuted = true;
                notificationUtil.postSendSMS(traceId, savedInsurancePolicy);


        } catch (Exception e) {

            LOGGER.error(traceId,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();

        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, "web",
                            methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, policyRequest.getSessionId(),
                            headers.getRemoteAddr(), false, "Create Policy",  null));


         }
        }
        else {
            LOGGER.info("Invalid payload");
        }
        return response;

    }



    @GET
    @Path("/product-config-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductConfig(@QueryParam("subProductId") Long subProductId,@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getProductConfig";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. subProductId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",subProductId, methodName, username, sessionId, reqRes, ipAddress);

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            SubProduct subProduct = new SubProduct();
            subProduct.setSubProductId(subProductId);

            Optional<ProductConfig> productConfig = productConfigInterface.findBySubProductAndStatus(subProduct, setActive());
            if (productConfig.isPresent()) {
                response = Response.status(Response.Status.OK).entity(productConfig.get()).build();
                defaultSuccess(LOGGER,reqRes);
                queryExecuted = true;
            } else {
                response = Response.status(Response.Status.OK).build();
            }


        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        return response;

    }

    @GET
    @Path("/beneficiaries-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBeneficiaries(@QueryParam("insurancePolicyId") String insurancePolicyId,@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getBeneficiaries";
        LOGGER.info("{} is being called with parameter. insurancePolicyId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                 methodName, insurancePolicyId,username, sessionId, reqRes, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<Beneficiaries> beneficiaries = beneficiariesInterface.findByInsurancePolicyAndStatus(setInsurancePolicy(insurancePolicyId), setActive());
            response = Response.status(Response.Status.OK).entity(beneficiaries).build();
            defaultSuccess(LOGGER,reqRes);
            queryExecuted = true;


        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }
        return response;

    }

    @POST
    @Path("/cancel")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response cancelPolicy(PolicyCancelRequest policyCancelRequest,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "cancelPolicy";
        Response response = Response.status(Response.Status.BAD_REQUEST).build();
        if(policyCancelRequest!=null) {
            defaultObjectRequest(LOGGER, reqRes, policyCancelRequest.toString(), methodName, headers.getRemoteAddr());

            Date requestTime = today();
            boolean queryExecuted = false;
            String errorCause = "";

            try {

                int updated = insurancePolicyInterface.cancelPolicy(today(), setStatus(Statuses.CANCELLED.toString()), policyCancelRequest.getUsername(),
                        policyCancelRequest.getPolicyId());

                if (updated > 0) {
                    queryExecuted = true;

                    InsurancePolicy ip = new InsurancePolicy();
                    ip.setPolicyId(policyCancelRequest.getPolicyId());

                    InsurancePolicyHistory insurancePolicyHistory = new InsurancePolicyHistory();
                    insurancePolicyHistory.setInsurancePolicy(ip);
                    insurancePolicyHistory.setChangeDescription(policyCancelRequest.getComment());
                    insurancePolicyHistory.setCreatedDate(today());
                    insurancePolicyHistory.setUsers(setUser(policyCancelRequest.getUsername()));
                    insurancePolicyHistory.setProcessAction(setProcessAction(CANCEL.toString()));
                    insurancePolicyHistory.setProcessId(policyCancelRequest.getProcessNumber());
                    insurancePolicyHistory.setNarrative(policyCancelRequest.getNarrative());

                    Department department = new Department();
                    department.setId(policyCancelRequest.getRequestBranch());
                    insurancePolicyHistory.setDepartment(department);

                    InsurancePolicyHistory insurancePolicyHistorySaved = insurancePolicyHistoryInterface.save(insurancePolicyHistory);

                    LOGGER.info("InsurancePolicyHistory saved {}. traceId -> {}", insurancePolicyHistorySaved.getIphId(),reqRes);

                    CancellationContext cancellationContext = new CancellationContext();
                    cancellationContext.setPolicyId(policyCancelRequest.getPolicyId());
                    cancellationContext.setComments(policyCancelRequest.getComment());
                    cancellationContext.setLogId(reqRes);

                    Callable<String> callable = () -> postCancellation.apply(cancellationContext);
                    executorService.submit(callable);


                    response = Response.status(Response.Status.OK).entity(true).build();
                    defaultSuccess(LOGGER, reqRes);

                } else {
                    response = Response.status(Response.Status.OK).entity(false).build();
                }

                LOGGER.info("Policy canceled {}", queryExecuted);

                queryExecuted = true;
            } catch (Exception e) {
                LOGGER.error(reqRes,e);
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                errorCause = e.getMessage();

            } finally {

                queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, policyCancelRequest.getUsername(),
                        methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, policyCancelRequest.getSessionId(), headers.getRemoteAddr()));
            }
        }
        else {
            LOGGER.info("PolicyCancelRequest is null. traceId -> {}",reqRes);
        }
        return response;

    }


    @GET
    @Path("/member-price-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMemberPrice(@QueryParam("subProductId") Long subProductId,
                                   @QueryParam("benefitCycle") Long benefitCycle,
                                   @QueryParam("dateOfBirth") String dateOfBirth,
                                   @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getMemberPrice";
        LOGGER.info("{} is being called with parameter. subProductId -> {}, username -> {}, sessionId -> {}, logId -> {}, benefitCycle - {}, dateOfBirth -. {}, ipAddress -> {} ",
                methodName,subProductId, username, sessionId, reqRes,benefitCycle,dateOfBirth, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            SubProduct subProduct = new SubProduct();
            subProduct.setSubProductId(subProductId);

            int age = calculateAge(dateOfBirth);

            LOGGER.info("Age is {}",age);
            Optional<MemberProductPrice> memberProductPrices = memberProductPriceInterface.findBySubProduct(subProduct,
                    age,setBenefitCycle(benefitCycle));
            if(memberProductPrices.isPresent()) {
                response = Response.status(Response.Status.OK).entity(memberProductPrices.get()).build();
            }
            defaultSuccess(LOGGER,reqRes);
            queryExecuted = true;


        } catch (Exception e) {
            LOGGER.error(reqRes,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }

        return response;

    }

    public static int calculateAge(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
        LocalDate today = LocalDate.now();

        return Period.between(dob, today).getYears();
    }

    @GET
    @Path("/payment-log")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentLog(@QueryParam("startDate") String startDate,@QueryParam("endDate") String endDate,@QueryParam("policyId") String policyId,@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,
                                  @QueryParam("status") String status,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getPaymentSchedule";
        LOGGER.info("{} is being called with parameter. startDate -> {}, endDate -> {}, policyId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate, endDate, policyId,  username, sessionId, reqRes, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            List<PaymentSchedule> paymentSchedules;
            if (status.equalsIgnoreCase(RequestParams.ALL.toString())) {
                paymentSchedules = paymentScheduleInterface.getByPolicyId(policyId, sd, ed);
            } else {
                paymentSchedules = paymentScheduleInterface.getByPolicyId(policyId, sd, ed, status);
            }

            response = Response.status(Response.Status.OK).entity(paymentSchedules).build();
            queryExecuted = true;


        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }
        return response;

    }

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePolicy(PolicyRequest policyRequest,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "updatePolicy";
        Response response = Response.status(Response.Status.BAD_REQUEST).build();
        if(policyRequest!=null) {
            defaultObjectRequest(LOGGER,traceId,policyRequest.toString(),methodName,headers.getRemoteAddr());

            Date requestTime = today();


            boolean queryExecuted = false;
            String errorCause = "";
            PolicyResponse policyResponse = new PolicyResponse();

            try {

                Optional<InsurancePolicy> insurancePolicyDB = insurancePolicyInterface.findByPolicyId(policyRequest.getPolicyId());
                if (insurancePolicyDB.isPresent()) {

                    insuranceUtil.updatePolicy(policyRequest,insurancePolicyDB.get(),traceId);
                    policyResponse.setPolicyId(policyRequest.getPolicyId());
                    policyResponse.setStatus(true);
                    response = Response.status(Response.Status.OK).entity(policyResponse).build();
                    queryExecuted = true;


                } else {
                    LOGGER.info("Policy not found. traceId -> {}",traceId);
                }


            } catch (Exception e) {
                LOGGER.error(traceId,e);
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                errorCause = e.getMessage();
            } finally {

                queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, policyRequest.getUsername(),
                        methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, policyRequest.getSessionId(), headers.getRemoteAddr()));
            }
        }
        else {
            LOGGER.info("PolicyRequest is null. traceId -> {}",traceId);
        }
        return response;

    }




    @GET
    @Path("/payment-log/status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPaymentStatus(@QueryParam("policyId") String policyId,@QueryParam("sessionId") String sessionId,
                                     @QueryParam("username") String username,@QueryParam("status") String status,
                                     @QueryParam("startDate") String startDate,@QueryParam("endDate") String endDate,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "getPaymentStatus";
        LOGGER.info("{} is being called with parameter.  policyId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                policyId, methodName, username, sessionId, traceId, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            List<PaymentSchedule> paymentLogs = paymentScheduleInterface.findByPolicyIdAndStatus(policyId, status,sd,ed);
            response = Response.status(Response.Status.OK).entity(paymentLogs).build();
            defaultSuccess(LOGGER,traceId);
            queryExecuted = true;


        } catch (Exception e) {
            LOGGER.error(traceId,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }

        return response;

    }


    @POST
    @Path("/update/sub-product")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateSubProduct(SubProductUpdate subProductUpdate,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "updateSubProduct";
        Response response = Response.status(Response.Status.BAD_REQUEST).build();

        if (subProductUpdate == null) {
            LOGGER.info("SubProductUpdate is null. ipAddress -> {}", headers.getRemoteAddr());
        } else {

            defaultObjectRequest(LOGGER, traceId, subProductUpdate.toString(), methodName, headers.getRemoteAddr());

            Date requestTime = today();
            boolean queryExecuted = false;
            String errorCause = "";

            ProductConfigResponse productConfigResponse = new ProductConfigResponse();

            try {
                Optional<Users> users = userInterface.findByUserId(subProductUpdate.getUsername());
                if (users.isPresent()) {
                    List<ProductConfig> productConfigList = productConfigInterface.findByStatus(setPending());
                    if (productConfigList.size() > 0) {

                        productConfigResponse.setStatus(false);
                        productConfigResponse.setErrorMessage("Já existe algum processo pendente de autorização");
                        LOGGER.info("ProductConfig Response {}", productConfigResponse);
                        return Response.status(Response.Status.OK).entity(productConfigResponse).build();
                    }
                    ProcessWorkflow processWorkflow = new ProcessWorkflow();
                    processWorkflow.setProcessAction(setProcessAction(ALTER.toString()));
                    processWorkflow.setProcessState(setProcessState(AWAITING_APPROVAL.toString()));
                    processWorkflow.setCurrentDepartment(users.get().getDepartment());
                    processWorkflow.setInputDate(today());
                    processWorkflow.setUserInput(users.get());

                    ProcessWorkflow pw = processWorkflowInterface.save(processWorkflow);
                    LOGGER.info("ProcessWorkflow saved! id = {}", pw.getWorkflowId());


                    ProductConfig productConfig = new ProductConfig();
                    productConfig.setSubProduct(setSubProduct(subProductUpdate.getSubProductId()));

                    productConfig.setChildAgeLimit(subProductUpdate.getChildAgeLimit());
                    productConfig.setChildMinAge(subProductUpdate.getChildMinAge());
                    productConfig.setMemberAgeLimit(subProductUpdate.getMemberAgeLimit());
                    productConfig.setMemberMinAge(subProductUpdate.getMemberMinAge());
                    productConfig.setChildNumberLimit(subProductUpdate.getChildNumberLimit());
                    productConfig.setParentsMaxAge(subProductUpdate.getParentsMaxAge());
                    productConfig.setStatus(setPending());
                    productConfig.setProcessWorkflow(processWorkflow);
                    productConfig.setHolderAgeLimit(subProductUpdate.getHolderAgeLimit());
                    productConfig.setHolderAgeLimit(subProductUpdate.getHolderAgeLimit());
                    productConfig.setParentsNumberLimit(subProductUpdate.getParentsNumberLimit());
                    productConfig.setStudentMaxAge(subProductUpdate.getStudentMaxAge());
                    productConfig.setStudentMinAge(subProductUpdate.getStudentMinAge());
                    productConfig.setParentsMaxAge(subProductUpdate.getParentsMaxAge());
                    productConfig.setPartnerMinAge(subProductUpdate.getPartnerMinAge());
                    productConfig.setPartnerMaxAge(subProductUpdate.getPartnerMaxAge());
                    productConfig.setMemberNumberLimit(subProductUpdate.getMemberNumberLimit());
                    productConfig.setMaxBenNumber(subProductUpdate.getMaxBenNumber());
                   // productConfig.setBenExitAge(subProductUpdate);

                    ProductConfig pc = productConfigInterface.save(productConfig);

                    LOGGER.info("ProductConfiguration saved! id = {}", pc.getProductConfigId());
                    productConfigResponse.setStatus(true);
                    response = Response.status(Response.Status.OK).entity(productConfigResponse).build();

                } else {
                    LOGGER.info("User not found. LogId -> {}", traceId);
                    productConfigResponse.setStatus(false);
                    productConfigResponse.setErrorMessage("Utilizador não encontrado!");
                    response = Response.status(Response.Status.OK).entity(false).build();
                }

            } catch (Exception e) {
                LOGGER.error(e);
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                errorCause = e.getCause().getMessage();
            } finally {

                queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, subProductUpdate.getUsername(),
                        methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, subProductUpdate.getSessionId(), headers.getRemoteAddr()));
            }
        }

        return response;

    }


    @POST
    @Path("/update/sub-product-v2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateSubProductV2(SubProductUpdate subProductUpdate,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "updateSubProduct";
        Response response = Response.status(Response.Status.BAD_REQUEST).build();

        if (subProductUpdate == null) {
            LOGGER.info("SubProductUpdate is null. ipAddress -> {}", headers.getRemoteAddr());
        } else {

            defaultObjectRequest(LOGGER, traceId, subProductUpdate.toString(), methodName, headers.getRemoteAddr());

            Date requestTime = today();
            boolean queryExecuted = false;
            String errorCause = "";

            ProductConfigResponse productConfigResponse = new ProductConfigResponse();

            try {
                Optional<Users> users = userInterface.findByUserId(subProductUpdate.getUsername());
                if (users.isPresent()) {

                    ProcessWorkflow processWorkflow = new ProcessWorkflow();
                    processWorkflow.setProcessAction(setProcessAction(ALTER.toString()));
                    processWorkflow.setProcessState(setProcessState(APPROVED.toString()));
                    processWorkflow.setCurrentDepartment(users.get().getDepartment());
                    processWorkflow.setInputDate(today());
                    processWorkflow.setUserInput(users.get());

                    ProcessWorkflow pw = processWorkflowInterface.save(processWorkflow);
                    LOGGER.info("ProcessWorkflow saved! id = {}", pw.getWorkflowId());


                    Optional<ProductConfig> productConfigDB = productConfigInterface.findBySubProductAndStatus(setSubProduct(subProductUpdate.getSubProductId()),
                            setActive());

                    if(productConfigDB.isPresent()) {
                        ProductConfig productConfig = new ProductConfig();
                        productConfig.setSubProduct(setSubProduct(subProductUpdate.getSubProductId()));

                        productConfig.setChildAgeLimit(subProductUpdate.getChildAgeLimit());
                        productConfig.setChildMinAge(subProductUpdate.getChildMinAge());
                        productConfig.setMemberAgeLimit(subProductUpdate.getMemberAgeLimit());
                        productConfig.setMemberMinAge(subProductUpdate.getMemberMinAge());
                        productConfig.setChildNumberLimit(subProductUpdate.getChildNumberLimit());
                        productConfig.setParentsMaxAge(subProductUpdate.getParentsMaxAge());
                        productConfig.setStatus(setActive());
                        productConfig.setProcessWorkflow(processWorkflow);
                        productConfig.setHolderAgeLimit(subProductUpdate.getHolderAgeLimit());
                        productConfig.setHolderMinAge(subProductUpdate.getHolderMinAge());
                        productConfig.setParentsNumberLimit(subProductUpdate.getParentsNumberLimit());
                        productConfig.setStudentMaxAge(subProductUpdate.getStudentMaxAge());
                        productConfig.setStudentMinAge(subProductUpdate.getStudentMinAge());
                        productConfig.setParentsMaxAge(subProductUpdate.getParentsMaxAge());
                        productConfig.setPartnerMinAge(subProductUpdate.getPartnerMinAge());
                        productConfig.setPartnerMaxAge(subProductUpdate.getPartnerMaxAge());
                        productConfig.setMemberNumberLimit(subProductUpdate.getMemberNumberLimit());
                        productConfig.setMaxBenNumber(subProductUpdate.getMaxBenNumber());
                        productConfig.setProductConfigId(productConfigDB.get().getProductConfigId());
                        productConfig.setNumberOfWorkers(productConfigDB.get().getNumberOfWorkers());
                        productConfig.setPartnerNumberLimit(subProductUpdate.getPartnerNumberLimit());
                        productConfig.setBenExitAge(productConfigDB.get().getBenExitAge());
                        productConfig.setHolderExitAge(productConfigDB.get().getHolderExitAge());

                        ProductConfig pc = productConfigInterface.save(productConfig);

                        LOGGER.info("ProductConfiguration saved! id = {}", pc.getProductConfigId());
                        productConfigResponse.setStatus(true);
                    }
                    else {
                        productConfigResponse.setErrorMessage("Configurações inválidas!");
                        productConfigResponse.setStatus(false);
                    }
                    response = Response.status(Response.Status.OK).entity(productConfigResponse).build();

                } else {
                    LOGGER.info("User not found. LogId -> {}", traceId);
                    productConfigResponse.setStatus(false);
                    productConfigResponse.setErrorMessage("Utilizador não encontrado!");
                    response = Response.status(Response.Status.OK).entity(false).build();
                }

            } catch (Exception e) {
                LOGGER.error(e);
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                errorCause = e.getCause().getMessage();
            } finally {

                queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, subProductUpdate.getUsername(),
                        methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, subProductUpdate.getSessionId(), headers.getRemoteAddr()));
            }
        }

        return response;

    }
    @POST
    @Path("/update/beneficiary")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateBeneficiary(BeneficiaryRequest beneficiaryRequest,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "updateBeneficiary";
        Response response = Response.status(Response.Status.BAD_REQUEST).build();
        if(beneficiaryRequest==null){
            LOGGER.info("BeneficiaryRequest is null. traceId -> {}",traceId);
        }
        else {
            defaultObjectRequest(LOGGER, traceId, beneficiaryRequest.toString(), methodName, headers.getRemoteAddr());

            Date requestTime = today();
            boolean queryExecuted = false;
            String errorCause = "";

            ProductConfigResponse productConfigResponse = new ProductConfigResponse();

            try {

                if (beneficiaryRequest.getOperationType().equals(OperationTypes.REMOVE.toString())) {
                    Status status = new Status();
                    status.setId(Statuses.REMOVED.toString());
                    int updatedBeneficiary = beneficiariesInterface.updateBeneficiary(today(), beneficiaryRequest.getUsername(), status,
                            beneficiaryRequest.getMemberRequest().getBeneficiaryId());

                    if (updatedBeneficiary > 0) {
                        LOGGER.info("Policy Removed. traceId -> {}", traceId);
                        queryExecuted = true;
                    } else {
                        LOGGER.info("Policy not Removed. traceId -> {}", traceId);
                    }
                } else if (beneficiaryRequest.getOperationType().equals(OperationTypes.UPDATE.toString())) {
                    MemberRequest memberRequest = beneficiaryRequest.getMemberRequest();
                    InsurancePolicy insurancePolicy = new InsurancePolicy();
                    insurancePolicy.setPolicyId(beneficiaryRequest.getPolicyId());


                    int updatedBeneficiary = beneficiariesInterface.updateBeneficiary(memberRequest.getName(),
                            stringToDate(memberRequest.getDateOfBirth()), setIDType(memberRequest.getIdTypeId()),
                            memberRequest.getBenStudent(), setRelationShip(memberRequest.getRelationShipId()),
                            today(), beneficiaryRequest.getUsername(),
                            insurancePolicy, memberRequest.getTotalCharge().doubleValue(), memberRequest.getBeneficiaryId());

                    if (updatedBeneficiary > 0) {
                        LOGGER.info("Policy updated. traceId -> {}", traceId);
                        queryExecuted = true;
                    } else {
                        LOGGER.info("Policy not updated. traceId -> {}", traceId);
                    }
                } else if (beneficiaryRequest.getOperationType().equals(OperationTypes.UPDATE_MIN.toString())) {
                    MemberRequest memberRequest = beneficiaryRequest.getMemberRequest();
                    InsurancePolicy insurancePolicy = new InsurancePolicy();
                    insurancePolicy.setPolicyId(beneficiaryRequest.getPolicyId());


                    int updatedBeneficiary = beneficiariesInterface.updateBeneficiary(memberRequest.getName(),
                            stringToDate(memberRequest.getDateOfBirth()), setIDType(memberRequest.getIdTypeId()),
                            memberRequest.getBenStudent(), setRelationShip(memberRequest.getRelationShipId()),
                            today(), beneficiaryRequest.getUsername(),
                            insurancePolicy, memberRequest.getBeneficiaryId());

                    if (updatedBeneficiary > 0) {
                        LOGGER.info("Policy updated. traceId -> {}", traceId);
                        queryExecuted = true;
                    } else {
                        LOGGER.info("Policy not updated. traceId -> {}", traceId);
                    }
                }


                if (queryExecuted) {

                    ReportRequest reportRequest = new ReportRequest();
                    reportRequest.setPolicyId(beneficiaryRequest.getPolicyId());
                    reportRequest.setSessionId(beneficiaryRequest.getSessionId());
                    reportRequest.setUsername(beneficiaryRequest.getUsername());
                    reportRequest.setRegenerate(true);

                    Callable<String> callable = () -> postReportBuild.apply(reportRequest);
                    executorService.submit(callable);

                }

                response = Response.status(Response.Status.OK).entity(productConfigResponse).build();


            } catch (Exception e) {
                LOGGER.error(e);
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
                errorCause = e.getCause().getMessage();
            } finally {

                queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, beneficiaryRequest.getUsername(),
                        methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, beneficiaryRequest.getSessionId(), headers.getRemoteAddr()));
            }
        }

        return response;

    }



    @GET
    @Path("/accounts/details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountDetails(@QueryParam("subProductId") Long subProductId,
                                      @QueryParam("sessionId") String sessionId,
                                      @QueryParam("username") String username,
                                      @QueryParam("currencyId") String currencyId,
                                      @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getAccountDetails";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter.  subProductId -> {} ,currencyId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                subProductId, currencyId, methodName, username, sessionId, reqRes, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            Optional<SubProductAccount> subProductAccount = subProductAccountInterface.findBySubProductAndCurrencyAndStatus(
                    setSubProduct(subProductId),
                    setCurrency(currencyId),
                    setActive()

            );

            if (subProductAccount.isPresent()) {
                response = Response.status(Response.Status.OK).entity(subProductAccount.get()).build();
            } else {
                response = Response.status(Response.Status.OK).entity(null).build();
            }


            queryExecuted = true;


        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }

        return response;

    }

    @GET
    @Path("/insurance/history")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsuranceHistory(@QueryParam("policyId") String policyId,
                                        @QueryParam("sessionId") String sessionId,
                                        @QueryParam("username") String username,
                                        @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getInsuranceHistory";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter.  policyId -> {} , username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, policyId, username, sessionId, reqRes, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Status> statuses = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            InsurancePolicy insurancePolicy = new InsurancePolicy();
            insurancePolicy.setPolicyId(policyId);
            List<InsurancePolicyHistory> insurancePolicyHistories = insurancePolicyHistoryInterface.findByInsurancePolicyOrderByCreatedDateDesc(
                    insurancePolicy
            );

            List<InsuranceHistoryResponse> insuranceHistoryResponses = insurancePolicyHistories.stream().map(request -> {
                InsuranceHistoryResponse insuranceHistoryResponse = new InsuranceHistoryResponse();
                insuranceHistoryResponse.setComments(request.getChangeDescription());
                insuranceHistoryResponse.setDate(request.getCreatedDate());
                insuranceHistoryResponse.setUsername(request.getUsers().getUserId());
                insuranceHistoryResponse.setAction(request.getProcessAction().getActionName().toUpperCase());
               insuranceHistoryResponse.setNarrative(request.getNarrative());
                insuranceHistoryResponse.setProcessId(request.getProcessId());

                Optional<UserDetails> userDetails = userDetailsInterface.findByUsers(request.getUsers());
                userDetails.ifPresent(details -> insuranceHistoryResponse.setFullName(details.getFullName() + " " + details.getSurname()));

                return insuranceHistoryResponse;
            }).collect(Collectors.toList());
            LOGGER.debug("getInsuranceHistory returned  {}", insuranceHistoryResponses);

            response = Response.status(Response.Status.OK).entity(insuranceHistoryResponses).build();


            queryExecuted = true;


        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        LOGGER.info("Response {}, Response Id = {}", statuses, reqRes);
        return response;

    }


    @POST
    @Path("/reopen")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response reopenPolicy(PolicyReopenRequest policyReopenRequest,
                                 @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "reopenPolicy";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameters. request -> {}, logId -> {}, ipAddress -> {} ",
                policyReopenRequest, methodName, reqRes, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            int updated = insurancePolicyInterface.cancelPolicy(today(), setStatus(Statuses.ACTIVE.toString()), policyReopenRequest.getUsername(),
                    policyReopenRequest.getPolicyId());

            if (updated > 0) {
                queryExecuted = true;

                InsurancePolicy ip = new InsurancePolicy();
                ip.setPolicyId(policyReopenRequest.getPolicyId());

                InsurancePolicyHistory insurancePolicyHistory = new InsurancePolicyHistory();
                insurancePolicyHistory.setInsurancePolicy(ip);
                insurancePolicyHistory.setChangeDescription(policyReopenRequest.getComment());
                insurancePolicyHistory.setCreatedDate(today());
                insurancePolicyHistory.setUsers(setUser(policyReopenRequest.getUsername()));
                insurancePolicyHistory.setProcessAction(setProcessAction(REOPEN.toString()));
                insurancePolicyHistory.setProcessId("");
                insurancePolicyHistory.setNarrative("");


                InsurancePolicyHistory insurancePolicyHistorySaved = insurancePolicyHistoryInterface.save(insurancePolicyHistory);

                LOGGER.info("InsurancePolicyHistory saved {} ", insurancePolicyHistorySaved.getIphId());

                response = Response.status(Response.Status.OK).entity(true).build();


            } else {
                response = Response.status(Response.Status.OK).entity(false).build();
            }

            LOGGER.info("Policy reopened {}", queryExecuted);

            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, policyReopenRequest.getUsername(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, policyReopenRequest.getSessionId(), ipAddress));
        }

        return response;

    }

    @GET
    @Path("/products-type-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductByType(@QueryParam("sessionId") String sessionId,
                                @QueryParam("username") String username,
                                @QueryParam("productType") String productType,
                                @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getProductsByType";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId, reqRes, headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<Product> products = productInterface.findByProductType(productType);
            response = Response.status(Response.Status.OK).entity(products).build();
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        return response;

    }



    @GET
    @Path("/sub-product-beneficiaries-price")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBeneficiariesPrice(@QueryParam("subProductId") Long subProductId,@QueryParam("benefitCycle") Long benefCycle,@QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getBeneficiariesPrice";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. subProductId -> {}, benefitCycle ->{}," +
                " username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",subProductId,benefCycle, methodName, username, sessionId, reqRes, ipAddress);

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<BeneficiaryPriceResponse> beneficiaryPriceResponses =
                    memberPriceInterface
                            .findBySubProductAndBenefitCycleAndStatus(
                                    setSubProduct(subProductId),
                                    setBenefitCycle(benefCycle),
                                    setActive()
                            )
                            .stream()
                            .map(m -> new BeneficiaryPriceResponse(
                                    m.getAmount(),
                                    m.getBeneficiaryDescription() + "( "+m.getMinAge()+" - "+m.getMaxAge()+")"
                            ))
                            .collect(Collectors.toList());

            LOGGER.info("MemberProductPrice returned {}",beneficiaryPriceResponses);
                response = Response.status(Response.Status.OK).entity(beneficiaryPriceResponses).build();
                defaultSuccess(LOGGER,reqRes);
                queryExecuted = true;



        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        return response;

    }


    @GET
    @Path("/by-phoneNumber")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchPolicyByPhoneNumber(@QueryParam("phoneNumber") String phoneNumber,
                                             @QueryParam("sessionId") String sessionId,
                                             @QueryParam("username") String username,
                                             @Context HttpServletRequest headers) {
        String reqRes = getLogId();
        String methodName = "fetchPolicyByPhoneNumber";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. phoneNumber -> {},  sessionId -> {}, username -> {}, logId -> {}, ipAddress -> {} ",methodName,phoneNumber, sessionId,username, reqRes, ipAddress);
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<InsurancePolicy> insurancePolicyList = this.insurancePolicyInterface.findByMobileNumber(phoneNumber);
            if (!insurancePolicyList.isEmpty()) {
                response = Response.status(Response.Status.OK).entity(insurancePolicyList).build();
                defaultSuccess(LOGGER,reqRes);
                queryExecuted = true;
            } else {
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        return response;

    }


    @GET
    @Path("/by-phone-number-and-policy-number")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response fetchPolicyByPhoneNumberAndInsurance(
                                             @QueryParam("phoneNumber") String phoneNumber,
                                             @QueryParam("insurancePolicyId") String insurancePolicyId,
                                             @QueryParam("sessionId") String sessionId,
                                             @QueryParam("username") String username,
                                             @Context HttpServletRequest headers) {
        String reqRes = getLogId();
        String methodName = "fetchPolicyByPhoneNumberAndInsurance";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. phoneNumber -> {}, insurancePolicyId ->{}, sessionId -> {}, username -> {}, logId -> {}, ipAddress -> {} ",methodName,phoneNumber,insurancePolicyId, sessionId,username, reqRes, ipAddress);
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Optional<InsurancePolicy> insurancePolicy = this.insurancePolicyInterface.findOneWithPolicyHolder(phoneNumber, insurancePolicyId);
            if (insurancePolicy.isPresent()) {
                response = Response.status(Response.Status.OK).entity(insurancePolicy.get()).build();
                defaultSuccess(LOGGER,reqRes);
                queryExecuted = true;
            } else {
                response = Response.status(Response.Status.OK).build();
            }
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        return response;

    }



}
