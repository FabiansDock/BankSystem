package system.bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import system.bank.entities.LoanPayment;

@Repository
public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Integer> {
}

