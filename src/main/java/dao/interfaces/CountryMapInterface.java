package dao.interfaces;


import dao.entities.CountryMap;
import dao.entities.Status;

import java.util.List;


public interface CountryMapInterface {
    <S extends CountryMap> S save(S a);
    List<CountryMap> findByStatusOrderByName(Status status);
}
