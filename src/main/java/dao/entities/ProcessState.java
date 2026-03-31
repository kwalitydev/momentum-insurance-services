package dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ProcessState implements Serializable {
    @Id
    private String processStateId;
    private String stateDescription;

    public String getProcessStateId() {
        return processStateId;
    }

    public void setProcessStateId(String processStateId) {
        this.processStateId = processStateId;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    @Override
    public String toString() {
        return "ProcessState{" +
                "processStateId=" + processStateId +
                ", stateDescription='" + stateDescription + '\'' +
                '}';
    }
}
