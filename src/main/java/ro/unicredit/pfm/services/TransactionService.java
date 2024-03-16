package ro.unicredit.pfm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.entities.Keyword;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.exceptions.NotFoundException;
import ro.unicredit.pfm.repositories.CategoryRepository;
import ro.unicredit.pfm.repositories.KeywordRepository;
import ro.unicredit.pfm.repositories.TransactionRepository;
import ro.unicredit.pfm.services.dtos.requests.RequestTransactionDto;
import ro.unicredit.pfm.services.dtos.responses.ResponseTransactionDto;
import ro.unicredit.pfm.services.mappers.requests.RequestTransactionMapper;
import ro.unicredit.pfm.services.mappers.responses.ResponseTransactionMapper;

import java.util.List;

@Service
@AllArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ResponseTransactionMapper responseTransactionMapper;
    private final RequestTransactionMapper requestTransactionMapper;
    private final CategoryRepository categoryRepository;
    private final KeywordRepository keywordRepository;

    public List<ResponseTransactionDto> findAll(){
        return responseTransactionMapper.toDto(transactionRepository.findAll());
    }

    public ResponseTransactionDto findById(Long id){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transaction with id " + id + " not found."));
        return responseTransactionMapper.toDto(transaction);
    }

    public ResponseTransactionDto save(RequestTransactionDto requestTransactionDto){
        Transaction transaction = requestTransactionMapper.toEntity(requestTransactionDto);
        Transaction savedTransaction = transactionRepository.save(transaction);
        return responseTransactionMapper.toDto(savedTransaction);
    }

    public ResponseTransactionDto deleteById(Long id){
        ResponseTransactionDto transactionToDelete = findById(id);
        transactionRepository.deleteById(id);
        return transactionToDelete;
    }

    public ResponseTransactionDto update(Long id, RequestTransactionDto requestTransactionDto){
        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Update failed. Transaction not found."));
        Category associatedCategory = categoryRepository.findById(existingTransaction.getCategory().getId()).orElse(null);
        Keyword associatedKeyword = keywordRepository.findById(existingTransaction.getKeyword().getId()).orElse(null);
        Transaction parentTransaction = transactionRepository.findById(id).orElse(null);
        existingTransaction.setCategory(associatedCategory);
        existingTransaction.setKeyword(associatedKeyword);
        existingTransaction.setAmount(requestTransactionDto.getAmount());
        existingTransaction.setDate(requestTransactionDto.getDate());
        existingTransaction.setDescription(requestTransactionDto.getDescription());
        existingTransaction.setParent(parentTransaction);
        Transaction updatedTransaction = transactionRepository.save(existingTransaction);
        return responseTransactionMapper.toDto(updatedTransaction);
    }
}

