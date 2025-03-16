package com.eryi.bean.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SkuDto {
    private String id;
    private String productId;
    private String specValues;
}
