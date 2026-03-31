package dao.interfaces;


import dao.entities.Submenu;

import java.util.List;

public interface SubMenuInterface {

    List<Submenu> getSubmenus(int menuId);

    <S extends Submenu> S save(S b);

}
