package ro.unicredit.pfm.services.mappers.requests;

import ro.unicredit.pfm.entities.Keyword;
import ro.unicredit.pfm.services.dtos.requests.RequestKeywordDto;

import java.util.List;

public interface RequestKeywordMapper {
    RequestKeywordDto toDto(Keyword keyword);
    Keyword toEntity(RequestKeywordDto requestKeywordDto);
    List<RequestKeywordDto> toKeywordDtoList(List<Keyword> keywords);
}
