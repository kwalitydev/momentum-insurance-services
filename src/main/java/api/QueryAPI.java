package api;

import core.beans.SubProductResponse;
import core.constants.RecordTypes;
import core.constants.Statuses;
import core.util.CoreUtil;
import core.util.QueryUtil;
import core.util.RequestUtil;
import dao.entities.*;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.*;

import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/queries")
public class QueryAPI {
    private static final Logger LOGGER = LogManager.getLogger(QueryAPI.class);

    @Inject
    private QueryUtil queryUtil;
    @Inject
    private RelationshipInterface relationshipInterface;
    @Inject
    private MemberPriceInterface memberPriceInterface;
    @Inject
    private BaseAmountInterface baseAmountInterface;
    @Inject
    private IDTypeInterface idTypeInterface;
    @Inject
    private SubProductAccountInterface subProductAccountInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;
    @Inject
    private PaymentScheduleInterface paymentScheduleInterface;
    @Inject
    private CoverageTypeRateInterface coverageTypeRateInterface;
    @Inject
    private SubProductInterface subProductInterface;
    @Inject
    private TermInterface termInterface;
    @Inject
    private CountryMapInterface countryMapInterface;
    @Inject
    private ApplicationInterface applicationInterface;
    @Inject
    private TaskInterface taskInterface;
    @Inject
    private BeneficiariesInterface beneficiariesInterface;
    @Inject
    private IndustryInterface industryInterface;
    @Inject
    private ProductConfigInterface productConfigInterface;
    @Inject
    private FrequencyInterface frequencyInterface;
    @Inject
    private JobTitleInterface jobTitleInterface;
    @Inject
    private SubProductCurrencyInterface subProductCurrencyInterface;
    @Inject
    private BenefitCycleInterface benefitCycleInterface;

    @GET
    @Path("/relationships-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRelationShip( @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@QueryParam("productId") String productId,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getRelationShip";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. username -> {}, productId -> {}, sessionId -> {}, traceId -> {}, ipAddress -> {} ",
                methodName, username, productId, sessionId, reqRes,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Status> statuses = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<RelationShip> relationShips = relationshipInterface.findByStatusAndProductOrderByDescription(setActive(),setProduct(productId));
            response = Response.status(Response.Status.OK).entity(relationShips).build();
            defaultSuccess(LOGGER,reqRes);
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(reqRes,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        LOGGER.info("Response {}, Response Id = {}", statuses, reqRes);
        return response;

    }


    @GET
    @Path("/id-types-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIDType( @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getIDType";
        defaultNoParamRequest(LOGGER,reqRes,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<IDType> idTypes = idTypeInterface.findAllByOrderByDescription();
            response = Response.status(Response.Status.OK).entity(idTypes).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,reqRes);
        } catch (Exception e) {
            LOGGER.error(e);
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
    @Path("/product-account-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductAccounts( @QueryParam("sessionId") String sessionId,
                               @QueryParam("username") String username,
                               @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getProductAccounts";
        defaultNoParamRequest(LOGGER,reqRes,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<SubProductAccount> subProductAccounts = subProductAccountInterface.findByStatus(setStatus(Statuses.ACTIVE.toString()));
            defaultSuccess(LOGGER,reqRes);
            response = Response.status(Response.Status.OK).entity(subProductAccounts).build();
            queryExecuted = true;

        } catch (Exception e) {
            LOGGER.error(reqRes,e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,reqRes));
        }
        return response;

    }



    @GET
    @Path("/quotation/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuotations( @QueryParam("sessionId") String sessionId,
                                        @QueryParam("username") String username,
                                        @QueryParam("productId") String productId,
                                        @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getQuotations";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId, reqRes,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<InsurancePolicy> insurancePolicies = insurancePolicyInterface.findByRecordTypeByOrderByCreatedDateDesc(RecordTypes.SIMULATED.toString(),setProduct(productId));

            List<InsurancePolicy> filtered = new ArrayList<>();
            insurancePolicies.forEach((ip)->{

                Optional<InsurancePolicy> toAdd = insurancePolicyInterface.findBySimulationId(ip.getPolicyId());
                if(!toAdd.isPresent()){
                    filtered.add(ip);
                }

            });
            defaultSuccess(LOGGER,reqRes);
            response = Response.status(Response.Status.OK).entity(filtered).build();
            queryExecuted = true;
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
    @Path("/member/price-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMemberPriceList( @QueryParam("currencyId") String currencyId,
                                        @QueryParam("subProductId") Long subProductId,
                                        @QueryParam("sessionId") String sessionId,
                                     @QueryParam("username") String username,
                                     @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getMemberPriceList";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId, reqRes,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            Optional<MemberProductPrice> memberProductPrices = memberPriceInterface.findByCurrencyAndSubProductAndStatus(setCurrency(currencyId),setSubProduct(subProductId),setActive());
            if(memberProductPrices.isPresent()){
                response = Response.status(Response.Status.OK).entity(memberProductPrices.get()).build();
                defaultSuccess(LOGGER,reqRes);
            }
            else {
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }
            queryExecuted = true;
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
    @Path("/collections/collected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalCollected(@QueryParam("startDate") String startDate,@QueryParam("endDate") String endDate,@QueryParam("status") String status,
                                      @QueryParam("username") String username,@QueryParam("sessionId") String sessionId,@QueryParam("subProductId") Long subProductId,@Context HttpServletRequest headers) {


        String logId = getLogId();
        Date requestTime = new Date();
        String methodName = "getTotalCollected";
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";
        LOGGER.info("getTotalCollected webservice is being called with parameters. Request {startDate -> {}, endDate -> {}, userId -> {}}, Ip Address = {}, LogId = {} ",
                startDate,endDate,username, headers.getRemoteAddr(),logId);

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            BigDecimal total = paymentScheduleInterface.getTotalCollected(sd,ed,setStatus(status),setSubProduct(subProductId));

            defaultSuccess(LOGGER,logId);
            response =  Response.status(Response.Status.OK).entity(total).build();
            queryExecuted = true;

        }
        catch (Exception e){
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(logId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        return response;
    }

    @GET
    @Path("/collections/expected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTotalExpected(@QueryParam("startDate") String startDate,@QueryParam("endDate") String endDate,@QueryParam("username") String username,@QueryParam("sessionId") String sessionId,@QueryParam("subProductId") Long subProductId,
                                      @Context HttpServletRequest headers) {


        String logId = getLogId();
        LOGGER.info("getTotalExpected webservice is being called with parameters. Request {startDate -> {}, endDate -> {}, userId -> {}}, Ip Address = {}, LogId = {} ",
                startDate,endDate,username, headers.getRemoteAddr(),logId);

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            BigDecimal total = paymentScheduleInterface.getTotalCollected(sd,ed,setSubProduct(subProductId));
            defaultSuccess(LOGGER,logId);
            return Response.status(Response.Status.OK).entity(total).build();


        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GET
    @Path("/collections/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCollectionByDate(@QueryParam("startDate") String startDate,@QueryParam("endDate") String endDate,@QueryParam("username") String username,
                                        @QueryParam("status") String status,@QueryParam("sessionId") String sessionId,@QueryParam("subProductId") Long subProductId,@Context HttpServletRequest headers) {


        String logId = getLogId();
        LOGGER.info("getCollectionByDate webservice is being called with parameters. Request {startDate -> {}, endDate -> {}, userId -> {}}, Ip Address = {}, LogId = {} ",
                startDate,endDate,username, headers.getRemoteAddr(),logId);

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            List<PaymentSchedule> paymentSchedules = paymentScheduleInterface.getCollectionsByInterval(sd,ed,setStatus(status),setSubProduct(subProductId));

            defaultSuccess(LOGGER,logId);
            return Response.status(Response.Status.OK).entity(paymentSchedules).build();


        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }


    @GET
    @Path("/coverage-rate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRCoverageRate( @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@QueryParam("birthDate") String birthDate,@QueryParam("coverageTypeId") Long coverageTypeId,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getRCoverageRate";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. birthDate -> {}, coverageTypeId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",methodName, birthDate,coverageTypeId,username, sessionId, reqRes,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            int age = getAge(stringToDate(birthDate),today());
            CoverageType coverageType = new CoverageType();
            coverageType.setCoverageTypeId(coverageTypeId);
            Optional<CoverageTypeRate> coverageTypeRate = coverageTypeRateInterface.findByCoverageTypeAndAge(
                    coverageType,
                    age
            );
            if(coverageTypeRate.isPresent()){
                defaultSuccess(LOGGER,reqRes);
                queryExecuted = true;
               return Response.status(Response.Status.OK).entity(coverageTypeRate.get()).build();
            }

        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        return response;

    }


    @GET
    @Path("/term-find")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTermPrice( @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@QueryParam("subProductId") Long subProductId,@QueryParam("birthDate") String birthDate,@QueryParam("term") int term,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getTermPrice";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. username -> {}, subProductId -> {}, birthDate -> {},term ->{}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, subProductId,birthDate,term, sessionId, reqRes,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Date birthDateConv = stringToDate(birthDate);
            int age = getAge(birthDateConv,today());

            Optional<Term> terms = termInterface.findByTermAndAge(term,age,setActive(),setSubProduct(subProductId));
            defaultSuccess(LOGGER,reqRes);
            if(terms.isPresent()){
                response = Response.status(Response.Status.OK).entity(terms.get()).build();
            }
            else {
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }


            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        return response;

    }


    @GET
    @Path("/term-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTerms( @QueryParam("sessionId") String sessionId,
                                  @QueryParam("username") String username,
                                  @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getTerms";
        defaultNoParamRequest(LOGGER,reqRes,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            List<Integer> terms = termInterface.findDistinctByTerm(setActive());
            defaultSuccess(LOGGER,reqRes);
            response = Response.status(Response.Status.OK).entity(terms).build();
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
    @Path("/country-map-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountryMap( @QueryParam("sessionId") String sessionId,
                                            @QueryParam("username") String username,
                                            @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getCountryMap";
        defaultNoParamRequest(LOGGER,reqRes,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<CountryMap> countryMaps = countryMapInterface.findByStatusOrderByName(setActive());
            defaultSuccess(LOGGER,reqRes);
            response = Response.status(Response.Status.OK).entity(countryMaps).build();
            queryExecuted = true;

        } catch (Exception e) {

            LOGGER.error(e);
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
    @Path("/application-details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplicationDetails( @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getApplicationDetails";
        defaultNoParamRequest(LOGGER,reqRes,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Optional<Application> application = applicationInterface.findByAppId(RequestUtil.APP_ID);
            if(application.isPresent()){
                defaultSuccess(LOGGER,reqRes);
                response = Response.status(Response.Status.OK).entity(application.get()).build();
            }
            else {
               LOGGER.info("No application data found for id -> {}",RequestUtil.APP_ID);
            }

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
    @Path("/task-config-details")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTaskConfigDetails( @QueryParam("sessionId") String sessionId,
                                           @QueryParam("username") String username,
                                           @QueryParam("taskId") String taskId,
                                           @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getTaskConfigDetails";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId, reqRes,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        TaskConfig taskResult = null;
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            Optional<TaskConfig> taskConfig = taskInterface.getTasks(taskId);
            if(taskConfig.isPresent()){
                LOGGER.info("{} returned -> {}, logId -> {}",methodName,taskConfig.get(),reqRes);
                taskResult = taskConfig.get();
                response = Response.status(Response.Status.OK).entity(taskConfig.get()).build();
            }
            else {
                LOGGER.info("No task data found for id -> {}",RequestUtil.APP_ID);
            }

            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        LOGGER.info("Response {}, Response Id = {}", taskResult, reqRes);
        return response;

    }


    @GET
    @Path("/beneficiary-by-id")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBeneficiaryDetails( @QueryParam("sessionId") String sessionId,
                                   @QueryParam("username") String username,
                                   @QueryParam("beneficiaryId") Long beneficiaryId,
                                   @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getBeneficiaryDetails";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. beneficiaryId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, beneficiaryId,username, sessionId, reqRes,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Status> statuses = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            Optional<Beneficiaries> beneficiaries = beneficiariesInterface.findByBeneficiaryId(beneficiaryId);
            if(beneficiaries.isPresent()){
                LOGGER.info("{} returned -> {}, logId -> {}",methodName,beneficiaries.get(),reqRes);

                return Response.status(Response.Status.OK).entity(beneficiaries.get()).build();
            }

            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        LOGGER.info("Response {}, Response Id = {}", statuses, reqRes);
        return response;

    }



    @GET
    @Path("/industries-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIndustries( @QueryParam("sessionId") String sessionId,
                                  @QueryParam("username") String username,
                                  @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getIndustries";
        defaultNoParamRequest(LOGGER,reqRes,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<Industry> industries = industryInterface.findByStatusOrderByName(setActive());
            defaultSuccess(LOGGER,reqRes);

            response = Response.status(Response.Status.OK).entity(industries).build();
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }
        return response;

    }


    @GET
    @Path("/frequencies-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFrequencies( @QueryParam("sessionId") String sessionId,
                                   @QueryParam("username") String username,
                                   @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getFrequencies";
        defaultNoParamRequest(LOGGER,reqRes,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<Frequency> frequencies = frequencyInterface.findAll();
            defaultSuccess(LOGGER,reqRes);
            response = Response.status(Response.Status.OK).entity(frequencies).build();
            queryExecuted = true;

        } catch (Exception e) {
            LOGGER.error(e);
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
    @Path("/job-title-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobTitle( @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "getJobTitle";
        defaultNoParamRequest(LOGGER,traceId,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<JobTitle> jobTitle = jobTitleInterface.findAllByOrderByName();
            defaultSuccess(LOGGER,traceId);
            response = Response.status(Response.Status.OK).entity(jobTitle).build();
            queryExecuted = true;

        } catch (Exception e) {

            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }

        return response;

    }



    @GET
    @Path("/find-benefit-cycle")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBenefitCycle( @QueryParam("sessionId") String sessionId,@QueryParam("username") String username,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "getBenefitCycle";
        defaultNoParamRequest(LOGGER,traceId,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {

            List<BenefitCycle> benefitCycles = benefitCycleInterface.findAll();
            defaultSuccess(LOGGER,traceId);
            response = Response.status(Response.Status.OK).entity(benefitCycles).build();
            queryExecuted = true;

        } catch (Exception e) {

            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }

        return response;

    }



    @GET
    @Path("/base-product-rules")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBaseAndProductRules( @QueryParam("subProductId") Long subProductId,
                                            @QueryParam("benefitCycle") Long benefitCycle,
                                            @QueryParam("sessionId") String sessionId,
                                            @QueryParam("username") String username,@Context HttpServletRequest headers) {

        String traceId = getLogId();
        String methodName = "getBaseAndProductRules";
        defaultNoParamRequest(LOGGER,traceId,sessionId,username,methodName,headers.getRemoteAddr());

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";
        SubProductResponse subProductResponse = new SubProductResponse();

        try {

            Optional<BaseAmount> baseAmount = baseAmountInterface.findBySubProductAndStatus(setSubProduct(subProductId),
                    setActive(), setCurrency(DEFAULT_CURRENCY), setBenefitCycle(benefitCycle));


            if(baseAmount.isPresent()){
                subProductResponse.setBaseAmount(baseAmount.get().getBaseAmount());
                subProductResponse.setHolderAgeLimit(baseAmount.get().getProductConfig().getHolderAgeLimit());
                subProductResponse.setCurrency(baseAmount.get().getCurrency().getCurrencyId());
                subProductResponse.setHolderMinAge(baseAmount.get().getProductConfig().getHolderMinAge());

            }

            defaultSuccess(LOGGER,traceId);
            response = Response.status(Response.Status.OK).entity(subProductResponse).build();
            queryExecuted = true;

        } catch (Exception e) {

            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();

        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(traceId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, headers.getRemoteAddr()));
        }

        return response;

    }


    public static String getIpAddress(HttpServletRequest headers){
        return headers.getRemoteAddr();
    }

}
