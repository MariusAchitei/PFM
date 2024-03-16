package ro.unicredit.pfm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.repositories.TransactionRepository;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAllTransactions(){
        return transactionRepository.findAll();
    }
}
