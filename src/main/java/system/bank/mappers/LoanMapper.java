package system.bank.mappers;

import system.bank.dto.LoanDTO;
import system.bank.dto.LoanPaymentDTO;
import system.bank.entities.Loan;
import system.bank.entities.LoanPayment;

import java.util.List;
import java.util.stream.Collectors;

public class LoanMapper {

    public static LoanDTO toDTO(Loan loan) {
        List<LoanPaymentDTO> paymentDTOs = null;
        if (loan.getPayments() != null) {
            paymentDTOs = loan.getPayments().stream()
                    .map(LoanMapper::toPaymentDTO)
                    .collect(Collectors.toList());
        }

        return new LoanDTO(
                loan.getLoanID(),
                loan.getAmount(),
                loan.getInterestRate(),
                loan.getStartDate(),
                loan.getEndDate(),
                loan.getUser(),
                loan.getEmiAmount(),
                paymentDTOs
        );
    }

    public static Loan toEntity(LoanDTO loanDTO) {
        Loan loan = new Loan();
        loan.setLoanID(loanDTO.getLoanID());
        loan.setAmount(loanDTO.getAmount());
        loan.setInterestRate(loanDTO.getInterestRate());
        loan.setStartDate(loanDTO.getStartDate());
        loan.setEndDate(loanDTO.getEndDate());
        loan.setUser(loanDTO.getUser());
        loan.setEmiAmount(loanDTO.getEmiAmount());
        // Payments are usually set separately to avoid circular references
        return loan;
    }

    private static LoanPaymentDTO toPaymentDTO(LoanPayment payment) {
        return new LoanPaymentDTO(
                payment.getPaymentsID(),
                payment.getPaymentDate(),
                payment.getAmount()
        );
    }

    public static LoanPayment toPaymentEntity(LoanPaymentDTO dto) {
        LoanPayment payment = new LoanPayment();
        payment.setPaymentsID(dto.getPaymentsID());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setAmount(dto.getAmount());
        // Loan reference should be set externally
        return payment;
    }
}
