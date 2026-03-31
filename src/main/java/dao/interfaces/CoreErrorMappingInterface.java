package dao.interfaces;


import dao.entities.CoreErrorMapping;

import java.util.List;
import java.util.Optional;

public interface CoreErrorMappingInterface {
    List<CoreErrorMapping> findByCoreMessage(String errorType);
    List<String> getCoreMessage(String errorType);
}
