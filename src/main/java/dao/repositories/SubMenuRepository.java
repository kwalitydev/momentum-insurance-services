package dao.repositories;


import dao.entities.Submenu;
import dao.interfaces.SubMenuInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubMenuRepository extends JpaRepository<Submenu, String>, SubMenuInterface {



    @Query("SELECT s FROM Submenu s WHERE s.idMenu=?1 ORDER BY s.description")
    List<Submenu> getSubmenus(int menuId);

    @Query("SELECT s,m FROM Submenu s INNER JOIN Menu m ON (m.id = s.idMenu)")
    List getSubmenus();

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Submenu WHERE id=?1")
    void removeSubmenu(int id);


}
