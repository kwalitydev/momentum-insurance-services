package dao.repositories;


import dao.entities.Status;
import dao.entities.TaskConfig;
import dao.interfaces.TaskInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskConfig, String>, TaskInterface {

    @Query("SELECT t FROM TaskConfig t WHERE t.taskId =?1")
    Optional<TaskConfig> getTasks(String taskId);

    @Query("SELECT t FROM TaskConfig t WHERE t.taskId IN ?1")
    List<TaskConfig> findTaskIn(List<String> taskList);

    @Modifying(clearAutomatically = true)
    @Query("update TaskConfig set enabled=?1 where taskId=?2")
    int updateTaskStatus(boolean status,String taskId);

    @Modifying(clearAutomatically = true)
    @Query("update TaskConfig set nextRunningDate=?2 where taskId=?1")
    int updateTaskNextRunDate(String taskId, Date nextRunDate);

    @Modifying(clearAutomatically = true)
    @Query("update TaskConfig set poolInterval=?1where taskId=?2")
    int updatePoolInterval(int poolInterval,String taskId);



}
