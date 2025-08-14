package system.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import system.bank.entities.Account;
import system.bank.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
//    private Integer transactionID;
    private LocalDateTime date;
    private BigDecimal amount;
    private TransactionType type;
    private Account sourceAccount;
    private Account destinationAccount;
    private Account account;
}
