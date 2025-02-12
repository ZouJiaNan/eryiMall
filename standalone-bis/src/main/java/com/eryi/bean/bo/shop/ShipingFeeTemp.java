package com.eryi.bean.bo.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * �˷�ģ��
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipingFeeTemp {
    private String id;
    /**
     * ����
     */
    private Shop shop;
    /**
     * ����
     */
    private String name;
    /**
     * ����ģ��
     */
    private List<RegionTemplate> regionTemplateList;
    /**
     * �Ʒѹ���
     * 1-�Ʒѡ�2-�Ƽ���3-�����
     */
    private int type;
}
