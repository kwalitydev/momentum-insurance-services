package dao.repositories;

import dao.entities.RoleMenu;
import dao.interfaces.RoleMenuInterface;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleMenuRepository extends JpaRepository<RoleMenu, String>, RoleMenuInterface {


}
