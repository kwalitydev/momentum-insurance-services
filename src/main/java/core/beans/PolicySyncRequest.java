package core.beans;

import java.io.Serializable;
import java.util.List;

public class PolicySyncRequest implements Serializable {

    private String migrationStatus;
    private List<InsuranceSync> policies;
    private String username;

    public String getMigrationStatus() {
        return migrationStatus;
    }

    public void setMigrationStatus(String migrationStatus) {
        this.migrationStatus = migrationStatus;
    }

    public List<InsuranceSync> getPolicies() {
        return policies;
    }

    public void setPolicies(List<InsuranceSync> policies) {
        this.policies = policies;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "PolicySyncRequest{" +
                "migrationStatus='" + migrationStatus + '\'' +
                ", policies=" + policies +
                ", username='" + username + '\'' +
                '}';
    }
}
