package com.eryi.bean.bo.product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
/**
 * ���ʵ��
 */
public class Spec {
    private String id;
    /**
     * �������
     */
    private String name;
    /**
     * ��������
     */
    private String type;
    /**
     * ��λ
     */
    private String unit;
}
