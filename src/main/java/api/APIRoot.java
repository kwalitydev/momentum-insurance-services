package api;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
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
        return classes;
    }
}
