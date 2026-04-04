package dao.repositories;

import dao.entities.RoleMenu;
import dao.interfaces.RoleMenuInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleMenuRepository extends JpaRepository<RoleMenu, String>, RoleMenuInterface {

    @Query("SELECT r FROM RoleMenu r WHERE r.idRole = :idRole")
    List<RoleMenu> findByUserId(@Param("idRole") String idRole);
}
