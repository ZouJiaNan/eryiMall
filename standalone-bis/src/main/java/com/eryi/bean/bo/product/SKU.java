package com.eryi.bean.bo.product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SKU {
    private String id;
    private String specValues;
    private int amount;
    private OnSale onSale;
    private String images;
    private String productId;
}
