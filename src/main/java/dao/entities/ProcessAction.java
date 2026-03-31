package dao.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ProcessAction implements Serializable {
    @Id
    private String processActionId;
    private String actionName;

    public String getProcessActionId() {
        return processActionId;
    }

    public void setProcessActionId(String processActionId) {
        this.processActionId = processActionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Override
    public String toString() {
        return "ProcessAction{" +
                "processActionId=" + processActionId +
                ", actionName='" + actionName + '\'' +
                '}';
    }
}
