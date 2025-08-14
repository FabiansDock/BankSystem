package system.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan_payment")
public class LoanPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private Integer paymentsID;

    @Column(name = "PaymentDate", nullable = false)
    private LocalDateTime paymentDate;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "LoanID", nullable = false)
    private Loan loan;

}
