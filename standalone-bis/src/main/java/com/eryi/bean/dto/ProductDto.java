package com.eryi.bean.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private String categoryId;
    private String tags;
    private String freeTemplateId;
    private String name;
    private BigDecimal platformDivision;
}
