package api;


import core.beans.ActivationResponseDTO;
import core.beans.LoginRequest;
import core.beans.LoginResponseDTO;
import dao.interfaces.AuthService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static core.util.Util.API_V2;

@Path(API_V2)

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthDashboardAPI {

    @Inject
    AuthService authService;

    @POST
    @Path("/auth/login")
    public Response login(LoginRequest request) {
        LoginResponseDTO response = authService.authenticate(
                request.getUsername(),
                request.getPassword()
        );
        return Response.ok(response).build();
    }


    @POST
    @Path("/auth/activate")
    public Response activate(LoginRequest request) {

        ActivationResponseDTO response = authService.activate(
                request.getUsername(),
                request.getPassword()
        );

        return Response.ok(response).build();
    }

    @POST
    @Path("/auth/update-password")
    public Response updatePassword(LoginRequest dto) {
        ActivationResponseDTO activationResponseDTO =
                authService.updatePasswordAndActivate(dto.getUsername(), dto.getPassword());

        return Response.ok(activationResponseDTO).build();
    }
}
