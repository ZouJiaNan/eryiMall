package com.eryi.bean.po;

import lombok.*;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoryPo {
    private String id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 排序编码
     */
    private int level;
    /**
     * 父分类
     */
    private String parentId;
    /**
     * 平台分成比列 %
     */
    private BigDecimal platformDivision;
}
