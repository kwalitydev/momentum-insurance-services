package dao.interfaces;


import dao.entities.DocumentType;

import java.util.List;
import java.util.Optional;

public interface DocumentTypeInterface {

    List<DocumentType> findByFileType(String fileType);
    Optional<DocumentType> findById(Long id);
}
