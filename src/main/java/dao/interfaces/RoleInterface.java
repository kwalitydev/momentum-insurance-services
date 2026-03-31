package dao.interfaces;


import dao.entities.Role;

import java.util.List;

public interface RoleInterface {

    List<Role> findAll();
    List<Role> getRoles();

    <S extends Role> S save(S b);
}
