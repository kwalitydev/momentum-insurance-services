package dao.repositories;

import dao.entities.ReportFieldMap;
import dao.interfaces.ReportFieldMapInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportFieldRepository extends JpaRepository<ReportFieldMap, String>, ReportFieldMapInterface {


}
