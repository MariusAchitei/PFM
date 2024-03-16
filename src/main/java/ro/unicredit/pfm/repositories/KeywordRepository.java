package ro.unicredit.pfm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.unicredit.pfm.entities.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
