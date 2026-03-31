package dao.interfaces;


import dao.entities.ContractType;
import dao.entities.Status;

import java.util.List;

public interface ContractTypeInterface {

    List<ContractType> findByStatus(Status status);
}
