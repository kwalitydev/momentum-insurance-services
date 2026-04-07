package core.beans;

import java.io.Serializable;
import java.util.List;

public class BenefRequest implements Serializable {
    private List<BeneficiaryRequestPayload> remaining;
    private List<BeneficiaryRequestPayload> newlyAdded;
    private List<BeneficiaryRequestPayload> toBeRemoved;


    public List<BeneficiaryRequestPayload> getRemaining() {
        return remaining;
    }

    public void setRemaining(List<BeneficiaryRequestPayload> remaining) {
        this.remaining = remaining;
    }

    public List<BeneficiaryRequestPayload> getNewlyAdded() {
        return newlyAdded;
    }

    public void setNewlyAdded(List<BeneficiaryRequestPayload> newlyAdded) {
        this.newlyAdded = newlyAdded;
    }

    public List<BeneficiaryRequestPayload> getToBeRemoved() {
        return toBeRemoved;
    }

    public void setToBeRemoved(List<BeneficiaryRequestPayload> toBeRemoved) {
        this.toBeRemoved = toBeRemoved;
    }

    @Override
    public String toString() {
        return "BenefRequest{" +
                "remaining=" + remaining +
                ", newlyAdded=" + newlyAdded +
                ", toBeRemoved=" + toBeRemoved +
                '}';
    }
}
