package dao.repositories;

import dao.entities.FileTransferLog;
import dao.interfaces.FileTransferLogInterface;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FileTransferLogRepository extends JpaRepository<FileTransferLog, String>, FileTransferLogInterface {


}
