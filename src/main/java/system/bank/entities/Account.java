package system.bank.entities;

import jakarta.persistence.*;
import system.bank.enums.AccountType;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Long accountId;

    @Column(name = "AccountNumber", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "Balance", nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "AccountType", nullable = false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private User customerId;

    @ManyToOne
    @JoinColumn(name = "BranchID", nullable = false)
    private Long branchId;

    @Column(name = "IsApproved")
    private Boolean isApproved;
}
