package api;

import core.beans.*;
import core.constants.Statuses;
import core.util.*;
import dao.entities.*;
import dao.interfaces.*;
import dao.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static core.constants.LoginStatus.FAILED;
import static core.constants.Statuses.ACTIVATING;
import static core.constants.Statuses.ACTIVE;
import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/users")
public class UserAPI {
    private static final Logger LOGGER = LogManager.getLogger(UserAPI.class);
    @Inject
    private UserInterface userInterface;

    @Inject
    private UserRepository repository;
    @Inject
    private RoleInterface roleInterface;
    @Inject
    private UserAttemptInterface userAttemptInterface;
    @Inject
    private SubMenuInterface subMenuInterface;
    @Inject
    private UserDetailsInterface userDetailsInterface;
    @Inject
    private DepartmentInterface departmentInterface;
    @Inject
    private QueryUtil queryUtil;
    @Inject
    private ApplicationInterface applicationInterface;
    @Inject
    private WebserviceInterface webserviceInterface;
    @Inject
    private UserHelper userHelper;

    /**
     * get all status of users
     **/
    @GET
    @Path(STATUS_APP_ENDPOINT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserStatus(@QueryParam("username") String username,
                                  @QueryParam("sessionId") String sessionId, @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getUserStatus";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ", methodName, username, sessionId, reqRes,
                headers.getRemoteAddr());
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Status> statuses = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            statuses = userInterface.findAllStatuses();
            response = Response.status(Response.Status.OK).entity(statuses).build();
            queryExecuted = true;
        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        LOGGER.debug("Response {}, Response Id = {}", statuses, reqRes);
        return response;
    }


    @GET
    @Path("/by-status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByStatus(@QueryParam("username") String username,
                                     @QueryParam("sessionId") String sessionId,
                                     @QueryParam("statusId") String statusId,
                                     @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "getUsersByStatus";
        String ipAddress = headers.getRemoteAddr();
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ", methodName, username, sessionId, reqRes,
                headers.getRemoteAddr());
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();

        boolean queryExecuted = false;
        String errorCause = "";

        try {
            Status status = new Status();
            status.setId(statusId);
            List<Users> users = userInterface.findByStatus(status);
            response = Response.status(Response.Status.OK).entity(users).build();
            queryExecuted = true;
            LOGGER.debug("Response {}, Response Id = {}", users, reqRes);
        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }

        return response;
    }


    @GET
    @Path(ROLE_ENDPOINT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRole(@QueryParam("username") String username,
                            @QueryParam("sessionId") String sessionId,
                            @Context HttpServletRequest headers) {


        String reqRes = getLogId();
        String ipAddress = headers.getRemoteAddr();
        String methodName = "getRole";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ", methodName, username, sessionId, reqRes,
                ipAddress);
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        List<Role> roles = new ArrayList<>();
        boolean queryExecuted = false;
        String errorCause = "";

        try {
            roles = roleInterface.getRoles();
            response = Response.status(Response.Status.OK).entity(roles).build();
            queryExecuted = true;

        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        LOGGER.debug("Response {}, RequestId = {}", roles, reqRes);


        return response;
    }


    @GET
    @Path(USER_INFO_ENDPOINT) /*get user information */
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInformation(@QueryParam("username") String username,
                                       @QueryParam("sessionId") String sessionId,
                                       @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String ipAddress = headers.getRemoteAddr();
        String methodName = "getUserInformation";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ", methodName, username, sessionId, reqRes,
                ipAddress);
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";


        try {
            UserInfoResponse userInfoResponse = new UserInfoResponse();
            UserInformation userInfo = getUserInfo(username);
            queryExecuted = true;

            if (userInfo.getUsers() != null) {
                Users users = userInfo.getUsers();
                userInfoResponse.setUserInformation(userInfo);
                userInfoResponse.setCreatedDate(formatDateTime(users.getCreatedDate()));
                userInfoResponse.setLastLogin(formatDateTime(users.getLastLogin()));
                userInfoResponse.setLastLogout(formatDateTime(users.getLastLogout()));
                userInfoResponse.setNextLoginTime(formatDateTime(users.getNextLoginTime()));
                response = Response.status(Response.Status.OK).entity(userInfoResponse).build();
            } else {
                LOGGER.info("User not found, RequestId = {}", reqRes);
                response = Response.status(Response.Status.NO_CONTENT).build();
            }


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.NO_CONTENT).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }


        return response;
    }


    @GET
    @Path(DEPARTMENT_ENDPOINT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartments(@QueryParam("username") String username,
                                   @QueryParam("sessionId") String sessionId,
                                   @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String ipAddress = headers.getRemoteAddr();
        String methodName = "getDepartments";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {}, logId -> {}, ipAddress -> {} ", methodName, username, sessionId, reqRes,
                ipAddress);
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        List<Department> departments = new ArrayList<>();


        try {
            departments = departmentInterface.findAll();
            response = Response.status(Response.Status.OK).entity(departments).build();
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
           LOGGER.error(e);
            response = Response.status(Response.Status.NO_CONTENT).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        LOGGER.debug("Response {}, Response Id = {}", departments, reqRes);
        return response;
    }


    @POST
    @Path(USER_LOGOUT_ENDPOINT)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response doLogout(UserRequest userRequest, @Context HttpServletRequest headers) {

        String reqResId = getLogId();
        String methodName = "doLogout";
        LOGGER.info("{} is being called with parameter. Request = {},RequestId = {} ", methodName, userRequest, reqResId);
        String ipAddress = headers.getRemoteAddr();
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        int updated;
        boolean queryExecuted = false;
        String errorCause = "";


        try {
            updated = userHelper.doLogout(userRequest.getUser().getUserId());
            response = Response.status(Response.Status.OK).entity(updated).build();
            queryExecuted = updated > 0;
            LOGGER.info("User {} updated", userRequest.getUser().getUserId());

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
           LOGGER.error(e);
            response = Response.status(Response.Status.NO_CONTENT).build();
            errorCause = e.getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqResId, requestTime, userRequest.getUser().getUserId(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, userRequest.getSessionId(), ipAddress));
        }

        return response;
    }

    /**
     * get all users from database
     **/
    @GET
    @Path(USER_ENDPOINT)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers(@QueryParam("username") String username,
                             @QueryParam("sessionId") String sessionId,
                             @Context HttpServletRequest headers) {

        String reqResId = getLogId();
        String methodName = "getUsers";
        LOGGER.info("{} is being called with parameter. username -> {},requestId -> {} ", methodName, username, reqResId);
        String ipAddress = headers.getRemoteAddr();
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";
        List<Object[]> users = new ArrayList<>();

        try {
            users = userInterface.getUsersDetails();

            List<UserInformation> userResponses = new ArrayList<>();
            for (Object[] o : users) {

                Users u = (Users) o[0];
                UserDetails ud = (UserDetails) o[1];
                UserInformation userResponse = new UserInformation();
                userResponse.setUsers(u);
                userResponse.setUserDetails(ud);
                userResponses.add(userResponse);

            }
            response = Response.status(Response.Status.OK).entity(userResponses).build();
            queryExecuted = true;

        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.NO_CONTENT).build();

        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqResId, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }

        LOGGER.info("Response {} total users returned, ResponseId = {} ", users.size(), reqResId);

        return response;
    }

    /*change status of user */
    @POST
    @Path(USER_STATUS_ENDPOINT)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response changeUserStatus(UserRequest userRequest, @Context HttpServletRequest headers) {

        String reqResId = getLogId();
        String methodName = "changeUserStatus";
        LOGGER.info("{} is being called with parameter. request -> {},requestId -> {} ", methodName, userRequest, reqResId);
        String ipAddress = headers.getRemoteAddr();
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        int rowUpdated;


        try {
            rowUpdated = userInterface.updateStatus(userRequest.getUser().getStatus().getId(), userRequest.getUser().getUserId());
            LOGGER.info("User {} status changed to {}", userRequest.getUser().getUserId(), userRequest.getUser().getStatus().getId());

            if (userRequest.getUser().getStatus().getId().equals(Statuses.ACTIVE.toString())) {
                int userAttemptRow = userAttemptInterface.resetUserAttempts(userRequest.getUser().getUserId(),
                        formatDate(today(), SIMPLE_DATE_PATTERN), FAILED.toString(), today());
                if (userAttemptRow > 0) {
                    LOGGER.info("User attempt update for {}", userRequest.getUser().getUserId());
                }
            }

            response = Response.status(Response.Status.OK).entity(rowUpdated).build();
            queryExecuted = rowUpdated > 0;


        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.NO_CONTENT).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqResId, requestTime, userRequest.getUser().getUserId(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, userRequest.getSessionId(), ipAddress));
        }
        LOGGER.info("Response {} , Response Id = {}", queryExecuted, reqResId);
        return response;


    }

    /*update user information */
    @POST
    @Path(USER_EDIT_ENDPOINT)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateUserInfo(UserRequest userRequest, @Context HttpServletRequest headers) {

        String reqResId = getLogId();
        String methodName = "updateUserInfo";
        LOGGER.info("{} is being called with parameter. username -> {},requestId -> {} ", methodName, userRequest.getUser().getUserId(), reqResId);
        String ipAddress = headers.getRemoteAddr();
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        int rowUserDetails = 0;

        try {
            Users userReq = userRequest.getUser();
            Optional<Users> users = userInterface.findByUserId(userReq.getUserId());
            if (users.isPresent()) {

                int rowUpdated = userInterface.updateUser(userReq.getIdRole(), userReq.getDepartment().getId(), users.get().getStatus().getId(), userReq.getUserId());
                if (rowUpdated > 0) {
                    LOGGER.info("User {} updated. RequestId = {}", userReq.getUserId(), reqResId);
                    UserDetails details = userRequest.getUserDetails();
                    rowUserDetails = userInterface.updateUserDetails(details.getEmail(), details.getEmailAlt(), details.getFullName(), details.getSurname(),
                            details.getMobile(), details.getMobileAlt(), userReq.getUserId(), today());
                }
                if (rowUserDetails > 0) {
                    LOGGER.debug("User Updated, ResponseId = {}", reqResId);
                }
                response = Response.status(Response.Status.OK).entity(rowUserDetails).build();


            } else {
                LOGGER.info("User not found");
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }


        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqResId, requestTime, userRequest.getUser().getUserId(),
                    methodName, response.getStatus(), queryExecuted, HttpMethod.POST, errorCause, userRequest.getSessionId(), ipAddress));
        }


        return response;


    }


    @POST
    @Path(USER_CREATE_ENDPOINT) /*insert new user and userDetails */
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createUser(UserRequest userRequest, @Context HttpServletRequest headers) {

        String reqResId = getLogId();
        String methodName = "createUser";
        String ipAddress = "127.0.0.1";
        if (headers != null) {
            LOGGER.info("{} is being called with parameters. username -> {},requestId -> {} ", methodName, userRequest.getUser().getUserId(), reqResId);
            ipAddress = headers.getRemoteAddr();
        } else {
            LOGGER.info("{} is being called with from localhost. ", methodName);

        }
        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        boolean userSaved = false, userDetailsSaved = false;


        try {
            Users userToSave = userRequest.getUser();
            Optional<Users> userToCheck = userInterface.findByUserId(userRequest.getUser().getUserId());
            String password;
            if (!userToCheck.isPresent()) {
                userToSave.setCreatedDate(today());
                Users saved;
                Status status = new Status();
                if (!userRequest.getUser().getActiveDirectory()) {
                    password = getSaltString(6);
                    status.setId(ACTIVATING.toString());
                    userToSave.setUserKey(AES.encrypt(password));
                } else {
                    status.setId(ACTIVE.toString());

                }
                userToSave.setStatus(status);

                saved = repository.save(userToSave);

                if (saved != null) {
                    LOGGER.info("User {} saved", saved.getUserId());
                    UserDetails userDetToSave = userRequest.getUserDetails();
                    userDetToSave.setCreatedDate(today());
                    userDetToSave.setLastUpdate(today());
                    userDetToSave.setUsers(saved);
                    userSaved = true;
                    UserDetails udSaved = userDetailsInterface.save(userDetToSave);
                    if (udSaved != null) {
                        LOGGER.info("User {} details updated", udSaved.getUsers().getUserId());
                        userDetailsSaved = true;

                    }
                }


                response = Response.status(Response.Status.OK).entity(saved).build();
            } else {
                response = Response.status(Response.Status.OK).entity("eu").build();
            }
            queryExecuted = true;

        } catch (Exception e) {
            if (headers != null) {
               LOGGER.error(e);
                LOGGER.error(e.getMessage());
            }
            response = Response.status(Response.Status.NO_CONTENT).build();
            errorCause = e.getCause().getMessage();
        } finally {
            if (headers != null) {
                queryUtil.saveLog(CoreUtil.setWebserviceLog(reqResId, requestTime, userRequest.getUser().getCreatedBy(),
                        methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, userRequest.getSessionId(), ipAddress));
            }
        }

        LOGGER.debug("Response {User saved = {}, userDetails saved ={}}, ResponseId = {} ", userSaved, userDetailsSaved, reqResId);

        return response;


    }

    private UserInformation getUserInfo(String username) {

        List<MenuResponse> responses = new ArrayList<>();
        UserInformation userInformation = new UserInformation();
        MenuResponse menuResponse;
        List<Object[]> menus = userInterface.getUserMenu(username);
        LOGGER.debug("Menus returned {}", menus);

        int i = 0;
        for (Object[] o : menus) {

            Users users = (Users) o[0];
            UserDetails userDetails = (UserDetails) o[1];
            Role role = (Role) o[2];
            Menu m = (Menu) o[3];
            List<Submenu> submenus = subMenuInterface.getSubmenus(m.getId());

            if (i == 0) {
                userInformation.setUserDetails(userDetails);
                userInformation.setUsers(users);
                userInformation.setRole(role);
            }
            menuResponse = new MenuResponse();
            menuResponse.setMenu(m);
            menuResponse.setSubmenus(submenus);
            responses.add(menuResponse);
            i++;
        }

        userInformation.setMenus(responses);
        return userInformation;

    }



    @GET
    @Path("/departments/users")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByDepartment(@QueryParam("username") String username,
                                   @QueryParam("sessionId") String sessionId,
                                        @QueryParam("departmentId") String departmentId,
                                   @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String ipAddress = headers.getRemoteAddr();
        String methodName = "getUserByDepartment";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {},departmentId -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId,departmentId, reqRes,
                ipAddress);

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";

        List<UserDetails> users = new ArrayList<>();


        try {
            Department department = new Department();
            department.setId(departmentId);
            users = userDetailsInterface.findByDepartment(department);
            response = Response.status(Response.Status.OK).entity(users).build();
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
           LOGGER.error(e);
            response = Response.status(Response.Status.NO_CONTENT).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        LOGGER.debug("Response {}, Response Id = {}", users, reqRes);
        LOGGER.info("Response, total -> {}, Response Id = {}", users.size(), reqRes);
        return response;
    }


    @GET
    @Path("/web-services/log")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserLog(@QueryParam("username") String username,
                                        @QueryParam("userId") String userId,
                                        @QueryParam("startDate") String startDate,
                                        @QueryParam("endDate") String endDate,
                                        @QueryParam("resultType") String resultType,
                                        @QueryParam("sessionId") String sessionId,
                                        @QueryParam("limit") int limit,
                                        @Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String ipAddress = headers.getRemoteAddr();
        String methodName = "getUserLog";
        LOGGER.info("{} is being called with parameter. username -> {}, sessionId -> {},userId -> {}, startDate -> {}, endDate -> {}, logId -> {}, ipAddress -> {} ",
                methodName, username, sessionId,userId,startDate,endDate, reqRes,
                ipAddress);

        Date requestTime = today();
        Response response = Response.status(Response.Status.NO_CONTENT).build();
        boolean queryExecuted = false;
        String errorCause = "";
        Pageable top = PageRequest.of(0, limit);
        List<WebserviceRequest> webserviceRequests = new ArrayList<>();


        try {

            Date sd = stringToDateTime(startDate);
            Date ed = getDatePlus(stringToDate(endDate), 1, Calendar.DATE);

            webserviceRequests = webserviceInterface.findByUser(userId,sd,ed,top);
            response = Response.status(Response.Status.OK).entity(webserviceRequests).build();
            queryExecuted = true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
           LOGGER.error(e);
            response = Response.status(Response.Status.NO_CONTENT).build();
            errorCause = e.getCause().getMessage();
        } finally {

            queryUtil.saveLog(CoreUtil.setWebserviceLog(reqRes, requestTime, username,
                    methodName, response.getStatus(), queryExecuted, HttpMethod.GET, errorCause, sessionId, ipAddress));
        }
        LOGGER.debug("Response {}, Response Id = {}", webserviceRequests, reqRes);
        return response;
    }
}




