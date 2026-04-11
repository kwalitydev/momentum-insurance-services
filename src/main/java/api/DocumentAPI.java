package api;


import core.beans.JSONRequest;
import core.beans.JSONResponse;
import core.beans.ReportResponse;
import core.util.CoreUtil;
import core.util.FileUtil;
import core.util.QueryUtil;
import dao.entities.DocumentFile;
import dao.entities.DocumentType;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
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

import static core.util.CoreUtil.*;

@Path("/documents")
@ApplicationScoped
public class DocumentAPI {
    private static final Logger LOGGER = LogManager.getLogger(DocumentAPI.class);
    @Inject
    private DocumentTypeInterface documentTypeInterface;
    @Inject
    private DocumentFileInterface documentFileInterface;
    @Inject
    private QueryUtil queryUtil;


    @GET
    @Path("/file-types/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFileType(@QueryParam("fileType") String fileType,
                                @QueryParam("username") String username,
                                @QueryParam("sessionId") String sessionId,
                                @Context HttpServletRequest headers) {

        String logId = getLogId();
        LOGGER.info("getFileType webservice is being called with parameters. Request {}, traceId -> {}, Ip Address = {} ", fileType, logId, headers.getRemoteAddr());
        try {
                List<DocumentType> documentType = documentTypeInterface.findByFileType(fileType);
                defaultSuccess(LOGGER,logId);
                return Response.status(Response.Status.OK).entity(documentType).build();

        }
        catch (Exception e){
            LOGGER.error(logId,e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }


    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPolicyDocuments(@QueryParam("policyId") String policyId,
                                @QueryParam("username") String username,
                                @QueryParam("sessionId") String sessionId,
                                @Context HttpServletRequest headers) {

        String logId = getLogId();
        LOGGER.info("getPolicyDocuments webservice is being called with parameters. Request {policyId = {}}, RequestId -> {}, Ip Address = {} ",
                policyId, logId, headers.getRemoteAddr());

        try {
                List<DocumentFile> documentFiles = documentFileInterface.findByObjectId(policyId);
                defaultSuccess(LOGGER,logId);
                return Response.status(Response.Status.OK).entity(documentFiles).build();

        }
        catch (Exception e){
            LOGGER.info(logId,e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }


    @GET
    @Path("/download")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response downloadDocument(@QueryParam("documentId") Long documentId,
                                  @QueryParam("sessionId") String sessionId,
                                  @QueryParam("username") String username,
                                  @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "downloadDocument";
        LOGGER.info("{} is being called with parameter. documentId -> {}, username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ",
                methodName,documentId,username, sessionId, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {
                ReportResponse reportResponse = new ReportResponse();
                Optional<DocumentFile> documentFile = documentFileInterface.findById(documentId);
                if(documentFile.isPresent()){
                    reportResponse.setFile(FileUtil.toBase64( documentFile.get().getUrl()));
                    reportResponse.setFileName(documentFile.get().getTitle());
                }
                defaultSuccess(LOGGER,headers.getRemoteAddr());
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


    @POST
    @Path("/remove")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response removeDocument(JSONRequest jsonRequest,
                                   @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        Date requestTime = today();
        String methodName = "removeDocument";
        LOGGER.info("{} is being called with parameters. request -> {}, traceId -> {}, ipAddress -> {} ",
                methodName,jsonRequest, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {


            JSONResponse jsonResponse = new JSONResponse();
            Optional<DocumentFile> documentFile = documentFileInterface.findById(Long.parseLong(jsonRequest.getObjectId()));
            if(documentFile.isPresent()){
                documentFileInterface.deleteDocument(documentFile.get().getId());
                jsonResponse.setSuccess(true);
                LOGGER.info("Document successfully removed. id -> {}. traceId -> {}",jsonRequest.getObjectId(),reqRes);
            }
            else{
                jsonResponse.setSuccess(false);
                LOGGER.info("Document not removed. id -> {}. traceId -> {}",jsonRequest.getObjectId(),reqRes);
            }

            response = Response.status(Response.Status.OK).entity(jsonResponse).build();
            defaultSuccess(LOGGER,headers.getRemoteAddr());
            queryExecuted = jsonResponse.isSuccess();

        } catch (Exception e) {
            LOGGER.error(e);
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, jsonRequest.getUsername(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, jsonRequest.getSessionId(), headers.getRemoteAddr()));
        }

        return response;

    }

}
