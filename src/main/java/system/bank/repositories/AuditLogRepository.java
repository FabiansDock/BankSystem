package system.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.bank.entities.AuditLog;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog,Integer> {

}
