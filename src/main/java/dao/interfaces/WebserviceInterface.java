package dao.interfaces;


import dao.entities.WebserviceRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface WebserviceInterface {
    WebserviceRequest save(WebserviceRequest ws);
    List<WebserviceRequest> findByUser(String userId, Date sd,Date ed, Pageable pageable);

}
