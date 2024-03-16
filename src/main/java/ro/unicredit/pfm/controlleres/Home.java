package ro.unicredit.pfm.controlleres;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.unicredit.pfm.services.CategoryService;

@RestController("/home")
public class Home {
    private CategoryService categoryService;
    @GetMapping
    public String home() {
        return "Welcome to PFM";
    }
}
