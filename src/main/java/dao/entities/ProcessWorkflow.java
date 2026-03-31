package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ProcessWorkflow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workflowId;
    @OneToOne
    private ProcessState processState;
    @OneToOne
    private Users userInput;
    @OneToOne
    private Users userAuth;
    private Date inputDate;
    private Date authDate;
    @OneToOne
    private ProcessAction processAction;
    private String comments;
    @OneToOne
    private Department currentDepartment;
    private String changedObjectId;


    public Long getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Long workflowId) {
        this.workflowId = workflowId;
    }

    public ProcessState getProcessState() {
        return processState;
    }

    public void setProcessState(ProcessState processState) {
        this.processState = processState;
    }

    public Users getUserInput() {
        return userInput;
    }

    public void setUserInput(Users userInput) {
        this.userInput = userInput;
    }

    public Users getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(Users userAuth) {
        this.userAuth = userAuth;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Date getAuthDate() {
        return authDate;
    }

    public void setAuthDate(Date authDate) {
        this.authDate = authDate;
    }

    public ProcessAction getProcessAction() {
        return processAction;
    }

    public void setProcessAction(ProcessAction processAction) {
        this.processAction = processAction;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Department getCurrentDepartment() {
        return currentDepartment;
    }

    public void setCurrentDepartment(Department currentDepartment) {
        this.currentDepartment = currentDepartment;
    }

    public String getChangedObjectId() {
        return changedObjectId;
    }

    public void setChangedObjectId(String changedObjectId) {
        this.changedObjectId = changedObjectId;
    }

    @Override
    public String toString() {
        return "ProcessWorkflow{" +
                "workflowId=" + workflowId +
                ", processState=" + processState +
                ", userInput=" + userInput +
                ", userAuth=" + userAuth +
                ", inputDate=" + inputDate +
                ", authDate=" + authDate +
                ", processAction=" + processAction +
                ", comments='" + comments + '\'' +
                ", currentDepartment=" + currentDepartment +
                ", changedObjectId='" + changedObjectId + '\'' +
                '}';
    }
}
