package dao.interfaces;


import dao.entities.RoleMenu;

public interface RoleMenuInterface {

    <S extends RoleMenu> S save(S b);
}
