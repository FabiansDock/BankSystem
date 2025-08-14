package system.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import system.bank.entities.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {
    private Integer loanID;
    private BigDecimal amount;
    private BigDecimal interestRate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User user;
    private BigDecimal emiAmount;
    private List<LoanPaymentDTO> payments;
}
