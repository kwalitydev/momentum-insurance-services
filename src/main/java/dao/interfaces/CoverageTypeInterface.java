package dao.interfaces;


import dao.entities.CoverageType;
import dao.entities.Status;

import java.util.List;

public interface CoverageTypeInterface {
   List<CoverageType> findByStatus(Status status);
}
