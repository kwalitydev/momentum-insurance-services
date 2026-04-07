package api;


import core.exception.GlobalExceptionHandler;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@OpenAPIDefinition(
        info = @Info(
                title = "Momentum API",
                version = "1.0"
        ),
        servers = {
                @Server(url = "/momentum")
        }
)
@ApplicationPath("/api")
public class APIRoot extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(UserAPI.class);
        classes.add(PolicyAPI.class);
        classes.add(QueryAPI.class);
        classes.add(ReportAPI.class);
        classes.add(WorkflowAPI.class);
        classes.add(GenericAPI.class);
        classes.add(DocumentAPI.class);
        classes.add(ClaimAPI.class);
        classes.add(SystemAPI.class);
        classes.add(MetricAPI.class);
        classes.add(AuthDashboardAPI.class);
        classes.add(DashboardAPI.class);
        classes.add(AuthAppAPI.class);
        classes.add(OpenApiResource.class);
        classes.add(GlobalExceptionHandler.class);
        return classes;
    }
}
