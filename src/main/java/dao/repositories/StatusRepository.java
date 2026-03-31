package dao.repositories;


import dao.entities.Status;
import dao.interfaces.StatusInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, String>, StatusInterface {

    @Query("SELECT st FROM Status st WHERE st.statusType LIKE %?1% ORDER BY st.description ")
    List<Status> findByStatusType(String statusType);



}
