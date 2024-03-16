package ro.unicredit.pfm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.repositories.CategoryRepository;
import ro.unicredit.pfm.repositories.KeywordRepository;
import ro.unicredit.pfm.repositories.TransactionRepository;
import ro.unicredit.pfm.services.dtos.responses.ResponseTransactionDto;
import ro.unicredit.pfm.services.mappers.responses.ResponseTransactionMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ResponseTransactionMapper responseTransactionMapper;
    private final CategoryRepository categoryRepository;
    private final KeywordRepository keywordRepository;

    public List<ResponseTransactionDto> findAllTransactions(){
        return transactionRepository.findAll().stream().map(transaction -> responseTransactionMapper.toDto(transaction)).toList();
    }

    public ResponseTransactionDto findTransactionById(Long id){
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        if (transaction == null) {
            return null;
        }
        return responseTransactionMapper.toDto(transaction);
    }

    public ResponseTransactionDto saveTransaction(Transaction transaction){
        return responseTransactionMapper.toDto(transactionRepository.save(transaction));
    }

    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }

    public void updateTransaction(Long id, ResponseTransactionDto responseTransactionDto){
        Transaction existingTransaction = transactionRepository.findById(id).orElse(null);
        existingTransaction.setCategory(categoryRepository.findById(responseTransactionDto.getCategoryId()).orElse(null));
        existingTransaction.setKeyword(keywordRepository.findById(responseTransactionDto.getKeywordId()).orElse(null));

        existingTransaction.setAmount(responseTransactionDto.getAmount());
        existingTransaction.setDate(responseTransactionDto.getDate());
        existingTransaction.setDescription(responseTransactionDto.getDescription());
        if (responseTransactionDto.getParentId() != null) {
            existingTransaction.setParent(transactionRepository.findById(responseTransactionDto.getParentId()).orElse(null));
        }
        transactionRepository.save(existingTransaction);
    }
}

