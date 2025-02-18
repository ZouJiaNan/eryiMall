package com.eryi.bean.bo.shop;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shop {
    private String id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 商铺编码
     */
    private String code;
    /**
     * 状态
     */
    private int status;
}
