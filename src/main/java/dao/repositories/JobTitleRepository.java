package dao.repositories;

import dao.entities.JobTitle;
import dao.interfaces.JobTitleInterface;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobTitleRepository extends JpaRepository<JobTitle, String>, JobTitleInterface {


}
