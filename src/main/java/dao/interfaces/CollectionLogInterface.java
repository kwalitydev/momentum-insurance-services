package dao.interfaces;


import dao.entities.CollectionLog;

import java.util.List;


public interface CollectionLogInterface {
    CollectionLog save(CollectionLog collectionLog);
    List<Object[]> getCollectionAttempts(String startDate, String endDate);
    List<Object[]> getLastRows();
}
