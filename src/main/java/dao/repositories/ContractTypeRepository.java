package dao.repositories;

import dao.entities.ContractType;
import dao.interfaces.ContractTypeInterface;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContractTypeRepository extends JpaRepository<ContractType, String>, ContractTypeInterface {


}
