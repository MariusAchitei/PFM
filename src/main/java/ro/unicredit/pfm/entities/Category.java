package ro.unicredit.pfm.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "pfm_category")
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

}
