package ro.unicredit.pfm.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "pfm_keyword")
@Data
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
