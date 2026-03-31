package dao.interfaces;



import dao.entities.Industry;
import dao.entities.Status;

import java.util.List;
import java.util.Optional;

public interface IndustryInterface {

    List<Industry> findByStatusOrderByName(Status status);
    Optional<Industry> findByIndustryId(String id);


    Industry save(Industry s);
}
