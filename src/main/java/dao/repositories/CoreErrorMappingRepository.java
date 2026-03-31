package dao.repositories;


import dao.entities.CoreErrorMapping;
import dao.interfaces.CoreErrorMappingInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CoreErrorMappingRepository extends JpaRepository<CoreErrorMapping, String>, CoreErrorMappingInterface {
    @Query("SELECT cm from CoreErrorMapping cm WHERE cm.errorType = ?1")
    List<CoreErrorMapping> findByCoreMessage(String errorType);

    @Query("SELECT cm.coreMessage from CoreErrorMapping cm WHERE cm.errorType = ?1")
    List<String> getCoreMessage(String errorType);

    @Query("SELECT cm from CoreErrorMapping cm WHERE cm.coreMessage = ?1 AND cm.errorType=?2")
    Optional<CoreErrorMapping> findSingleCoreMessage(String error,String errorType);

}
