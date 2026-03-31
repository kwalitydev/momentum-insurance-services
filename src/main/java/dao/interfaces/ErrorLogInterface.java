package dao.interfaces;


import dao.entities.ErrorLog;
import dao.entities.Status;

import java.util.List;

public interface ErrorLogInterface {

    List<ErrorLog> findByStatus(Status status);
    int removeErrorLog(String id);
}
