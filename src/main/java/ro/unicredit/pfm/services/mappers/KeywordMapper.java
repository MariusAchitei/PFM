package ro.unicredit.pfm.services.mappers;

import org.mapstruct.Mapper;
import ro.unicredit.pfm.entities.Keyword;
import ro.unicredit.pfm.services.dtos.KeywordDto;

@Mapper(componentModel = "spring")
public interface KeywordMapper {
    KeywordDto toDto(Keyword keyword);
    Keyword toEntity(KeywordDto keywordDto);
}
