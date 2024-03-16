package ro.unicredit.pfm.controlleres;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @GetMapping
    public List<Transaction> getAll(){
        return transactionService.findAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(Long id){
        return transactionService.findTransactionById(id);
    }

    @PostMapping
    public Transaction saveTransaction(Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

    @PutMapping("/{id}")
    public void updateTransaction(Long id, Transaction transaction){
        transactionService.updateTransaction(id, transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(Long id){
        transactionService.deleteTransaction(id);
    }
}
