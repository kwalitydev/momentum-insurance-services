package dao.repositories;


import dao.entities.Role;
import dao.entities.RoleMenu;
import dao.interfaces.RoleInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, String>, RoleInterface {

    @Query("SELECT r FROM Role r")
    List<Role> getRoles();

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM RoleMenu")
    void deleteRoleMenu(String idRole);

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Role WHERE idRole=?1")
    void deleteRole(String id_role);

    @Query("SELECT rm FROM RoleMenu rm WHERE rm.idRole=?1")
    List<RoleMenu> findRoleMenu(String idRole);



}
