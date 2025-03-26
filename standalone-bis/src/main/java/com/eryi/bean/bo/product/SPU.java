package com.eryi.bean.bo.product;

import lombok.*;

import java.util.List;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SPU {
    private String id;
    private List<Spec> specs;
    private List<SKU> skus;
    //产品主图
    private String mainImage;
    private String productId;
    //显示价格
    private String viewPrice;
}
