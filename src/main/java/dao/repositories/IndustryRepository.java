package dao.repositories;

import dao.entities.Industry;
import dao.interfaces.IndustryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustryRepository extends JpaRepository<Industry, String>, IndustryInterface {



}
