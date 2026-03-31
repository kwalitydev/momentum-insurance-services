package dao.interfaces;


import dao.entities.CoverageType;
import dao.entities.CoverageTypeRate;

import java.util.Optional;

public interface CoverageTypeRateInterface {
   Optional<CoverageTypeRate> findByCoverageTypeAndAge(CoverageType coverageType, int age);

}
