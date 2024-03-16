package ro.unicredit.pfm.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.repositories.CategoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }
}
