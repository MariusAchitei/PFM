package ro.unicredit.pfm.controlleres;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.services.TransactionService;
import ro.unicredit.pfm.services.dtos.TransactionDto;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @GetMapping
    public List<TransactionDto> getAll(){
        return transactionService.findAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionDto getTransactionById(@PathVariable Long id){
        return transactionService.findTransactionById(id);
    }

    @PostMapping
    public TransactionDto saveTransaction(Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable Long id,@RequestBody TransactionDto transactionDto){
        transactionService.updateTransaction(id, transactionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
    }
}
