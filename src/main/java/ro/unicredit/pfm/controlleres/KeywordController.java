package ro.unicredit.pfm.controlleres;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.unicredit.pfm.entities.Keyword;
import ro.unicredit.pfm.services.KeywordService;

@Controller
@AllArgsConstructor
public class KeywordController {
    private final KeywordService keywordService;

    @GetMapping("/{id}")
    public Keyword findById(@PathVariable Long id) {
        return keywordService.findById(id);
    }
}
