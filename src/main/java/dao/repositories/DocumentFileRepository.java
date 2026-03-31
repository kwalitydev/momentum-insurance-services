package dao.repositories;

import dao.entities.DocumentFile;
import dao.entities.ProductConfig;
import dao.interfaces.DocumentFileInterface;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DocumentFileRepository extends JpaRepository<DocumentFile, String>, DocumentFileInterface {

    @Modifying(clearAutomatically = true)
    @Query("update DocumentFile set url=?1 where objectId=?2 AND recordType=?3")
    int updateDocumentUrl(String url,String objectId,String recordType);

    @Modifying(clearAutomatically = true)
    @Query("DELETE from DocumentFile where id=?1")
    void deleteDocument(Long id);
}
