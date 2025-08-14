package system.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.bank.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {

    boolean existsByBranchName(String branchName);
    boolean existsByManagerId(String managerId);
}

