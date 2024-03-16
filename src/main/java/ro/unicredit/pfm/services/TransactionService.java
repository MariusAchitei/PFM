package ro.unicredit.pfm.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.repositories.TransactionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> findAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction findTransactionById(Long id){
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction saveTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
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

