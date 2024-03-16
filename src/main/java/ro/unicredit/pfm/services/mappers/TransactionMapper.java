package ro.unicredit.pfm.services.mappers;

import org.mapstruct.Mapper;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.services.dtos.TransactionDto;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toEntity(TransactionDto transactionDto);
    TransactionDto toDto(Transaction transaction);
}
