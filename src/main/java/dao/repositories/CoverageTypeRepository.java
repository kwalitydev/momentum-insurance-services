package dao.repositories;

import dao.entities.*;
import dao.interfaces.CoverageTypeInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CoverageTypeRepository extends JpaRepository<CoverageType, String>, CoverageTypeInterface {


}
