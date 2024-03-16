package ro.unicredit.pfm.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ro.unicredit.pfm.entities.Keyword;
import ro.unicredit.pfm.exceptions.NotFoundException;
import ro.unicredit.pfm.repositories.KeywordRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KeywordService {
    private final KeywordRepository keywordRepository;

    public Keyword findById(Long id) {
        return keywordRepository.findById(id).orElseThrow(() -> new NotFoundException("Keyword not found."));
    }

    public List<Keyword> findAll() {
        return keywordRepository.findAll();
    }

    public Keyword save(Keyword keyword) {
        return keywordRepository.save(keyword);
    }

    public Keyword delete(Keyword keyword) {
        keywordRepository.delete(keyword);
        return keyword;
    }

    public Keyword update(Keyword keyword) {
        Objects.requireNonNull(keyword);
        Optional<Keyword> keywordOptional = keywordRepository.findById(keyword.getId());
        if(keywordOptional.isEmpty()) {
            return save(keyword);
        }
        Keyword updatedKeyword = keywordOptional.get();
        updatedKeyword.setCategory(keyword.getCategory());
        updatedKeyword.setValue(keyword.getValue());
        return save(updatedKeyword);
    }
}
