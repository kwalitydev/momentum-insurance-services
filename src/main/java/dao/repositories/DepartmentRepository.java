package dao.repositories;

import dao.entities.Department;
import dao.interfaces.DepartmentInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String>, DepartmentInterface {



}
