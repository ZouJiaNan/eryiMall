package com.eryi.bean.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private String name;
    private BigDecimal platformDivision;
    private int level;
    private String parentId;
}
