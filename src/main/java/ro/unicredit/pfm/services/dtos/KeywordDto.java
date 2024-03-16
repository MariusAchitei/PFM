package ro.unicredit.pfm.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeywordDto {
    private Long id;
    private String value;
    private Long categoryId;
}
