package com.eryi.bean.po;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegionTemplatePo {
    /**
     * �����˷�ģ��ID
     */
    private String shipingFeeTempId;
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
