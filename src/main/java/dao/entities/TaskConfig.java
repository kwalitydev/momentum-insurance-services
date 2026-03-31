package dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
public class TaskConfig implements Serializable {

    @Id
    @Column(length = 50)
    private String taskId;
    private boolean enabled;
    private int poolInterval;
    private int startDelay;
    private Date nextRunningDate;
    private String stopTime;
    @Column(length = 100)
    private String description;
    private Integer threadPool;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getPoolInterval() {
        return poolInterval;
    }

    public void setPoolInterval(int poolInterval) {
        this.poolInterval = poolInterval;
    }

    public int getStartDelay() {
        return startDelay;
    }

    public void setStartDelay(int startDelay) {
        this.startDelay = startDelay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(Integer threadPool) {
        this.threadPool = threadPool;
    }

    public Date getNextRunningDate() {
        return nextRunningDate;
    }

    public void setNextRunningDate(Date nextRunningDate) {
        this.nextRunningDate = nextRunningDate;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public String toString() {
        return "TaskConfig{" +
                "taskId='" + taskId + '\'' +
                ", enabled=" + enabled +
                ", poolInterval=" + poolInterval +
                ", startDelay=" + startDelay +
                ", nextRunningDate=" + nextRunningDate +
                ", stopTime='" + stopTime + '\'' +
                ", description='" + description + '\'' +
                ", threadPool=" + threadPool +
                '}';
    }
}
