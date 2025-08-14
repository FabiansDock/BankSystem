package system.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import system.bank.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Integer transactionID;

    @Column(name = "Date", nullable = false)
    private LocalDateTime date;

    @Column(name = "Amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "Type", nullable = false)
    private TransactionType type;

    @ManyToOne
    @JoinColumn (name = "AccountID", nullable = false)
    private Account sourceAccount;

    @Column(name = "DestinationAccount")
    private Account destinationAccount;

    @ManyToOne
    @JoinColumn(name = "AccountID", nullable = false)
    private Account account;

}
