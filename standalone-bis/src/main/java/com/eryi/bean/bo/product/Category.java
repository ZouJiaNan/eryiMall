package com.eryi.bean.bo.product;

import lombok.*;

import java.math.BigDecimal;

/**
 * ��Ʒ����
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private String id;
    /**
     * ��������
     */
    private String name;
    /**
     * ������
     */
    private String parentId;
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
