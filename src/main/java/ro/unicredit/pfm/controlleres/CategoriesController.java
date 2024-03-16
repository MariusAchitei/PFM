package ro.unicredit.pfm.controlleres;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.unicredit.pfm.entities.Category;
import ro.unicredit.pfm.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAllCategories();
    }
}
