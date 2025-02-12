package com.eryi.bean.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private String categoryId;
    private String tags;
    private String specs;
    private String freeTemplateId;
    private String name;
}
