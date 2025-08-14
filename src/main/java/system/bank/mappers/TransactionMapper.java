package system.bank.mappers;

import system.bank.dto.TransactionDTO;
import system.bank.entities.Transaction;

public class TransactionMapper {

    public static TransactionDTO toDTO(Transaction transaction) {
        return new TransactionDTO(
//                transaction.getTransactionID(),
                transaction.getDate(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getSourceAccount(),
                transaction.getDestinationAccount(),
                transaction.getAccount()
        );
    }

    public static Transaction toEntity(TransactionDTO dto) {
        Transaction transaction = new Transaction();
//        transaction.setTransactionID(dto.getTransactionID());
        transaction.setDate(dto.getDate());
        transaction.setAmount(dto.getAmount());
        transaction.setType(dto.getType());
        transaction.setSourceAccount(dto.getSourceAccount());
        transaction.setDestinationAccount(dto.getDestinationAccount());
        transaction.setAccount(dto.getAccount());
        return transaction;
    }
}

