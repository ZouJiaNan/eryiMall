package com.eryi.bean.bo.shop;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Shop {
    private String id;
    /**
     * ��Ʒ��
     */
    private String name;
    /**
     * ���̱���
     */
    private String code;
    /**
     * ״̬
     */
    private int status;
}
