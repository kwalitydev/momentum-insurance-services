package core.beans;

import dao.entities.InsurancePolicyHistory;

import java.io.Serializable;
import java.util.Date;

public class InsuranceHistoryResponse implements Serializable {
    private String comments;
    private String username;
    private String fullName;
    private Date date;
    private String action;
    private String branchName;
    private String processId;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    @Override
    public String toString() {
        return "InsuranceHistoryResponse{" +
                "comments='" + comments + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", date=" + date +
                ", action='" + action + '\'' +
                ", branchName='" + branchName + '\'' +
                ", processId='" + processId + '\'' +
                '}';
    }
}
