package dao.repositories;

import dao.entities.Menu;
import dao.entities.Submenu;
import dao.interfaces.MenuInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, String>, MenuInterface {

       @Query("SELECT s FROM Submenu s WHERE s.idMenu=?1")
    List<Submenu> getSubmenus(int menuId, int lan);

    @Query("SELECT m FROM Menu m")
    List<Menu> getMenus();

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Menu WHERE id=?1")
    void removeMenu(int id);


}
