package system.bank.services;

import system.bank.dto.LoanDTO;
import system.bank.entities.Loan;
import system.bank.mappers.LoanMapper;
import system.bank.repositories.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public LoanDTO createLoan(LoanDTO loanDTO) {
        Loan loan = LoanMapper.toEntity(loanDTO);
        return LoanMapper.toDTO(loanRepository.save(loan));
    }

    public List<LoanDTO> getAllLoans() {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream()
                .map(LoanMapper::toDTO)
                .toList();
    }

    public LoanDTO getLoanById(int id) {
        Optional<Loan> optionalLoan = loanRepository.findById(id);
        return optionalLoan.map(LoanMapper::toDTO).orElse(null);
    }

    public LoanDTO updateLoan(int id, LoanDTO loanDTO) {
        return loanRepository.findById(id)
                .map(existingLoan -> {
                    existingLoan.setAmount(loanDTO.getAmount());
                    existingLoan.setInterestRate(loanDTO.getInterestRate());
                    existingLoan.setStartDate(loanDTO.getStartDate());
                    existingLoan.setEndDate(loanDTO.getEndDate());
                    existingLoan.setUser(loanDTO.getUser());
                    existingLoan.setEmiAmount(loanDTO.getEmiAmount());
                    return LoanMapper.toDTO(loanRepository.save(existingLoan));
                })
                .orElse(null);
    }

    public boolean deleteLoan(int id) {
        if (loanRepository.existsById(id)) {
            loanRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
