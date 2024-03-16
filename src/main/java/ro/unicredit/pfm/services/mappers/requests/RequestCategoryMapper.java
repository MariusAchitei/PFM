package ro.unicredit.pfm.services.mappers.requests;

import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.services.dtos.requests.RequestCategoryDto;

public interface RequestCategoryMapper {
    RequestCategoryDto toDto(Category category);
    Category toEntity(RequestCategoryDto requestCategoryDto);
}
