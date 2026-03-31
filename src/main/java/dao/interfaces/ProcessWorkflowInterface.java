package dao.interfaces;


import dao.entities.*;

import java.util.Date;
import java.util.List;

public interface ProcessWorkflowInterface {

    ProcessWorkflow save(ProcessWorkflow s);
    List<ProcessWorkflow> findByCurrentDepartmentAndProcessState(Department currentDepartment, ProcessState processState);
    int updateProcessWorkflow(ProcessState processState, Users userAuth, Date authDate, ProcessAction processAction,String comments,Long workflowId);
}
