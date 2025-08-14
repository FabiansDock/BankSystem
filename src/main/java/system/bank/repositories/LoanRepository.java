package system.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.bank.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
