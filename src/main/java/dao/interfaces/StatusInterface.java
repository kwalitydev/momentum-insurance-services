package dao.interfaces;


import dao.entities.Status;

import java.util.List;

public interface StatusInterface {
    List<Status> findAll();
    List<Status> findByStatusType(String statusType);
}
