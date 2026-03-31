package core.threads;

import dao.entities.WebserviceRequest;
import dao.interfaces.WebserviceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.function.Function;


@Dependent
@Transactional
public class PostLog implements Function<WebserviceRequest, String> {

    private static final Logger LOGGER = LogManager.getLogger(PostLog.class);

    @Inject
    private WebserviceInterface webserviceInterface;

    @Override
    public String apply(WebserviceRequest webserviceRequest) {

        try {

            if(webserviceRequest.getErrorCause()!=null){
                if(webserviceRequest.getErrorCause().length()>500)
                    webserviceRequest.setErrorCause(webserviceRequest.getErrorCause().substring(0,500));
            }

            WebserviceRequest saved = webserviceInterface.save(webserviceRequest);
            LOGGER.info("webserviceLog saved {}",saved.getRequestId());
        }
        catch (Exception e){
            LOGGER.error("Error while saving webserviceLog",e);
        }


        return null;
    }



}
