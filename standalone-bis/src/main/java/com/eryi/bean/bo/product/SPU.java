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
    //��Ʒ��ͼ
    private String mainImage;
    private String productId;
    //��ʾ�۸�
    private String viewPrice;
}
