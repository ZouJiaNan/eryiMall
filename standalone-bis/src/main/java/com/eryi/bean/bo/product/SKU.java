package com.eryi.bean.bo.product;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SKU {
    private String id;
    private List<Spec> specs;
    private OnSale onSale;
    private String images;
    private String productId;
    private String skuCode;
}
