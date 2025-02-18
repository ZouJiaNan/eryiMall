package com.eryi.bean.po;

import com.eryi.bean.bo.shop.RegionTemplate;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShipingFeeTempPo {
    private String id;
    /**
     * ����
     */
    private String shopId;
    /**
     * ����
     */
    private String name;
    /**
     * �Ʒѹ���
     * 1-�Ʒѡ�2-�Ƽ���3-�����
     */
    private int type;
}
