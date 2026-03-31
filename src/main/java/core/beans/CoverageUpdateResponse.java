package core.beans;

import dao.entities.Coverage;

import java.io.Serializable;

public class CoverageUpdateResponse implements Serializable {
    private Coverage currentCoverage;
    private Coverage newCoverage;

    public Coverage getCurrentCoverage() {
        return currentCoverage;
    }

    public void setCurrentCoverage(Coverage currentCoverage) {
        this.currentCoverage = currentCoverage;
    }

    public Coverage getNewCoverage() {
        return newCoverage;
    }

    public void setNewCoverage(Coverage newCoverage) {
        this.newCoverage = newCoverage;
    }

    @Override
    public String toString() {
        return "CoverageUpdateResponse{" +
                "currentCoverage=" + currentCoverage +
                ", newCoverage=" + newCoverage +
                '}';
    }
}
