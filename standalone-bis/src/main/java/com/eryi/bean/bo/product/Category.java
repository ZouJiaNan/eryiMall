package com.eryi.bean.bo.product;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * ��Ʒ����
 */
@Data
@Getter
@Setter
public class Category {
    private String id;
    /**
     * ��������
     */
    private String name;
    /**
     * �������
     */
    private int level;
    /**
     * ������
     */
    private Category parentCategory;
    /**
     * ƽ̨�ֳɱ��� %
     */
    private BigDecimal platformDivision;
}
