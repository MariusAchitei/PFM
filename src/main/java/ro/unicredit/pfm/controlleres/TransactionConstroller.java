package ro.unicredit.pfm.controlleres;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.repositories.TransactionRepository;
import ro.unicredit.pfm.services.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionConstroller {
    TransactionService transactionService;
    @GetMapping
    public List<Transaction> getAll(){
        return transactionService.findAllTransactions();
    }

}
