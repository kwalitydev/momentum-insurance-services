package dao.repositories;

import dao.entities.CollectionLog;
import dao.interfaces.CollectionLogInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CollectionLogRepository extends JpaRepository<CollectionLog, String>, CollectionLogInterface {

    @Query(value = " SELECT " +
            "    CASE " +
            "        WHEN status = 'UNPAID' THEN 'Insufficient balance or debit restriction' " +
            "        WHEN status = 'ERROR'  THEN 'T24 Error' " +
            "        WHEN status = 'PAID'   THEN 'Success' " +
            "        ELSE status " +
            "        END AS status_description, " +
            "    COUNT(*) AS total " +
            "FROM COLLECTIONLOG " +
            "WHERE CREATEDDATE BETWEEN TO_DATE(?1,'dd/mm/yyyy') AND TO_DATE(?2,'dd/mm/yyyy') AND STATUS IS NOT NULL " +
            "GROUP BY status ",nativeQuery = true)
    List<Object[]> getCollectionAttempts(String startDate, String endDate);


    @Query(value = " SELECT ID " +
            "FROM COLLECTIONLOG " +
            "WHERE createdDate >= SYSDATE - (5/1440) " +
            "ORDER BY createdDate DESC ",nativeQuery = true)
    List<Object[]> getLastRows();
}
