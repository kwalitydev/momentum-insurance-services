package dao.repositories;

import dao.entities.DocumentType;
import dao.interfaces.DocumentTypeInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<DocumentType, String>, DocumentTypeInterface {


}
