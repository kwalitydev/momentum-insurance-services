package dao.interfaces;


import dao.entities.TaskConfig;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface TaskInterface {
    Optional<TaskConfig> getTasks(String taskId);
    List<TaskConfig> findTaskIn(List<String> taskList);
    int updateTaskStatus(boolean status,String taskId);
    int updateTaskNextRunDate(String taskId, Date nextRunDate);

    List<TaskConfig> findAllByOrderByTaskIdAsc();
    int updatePoolInterval(int poolInterval,String taskId);

    List<TaskConfig> findAllByOrderByTaskId();
}
