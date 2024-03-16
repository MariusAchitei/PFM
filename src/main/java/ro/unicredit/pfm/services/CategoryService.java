package ro.unicredit.pfm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories(){
        return categoryRepository.findAll();
    }
}
