package api;

import core.beans.*;
import core.constants.ClaimStatuses;
import core.constants.RecordTypes;
import core.constants.RequestParams;
import core.threads.PostSFTP;
import core.util.CoreUtil;
import core.util.FileUtil;
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
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import static core.util.CoreUtil.*;
import static core.util.Util.*;
import static core.util.Util.CLAIMS_DIR;

@Path("/claims")
@ApplicationScoped
public class ClaimAPI {
    private static final Logger LOGGER = LogManager.getLogger(ClaimAPI.class);
    @Inject
    private DocumentFileInterface documentFileInterface;
    @Inject
    private ClaimInterface claimInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private PostSFTP postSFTP;
    @Inject
    private QueryUtil  queryUtil;
    @Inject
    private BeneficiariesInterface beneficiariesInterface;
    @Inject
    private InsuranceCompanyInterface insuranceCompanyInterface;
    @Inject
    private ClaimCoverageInterface claimCoverageInterface;


    @POST
    @Path("/create/v2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClaimWithoutAuth(ClaimRequest claimRequest, @Context HttpServletRequest headers) {
        String logId = getLogId();
        Date requestTime = today();
        String methodName = "createClaimWithoutAuth";
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            LOGGER.info("createClaimWithoutAuth webservice called. Request: {}, traceId: {}, IP Address: {}", claimRequest, logId, headers.getRemoteAddr());

            Claim claim = buildClaimFromRequest(claimRequest);
            claim.setStatus(setStatus(ClaimStatuses.OPENED.toString()));

            Claim savedClaim = queryUtil.postClaimSave(claim);
            processFiles(claimRequest, savedClaim, logId);

            queryExecuted = true;
            return Response.status(Response.Status.OK).entity(true).build();
        } catch (Exception e) {
            LOGGER.error("Exception occurred: {}", e.getMessage(), e);
            errorCause = e.getMessage();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } finally {
            saveLog(logId, requestTime, claimRequest, methodName, queryExecuted, errorCause, headers);
        }
    }

    private Claim buildClaimFromRequest(ClaimRequest claimRequest) throws ParseException {
        Claim claim = new Claim();
        claim.setCreatedDate(today());
        claim.setDescription(claimRequest.getDescription());
        claim.setAdmissionDate(parseDate(claimRequest.getAdmissionDate()));
        claim.setSinisterDate(parseDate(claimRequest.getSinisterDate()));
        claim.setExitDate(parseDate(claimRequest.getExitDate()));
        claim.setBenefitAmount(claimRequest.getBenefitAmount());
        claim.setSinisterPlace(claimRequest.getSinisterPlace());
        claim.setSinisterType(claimRequest.getSinisterType());
        claim.setClaimProcessId(claimRequest.getClaimProcessId());
        claim.setQmsProcessNr(claimRequest.getQmsProcessNr());
        claim.setInsurerPaidAmount(claimRequest.getInsurerPaidAmount());
        claim.setCoverType(claimRequest.getCoverType());
        claim.setSinisterStatus(claimRequest.getSinisterStatus());
        claim.setFranchiseAmount(claimRequest.getFranchiseAmount());
        claim.setClaimant(claimRequest.getClaimant());
        claim.setStatus(setStatus(claimRequest.getStatus()));

        InsurancePolicy insurancePolicy = new InsurancePolicy();
        insurancePolicy.setPolicyId(claimRequest.getPolicyId());
        claim.setInsurancePolicy(insurancePolicy);
        claim.setUsers(setUser(claimRequest.getUsername()));

        Optional<InsuranceCompany> insuranceCompany = insuranceCompanyInterface.findByInsuranceCompanyId(claimRequest.getInsuranceCompanyId());
        insuranceCompany.ifPresent(claim::setInsuranceCompany);

        return claim;
    }

    private Date parseDate(String dateString) throws ParseException {
        return dateString != null ? stringToDate(dateString) : null;
    }

    private void processFiles(ClaimRequest claimRequest, Claim savedClaim, String logId) throws IOException {
        if (claimRequest.getFileRequests() != null) {
            for (FileRequest fl : claimRequest.getFileRequests()) {
                DocumentFile documentFile = buildDocumentFile(fl, savedClaim,claimRequest.getUsername());
                DocumentFile savedDocument = queryUtil.saveDocumentFile(documentFile);
                LOGGER.info("DocumentFile saved. id -> {}, traceId -> {}", savedDocument.getId(), logId);

                File file = FileUtil.createFile(fl.getImage(), documentFile.getTitle(), CLAIMS_DIR, formatDate(today(), SIMPLE_DATE_PATTERN));
                LOGGER.info("File Created. Name -> {}, file -> {}, traceId -> {}", documentFile.getTitle(), file.getAbsolutePath(), logId);

                SFTPContext sftpContext = new SFTPContext();
                sftpContext.setClaim(savedClaim);
                sftpContext.setDocumentFile(savedDocument);

                executorService.submit(() -> postSFTP.apply(sftpContext));
            }
        }
    }

    private DocumentFile buildDocumentFile(FileRequest fl, Claim savedClaim, String username) {
        DocumentFile documentFile = new DocumentFile();
        documentFile.setDocumentType(setDocumentType(fl.getDocumentTypeId()));
        String subFolder = formatDate(today(), SIMPLE_DATE_PATTERN);
        documentFile.setInputter(username);
        documentFile.setCreatedDate(today());
        documentFile.setTitle(fl.getFileName());
        documentFile.setUrl(File.separator + CLAIMS_DIR + File.separator + subFolder + File.separator + getLogId() + "." + FileUtil.getType(fl.getImage()));
        documentFile.setDescription(fl.getFileName());
        documentFile.setObjectId(String.valueOf(savedClaim.getClaimId()));
        documentFile.setFileType(fl.getFileType());
        return documentFile;
    }

    private void saveLog(String logId, Date requestTime, ClaimRequest claimRequest, String methodName, boolean queryExecuted, String errorCause, HttpServletRequest headers) {
        queryUtil.saveLog(CoreUtil.setWebserviceLog(logId, requestTime, claimRequest.getUsername(), methodName, Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), queryExecuted,
                HttpMethod.POST, errorCause, claimRequest.getSessionId(), headers.getRemoteAddr(), false, "Create Claim", null));
    }


    @GET
    @Path("/find/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClaimById(@QueryParam("claimId") Long claimId,
                                 @QueryParam("username") String username,
                                 @QueryParam("sessionId") String sessionId,
                                 @Context HttpServletRequest headers) {


        String logId = getLogId();
        Date requestTime = today();
        String methodName = "getClaimById";
        String friendlyName = "Obtain claim details";
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String ipAddress = headers.getRemoteAddr();
        String errorCause = "";
        LOGGER.info("getClaimById webservice is being called with parameters. Request {claimId -> {}, userId -> {}}, Ip Address = {}, LogId = {} ",
                claimId,username, headers.getRemoteAddr(),logId);

        try {
            Optional<Claim> claim = claimInterface.findByClaimId(claimId);
            if(claim.isPresent()) {

                ClaimResponse claimResponse = new ClaimResponse();
                claimResponse.setClaim(claim.get());

                List<DocumentFile> documentFiles = documentFileInterface.findByObjectId(String.valueOf(claimId));
                List<ClaimResponse.DocumentResponse> documentResponses = documentFiles.stream()
                        .map(this::toDocumentResponse)
                        .collect(Collectors.toList());

                claimResponse.setDocumentResponses(documentResponses);

                LOGGER.info("getClaimById returned {} documents. LogId = {}", claim.get(), logId);
                return Response.status(Response.Status.OK).entity(claimResponse).build();
            }

            else{
                LOGGER.info("getClaimById returned no documents. LogId = {}",logId);
                return Response.status(Response.Status.OK).build();
            }

        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(logId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause,
                    sessionId,ipAddress,false,friendlyName,"Claim ID ->"+claimId));
        }

    }

    private ClaimResponse.DocumentResponse toDocumentResponse(DocumentFile df) {
        ClaimResponse.DocumentResponse documentResponse = new ClaimResponse.DocumentResponse();
        try {
            documentResponse.setDocumentName(df.getDescription());
            documentResponse.setDocumentImage(FileUtil.toBase64(df.getUrl()));
            documentResponse.setDocumentType(df.getDocumentType().getDescription());
        } catch (Exception e) {
            LOGGER.error("Error processing document file. Id: {}, Error: {}", df.getId(), e.getMessage(), e);
        }
        return documentResponse;
    }
    @GET
    @Path("/list/interval")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listClaims(@QueryParam("startDate") String startDate,
                               @QueryParam("endDate") String endDate,
                                 @QueryParam("username") String username,
                                 @QueryParam("sessionId") String sessionId,
                                 @Context HttpServletRequest headers) {


        String logId = getLogId();
        Date requestTime = today();
        String methodName = "listClaims";
        String friendlyName = "Obtain claim list";
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String ipAddress = headers.getRemoteAddr();
        String errorCause = "";

        LOGGER.info("listClaims webservice is being called with parameters. Request {startDate -> {}, endDate -> {}, userId -> {}}, Ip Address = {}, LogId = {} ",
                startDate,endDate,username, headers.getRemoteAddr(),logId);

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            List<Claim> claims = claimInterface.findByDates(sd,ed);

                LOGGER.info("listClaims returned {}. LogId = {}", claims.size(), logId);
                return Response.status(Response.Status.OK).entity(claims).build();


        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(logId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause,
                    sessionId,ipAddress,false,friendlyName,"Start date ->"+startDate+" End date -> {}"+endDate));
        }

    }





    @GET
    @Path("/beneficiaries/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClaimant( @QueryParam("username") String username,
                                 @QueryParam("sessionId") String sessionId,
                                 @QueryParam("policyId") String policyId,
                                 @Context HttpServletRequest headers) {


        String logId = getLogId();
        LOGGER.info("getClaimant webservice is being called with parameters. Request {userId -> {}, policyId -> {}}, Ip Address = {}, LogId = {} ",
                username,policyId, headers.getRemoteAddr(),logId);

        try {


           Optional<InsurancePolicy> insurancePolicy = insurancePolicyInterface.findByPolicyId(policyId);
           if(insurancePolicy.isPresent()){

               List<Beneficiaries> beneficiaries = beneficiariesInterface.findByInsurancePolicyAndStatus(insurancePolicy.get(),setActive());
               Beneficiaries mainBen = new Beneficiaries();

               mainBen.setName(insurancePolicy.get().getPolicyHolder().getCustomerName());
               mainBen.setBeneficiaryId(Long.parseLong("-1"));

               beneficiaries.add(mainBen);


                LOGGER.info("getClaimant returned {} documents. LogId = {}", beneficiaries, logId);
                return Response.status(Response.Status.OK).entity(beneficiaries).build();
            }

            else{
                LOGGER.info("getClaimant returned no documents. LogId = {}",logId);
                return Response.status(Response.Status.OK).build();
            }

        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }



    @GET
    @Path("/tat/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPendingClaims( @QueryParam("username") String username,@QueryParam("sessionId") String sessionId,@QueryParam("policyId") String policyId,
                                      @QueryParam("subProduct") String subProduct,@QueryParam("startDate") String startDate,@QueryParam("endDate") String endDate,
                                      @QueryParam("productId") String productId,
                                      @Context HttpServletRequest headers) {


        String traceId = getLogId();
        LOGGER.info("getPendingClaims webservice is being called with parameters. Request {userId -> {}, sessionId -> {}, policyId -> {},subProduct -> {}, " +
                        "startDate -> {}, endDate -> {}}, Ip Address = {}, traceId = {} ",
                username,sessionId,policyId,subProduct,startDate,endDate, headers.getRemoteAddr(),traceId);

        try {
            List<Claim> pendingClaims;
            List<Status> statuses = Arrays.asList(setStatus(ClaimStatuses.PENDING_AUTH.toString()),
                    setStatus(ClaimStatuses.OPENED.toString()),setStatus(ClaimStatuses.APPROVED.toString()),
                    setStatus(ClaimStatuses.DECLINED.toString()));

            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);

            if(!policyId.equalsIgnoreCase(RequestParams.ALL.toString())){
                pendingClaims = claimInterface.findByStatusAndDates(statuses,policyId,sd,ed);
            }
            else if(!subProduct.equalsIgnoreCase(RequestParams.ALL.toString())){
                pendingClaims = claimInterface.findByStatusAndDates(statuses,sd,ed,setSubProduct(Long.parseLong(subProduct)));
            }
            else {
                pendingClaims = claimInterface.findByStatusProductAndDates(statuses,setProduct(productId),sd,ed);
            }

            List<ClaimsTATResponse> claimsTATResponses = pendingClaims.stream().map(claim -> {
                ClaimsTATResponse claimsTATResponse = new ClaimsTATResponse();

                String _RAG;
                Date closureDate = today();
                if(claim.getClosureDate()!=null){
                    closureDate = claim.getClosureDate();
                }
                long _SLA = getDateDiffInHours(claim.getCreatedDate(),closureDate);
                if(_SLA>claim.getInsurancePolicy().getSubProduct().getSLAInHours()){
                    _RAG = "danger";
                }
                else {
                    _RAG = "success";
                }
                claimsTATResponse.setTAT(formatHours(_SLA));
                claimsTATResponse.setClaim(claim);
                claimsTATResponse.setRAG(_RAG);


                return claimsTATResponse;
            }).collect(Collectors.toList());

            defaultSuccess(LOGGER,traceId);
            return Response.status(Response.Status.OK).entity(claimsTATResponses).build();


        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @POST
    @Path("/update/status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateClaimStatus(ClaimUpdateRequest claimUpdateRequest, @Context HttpServletRequest headers) {
        String logId = getLogId();

        try {
            LOGGER.info("updateClaimStatus webservice is being called with parameters. Request {}, traceId = {}, Ip Address = {} ", claimUpdateRequest, logId, headers.getRemoteAddr());

           int updated;

              updated = claimInterface.updateClaimStatus(setStatus(claimUpdateRequest.getStatusId()),claimUpdateRequest.getClaimProcessId(),
                      claimUpdateRequest.getInsurerPaidAmount(), today(),claimUpdateRequest.getClaimId());

           if(updated>0){
               LOGGER.info("Claim {} updated to -> {}",claimUpdateRequest.getClaimId(),claimUpdateRequest.getStatusId());
               return Response.status(Response.Status.OK).entity(true).build();
           }
           else {
               LOGGER.info("Claim {} NOT updated to -> {}",claimUpdateRequest.getClaimId(),claimUpdateRequest.getStatusId());
               return Response.status(Response.Status.OK).entity(false).build();
           }

        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }


    }


    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClaimCoverage(@QueryParam("product") String product,
                                 @QueryParam("username") String username,
                                 @QueryParam("sessionId") String sessionId,
                                 @Context HttpServletRequest headers) {


        String logId = getLogId();
        Date requestTime = today();
        String methodName = "getClaimCoverage";
        String friendlyName = "Obtain coverage status";
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String ipAddress = headers.getRemoteAddr();
        String errorCause = "";
        LOGGER.info("{} webservice is being called with parameters. Request {product -> {}, userId -> {}}, Ip Address = {}, LogId = {} ",
                methodName,product,username, headers.getRemoteAddr(),logId);

        try {
            List<ClaimCoverage> claimCoverages = claimCoverageInterface.findByProductAndStatus(setProduct(
                    product),true);
            return Response.status(Response.Status.OK).entity(claimCoverages).build();

        }
        catch (Exception e){
            LOGGER.error(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(logId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause,
                    sessionId,ipAddress,false,friendlyName,"Product ID ->"+product));
        }

    }

}
