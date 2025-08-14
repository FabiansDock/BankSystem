package system.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bank.dto.LoanPaymentDTO;
import system.bank.entities.LoanPayment;
import system.bank.mappers.LoanPaymentMapper;
import system.bank.repositories.LoanPaymentRepository;
import system.bank.services.LoanPaymentService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoanPaymentService {

    @Autowired
    private LoanPaymentRepository loanPaymentRepository;

    public LoanPaymentDTO createLoanPayment(LoanPaymentDTO loanPaymentDTO) {
        LoanPayment payment = LoanPaymentMapper.toEntity(loanPaymentDTO);
        return LoanPaymentMapper.toDTO(loanPaymentRepository.save(payment));
    }

    public List<LoanPaymentDTO> getAllLoanPayments() {
        return loanPaymentRepository.findAll().stream()
                .map(LoanPaymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LoanPaymentDTO getLoanPaymentById(int id) {
        Optional<LoanPayment> payment = loanPaymentRepository.findById(id);
        return payment.map(LoanPaymentMapper::toDTO).orElse(null);
    }

    public LoanPaymentDTO updateLoanPayment(int id, LoanPaymentDTO loanPaymentDTO) {
        return loanPaymentRepository.findById(id)
                .map(existing -> {
                    existing.setPaymentDate(loanPaymentDTO.getPaymentDate());
                    existing.setAmount(loanPaymentDTO.getAmount());
                    return LoanPaymentMapper.toDTO(loanPaymentRepository.save(existing));
                })
                .orElse(null);
    }

    public boolean deleteLoanPayment(int id) {
        if (loanPaymentRepository.existsById(id)) {
            loanPaymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

