package ro.unicredit.pfm.services.mappers.responses;

import org.mapstruct.Mapper;
import ro.unicredit.pfm.entities.Transaction;
import ro.unicredit.pfm.services.dtos.responses.ResponseTransactionDto;

@Mapper(componentModel = "spring")
public interface ResponseTransactionMapper {
    Transaction toEntity(ResponseTransactionDto responseTransactionDto);
    ResponseTransactionDto toDto(Transaction transaction);
}
