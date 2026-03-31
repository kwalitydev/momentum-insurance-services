package dao.repositories;

import dao.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface ProcessWorkflowRepository extends JpaRepository<ProcessWorkflow, String> {

    @Modifying(clearAutomatically = true)
    @Query("update ProcessWorkflow set processState= ?1, userAuth= ?2, authDate= ?3, processAction= ?4, comments=?5 where workflowId=?6")
    int updateProcessWorkflow(ProcessState processState, Users userAuth, Date authDate, ProcessAction processAction, String comments, Long workflowId);

    @Query("Select p FROM ProcessWorkflow p WHERE p.currentDepartment =?1 AND p.processState=?2")
    List<ProcessWorkflow> findByCurrentDepartmentAndProcessState(Department currentDepartment, ProcessState processState);
}
