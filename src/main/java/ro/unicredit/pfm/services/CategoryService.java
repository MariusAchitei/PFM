package ro.unicredit.pfm.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.entities.Keyword;
import ro.unicredit.pfm.repositories.CategoryRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category delete(Category category) {
        categoryRepository.delete(category);
        return category;
    }

    public Category update(Category category) {
        Objects.requireNonNull(category);
        Optional<Category> categoryOptional = findById(category.getId());
        if(categoryOptional.isEmpty()) {
            return save(category);
        }
        Category updatedCategory = categoryOptional.get();
        updatedCategory.setValue(category.getValue());
        updatedCategory.setParent(category.getParent());
        return save(updatedCategory);
    }
}
