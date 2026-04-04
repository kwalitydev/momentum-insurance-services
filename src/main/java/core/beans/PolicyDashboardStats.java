package core.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDashboardStats {
    private long totalPolicies;
    private long activePolicies;
    private long cancelledPolicies;
    private long suspendedPolicies;
}
