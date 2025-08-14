package system.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bank.dto.TransactionDTO;
import system.bank.entities.Transaction;
import system.bank.mappers.TransactionMapper;
import system.bank.repositories.TransactionRepository;
//import system.bank.services.TransactionServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService  {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = TransactionMapper.toEntity(transactionDTO);
        return TransactionMapper.toDTO(transactionRepository.save(transaction));
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(TransactionMapper::toDTO)
                .collect(Collectors.toList());
    }

    public TransactionDTO getTransactionById(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.map(TransactionMapper::toDTO).orElse(null);
    }

    public TransactionDTO updateTransaction(int id, TransactionDTO transactionDTO) {
        return transactionRepository.findById(id)
                .map(existing -> {
                    existing.setDate(transactionDTO.getDate());
                    existing.setAmount(transactionDTO.getAmount());
                    existing.setType(transactionDTO.getType());
                    existing.setSourceAccount(transactionDTO.getSourceAccount());
                    existing.setDestinationAccount(transactionDTO.getDestinationAccount());
                    existing.setAccount(transactionDTO.getAccount());
                    return TransactionMapper.toDTO(transactionRepository.save(existing));
                })
                .orElse(null);
    }

    public boolean deleteTransaction(int id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

