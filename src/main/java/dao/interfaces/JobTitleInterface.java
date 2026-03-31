package dao.interfaces;


import dao.entities.JobTitle;

import java.util.List;
import java.util.Optional;


public interface JobTitleInterface {

    List<JobTitle> findAllByOrderByName();
    Optional<JobTitle> findByJobTitleId(Long jobTitleId);
}
