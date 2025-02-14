package com.eryi.bean.bo.shop;

import lombok.*;

import java.math.BigDecimal;

/**
 * 地区模板
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegionTemplate {
    /**
     * 地区编码
     */
    private String areaCode;
    /**
     * 地区名称
     */
    private String areaName;
    /**
     * 首量
     */
    private BigDecimal firstUnit;
    /**
     * 首价
     */
    private BigDecimal firstUnitPrice;
    /**
     * 续量
     */
    private BigDecimal nextUnit;
    /**
     * 续价
     */
    private BigDecimal nextUnitPrice;
    /**
     * 免邮条件
     */
    private BigDecimal freeCondition;
}
