package ro.unicredit.pfm.controlleres;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.services.TransactionService;
import ro.unicredit.pfm.services.dtos.responses.ResponseTransactionDto;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping
    public List<ResponseTransactionDto> getAll(){
        return transactionService.findAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseTransactionDto getTransactionById(@PathVariable Long id){
        return transactionService.findTransactionById(id);
    }

    @PostMapping
    public ResponseTransactionDto saveTransaction(Transaction transaction){
        return transactionService.saveTransaction(transaction);
    }

    @PutMapping("/{id}")
    public void updateTransaction(@PathVariable Long id,@RequestBody ResponseTransactionDto responseTransactionDto){
        transactionService.updateTransaction(id, responseTransactionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
    }
}
