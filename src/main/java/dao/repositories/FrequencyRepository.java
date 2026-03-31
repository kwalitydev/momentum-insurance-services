package dao.repositories;

import dao.entities.Frequency;
import dao.interfaces.FrequencyInterface;
import org.springframework.data.jpa.repository.JpaRepository;



public interface FrequencyRepository extends JpaRepository<Frequency, String>, FrequencyInterface {


}
