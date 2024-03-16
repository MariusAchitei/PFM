package ro.unicredit.pfm.services.mappers.responses;

import org.mapstruct.Mapper;
import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.services.dtos.responses.ResponseCategoryDto;

@Mapper(componentModel = "spring")
public interface ResponseCategoryMapper {
    ResponseCategoryDto toDto(Category category);
    Category toEntity(ResponseCategoryDto responseCategoryDto);
}
