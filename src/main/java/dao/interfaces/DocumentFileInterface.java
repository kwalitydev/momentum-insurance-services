package dao.interfaces;


import dao.entities.DocumentFile;

import java.util.List;
import java.util.Optional;

public interface DocumentFileInterface {
    DocumentFile save(DocumentFile df);
    Optional<DocumentFile> findById(Long id);
    Optional<DocumentFile> findByObjectIdAndRecordType(String objectId,String recordType);
    List<DocumentFile> findByObjectId(String objectId);
    int updateDocumentUrl(String url,String objectId,String recordType);
    void deleteDocument(Long id);

}
