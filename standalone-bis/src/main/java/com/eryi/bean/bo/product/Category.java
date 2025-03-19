package com.eryi.bean.bo.product;

import lombok.*;

import java.math.BigDecimal;

/**
 * 商品分类
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private String id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父分类
     */
    private String parentId;
    /**
     * 排序编码
     */
    private int level;
    /**
     * 父分类
     */
    private Category parentCategory;
    /**
     * 平台分成比列 %
     */
    private BigDecimal platformDivision;
}
