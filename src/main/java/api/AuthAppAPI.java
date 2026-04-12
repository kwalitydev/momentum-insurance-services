package api;


import core.beans.AuthAppRequest;
import core.beans.LoginAppRequest;
import core.beans.LoginOTPResponse;
import core.beans.LoginResponse;
import core.service.AuthService;
import dao.entities.InsurancePolicy;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static core.util.Util.APP;

@Path(APP)

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthAppAPI {

    @Inject
    AuthService authService;

    @POST
    @Path("/auth/login")
    public Response loginByNumberAndPhoneNumber(LoginAppRequest loginAppRequest) {
        Response validationError = validate(loginAppRequest.getPolicyNumber(), loginAppRequest.getPhoneNumber());
        if (validationError != null) {
            return validationError;
        }
        Long tokenId = authService.login(loginAppRequest.getPolicyNumber(), loginAppRequest.getPhoneNumber());
        LoginOTPResponse loginOTPResponse = new LoginOTPResponse();
        loginOTPResponse.setTokenId(tokenId);
        loginOTPResponse.setStatus("SUCCESS");
        return Response.ok(loginOTPResponse).build();
    }


    @POST
    @Path("/auth/token")
    public Response activate(AuthAppRequest authAppRequest) {
        InsurancePolicy insurancePolicy = authService.appAuthenticate(
                authAppRequest);
        return Response.ok(insurancePolicy).build();
    }


    private Response validate(String policyNumber, String phoneNumber) {

        if (isBlank(policyNumber)) {
            return badRequest("policyNumber is required");
        }

        if (isBlank(phoneNumber)) {
            return badRequest("phoneNumber is required");
        }
        return null;
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }

    private Response badRequest(String message) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error(message))
                .build();
    }

    private Map<String, Object> error(String message) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", "ERROR");
        res.put("message", message);
        return res;
    }

    private Map<String, Object> success(String key, Object value) {
        Map<String, Object> res = new HashMap<>();
        res.put("status", "SUCCESS");
        res.put(key, value);
        return res;
    }
}
