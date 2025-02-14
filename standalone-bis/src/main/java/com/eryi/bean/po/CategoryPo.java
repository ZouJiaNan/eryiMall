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
    private String parentId;
    /**
     * ƽ̨�ֳɱ��� %
     */
    private BigDecimal platformDivision;
}
