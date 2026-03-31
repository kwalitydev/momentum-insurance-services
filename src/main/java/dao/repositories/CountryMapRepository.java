package dao.repositories;

import dao.entities.CountryMap;
import dao.interfaces.CountryMapInterface;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryMapRepository extends JpaRepository<CountryMap, String>, CountryMapInterface {


}
