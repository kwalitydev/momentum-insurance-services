package dao.interfaces;



import dao.entities.IDType;

import java.util.List;

public interface IDTypeInterface {
    <S extends IDType> S save(S p);
    List<IDType> findAllByOrderByDescription();
}
