package dao.repositories;

import dao.entities.PolicySyncHistory;
import dao.interfaces.PolicySyncHistoryInterface;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface PolicySyncHistoryRepository extends JpaRepository<PolicySyncHistory, String>, PolicySyncHistoryInterface {


}
