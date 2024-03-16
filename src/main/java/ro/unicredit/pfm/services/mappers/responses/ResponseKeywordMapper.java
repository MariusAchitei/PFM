package ro.unicredit.pfm.services.mappers.responses;

import org.mapstruct.Mapper;
import ro.unicredit.pfm.entities.Keyword;
import ro.unicredit.pfm.services.dtos.responses.ResponseKeywordDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponseKeywordMapper {
    ResponseKeywordDto toDto(Keyword keyword);
    Keyword toEntity(ResponseKeywordDto responseKeywordDto);
    List<ResponseKeywordDto> toKeywordDtoList(List<Keyword> keywords);
}
