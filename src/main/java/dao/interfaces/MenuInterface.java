package dao.interfaces;



import dao.entities.Menu;

import java.util.List;

public interface MenuInterface {

    <S extends Menu> S save(S b);


}
