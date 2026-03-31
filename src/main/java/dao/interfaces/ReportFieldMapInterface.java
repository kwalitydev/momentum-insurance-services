package dao.interfaces;



import dao.entities.ReportFieldMap;
import dao.entities.Status;
import dao.entities.SubProduct;

import java.util.List;

public interface ReportFieldMapInterface {

    List<ReportFieldMap> findBySubProductAndStatus(SubProduct subProduct,Status statusId);

}
