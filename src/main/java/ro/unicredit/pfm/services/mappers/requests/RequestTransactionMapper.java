package ro.unicredit.pfm.services.mappers.requests;

import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.services.dtos.requests.RequestTransactionDto;

public interface RequestTransactionMapper {
    Transaction toEntity(RequestTransactionDto requestTransactionDto);
    RequestTransactionDto toDto(Transaction transaction);
}
