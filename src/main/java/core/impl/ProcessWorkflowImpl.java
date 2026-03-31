package core.impl;

import dao.entities.*;
import dao.interfaces.ProcessWorkflowInterface;
import dao.repositories.ProcessWorkflowRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public class ProcessWorkflowImpl implements ProcessWorkflowInterface {

    @Inject
    private ProcessWorkflowRepository processWorkflowRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public ProcessWorkflow save(ProcessWorkflow s) {
        return processWorkflowRepository.saveAndFlush(s);
    }

    @Override
    public List<ProcessWorkflow> findByCurrentDepartmentAndProcessState(Department currentDepartment, ProcessState processState) {
        return processWorkflowRepository.findByCurrentDepartmentAndProcessState(currentDepartment,processState);
    }

    @Override
    public int updateProcessWorkflow(ProcessState processState, Users userAuth, Date authDate, ProcessAction processAction, String comments, Long workflowId) {
        return processWorkflowRepository.updateProcessWorkflow(processState, userAuth, authDate, processAction, comments, workflowId);
    }
}
