package core.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<BusinessException> {

    @Override
    public Response toResponse(BusinessException ex) {
        ErrorResponse error = new ErrorResponse(ex.getCode(), ex.getMessage());
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }
}