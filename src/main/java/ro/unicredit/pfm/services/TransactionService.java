package ro.unicredit.pfm.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.repositories.TransactionRepository;
import ro.unicredit.pfm.services.dtos.TransactionDto;
import ro.unicredit.pfm.services.mappers.TransactionMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public List<TransactionDto> findAllTransactions(){
        return transactionRepository.findAll().stream().map(transaction -> transactionMapper.toDto(transaction)).toList();
    }

    public TransactionDto findTransactionById(Long id){
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction == null) {
            return null;
        }
        return transactionMapper.toDto(transaction);
    }

    public TransactionDto saveTransaction(Transaction transaction){
        return transactionMapper.toDto(transactionRepository.save(transaction));
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

    public void updateTransaction(Long id, Transaction transaction){
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        existingTransaction.setCategory(transaction.getCategory());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setDate(transaction.getDate());
        existingTransaction.setDescription(transaction.getDescription());
        existingTransaction.setKeyword(transaction.getKeyword());
        if (transaction.getParent() != null) {
            existingTransaction.setParent(transaction.getParent());
        }
        transactionRepository.save(transaction);
    }
}

