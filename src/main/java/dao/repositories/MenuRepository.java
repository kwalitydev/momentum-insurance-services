package dao.repositories;

import dao.entities.Menu;
import dao.entities.Submenu;
import dao.interfaces.MenuInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer>, MenuInterface {

    @Query("SELECT m FROM Menu m WHERE m.id = :id")
    Menu findMenuById(@Param("id") Integer id);


}
