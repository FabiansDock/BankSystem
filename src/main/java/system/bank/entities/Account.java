package system.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import system.bank.enums.AccountType;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private Integer accountId;

    @Column(name = "AccountNumber", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "Balance", nullable = false)
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    @Column(name = "AccountType", nullable = false)
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "BranchID", nullable = false)
//    private Integer branchId;

    @Column(name = "IsApproved")
    private Boolean isApproved;
}
