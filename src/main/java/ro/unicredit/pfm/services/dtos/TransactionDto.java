package ro.unicredit.pfm.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private String description;
    private Date date;
    private BigDecimal amount;
    private Long categoryId;
    private Long keywordId;
    private Long parentId;

}
