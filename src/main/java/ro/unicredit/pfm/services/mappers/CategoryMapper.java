package ro.unicredit.pfm.services.mappers;

import org.mapstruct.Mapper;
import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.services.dtos.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto categoryDto);
}
