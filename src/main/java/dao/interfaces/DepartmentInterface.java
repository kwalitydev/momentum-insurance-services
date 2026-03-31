package dao.interfaces;



import dao.entities.Department;

import java.util.List;

public interface DepartmentInterface {
    List<Department> findAll();
}
