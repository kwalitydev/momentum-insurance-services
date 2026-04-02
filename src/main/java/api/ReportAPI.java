package api;

import core.beans.*;
import core.constants.*;
import core.util.CoreUtil;
import core.util.FileUtil;
import core.util.QueryUtil;
import core.util.Util;
import dao.entities.*;
import dao.entities.Currency;
import dao.interfaces.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.type.OrientationEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static core.constants.DocumentTypes.POLICIES;
import static core.constants.DocumentTypes.QUOTATION;
import static core.constants.ProcessActions.CANCEL;
import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/reports")
@ApplicationScoped
public class ReportAPI {

    private static final Logger LOGGER = LogManager.getLogger(ReportAPI.class);
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private MemberPriceInterface memberPriceInterface;
    @Inject
    private BeneficiariesInterface beneficiariesInterface;
    @Inject
    private DocumentTypeInterface documentTypeInterface;
    @Inject
    private RelationshipInterface relationshipInterface;
    @Inject
    private UserDetailsInterface userDetailsInterface;
    @Inject
    private PaymentLogInterface paymentLogInterface;
    @Inject
    private NotificationInterface notificationInterface;
    @Inject
    private CommissionMapInterface commissionMapInterface;
    @Inject
    private InsurancePolicyHistoryInterface insurancePolicyHistoryInterface;
    @Inject
    private ReportFieldMapInterface reportFieldMapInterface;

    @Inject
    private IndustryInterface industryInterface;

    @Inject
    private CoverageOptionInterface coverageOptionInterface;
    @Inject
    private PaymentScheduleInterface paymentScheduleInterface;
    @Inject
    private BenefitInterface benefitInterface;
    @Inject
    private ProductConfigInterface productConfigInterface;

    @GET
    @Path("/policies-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPolicies(@QueryParam("startDate") String startDate,
                                @QueryParam("endDate") String endDate,
                                @QueryParam("subProductId") String subProductId,
                                @QueryParam("userId") String userId,
                                @QueryParam("statusId") String statusId,
                                @QueryParam("sessionId") String sessionId,
                                @QueryParam("username") String username,
                                @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getPolicies";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. startDate -> {}, endDate -> {}, subProductId -> {}, userId ->{}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate,endDate,subProductId,userId,username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<InsurancePolicy> insurancePolicies = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";


        try {

            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);

            if(subProductId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                        userId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                    statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed);

            }
            else if(!subProductId.equalsIgnoreCase(RequestParams.ALL.toString())){

                if( userId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setSubProduct(Long.parseLong(subProductId)));
                }
                else if(userId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setSubProduct(Long.parseLong(subProductId)));
                }
                else if(!userId.equalsIgnoreCase(RequestParams.ALL.toString())){

                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setSubProduct(Long.parseLong(subProductId)),setUser(userId));
                }
                else if(!userId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                        statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setUser(userId),setSubProduct(Long.parseLong(subProductId)));
                }

            }
            else if (!statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                if(subProductId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                        userId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setStatus(statusId));
                }
                else if(!subProductId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                        userId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setStatus(statusId),setSubProduct(Long.parseLong(subProductId)));
                }
                else if(subProductId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                        !userId.equalsIgnoreCase(RequestParams.ALL.toString())){

                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setStatus(statusId),setUser(userId));
                }


            }
            else if (!userId.equalsIgnoreCase(RequestParams.ALL.toString())){

                LOGGER.info("Searching with filtered username");
                if(subProductId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                        statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setUser(userId));
                }
                else if(!subProductId.equalsIgnoreCase(RequestParams.ALL.toString()) &&
                        statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    insurancePolicies = insurancePolicyInterface.findByDateInterval(sd,ed,setUser(userId),setSubProduct(Long.parseLong(subProductId)));
                }

            }

            response = Response.status(Response.Status.OK).entity(insurancePolicies).build();
            queryExecuted = true;
            defaultSuccess(LOGGER,reqRes);

        } catch (Exception e) {
            LOGGER.error(e);
            
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        return response;

    }



    private List<Object[]> buildObjectResponse(List<InsurancePolicy> insurancePolicies) {
        List<Object[]> objects = new ArrayList<>();

        for (InsurancePolicy insurancePolicy : insurancePolicies) {
            Object[] obj = new Object[21];

            obj[0] = insurancePolicy.getPolicyId();
            obj[1] = insurancePolicy.getSubProduct().getName();

            PolicyHolder policyHolder = insurancePolicy.getPolicyHolder();
            if (policyHolder != null) {
                obj[2] = policyHolder.getCustomerName();
                obj[3] = policyHolder.getGender();
                obj[4] = policyHolder.getDateOfBirth();
              //  obj[5] = policyHolder.getTarget() != null ? policyHolder.getTarget().getDescription() : "";
                obj[6] = policyHolder.getAccountNumber();
                obj[7] = policyHolder.getCustomerId();
            } else {
                Arrays.fill(obj, 2, 8, "");
            }

            obj[8] = insurancePolicy.getTotalAmount();
          //  obj[9] = insurancePolicy.getLoanAmount();

            // User details
            Users user = insurancePolicy.getUsers();
            if (user != null) {
                obj[10] = user.getUserId();
                obj[11] = user.getDepartment() != null ? user.getDepartment().getName() : "";
            } else {
                obj[10] = "";
                obj[11] = "";
            }

            obj[12] = insurancePolicy.getCreatedDate();
            obj[13] = insurancePolicy.getStartDate();
            obj[14] = insurancePolicy.getExpiryDate();
            obj[15] = insurancePolicy.getSimulationId();
            obj[16] = insurancePolicy.getStatus() != null ? insurancePolicy.getStatus().getDescription() : "";

            SubProduct subProduct = insurancePolicy.getSubProduct();
            if (subProduct != null) {
                obj[17] = subProduct.getProduct().getProductId();
                obj[18] = subProduct.getAliasName();
            } else {
                obj[17] = "";
                obj[18] = "";
            }
            obj[19] = insurancePolicy.getCurrency() != null ? insurancePolicy.getCurrency().getCurrencyId() : "";

            obj[20] = insurancePolicy.getRecordType();

            objects.add(obj);
        }

        return objects;
    }




    @GET
    @Path("/policies-list/v2/cancelled")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCancelledPolicies(
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("subProductId") String subProductId,
            @QueryParam("productId") String productId,
            @QueryParam("statusId") String statusId,
            @QueryParam("sessionId") String sessionId,
            @QueryParam("username") String username,
            @QueryParam("limit") int limit,
            @QueryParam("offset") int offset,
            @QueryParam("policyId") String policyId,
            @QueryParam("resultType") String resultType,
            @QueryParam("accountNumber") String accountNumber,
            @QueryParam("cif") String cif,
            @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getCancelledPolicies";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameters: startDate -> {}, endDate -> {}, subProductId -> {}, productId ->{}, limit -> {}, offset -> {}, accountNumber -> {}, cif -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {}",
                methodName, startDate, endDate, subProductId, productId, limit, offset, accountNumber, cif, username, sessionId, reqRes, ipAddress);

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<InsurancePolicy> insurancePolicies = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            Pageable pageable = PageRequest.of(offset, limit);

            if (!policyId.equalsIgnoreCase(RequestParams.ALL.toString())) {
                Optional<InsurancePolicy> policyOpt = insurancePolicyInterface.findByPolicyId(policyId);
                if (policyOpt.isPresent()) {
                    LOGGER.info("Searching by policy ID");
                    insurancePolicies.add(policyOpt.get());
                    return Response.status(Response.Status.OK).entity(insurancePolicies).build();
                }
            }


            LOGGER.info("Searching by date interval, product/subProduct, and status");
            insurancePolicies = getPoliciesByFilters(sd, ed, productId, subProductId, statusId, pageable);

            if (resultType.equalsIgnoreCase(ResultTypes.PREVIEW.toString())) {
                LOGGER.info("{} returned {} results", methodName, insurancePolicies.size());
                response = Response.status(Response.Status.OK).entity(insurancePolicies).build();
            } else {
                response = buildFileForDownload(insurancePolicies, username);
            }

            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error("Error occurred: {}", e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
        } finally {
            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username, methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }

        LOGGER.debug("Response {}, Response Id = {}", insurancePolicies, reqRes);
        return response;
    }

    private Response createResponse(List<InsurancePolicy> policies) {
        return Response.status(Response.Status.OK).entity(policies).build();
    }

    private List<InsurancePolicy> getPoliciesByFilters(Date sd, Date ed, String productId, String subProductId, String statusId, Pageable pageable) {
        if (subProductId.equalsIgnoreCase(RequestParams.ALL.toString())) {
            return statusId.equalsIgnoreCase(RequestParams.ALL.toString()) ?
                    insurancePolicyInterface.findByDateInterval(sd, ed, setProduct(productId), pageable) :
                    insurancePolicyInterface.findByDateInterval(sd, ed, setProduct(productId), setStatus(statusId), pageable);
        } else {
            return statusId.equalsIgnoreCase(RequestParams.ALL.toString()) ?
                    insurancePolicyInterface.findByDateInterval(sd, ed, setSubProduct(Long.parseLong(subProductId)), pageable) :
                    insurancePolicyInterface.findByDateInterval(sd, ed, setStatus(statusId), setSubProduct(Long.parseLong(subProductId)), pageable);
        }
    }


    private Response buildFileForDownload(List<InsurancePolicy> insurancePolicies, String username) throws Exception {
        ReportResponse reportResponse = new ReportResponse();

        LOGGER.info("Building file for download ...");
        String[] columns = { "Número de apólice", "Sub Produto", "Nome do cliente",
                "Número de Conta", "Prémio", "Data da criação", "Data de início",
                "Data de expiração", "Número da cotação", "Utilizador que criou", "Estado"};

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = createFileOutputStream(username)) {

            Sheet sheet = workbook.createSheet("Apólices");
            createHeaderRow(sheet, columns);
            populateDataRows(sheet, insurancePolicies);
            autoSizeColumns(sheet, columns.length);

            workbook.write(fileOut);
        }

        String shortUrl = generateFileUrl(username);
        LOGGER.info("File saved in path {}", shortUrl);

        reportResponse.setFile(FileUtil.toBase64(shortUrl));
        reportResponse.setFileName(new File(shortUrl).getName());

        return Response.status(Response.Status.OK).entity(reportResponse).build();
    }

    private void createHeaderRow(Sheet sheet, String[] columns) {
        Font headerFont = sheet.getWorkbook().createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        CellStyle headerCellStyle = sheet.getWorkbook().createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }

    private void populateDataRows(Sheet sheet, List<InsurancePolicy> insurancePolicies) {
        int rowNum = 1;
        for (InsurancePolicy ip : insurancePolicies) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(ip.getPolicyId());
            row.createCell(1).setCellValue(ip.getSubProduct() != null ? ip.getSubProduct().getName() : "");
            row.createCell(2).setCellValue(ip.getPolicyHolder() != null ? ip.getPolicyHolder().getCustomerName() : "");
            row.createCell(3).setCellValue(ip.getPolicyHolder() != null ? ip.getPolicyHolder().getAccountNumber() : "");
            row.createCell(4).setCellValue(ip.getTotalAmount() != null ? Util.formatDouble(ip.getTotalAmount().doubleValue()) : "");
            row.createCell(5).setCellValue(ip.getCreatedDate() != null ? CoreUtil.formatDate(ip.getCreatedDate(), DATETIME_PATTERN) : "");
            row.createCell(6).setCellValue(ip.getStartDate() != null ? CoreUtil.formatDate(ip.getStartDate(), DATETIME_PATTERN) : "");
            row.createCell(7).setCellValue(ip.getExpiryDate() != null ? CoreUtil.formatDate(ip.getExpiryDate(), DATETIME_PATTERN) : "");
            row.createCell(8).setCellValue(ip.getSimulationId());
            row.createCell(9).setCellValue(ip.getUsers() != null ? ip.getUsers().getUserId() : "");
            row.createCell(10).setCellValue(ip.getStatus() != null ? ip.getStatus().getDescription() : "");
        }
    }

    private void autoSizeColumns(Sheet sheet, int columnCount) {
        for (int i = 0; i < columnCount; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private FileOutputStream createFileOutputStream(String username) throws IOException {
        String baseDir = FileUtil.BASE_DIRECTORY + File.separator + REPORT_DIR + File.separator + EXPORT_DIR + File.separator + formatDate(today(), SIMPLE_DATE_PATTERN);
        String reportDir = baseDir + File.separator + username;

        File baseDirectory = new File(baseDir);
        if (!baseDirectory.exists() && baseDirectory.mkdirs()) {
            LOGGER.info("Base directory {} created", baseDir);
        }

        File exportDirectory = new File(reportDir);
        if (!exportDirectory.exists() && exportDirectory.mkdirs()) {
            LOGGER.info("Export directory {} created", reportDir);
        }

        String dateFormatted = formatDate(today(), TIMESTAMP_PATTERN);
        String filePath = reportDir + File.separator + "Apolices_" + dateFormatted + ".xlsx";
        return new FileOutputStream(filePath);
    }

    private String generateFileUrl(String username) {
        String dateFormatted = formatDate(today(), TIMESTAMP_PATTERN);
        return File.separator + REPORT_DIR + File.separator + EXPORT_DIR + File.separator + formatDate(today(), SIMPLE_DATE_PATTERN) + File.separator + username + File.separator + "Apolices_" + dateFormatted + ".xlsx";
    }


    private Response buildPaymentFileForDownload(List<Object[]> paymentLogs,String username) throws Exception {
        ReportResponse reportResponse = new ReportResponse();

        LOGGER.info("Building file for download ...");
        String[] columns = { "Número de apólice", "Sub Produto", "Nome do cliente",
                "Número de Conta" , "Prémio", "Data da cobrança", "Método de Pagamento", "ID da transacção",
                "Estado", "Motivo de erro"};


        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Coletas");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;


        for (Object[] ip : paymentLogs) {
            LOGGER.info("Looping in {} of {}",rowNum,paymentLogs.size());

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue((String) ip[0]);
            row.createCell(1).setCellValue((String) ip[1]);
            row.createCell(2).setCellValue((String) ip[3]);
            row.createCell(3).setCellValue((String) ip[4]);
            row.createCell(5).setCellValue(formatDate((Date) ip[5], DATETIME_PATTERN));
            if(ip[11]!=null){
                BigDecimal premium = (BigDecimal) ip[11];
                row.createCell(4).setCellValue(formatDouble (premium.doubleValue()));
            }
            else {
                row.createCell(4).setCellValue("");
            }

            row.createCell(7).setCellValue(ip[6]+"/"+ip[7]);

            BigDecimal premium = (BigDecimal) ip[12];
            if(premium!=null) {
                if (premium.intValue() == 1) {
                    row.createCell(6).setCellValue("Normal");
                } else {
                    row.createCell(6).setCellValue("Atrasado");
                }
            }
            else {
                row.createCell(6).setCellValue("");
            }


            row.createCell(7).setCellValue((String) ip[8]);
            row.createCell(8).setCellValue((String) ip[9]);
            row.createCell(9).setCellValue((String) ip[10]);

        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        String baseDir = FileUtil.BASE_DIRECTORY+ File.separator + REPORT_DIR+ File.separator+ EXPORT_DIR+ File.separator+ formatDate(today(),SIMPLE_DATE_PATTERN);
        String reportDir = baseDir + File.separator+username;
        File newDir = new File(baseDir);
        if (!newDir.exists()){
            LOGGER.info("Attempting to create base folder {}",baseDir);
            if(newDir.mkdir()){
                LOGGER.info("Folder {} created",baseDir);
            }

        }

        File expDir = new File(reportDir);
        if (!expDir.exists()){
            LOGGER.info("Attempting to create export folder {}",reportDir);
            if(expDir.mkdir()){
                LOGGER.info("Folder {} created",expDir);
            }

        }
        // Write the output to a file
        String dateFormatted = formatDate(today(),TIMESTAMP_PATTERN);
        String url = reportDir+ File.separator + "Coletas_"+dateFormatted+".xlsx";
        FileOutputStream fileOut = new FileOutputStream(url);
        workbook.write(fileOut);
        fileOut.close();

        String shortUrl =  File.separator+ REPORT_DIR+ File.separator+ EXPORT_DIR+ File.separator+ formatDate(today(),SIMPLE_DATE_PATTERN)+File.separator+username+File.separator + "Coletas_"+dateFormatted+".xlsx";
        LOGGER.info("File saved in path {}",url);

        // Thread.sleep(2000);
        reportResponse.setFile(FileUtil.toBase64(shortUrl));
        reportResponse.setFileName("Coletas_"+dateFormatted+".xlsx");

        return Response.status(Response.Status.OK).entity(reportResponse).build();


    }



    @GET
    @Path("/policies/id")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPolicyById(@QueryParam("policyId") String policyId,
                                  @QueryParam("sessionId") String sessionId,
                                  @QueryParam("username") String username,
                                @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getPolicies";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. policyId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,policyId,username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";


        try {

            InsurancePolicyResponse insurancePolicyResponse = new InsurancePolicyResponse();

           Optional<InsurancePolicy> insurancePolicy = insurancePolicyInterface.findByPolicyId(policyId);

           if(insurancePolicy.isPresent()){
               insurancePolicyResponse.setInsurancePolicy(insurancePolicy.get());
               Optional<MemberProductPrice> memberProductPrice = memberPriceInterface.findByCurrencyAndSubProductAndStatus(
                       insurancePolicy.get().getCurrency(),
                       insurancePolicy.get().getSubProduct(),

                       setActive()

               );
               memberProductPrice.ifPresent(insurancePolicyResponse::setMemberProductPrice);

               Optional<UserDetails> userDetails = userDetailsInterface.findByUsers(
                       insurancePolicy.get().getUsers());
               userDetails.ifPresent(details -> insurancePolicyResponse.setCreatedByName(details.getFullName() + " " + details.getSurname()));

               LOGGER.info("getPolicies returned {}",insurancePolicyResponse);
               response = Response.status(Response.Status.OK).entity(insurancePolicyResponse).build();
               defaultSuccess(LOGGER,reqRes);
               queryExecuted = true;
           }
           else {
               response = Response.status(Response.Status.OK).build();
           }

        } catch (Exception e) {
            LOGGER.error(e);
            
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }

        return response;

    }




    @POST
    @Path("/proof/quotation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response genPolicyProof(ReportRequest reportRequest, @Context HttpServletRequest headers) {
        String logId = getLogId();

        try {
            String baseDir = createDirectories();
            String fileName = reportRequest.getPolicyId() + ".pdf";

            Optional<InsurancePolicy> insurancePolicy = insurancePolicyInterface.findByPolicyId(reportRequest.getPolicyId());
            if (insurancePolicy.isPresent()) {
                InsurancePolicy insurancePolicyItem = insurancePolicy.get();
                Map<String, Object> parameters = populateParameters(insurancePolicyItem, reportRequest);
                generateReport(baseDir, fileName, parameters);

                ReportResponse reportResponse = createReportResponse(fileName);
                saveDocumentFile(reportRequest, insurancePolicyItem, fileName);

                LOGGER.info("Report Successfully Generated. traceId -> {}", logId);
                return Response.status(Response.Status.OK).entity(reportResponse).build();
            }
        } catch (Exception e) {
            LOGGER.error("Error generating policy proof. traceId -> {}", logId, e);
        }

        return Response.status(Response.Status.OK).entity(false).build();
    }

    private String createDirectories() {
        String baseDir = FileUtil.BASE_DIRECTORY + File.separator + REPORT_DIR + File.separator + QUOTATION_DIR + File.separator + formatDate(today(), SIMPLE_DATE_PATTERN);
        File baseDirectory = new File(baseDir);
        if (!baseDirectory.exists() && baseDirectory.mkdirs()) {
            LOGGER.info("Base directory created: {}", baseDir);
        }

        String reportDir = baseDir + File.separator;
        File reportDirectory = new File(reportDir);
        if (!reportDirectory.exists() && reportDirectory.mkdirs()) {
            LOGGER.info("Report directory created: {}", reportDir);
        }

        return reportDir;
    }

    private Map<String, Object> populateParameters(InsurancePolicy insurancePolicyItem, ReportRequest reportRequest) {
        Map<String, Object> parameters = new HashMap<>();
        determineTemplateName(insurancePolicyItem);

        parameters.put("subproduct", Optional.ofNullable(insurancePolicyItem.getSubProduct()).map(SubProduct::getDescription).orElse("Cotação"));
        populateAccountParameters(insurancePolicyItem, parameters);
        populatePolicyParameters(insurancePolicyItem, reportRequest, parameters);
        populateCoverageParameters(insurancePolicyItem, parameters);
        populateReportFieldParameters(insurancePolicyItem, parameters);
        populateBeneficiariesParameters(insurancePolicyItem, parameters);

        parameters.put("lastUpdate", formatDate(today(), SIMPLE_DATE_PATTERN));
        return parameters;
    }

    private String determineTemplateName(InsurancePolicy insurancePolicyItem) {
        if (insurancePolicyItem.getSubProduct() != null && insurancePolicyItem.getSubProduct().getProduct() != null) {
            return insurancePolicyItem.getSubProduct().getProduct().getProductId().toUpperCase() + ".jrxml";
        }
        return "";
    }

    private void populateAccountParameters(InsurancePolicy insurancePolicyItem, Map<String, Object> parameters) {
        PolicyHolder policyHolder = insurancePolicyItem.getPolicyHolder();
        if (policyHolder != null) {
            parameters.put("address", isNull(policyHolder.getAddress()));
            parameters.put("birthDate", formatDate(policyHolder.getDateOfBirth(), SIMPLE_DATE_PATTERN));
            parameters.put("documentId", isNull(policyHolder.getDocumentId()));
            parameters.put("occupation", isNull(policyHolder.getOccupation()));
            parameters.put("accountId", isNull(policyHolder.getAccountNumber()));
            parameters.put("accountHolderName", isNull(policyHolder.getCustomerName()));
            parameters.put("nuit", isNull(policyHolder.getVat()));
            parameters.put("activities", isNull(Optional.ofNullable(policyHolder.getJobTitle()).map(JobTitle::getDescription).orElse("")));
        } else {
            parameters.put("insuredName", "");
            parameters.put("address", "");
            parameters.put("birthDate", "");
            parameters.put("documentId", "");
            parameters.put("occupation", "");
            parameters.put("accountId", "");
            parameters.put("accountHolderName", "");
            parameters.put("nuit", "");
            parameters.put("activities", "");
        }
    }

    private void populatePolicyParameters(InsurancePolicy insurancePolicyItem, ReportRequest reportRequest, Map<String, Object> parameters) {
        parameters.put("policyNumberField", "Número da Cotação");
        parameters.put("policyNumber", reportRequest.getPolicyId());
        parameters.put("startDate", isNull(formatDate(insurancePolicyItem.getStartDate(), SIMPLE_DATE_PATTERN)));
        parameters.put("createdDate", isNull(formatDate(insurancePolicyItem.getCreatedDate(), SIMPLE_DATE_PATTERN)));
        if(insurancePolicyItem.getExpiryDate()!=null) {
            parameters.put("renewDate", formatDate(insurancePolicyItem.getExpiryDate(), SIMPLE_DATE_PATTERN));
        }
        else {
            parameters.put("renewDate", "");

        }

        Pageable top = PageRequest.of(0, 1);
        List<InsurancePolicyHistory> history = insurancePolicyHistoryInterface.getFirstInsurancePolicy(insurancePolicyItem, top);
        parameters.put("description", isNull(history.stream().findFirst().map(InsurancePolicyHistory::getChangeDescription).orElse("")));
        parameters.put("frequency", isNull(Optional.ofNullable(insurancePolicyItem.getPaymentFrequency()).map(Frequency::getName).orElse("")));
    }

    private void populateCoverageParameters(InsurancePolicy insurancePolicyItem, Map<String, Object> parameters) {
        BigDecimal baseAmountDecimal = insurancePolicyItem.getCoverage() != null ? insurancePolicyItem.getCoverage().getPremiumAmount() : BigDecimal.ZERO;
        double totalPremium = insurancePolicyItem.getTotalAmount().doubleValue();
        double premiumExtra = baseAmountDecimal.doubleValue() < totalPremium ? totalPremium - baseAmountDecimal.doubleValue() : 0;

        String currencyId = Optional.ofNullable(insurancePolicyItem.getCurrency()).map(Currency::getCurrencyId).orElse("");
        parameters.put("premiumPerEmployee", currencyId + " " + formatDouble(baseAmountDecimal.doubleValue()));
        parameters.put("insuredCapital", isNull(Optional.ofNullable(insurancePolicyItem.getCoverage()).map(Coverage::getCoverAmount).map(amount -> currencyId + " " + formatDouble(amount.doubleValue())).orElse("")));
        parameters.put("basePremium", currencyId + " " + formatDouble(baseAmountDecimal.doubleValue()));
        parameters.put("totalPremium", currencyId + " " + formatDouble(totalPremium));
        parameters.put("extraPremium", currencyId + " " + formatDouble(premiumExtra));
        parameters.put("anualPayment", currencyId + " " + formatDouble(totalPremium * 12));
    }

  
  

    private void populateReportFieldParameters(InsurancePolicy insurancePolicyItem, Map<String, Object> parameters) {
        List<ReportFieldMap> reportFieldMaps = reportFieldMapInterface.findBySubProductAndStatus(insurancePolicyItem.getSubProduct(), setActive());
        for (ReportFieldMap rfm : reportFieldMaps) {
            parameters.put(rfm.getFieldId(), rfm.getFieldValue());
        }
    }

    private void populateBeneficiariesParameters(InsurancePolicy insurancePolicyItem, Map<String, Object> parameters) {
        List<String> nearFamily = Arrays.asList(
                Relationships.DAUGHTER.getRelationship(),
                Relationships.SON.getRelationship(),
                Relationships.SPOUSE.getRelationship(),
                Relationships.MOTHER.getRelationship(),
                Relationships.FATHER.getRelationship()
        );
        List<Beneficiaries> nearBeneficiaries = beneficiariesInterface.findByRelationship(insurancePolicyItem, nearFamily, setActive());
        parameters.put("CollectionBeanParam", new JRBeanCollectionDataSource(convertToMembers(nearBeneficiaries)));

        List<String> otherFamily = Collections.singletonList(Relationships.OTHER.getRelationship());
        List<Beneficiaries> otherBeneficiaries = beneficiariesInterface.findByRelationship(insurancePolicyItem, otherFamily, setActive());
        parameters.put("CollectionBeanOther", new JRBeanCollectionDataSource(convertToMembers(otherBeneficiaries)));

        parameters.put("baseInsured", String.valueOf(nearBeneficiaries.size() + 1));
        parameters.put("baseExtras", String.valueOf(otherBeneficiaries.size()));
    }

    private List<Members> convertToMembers(List<Beneficiaries> beneficiaries) {
        List<Members> members = new ArrayList<>();
        int counter = 0;
        for (Beneficiaries b : beneficiaries) {
            counter++;
            Members m = new Members();
            m.setName(counter + "." + b.getName());
            m.setRelationShip(b.getRelationShip().getDescription());
            m.setDocumentId(isNull(b.getDocumentNumber()));
            members.add(m);
        }
        return members;
    }

    private void generateReport(String reportDir, String fileName, Map<String, Object> parameters) throws JRException {
        String templatePath = FileUtil.BASE_DIRECTORY + File.separator + TEMPLATE_DIR + File.separator + determineTemplateName((InsurancePolicy) parameters);
        JasperReport jasperReport = JasperCompileManager.compileReport(templatePath);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        jasperPrint.setOrientation(OrientationEnum.LANDSCAPE);
        JasperExportManager.exportReportToPdfFile(jasperPrint, reportDir + File.separator + fileName);
    }

    private ReportResponse createReportResponse(String fileName) throws IOException {
        ReportResponse reportResponse = new ReportResponse();
        String filePath = File.separator + REPORT_DIR + File.separator + QUOTATION_DIR + File.separator + formatDate(today(), SIMPLE_DATE_PATTERN) + File.separator + fileName;
        reportResponse.setFile(FileUtil.toBase64(filePath));
        reportResponse.setFileName("Comprovativo_" + fileName);
        return reportResponse;
    }

    private void saveDocumentFile(ReportRequest reportRequest, InsurancePolicy insurancePolicyItem, String fileName) {
        DocumentFile documentFile = new DocumentFile();
        documentFile.setFileType(FileTypes.ATTACHMENT.toString());
        documentFile.setCreatedBy(setUser(reportRequest.getUsername()));
        documentFile.setCreatedDate(today());
        documentFile.setRecordType(insurancePolicyItem.getRecordType());
        documentFile.setObjectId(reportRequest.getPolicyId());
        documentFile.setDocumentType(documentTypeInterface.findByFileType(QUOTATION.toString()).stream().findFirst().orElse(null));
        documentFile.setTitle(fileName);
        documentFile.setInputter(reportRequest.getUsername());
        documentFile.setUrl(File.separator + REPORT_DIR + File.separator + QUOTATION_DIR + File.separator + formatDate(today(), SIMPLE_DATE_PATTERN) + File.separator + fileName);
        documentFile.setDescription(fileName);

        queryUtil.saveDocumentFile(documentFile);
    }

    private String formatCurrency(Double amount, InsurancePolicy insurancePolicyItem) {
        String currencyId = Optional.ofNullable(insurancePolicyItem.getCurrency()).map(Currency::getCurrencyId).orElse("");
        return currencyId + " " + formatDouble(amount);
    }

    private String isNull(String value) {
        return value != null ? value : "";
    }

    private String formatDouble(double value) {
        return String.format("%.2f", value);
    }

    private String formatDate(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }


    @GET
    @Path("/proof/regenerate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reprintReport(@QueryParam("policyId") String policyId,
                                  @QueryParam("sessionId") String sessionId,
                                  @QueryParam("username") String username,
                                  @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "reprintReport";
        LOGGER.info("{} is being called with parameter. policyId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,policyId,username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {
            ReportResponse reportResponse = new ReportResponse();

                    ReportRequest reportRequest = new ReportRequest();
                    reportRequest.setPolicyId(policyId);
                    reportRequest.setSessionId(sessionId);
                    reportRequest.setUsername(username);

                    DocumentFile savedDf = genPolicyProof(reportRequest);
                    if(savedDf!=null) {
                        queryUtil.saveDocumentFile(savedDf);
                        reportResponse.setFile(FileUtil.toBase64( savedDf.getUrl()));
                        reportResponse.setFileName("Comprovativo_"+savedDf.getTitle());
                    }
                    else {
                        LOGGER.info("Document cannot be null");
                    }


                response = Response.status(Response.Status.OK).entity(reportResponse).build();

            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,headers.getRemoteAddr()));
        }

        return response;

    }


    public DocumentFile genPolicyProof(ReportRequest reportRequest){
            String logId = getLogId();
            String fileType;
            String baseDir = FileUtil.BASE_DIRECTORY + File.separator +  REPORT_DIR+ File.separator+QUOTATION_DIR+ File.separator+ formatDate(today(),SIMPLE_DATE_PATTERN);
            String reportDir = baseDir + File.separator;
            String fileName = reportRequest.getPolicyId()+".pdf";
            boolean folderCreated = true;

            try {

                File newDir = new File(baseDir);
                if (!newDir.exists()) {
                    LOGGER.info("Attempting to create base folder {}", baseDir);
                    folderCreated = newDir.mkdir();

                }
                File newReportDir = new File(reportDir);
                if (!newReportDir.exists()) {
                    LOGGER.info("Attempting to create report folder {}", baseDir);
                    folderCreated = newReportDir.mkdir();
                }

                if (folderCreated) {
                    LOGGER.info("Folder successfully created. traceId -> {}", logId);
                }

                InsurancePolicy insurancePolicyItem;
                Optional<InsurancePolicy> insurancePolicy = insurancePolicyInterface.findByPolicyId(reportRequest.getPolicyId());


                if (insurancePolicy.isPresent()) {
                    insurancePolicyItem = insurancePolicy.get();
                    String templateName;

                    Map<String, Object> parameters = new HashMap<>();

                    parameters.put("subproduct", insurancePolicyItem.getSubProduct().getDescription());

                    parameters.put("logoPath", FileUtil.BASE_DIRECTORY + File.separator + TEMPLATE_DIR + File.separator + "standardbank_logo.png");

                    if (insurancePolicyItem.getRecordType().equals(RecordTypes.SIMULATED.toString())) {
                        parameters.put("policyNumberField", "Número da Cotação");
                        parameters.put("subproduct", insurancePolicyItem.getSubProduct().getDescription());
                        templateName = insurancePolicyItem.getSubProduct().getProduct().getProductId().toUpperCase() + "_QUOTATION.jrxml";
                        fileType = QUOTATION.toString();
                    } else {
                        parameters.put("policyNumberField", "Número da Apólice");
                        parameters.put("subproduct", insurancePolicyItem.getSubProduct().getDescription());
                        templateName = insurancePolicyItem.getSubProduct().getProduct().getProductId().toUpperCase() + ".jrxml";
                        fileType = POLICIES.toString();
                    }



                        parameters.put("policyNumber", reportRequest.getPolicyId());
                        parameters.put("startDate", isNull(formatDate(insurancePolicyItem.getStartDate(), SIMPLE_DATE_PATTERN)));
                        parameters.put("createdDate", isNull(formatDate(insurancePolicyItem.getCreatedDate(), SIMPLE_DATE_PATTERN)));
                        try {
                            parameters.put("renewDate", isNull(formatDate(insurancePolicyItem.getExpiryDate(), SIMPLE_DATE_PATTERN)));
                        }
                        catch (NullPointerException ex){
                            parameters.put("renewDate", "");
                            LOGGER.info("Expiry date is null");

                        }
                        parameters.put("frequency", isNull(insurancePolicyItem.getPaymentFrequency().getName()));


                    try {
                        if (insurancePolicyItem.getPolicyHolder() != null) {
                            if (insurancePolicyItem.getPolicyHolder() != null) {
                               // parameters.put("insuredName", insurancePolicyItem.getInsuranceBenHolder());
                            } else {
                                parameters.put("insuredName", insurancePolicyItem.getPolicyHolder().getCustomerName());
                            }
                            parameters.put("address", isNull(insurancePolicyItem.getPolicyHolder().getAddress()));
                            parameters.put("birthDate", formatDate(insurancePolicyItem.getPolicyHolder().getDateOfBirth(), SIMPLE_DATE_PATTERN));
                            parameters.put("documentId", isNull(insurancePolicyItem.getPolicyHolder().getDocumentId()));
                            parameters.put("occupation", isNull(insurancePolicyItem.getPolicyHolder().getOccupation()));
                            parameters.put("accountId", isNull(insurancePolicyItem.getPolicyHolder().getAccountNumber()));
                            parameters.put("accountHolderName", isNull(insurancePolicyItem.getPolicyHolder().getCustomerName()));
                            parameters.put("nuit", isNull(insurancePolicyItem.getPolicyHolder().getVat()));
                            if (insurancePolicyItem.getPolicyHolder().getJobTitle() != null) {
                                parameters.put("activities", isNull(insurancePolicyItem.getPolicyHolder().getJobTitle().getDescription()));
                            } else {
                                parameters.put("activities", "");
                            }


                        } else {
                            parameters.put("insuredName", "");
                            parameters.put("address", "");
                            parameters.put("birthDate", "");
                            parameters.put("documentId", "");
                            parameters.put("occupation", "");
                            parameters.put("accountId", "");
                            parameters.put("accountHolderName", "");
                            parameters.put("nuit", "");
                        }
                    }
                    catch (Exception e){
                        LOGGER.error("error 2");
                        LOGGER.error(e);
                    }

                    parameters.put("baseExtras", "");
                    String currencyId = "";
                    if (insurancePolicyItem.getCurrency() != null) {
                        currencyId = insurancePolicyItem.getCurrency().getCurrencyId();
                    } else {
                        currencyId = "MZN";

                    }

                    if (insurancePolicyItem.getCoverage() != null) {
                        if (insurancePolicyItem.getCoverage().getCoverAmount() != null) {
                            parameters.put("totalBenefit", currencyId + " " + formatDouble(insurancePolicyItem.getCoverage().getCoverAmount().doubleValue()));


                            parameters.put("premiumPerEmployee", currencyId + " " +
                                    "" + formatDouble(insurancePolicyItem.getCoverage().getPremiumAmount().doubleValue()));

                            if (insurancePolicyItem.getCoverage().getCoverAmount() != null) {
                                parameters.put("insuredCapital", currencyId + " " + formatDouble(insurancePolicyItem.getCoverage().getCoverAmount().doubleValue()));
                            } else {
                                parameters.put("insuredCapital", "");
                            }
                        }


                    } else {
                        parameters.put("totalBenefit", "");
                    }

                    BigDecimal baseAmountDecimal;

                    if (insurancePolicyItem.getCoverage() != null) {
                        if (insurancePolicyItem.getCoverage().getPremiumAmount() != null) {
                            baseAmountDecimal = insurancePolicyItem.getCoverage().getPremiumAmount();


                            double premiumExtra = 0;
                            double totalPremium = insurancePolicyItem.getTotalAmount().doubleValue();

                            if (baseAmountDecimal != null) {
                                premiumExtra = totalPremium - baseAmountDecimal.doubleValue();
                            } else {
                                baseAmountDecimal = BigDecimal.valueOf(totalPremium);
                            }
                            parameters.put("basePremium", currencyId + " " + formatDouble(baseAmountDecimal.doubleValue()));
                            parameters.put("extraPremium", currencyId + " " + formatDouble(premiumExtra));
                        } else {
                            parameters.put("basePremium", "");
                            parameters.put("extraPremium", "");
                        }
                    } else {
                        parameters.put("basePremium", "");
                        parameters.put("extraPremium", "");
                    }

                    parameters.put("totalPremium", currencyId + " " + formatDouble(insurancePolicyItem.getTotalAmount().doubleValue()));
                    parameters.put("anualPayment", currencyId + " " + formatDouble(insurancePolicyItem.getTotalAmount().doubleValue() * 12));

                    if (insurancePolicyItem.getCoverage() != null) {
                        if (insurancePolicyItem.getCoverage().getCoverAmount() != null) {


                            parameters.put("totalMainMember", currencyId + " " +
                                    "" + formatDouble(insurancePolicyItem.getCoverage().getCoverAmount().doubleValue()));
                            parameters.put("totalCouple", currencyId + " " +
                                    "" + formatDouble(insurancePolicyItem.getCoverage().getCoverAmount().doubleValue()));
                            parameters.put("totalSon14to24", currencyId + " " +
                                    "" + formatDouble(insurancePolicyItem.getCoverage().getCoverAmount().doubleValue()));
                        } else {
                            parameters.put("totalMainMember", "");
                            parameters.put("totalCouple", "");
                            parameters.put("totalSon14to24", "");
                        }


                        if (insurancePolicyItem.getCurrency() != null && insurancePolicyItem.getCoverage().getChildBenefitSup() != null) {

                            parameters.put("totalSon4to14", currencyId + " " +
                                    "" + formatDouble(insurancePolicyItem.getCoverage().getChildBenefitSup().doubleValue()));
                        } else {
                            parameters.put("totalSon4to14", "");
                        }

                        if (insurancePolicyItem.getCurrency() != null && insurancePolicyItem.getCoverage().getChildBenefitMin() != null) {

                            parameters.put("totalSonLessThan4", currencyId + " " +
                                    "" + formatDouble(insurancePolicyItem.getCoverage().getChildBenefitMin().doubleValue()));
                        } else {
                            parameters.put("totalSonLessThan4", "");
                        }

                        if (insurancePolicyItem.getCoverage().getCoverAmount() != null) {
                            parameters.put("premiumPerEmployee", currencyId + " " +
                                    "" + formatDouble(insurancePolicyItem.getCoverage().getPremiumAmount().doubleValue()));
                        } else {
                            parameters.put("premiumPerEmployee", "");
                        }


                    } else {
                        parameters.put("totalMainMember", "");
                        parameters.put("totalCouple", "");
                        parameters.put("totalSon14to24", "");
                        parameters.put("totalSon4to14", "");
                        parameters.put("totalSonLessThan4", "");
                    }


                    parameters.put("totalNewBornDead", insurancePolicyItem.getCurrency().getCurrencyId() + " " + "5000.00");
                    parameters.put("totalExtendedFamily", insurancePolicyItem.getCurrency().getCurrencyId() + " " + "20 000.00");
                    parameters.put("totalOtherDependents", insurancePolicyItem.getCurrency().getCurrencyId() + " " + "20 000.00");
                    parameters.put("dailyBeneficiary", "");
                    parameters.put("optionCover", "");

                    parameters.put("maritalStatus", "");
                    parameters.put("address", isNull(insurancePolicyItem.getPolicyHolder().getAddress()));
                    if (insurancePolicyItem.getExpiryDate() != null) {
                        parameters.put("renewDate", formatDate(insurancePolicyItem.getExpiryDate(), SIMPLE_DATE_PATTERN));
                        parameters.put("expiryDate", isNull(formatDate(insurancePolicyItem.getExpiryDate(), SIMPLE_DATE_PATTERN)));
                    } else {
                        parameters.put("renewDate", "");
                        parameters.put("expiryDate", "");
                    }



                    parameters.put("monthlyPayment", "");
                    parameters.put("issueDate", isNull(formatDate(insurancePolicyItem.getIssueDate(), SIMPLE_DATE_PATTERN)));




                    if (insurancePolicyItem.getSubProduct().getName() != null) {
                        parameters.put("coverageDesc", insurancePolicyItem.getSubProduct().getDescription());
                    }
                    parameters.put("nuit", isNull(insurancePolicyItem.getPolicyHolder().getVat()));



                    parameters.put("fireAndDanger", "");
                    parameters.put("fireAndDangerValue", "");
                    parameters.put("lastUpdate", formatDate(today(), SIMPLE_DATE_PATTERN));




                    List<String> nearFamily;
                    LOGGER.info("Setting beneficiaries");
                    if (insurancePolicyItem.getSubProduct().getProduct().getProductId().equals(Products.LIFE.toString())) {
                        nearFamily = Arrays.asList(
                                Relationships.SON.getRelationship(),
                                Relationships.DAUGHTER.getRelationship(),
                                Relationships.MOTHER.getRelationship(),
                                Relationships.FATHER.getRelationship(),
                                Relationships.FATHER_IN_LAW.getRelationship(),
                                Relationships.MOTHER_IN_LAW.getRelationship(),
                                Relationships.OTHER.getRelationship(),
                                Relationships.SPOUSE.getRelationship());
                    } else {

                        nearFamily = Arrays.asList(
                                Relationships.SON.getRelationship(),
                                Relationships.DAUGHTER.getRelationship(),
                                Relationships.MOTHER.getRelationship(),
                                Relationships.FATHER.getRelationship(),
                                Relationships.FATHER_IN_LAW.getRelationship(),
                                Relationships.MOTHER_IN_LAW.getRelationship(),
                                Relationships.SPOUSE.getRelationship());
                    }


                    List<Beneficiaries> nearBeneficiaries = beneficiariesInterface.findByRelationship(insurancePolicyItem, nearFamily, setActive());

                    List<Members> members = new ArrayList<>();
                    int counter = 0;
                    for (Beneficiaries n : nearBeneficiaries) {
                        counter++;
                        Members m = new Members();
                        m.setName(counter + "." + n.getName());
                        Optional<RelationShip> relationships = relationshipInterface.findByRelationShipId(n.getRelationShip().getRelationShipId());
                        if (relationships.isPresent()) {
                            m.setRelationShip(relationships.get().getDescription());
                        } else {
                            m.setRelationShip("");
                        }

                        m.setDocumentId(isNull(n.getDocumentNumber()));




                        members.add(m);

                    }

                    List<ReportFieldMap> reportFieldMaps = reportFieldMapInterface.findBySubProductAndStatus(
                            insurancePolicyItem.getSubProduct(), setActive()
                    );

                    for (ReportFieldMap rfm : reportFieldMaps) {
                        //  LOGGER.info("Setting parameter {} to {}",rfm.getFieldId(),rfm.getFieldValue());
                        parameters.put(rfm.getFieldId(), rfm.getFieldValue());
                    }



                    Pageable top = PageRequest.of(0, 1);
                    List<InsurancePolicyHistory> history = insurancePolicyHistoryInterface.getFirstInsurancePolicy(insurancePolicyItem, top);

                    if (history.size() > 0) {
                        parameters.put("description", isNull(history.get(0).getChangeDescription()));
                    } else {
                        parameters.put("description", isNull(""));
                    }


                    if (insurancePolicyItem.getCoverageType() != null) {
                        parameters.put("coverageType", isNull(insurancePolicyItem.getCoverageType().getDescription()));
                        parameters.put("coverageTypeItem", "");
                    } else {
                        parameters.put("coverageType", "- Morte");
                        parameters.put("coverageTypeItem", "- Invalidez e Permanente");
                    }

                    JRBeanCollectionDataSource itemsJRBean = new JRBeanCollectionDataSource(members);
                    parameters.put("CollectionBeanParam", itemsJRBean);

                    List<String> otherFamily = Collections.singletonList(Relationships.OTHER.getRelationship());

                    List<Beneficiaries> otherBeneficiaries = beneficiariesInterface.findByRelationship(insurancePolicyItem, otherFamily, setActive());
               /* if(insurancePolicyItem.getInsuredAmount()!=null){
                    parameters.put("baseInsured", currencyId+" "+ formatDouble(insurancePolicyItem.getInsuredAmount().doubleValue()));
                }
                else{
                if(insurancePolicyItem.getSubProduct().getProduct().getProductId().equals(Products.FUNERAL.toString())){
                    parameters.put("baseInsured", String.valueOf(nearBeneficiaries.size()+1));
                    parameters.put("baseExtras", String.valueOf(otherBeneficiaries.size()));
                }
                else{
                    if(insurancePolicyItem.getCoverage()!=null) {
                        if (insurancePolicyItem.getCoverage().getCoverAmount() != null) {
                            parameters.put("baseInsured",currencyId+" "+ formatDouble(insurancePolicyItem.getCoverage().getCoverAmount().doubleValue()));
                        } else {
                            parameters.put("baseInsured", currencyId+" "+formatDouble(benBaseAmount));
                        }
                    }
                    parameters.put("baseExtras", isNull(""));
                }
                }*/
                    parameters.put("baseInsured", String.valueOf(nearBeneficiaries.size() + 1));
                    parameters.put("baseExtras", String.valueOf(otherBeneficiaries.size()));


                    List<Members> otherMembers = new ArrayList<>();
                    counter = 0;
                    for (Beneficiaries n : otherBeneficiaries) {
                        counter++;
                        Members m = new Members();
                        m.setName(counter + "." + n.getName());
                        Optional<RelationShip> relationships = relationshipInterface.findByRelationShipId(n.getRelationShip().getRelationShipId());
                        if (relationships.isPresent()) {
                            m.setRelationShip(relationships.get().getDescription());
                        } else {
                            m.setRelationShip("");
                        }




                        m.setDocumentId(isNull(n.getDocumentNumber()));
                        otherMembers.add(m);

                    }

                    LOGGER.info("Compiling report ...");
                    JRBeanCollectionDataSource itemsOtherJRBean = new JRBeanCollectionDataSource(otherMembers);
                    parameters.put("CollectionBeanOther", itemsOtherJRBean);

                    JasperReport jasperReport = JasperCompileManager.compileReport(FileUtil.BASE_DIRECTORY + File.separator + TEMPLATE_DIR + File.separator + templateName);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

                    jasperPrint.setOrientation(OrientationEnum.LANDSCAPE);
                    JasperExportManager.exportReportToPdfFile(jasperPrint, reportDir + File.separator + fileName);
                    LOGGER.info("Report Successfully Generated");


                    DocumentFile documentFile = new DocumentFile();
                    documentFile.setFileType(FileTypes.ATTACHMENT.toString());
                    documentFile.setCreatedBy(setUser(reportRequest.getUsername()));
                    documentFile.setCreatedDate(today());
                    documentFile.setRecordType(insurancePolicyItem.getRecordType());
                    documentFile.setObjectId(reportRequest.getPolicyId());


                    List<DocumentType> documentType = documentTypeInterface.findByFileType(fileType);

                    if (documentType.size() > 0) {
                        documentFile.setDocumentType(documentType.get(0));
                    } else {
                        LOGGER.info("DocumentType with fileType {} not found", fileType);
                    }

                    documentFile.setTitle(fileName);
                    documentFile.setInputter(reportRequest.getUsername());
                    documentFile.setUrl(File.separator + REPORT_DIR + File.separator + QUOTATION_DIR +
                            File.separator + formatDate(today(), SIMPLE_DATE_PATTERN) + File.separator + fileName);
                    documentFile.setDescription(fileName);

                    return documentFile;

                } else {
                    LOGGER.info("Policy {} not found", reportRequest.getPolicyId());
                }
            }
            catch (Exception e) {
                LOGGER.error(e);
            }


            return null;


    }


    @GET
    @Path("/collection-data-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCollectionData(@QueryParam("startDate") String startDate,
                                @QueryParam("endDate") String endDate,
                                @QueryParam("subProductId") String subProductId,
                                @QueryParam("productId") String productId,
                                @QueryParam("sessionId") String sessionId,
                                @QueryParam("username") String username,
                                @QueryParam("statusId") String statusId,
                                @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getPolicies";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. " +
                        "startDate -> {}, endDate -> {}, productId -> {}, subProductId -> {}, statusId ->{} " +
                        "username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate,endDate,productId,subProductId,statusId, username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<PaymentLog> paymentLogs = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {

            if(statusId.equalsIgnoreCase(RequestParams.ALL.toString())) {


                    Date sd = stringToDateTime(startDate);
                    Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);

                    if(!subProductId.equalsIgnoreCase(RequestParams.ALL.toString())){
                        LOGGER.info("Searching for single subProduct and all statuses");
                        paymentLogs = paymentLogInterface.findBySubProduct(setSubProduct(Long.parseLong(subProductId)), sd, ed);
                    }
                    else{
                        LOGGER.info("Searching for all subProducts and all statuses");
                        paymentLogs = paymentLogInterface.findByProduct(setProduct(productId), sd, ed);
                    }


              //  }
            }
            else{


                    Date sd = stringToDateTime(startDate);
                    Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
                    if(!subProductId.equalsIgnoreCase(RequestParams.ALL.toString())) {
                        LOGGER.info("Searching for single subProduct and single status");
                        paymentLogs = paymentLogInterface.findBySubProduct(setSubProduct(Long.parseLong(subProductId)), sd, ed, statusId);
                    }
                    else {
                        LOGGER.info("Searching for all subProducts and single status");
                        paymentLogs = paymentLogInterface.findByProduct(setProduct(productId), sd, ed, statusId);
                    }

            }

            LOGGER.info("PaymentLogs returned -> {}",paymentLogs.size());

            response = Response.status(Response.Status.OK).entity(paymentLogs).build();
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        LOGGER.debug("Response {}, Response Id = {}", paymentLogs.size(), reqRes);
        getDelay(LOGGER,requestTime,reqRes);
        return response;

    }


    @GET
    @Path("/notification-data-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotificationData(@QueryParam("startDate") String startDate,
                                      @QueryParam("endDate") String endDate,
                                      @QueryParam("mobileEmail") String mobileNumber,
                                      @QueryParam("sessionId") String sessionId,
                                      @QueryParam("username") String username,
                                      @QueryParam("limit") int limit,
                                      @QueryParam("statusId") String statusId,
                                      @QueryParam("channel") String channelId,
                                      @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getNotificationData";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. " +
                        "startDate -> {}, endDate -> {}, mobileNumber -> {}, statusId ->{}, limit -> {}, channel ->{} " +
                        "username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate,endDate,mobileNumber,statusId,limit,channelId, username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Notification> notifications;
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            Pageable top = PageRequest.of(0, limit);

            if(statusId.equalsIgnoreCase(RequestParams.ALL.toString())) {
                if(mobileNumber.equalsIgnoreCase(RequestParams.ALL.toString())){
                    LOGGER.info("Searching with ALL statuses");
                    notifications = notificationInterface.findByNotification(sd, ed,channelId, top);

                }
                else {
                    if(isNumber(mobileNumber)) {
                        LOGGER.info("Searching by Mobile Number");
                        notifications = notificationInterface.findByNotification(sd, ed, mobileNumber,channelId, top);
                    }
                    else {
                        LOGGER.info("Searching by email");
                        notifications = notificationInterface.findByNotificationByEmail(sd, ed, mobileNumber,channelId, top);
                    }
                }
            }
            else{
                if(!mobileNumber.equalsIgnoreCase(RequestParams.ALL.toString())){
                    if(isNumber(mobileNumber)) {
                        LOGGER.info("Searching by Mobile Number and status");
                        notifications = notificationInterface.findByNotification(sd, ed, mobileNumber, channelId,top);
                    }
                    else {
                        LOGGER.info("Searching by email Number and status");
                        notifications = notificationInterface.findByNotificationByStatusAndEmail(sd, ed, mobileNumber,channelId, top);
                    }
                }
                else {
                    LOGGER.info("Searching with status {}",statusId);
                    notifications = notificationInterface.findByNotificationStatus(sd,ed,statusId,channelId,top);

                }
            }

            defaultSuccess(LOGGER,reqRes);
            LOGGER.info(notifications.size());
            response = Response.status(Response.Status.OK).entity(notifications).build();
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
    @Path("/commission-data-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommissionData(@QueryParam("startDate") String startDate,
                                      @QueryParam("endDate") String endDate,
                                      @QueryParam("subProductId") String subProductId,
                                      @QueryParam("productId") String productId,
                                      @QueryParam("sessionId") String sessionId,
                                      @QueryParam("username") String username,
                                      @QueryParam("resultType") String resultType,
                                      @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getCommissionData";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. " +
                        "startDate -> {}, endDate -> {}, productId -> {}, subProductId -> {},resultType -> {}, " +
                        "username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate,endDate,productId,subProductId, resultType,username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Object[]> paymentSchedules;
        boolean queryExecuted = false;
        String errorCause = "";

        try {
                Date sd = stringToDateTime(startDate);
                Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
                if(!subProductId.equalsIgnoreCase(RequestParams.ALL.toString())) {
                    LOGGER.info("Searching for single subProduct");
                    paymentSchedules = paymentScheduleInterface.getCollectionsByInterval(formatDate(sd,DATABASE_DATE_PATTERN),formatDate(ed,DATABASE_DATE_PATTERN),setStatus(Statuses.PAID.toString()), Long.valueOf(subProductId));
                }
                else {
                    LOGGER.info("Searching for all subProducts");
                    paymentSchedules = paymentScheduleInterface.getCollectionsByInterval(formatDate(sd,DATABASE_DATE_PATTERN),formatDate(ed,DATABASE_DATE_PATTERN),productId,Statuses.PAID.toString());

                }
            List<CommissionResponse> commissionResponses =  new ArrayList<>();
                LOGGER.info("PaymentSchedules {}",paymentSchedules.size());

            List<Object[]> commissionMap;
            int counter = 0;

            for (Object[] o: paymentSchedules) {
                LOGGER.info("Getting commissions for payments. {} of {}",counter++,paymentSchedules.size());
                CommissionResponse commissionResponse = new CommissionResponse();

                try {

                    BigDecimal spId = (BigDecimal) o[0];
                    BigDecimal totalChargeableDependents = (BigDecimal) o[1];
                    BigDecimal coverageId = (BigDecimal) o[2];

                    InsurancePolicy insurancePolicy = new InsurancePolicy();
                    insurancePolicy.setPolicyId((String) o[3]);
                    BigDecimal totalAmount = (BigDecimal) o[8];
                    insurancePolicy.setTotalAmount(totalAmount);
                    BigDecimal insuredCapital = (BigDecimal) o[17];


                    BigDecimal coverAmount = (BigDecimal) o[19];
                    BigDecimal annualPayroll = (BigDecimal) o[20];

                    String currencyId = (String) o[9];
                    insurancePolicy.setCurrency(setCurrency(currencyId));

                    commissionResponse.setSubProductName((String) o[4]);
                    commissionResponse.setCustomerId((String) o[5]);
                    commissionResponse.setCustomerName((String) o[6]);
                    commissionResponse.setAccountNumber((String) o[7]);
                    commissionResponse.setTransactionId((String) o[10]);
                    commissionResponse.setInsurancePolicy(insurancePolicy);
                    commissionResponse.setCoverAmount(coverAmount);
                    commissionResponse.setAnnualPayroll(annualPayroll);

                    BigDecimal hasChargeableDependent = (BigDecimal) o[11];
                    BigDecimal hasStampDuty = (BigDecimal) o[12];
                    String productDescription = (String) o[13];
                    BigDecimal numberOfEmployees = (BigDecimal) o[14];
                    commissionResponse.setProductName(productDescription);

                    if (hasStampDuty.intValue() == 1)
                        commissionResponse.setHasStampDuty(true);


                    if (hasChargeableDependent.intValue() == 1) {
                        commissionResponse.setHasChargeableDependents(true);
                        int chargeable = 1;
                        if (totalChargeableDependents != null) {
                            chargeable = totalChargeableDependents.intValue();
                        }
                        commissionMap = commissionMapInterface.findByChargeableDependents(chargeable,
                                spId.longValue(), setActive(), coverageId.longValue());

                    } else {
                        commissionResponse.setHasChargeableDependents(false);
                        commissionMap = commissionMapInterface.findCommissionBySubProduct(spId.longValue(), setActive());
                    }


                    if (commissionMap.size() > 0) {
                        int chargeableDependents = (int) commissionMap.get(0)[0];
                        commissionResponse.setChargeableDependents(chargeableDependents);
                        commissionResponse.setNetCommissionPercentage((Double) commissionMap.get(0)[1]);
                        commissionResponse.setCustomFee((Double) commissionMap.get(0)[2]);
                        commissionResponse.setInsurerPremium(((BigDecimal) commissionMap.get(0)[3]).doubleValue());
                        commissionResponse.setNetGPIRatio((Double) commissionMap.get(0)[4]);
                        commissionResponse.setSpecialCommission((Boolean) commissionMap.get(0)[5]);
                        commissionResponse.setNumberOfEmployees(numberOfEmployees);
                        commissionResponse.setSubProductId(spId);
                        commissionResponse.setProductId((String) o[15]);
                        commissionResponse.setSbFee((BigDecimal) commissionMap.get(0)[6]);
                        commissionResponse.setAttributes((String) o[16]);
                    }
                    if(totalChargeableDependents!=null) {
                        commissionResponse.setTotalChargeableDependents(totalChargeableDependents.intValue());
                    }

                    commissionResponses.add(commissionResponse);
                }
                catch (Exception e){
                    LOGGER.error(e);
                }


            }

            defaultSuccess(LOGGER,reqRes);
            if(resultType.equalsIgnoreCase(ResultTypes.PREVIEW.toString())){

                response = Response.status(Response.Status.OK).entity(commissionResponses).build();
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
        getDelay(LOGGER,requestTime,reqRes);
        return response;

    }


    @GET
    @Path("/commission-data-list/consolidated")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommissionData(@QueryParam("startDate") String startDate,
                                      @QueryParam("endDate") String endDate,
                                      @QueryParam("productId") String productId,
                                      @QueryParam("sessionId") String sessionId,
                                      @QueryParam("username") String username,
                                      @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getConsolidatedCommissionData";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. " +
                        "startDate -> {}, endDate -> {}, productId -> {}, " +
                        "username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate,endDate,productId,username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        BigDecimal grossPremium;
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);

            LOGGER.info("Searching for all subProducts");
            grossPremium = paymentScheduleInterface.getTotalCollectionsByInterval(formatDate(sd,DATABASE_DATE_PATTERN),formatDate(ed,DATABASE_DATE_PATTERN),productId,Statuses.PAID.toString());
            CommissionResponse commissionResponse =  new CommissionResponse();

            List<Object[]> commissionMap = commissionMapInterface.findByChargeableDependents(setActive(),productId);
            if(commissionMap!=null) {
                if (commissionMap.size() > 0) {

                    Double netCommissionPercentage = (Double) commissionMap.get(0)[0];
                    Double netGPIRatio = (Double) commissionMap.get(0)[1];

                    if(netCommissionPercentage!=null && grossPremium!=null) {
                        double stampDuty = grossPremium.doubleValue() / netGPIRatio;
                        double STBCommission = (stampDuty * netCommissionPercentage) / 100;
                        double netPremium =grossPremium.doubleValue() - STBCommission;

                        commissionResponse.setStbCommission(STBCommission);
                        commissionResponse.setStampDuty(stampDuty);
                        commissionResponse.setNetPremium(netPremium);
                        commissionResponse.setGroupPremium(grossPremium.doubleValue());

                    }
                    else {
                        LOGGER.info("Total premium is null");
                    }

                }
                else {
                    LOGGER.info("CommissionMap found for {} is null",productId);
                }
            }
            else {
                LOGGER.info("No commissionMap found for {}",productId);
            }

            defaultSuccess(LOGGER,reqRes);
            response = Response.status(Response.Status.OK).entity(commissionResponse).build();
            queryExecuted = true;

        } catch (Exception e) {
            LOGGER.error(e);
            
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        getDelay(LOGGER,requestTime,reqRes);
        return response;

    }




    @GET
    @Path("/collection-data-list/v2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCollectionDataV2(@QueryParam("startDate") String startDate,
                                        @QueryParam("endDate") String endDate,
                                      @QueryParam("subProductId") String subProductId,
                                      @QueryParam("productId") String productId,
                                      @QueryParam("policyId") String policyId,
                                      @QueryParam("limit") int limit,
                                      @QueryParam("sessionId") String sessionId,
                                      @QueryParam("resultType") String resultType,
                                      @QueryParam("username") String username,
                                      @QueryParam("statusId") String statusId,
                                      @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getCollectionDataV2";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. " +
                        "startDate -> {}, endDate -> {}, productId -> {}, subProductId -> {}, statusId ->{} " +
                        "policyId ->{}, resultType ->{}. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate,endDate,productId,subProductId,statusId,policyId,resultType, username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";
        List<Object[]> paymentLogObject;

        try {
            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            Pageable top = PageRequest.of(0, limit);

            String startDateString = formatDate(sd,DATABASE_DATE_PATTERN);
            String endDateString = formatDate(ed,DATABASE_DATE_PATTERN);


            if(!policyId.equalsIgnoreCase(RequestParams.ALL.toString())){
                paymentLogObject =  paymentLogInterface.findByPolicyId(policyId,startDateString,endDateString,top);
                return Response.status(Response.Status.OK).entity(paymentLogObject).build();

            }

            if(subProductId.equalsIgnoreCase(RequestParams.ALL.toString())) {

                if(statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    LOGGER.info("Searching by ALL Statuses and Product");
                   // paymentLogs = paymentLogInterface.findByProduct(setProduct(productId), sd,ed,top);
                    paymentLogObject = paymentLogInterface.findByProduct(productId, startDateString, endDateString,top);
                }
                else {
                    LOGGER.info("Searching by Single Status and Product");
                    paymentLogObject = paymentLogInterface.findByProduct(productId, startDateString, endDateString,statusId,top);
                }

            }
            else{


                if(statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    LOGGER.info("Searching by ALL Statuses and SubProduct");
                    paymentLogObject = paymentLogInterface.findBySubProduct(Long.parseLong(subProductId), startDateString, endDateString,top);
                }
                else{
                    LOGGER.info("Searching by Single Status and SubProduct");
                    paymentLogObject = paymentLogInterface.findBySubProduct(Long.parseLong(subProductId),startDateString, endDateString,statusId,top);
                }


            }
            defaultSuccess(LOGGER,reqRes);
            if(resultType.equalsIgnoreCase(ResultTypes.PREVIEW.toString())){
                response = Response.status(Response.Status.OK).entity(paymentLogObject).build();
            }
            else{
                response = buildPaymentFileForDownload(paymentLogObject,username);
            }

            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e);
            
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId,ipAddress));
        }
        getDelay(LOGGER,requestTime,reqRes);
        return response;

    }


    @GET
    @Path("/policies-list/cancellation")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCancelledPolicies(@QueryParam("startDate") String startDate,
                                  @QueryParam("endDate") String endDate,
                                  @QueryParam("subProductId") String subProductId,
                                  @QueryParam("productId") String productId,
                                  @QueryParam("sessionId") String sessionId,
                                  @QueryParam("username") String username,
                                  @QueryParam("limit") int limit,
                                  @QueryParam("offset") int offset,
                                  @QueryParam("policyId") String policyId,
                                  @QueryParam("recordType") String recordType,
                                  @QueryParam("resultType") String resultType,
                                  @QueryParam("accountNumber") String accountNumber,
                                  @QueryParam("cif") String cif,
                                  @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "getCancelledPolicies";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. startDate -> {}, endDate -> {}, subProductId -> {}, productId ->{}," +
                        " limit -> {}, offset -> {},accountNumber -> {}, cif -> {}, username -> {},  sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,startDate,endDate,subProductId,productId,limit,offset,accountNumber,cif,username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<InsurancePolicy> insurancePolicies = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";


        try {

            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);
            Pageable top = PageRequest.of(0, limit);
            String statusId = "CANCELLED";


            if(!policyId.equalsIgnoreCase(RequestParams.ALL.toString())){
                Optional<InsurancePolicy> ip = insurancePolicyInterface.findByPolicyId(policyId);
                if(ip.isPresent()){
                    LOGGER.info("Searching by policy id");
                    insurancePolicies.add(ip.get());
                    return Response.status(Response.Status.OK).entity(insurancePolicies).build();
                }
            }


            if(subProductId.equalsIgnoreCase(RequestParams.ALL.toString())) {

                if(statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    LOGGER.info("Searching by ALL Statuses and Product");
                    insurancePolicies = insurancePolicyInterface.findByDateIntervalCancel(sd,ed,setProduct(productId),top);
                }
                else {
                    LOGGER.info("Searching by Single Status and Product");
                    insurancePolicies = insurancePolicyInterface.findByDateIntervalCancel(sd,ed,setProduct(productId),setStatus(statusId),top);
                }

            }
            else{


                if(statusId.equalsIgnoreCase(RequestParams.ALL.toString())){
                    LOGGER.info("Searching by ALL Statuses and SubProduct");
                    insurancePolicies = insurancePolicyInterface.findByDateIntervalCancel(sd,ed,setSubProduct(Long.parseLong(subProductId)),top);
                }
                else{
                    LOGGER.info("Searching by Single Status and SubProduct");
                    insurancePolicies = insurancePolicyInterface.findByDateIntervalCancel(sd,ed,setStatus(statusId),
                            setSubProduct(Long.parseLong(subProductId)),top);
                }


            }


            List<InsuranceCancellationResponse> cancellationReport = insurancePolicies.stream().map(ip -> {
                InsuranceCancellationResponse insuranceCancellationResponse = new InsuranceCancellationResponse();

                List<InsurancePolicyHistory> insurancePolicyHistory = insurancePolicyHistoryInterface
                        .findByProcessActionAndInsurancePolicy(setProcessAction(CANCEL.toString()),ip);

                 insuranceCancellationResponse.setInsurancePolicy(ip);
                 if(insurancePolicyHistory.size()>0)
                     insuranceCancellationResponse.setInsurancePolicyHistory(insurancePolicyHistory.get(0));

                return insuranceCancellationResponse;
            }).collect(Collectors.toList());

            if(resultType.equalsIgnoreCase(ResultTypes.PREVIEW.toString())){
                LOGGER.info("{} returned {} results",methodName,insurancePolicies.size());
                response = Response.status(Response.Status.OK).entity(cancellationReport).build();
            }
            else{
                response = buildCancellationFileForDownload(cancellationReport,username);
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


    private Response buildCancellationFileForDownload(List<InsuranceCancellationResponse> insuranceCancellationResponses,String username) throws Exception {
        ReportResponse reportResponse = new ReportResponse();


        LOGGER.info("Building file for download ...");
        String[] columns = { "Número de apólice", "Sub Produto", "Nome do cliente",
                 "Data de Nascimento","Número de Conta" ,"Moeda", "Balcão","Data do cancelamento", "Prémio", "Data da criação", "Data de início",
                "Tipo de cancelamento", "Processo QMS", "Utilizador que criou", "Estado","Motivo de cancelamento","Narrativa"};


        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Apólices");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;

        for (InsuranceCancellationResponse icp : insuranceCancellationResponses) {
            InsurancePolicy ip = icp.getInsurancePolicy();
            InsurancePolicyHistory iph = icp.getInsurancePolicyHistory();

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(ip.getPolicyId());
            if(ip.getSubProduct()!=null){
                row.createCell(1).setCellValue(ip.getSubProduct().getName());
            }
            else {
                row.createCell(1).setCellValue("");
            }
            if (ip.getPolicyHolder()!=null){
                row.createCell(2).setCellValue(ip.getPolicyHolder().getCustomerName());
            }
            else{
                row.createCell(2).setCellValue("");
            }

            if (ip.getPolicyHolder()!=null){
                try {
                    row.createCell(3).setCellValue(formatDate(ip.getPolicyHolder().getDateOfBirth(), SIMPLE_DATE_PATTERN));
                }
                catch (Exception e){
                    
                    LOGGER.error(e);
                    row.createCell(3).setCellValue("");
                 }
                }
            else{
                row.createCell(3).setCellValue("");
            }


            if(ip.getPolicyHolder()!=null){
                row.createCell(4).setCellValue(ip.getPolicyHolder().getAccountNumber());
            }
            else {
                row.createCell(4).setCellValue("");
            }

            if(ip.getCurrency()!=null){
                row.createCell(5).setCellValue(ip.getCurrency().getCurrencyId());
            }
            else {
                row.createCell(5).setCellValue("");
            }



            if(iph!=null) {
                if (iph.getDepartment() != null) {
                    row.createCell(6).setCellValue(iph.getDepartment().getName());
                } else {
                    row.createCell(6).setCellValue("");
                }
            }
            else {
                row.createCell(6).setCellValue("");
            }


            if(iph!=null) {
                if (iph.getCreatedDate() != null) {
                    try {
                        row.createCell(7).setCellValue(formatDate(iph.getCreatedDate(), SIMPLE_DATE_PATTERN));
                    } catch (Exception e) {
                        
                        LOGGER.error(e);
                        row.createCell(7).setCellValue("");
                    }
                } else {
                    row.createCell(7).setCellValue("");
                }
            }
            else {
                row.createCell(7).setCellValue("");
            }

            if(ip.getTotalAmount()!=null){
                row.createCell(8).setCellValue(Util.formatDouble(ip.getTotalAmount().doubleValue()));
            }
            else {
                row.createCell(8).setCellValue("");
            }

            if(ip.getCreatedDate()!=null){
                try{
                    row.createCell(9).setCellValue(CoreUtil.formatDate(ip.getCreatedDate(),DATETIME_PATTERN));
                }
                catch (Exception e) {
                
                LOGGER.error(e);
                row.createCell(9).setCellValue("");
            }
            }
            else {
                row.createCell(9).setCellValue("");
            }


            if(ip.getStartDate()!=null){
                try{
                row.createCell(10).setCellValue(CoreUtil.formatDate(ip.getStartDate(),DATETIME_PATTERN));
                }
                catch (Exception e) {
                    
                    LOGGER.error(e);
                    row.createCell(10).setCellValue("");
                }
                }
            else {
                row.createCell(10).setCellValue("");
            }

            try{
                if(iph!=null) {
                    if (iph.getUsers() == null) {
                        row.createCell(11).setCellValue("Automático");
                    } else if (iph.getUsers().getUserId().equals(getSystemUser().getUserId())) {
                        row.createCell(11).setCellValue("Automático");
                    } else {
                        row.createCell(11).setCellValue("Manual");
                    }
                }
                else {
                    row.createCell(11).setCellValue("Manual");
                }

            }
            catch (Exception e){

                row.createCell(11).setCellValue("Manual");
            }

            if(iph!=null) {
                row.createCell(12).setCellValue(iph.getProcessId());
            }
            else {
                row.createCell(12).setCellValue("");
            }
            if (ip.getUsers() != null) {
                row.createCell(13).setCellValue(ip.getUsers().getUserId());

            }
            else{
                row.createCell(13).setCellValue("");
            }

            row.createCell(14).setCellValue(ip.getStatus().getDescription());
            if(iph!=null) {
                row.createCell(15).setCellValue(iph.getChangeDescription());
                row.createCell(16).setCellValue(iph.getNarrative());
            }
            else {
                row.createCell(15).setCellValue("");
                row.createCell(16).setCellValue("");
            }
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        String baseDir = FileUtil.BASE_DIRECTORY+ File.separator + REPORT_DIR+ File.separator+ EXPORT_DIR+ File.separator+ formatDate(today(),SIMPLE_DATE_PATTERN);
        String reportDir = baseDir + File.separator+username;
        File newDir = new File(baseDir);
        if (!newDir.exists()){
            LOGGER.info("Attempting to create base folder {}",baseDir);
            if(newDir.mkdir()){
                LOGGER.info("Folder {} created",baseDir);
            }

        }

        File expDir = new File(reportDir);
        if (!expDir.exists()){
            LOGGER.info("Attempting to create export folder {}",reportDir);
            if(expDir.mkdir()){
                LOGGER.info("Folder {} created",expDir);
            }

        }
        // Write the output to a file
        String dateFormatted = formatDate(today(),TIMESTAMP_PATTERN);
        String url = reportDir+ File.separator + "Apolices_"+dateFormatted+".xlsx";
        FileOutputStream fileOut = new FileOutputStream(url);
        workbook.write(fileOut);
        fileOut.close();

        String shortUrl = File.separator +REPORT_DIR+ File.separator+ EXPORT_DIR+ File.separator+ formatDate(today(),SIMPLE_DATE_PATTERN)+File.separator+username+File.separator + "Apolices_"+dateFormatted+".xlsx";
        LOGGER.info("File saved in path {}",url);

        reportResponse.setFile(FileUtil.toBase64( shortUrl));
        reportResponse.setFileName("Apolices Canceladas_"+dateFormatted+".xlsx");

        return Response.status(Response.Status.OK).entity(reportResponse).build();


    }



    private Response buildRenewalFileForDownload(List<Object[]> renewalsList,String username) throws Exception {
        ReportResponse reportResponse = new ReportResponse();


        LOGGER.info("Building file for download ...");
        String[] columns = { "Número de apólice", "Sub Produto", "Nome do cliente","CIF",
                "Número de Conta" ,"Moeda",  "Prémio", "Data da criação", "Data de início",
                "Data de expiração",  "Utilizador que criou"};


        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Apólices");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        int rowNum = 1;

        for (Object[] ip : renewalsList) {
            LOGGER.info("Looping in {} of {}",rowNum,renewalsList.size());


            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue((String) ip[0]);
            row.createCell(1).setCellValue((String) ip[1]);
            row.createCell(2).setCellValue((String) ip[2]);
            row.createCell(3).setCellValue((String) ip[3]);
            row.createCell(4).setCellValue((String)ip[4]);
            row.createCell(5).setCellValue((String)ip[5]);
            BigDecimal premium = (BigDecimal) ip[6];
            row.createCell(6).setCellValue(formatDouble (premium.doubleValue()));
            row.createCell(7).setCellValue(formatDate((Date) ip[7], SIMPLE_DATE_PATTERN));
            row.createCell(8).setCellValue(formatDate((Date) ip[8], SIMPLE_DATE_PATTERN));
            row.createCell(9).setCellValue(formatDate((Date) ip[9], SIMPLE_DATE_PATTERN));

            row.createCell(10).setCellValue((String)ip[10]);
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        String baseDir = FileUtil.BASE_DIRECTORY+ File.separator + REPORT_DIR+ File.separator+ EXPORT_DIR+ File.separator+ formatDate(today(),SIMPLE_DATE_PATTERN);
        String reportDir = baseDir + File.separator+username;
        File newDir = new File(baseDir);
        if (!newDir.exists()){
            LOGGER.info("Attempting to create base folder {}",baseDir);
            if(newDir.mkdir()){
                LOGGER.info("Folder {} created",baseDir);
            }

        }

        File expDir = new File(reportDir);
        if (!expDir.exists()){
            LOGGER.info("Attempting to create export folder {}",reportDir);
            if(expDir.mkdir()){
                LOGGER.info("Folder {} created",expDir);
            }

        }
        // Write the output to a file
        String dateFormatted = formatDate(today(),TIMESTAMP_PATTERN);
        String url = reportDir+ File.separator + "Apolices_por_renovar"+dateFormatted+".xlsx";
        FileOutputStream fileOut = new FileOutputStream(url);
        workbook.write(fileOut);
        fileOut.close();

        String shortUrl = File.separator +REPORT_DIR+ File.separator+ EXPORT_DIR+ File.separator+ formatDate(today(),SIMPLE_DATE_PATTERN)+File.separator+username+File.separator + "Apolices_por_renovar"+dateFormatted+".xlsx";
        LOGGER.info("File saved in path {}",url);

        reportResponse.setFile(FileUtil.toBase64( shortUrl));
        reportResponse.setFileName("Apolices_por_renovar_"+dateFormatted+".xlsx");

        return Response.status(Response.Status.OK).entity(reportResponse).build();


    }




}
