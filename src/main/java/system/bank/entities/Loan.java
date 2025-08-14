package system.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LoanID")
    private Integer loanID;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "InterestRate", nullable = false)
    private BigDecimal interestRate;

    @Column(name = "StartDate", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "EndDate", nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "EmiAmount", nullable = false)
    private BigDecimal emiAmount;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL)
    private List<LoanPayment> payments;

}
