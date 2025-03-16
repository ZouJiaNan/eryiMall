package com.eryi.bean.bo.product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * 规格实体
 */
public class Spec {
    private String id;
    /**
     * 规格名称
     */
    private String name;
    /**
     * 数据类型
     */
    private String type;
    /**
     * 单位
     */
    private String unit;
}
