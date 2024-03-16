package ro.unicredit.pfm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.unicredit.pfm.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
