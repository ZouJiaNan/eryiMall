package com.eryi.bean.bo.shop;

import lombok.*;

import java.math.BigDecimal;

/**
 * ����ģ��
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegionTemplate {
    /**
     * ��������
     */
    private String areaCode;
    /**
     * ��������
     */
    private String areaName;
    /**
     * ����
     */
    private BigDecimal firstUnit;
    /**
     * �׼�
     */
    private BigDecimal firstUnitPrice;
    /**
     * ����
     */
    private BigDecimal nextUnit;
    /**
     * ����
     */
    private BigDecimal nextUnitPrice;
    /**
     * ��������
     */
    private BigDecimal freeCondition;
}
