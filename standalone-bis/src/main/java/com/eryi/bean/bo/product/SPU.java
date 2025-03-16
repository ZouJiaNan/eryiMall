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
    private List<Spec> spes;
    private List<SKU> skus;
    private String mainImage;
}
