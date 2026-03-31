package dao.repositories;


import dao.entities.WebserviceRequest;
import dao.interfaces.WebserviceInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface WebserviceRequestRepository extends JpaRepository<WebserviceRequest, String>, WebserviceInterface {

    @Query("SELECT wr FROM WebserviceRequest wr WHERE wr.userRequested.userId =?1 AND wr.requestTime BETWEEN ?2 AND ?3 ORDER BY wr.requestTime desc ")
    List<WebserviceRequest> findByUser(String userId, Date sd,Date ed, Pageable pageable);
}
