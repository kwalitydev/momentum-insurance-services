package dao.repositories;

import dao.entities.*;
import dao.interfaces.IDTypeInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDTypeRepository extends JpaRepository<IDType, String>, IDTypeInterface {


}
