package system.bank.mappers;

import system.bank.dto.LoanPaymentDTO;
import system.bank.entities.LoanPayment;

public class LoanPaymentMapper {

    public static LoanPaymentDTO toDTO(LoanPayment payment) {
        return new LoanPaymentDTO(
                payment.getPaymentsID(),
                payment.getPaymentDate(),
                payment.getAmount()
        );
    }

    public static LoanPayment toEntity(LoanPaymentDTO dto) {
        LoanPayment payment = new LoanPayment();
        payment.setPaymentsID(dto.getPaymentsID());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setAmount(dto.getAmount());
        // Loan reference should be set externally to avoid circular dependency
        return payment;
    }
}

