package core.beans;

import dao.entities.ProcessWorkflow;
import dao.entities.SubProduct;

import java.io.Serializable;
import java.util.Date;

public class WorkflowResponse implements Serializable {

    private Long objectId;
    private String objectChanged;
    private SubProduct subProduct;
    private String creatorName;
    private ProcessWorkflow processWorkflow;
    private String objectType;
    private String clientName;


    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getObjectChanged() {
        return objectChanged;
    }

    public void setObjectChanged(String objectChanged) {
        this.objectChanged = objectChanged;
    }

    public ProcessWorkflow getProcessWorkflow() {
        return processWorkflow;
    }

    public void setProcessWorkflow(ProcessWorkflow processWorkflow) {
        this.processWorkflow = processWorkflow;
    }

    public SubProduct getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(SubProduct subProduct) {
        this.subProduct = subProduct;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String toString() {
        return "WorkflowResponse{" +
                "objectId=" + objectId +
                ", objectChanged='" + objectChanged + '\'' +
                ", subProduct=" + subProduct +
                ", creatorName='" + creatorName + '\'' +
                ", processWorkflow=" + processWorkflow +
                ", objectType='" + objectType + '\'' +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
