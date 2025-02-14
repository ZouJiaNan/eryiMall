package com.eryi.bean.dto;

import com.eryi.bean.bo.shop.RegionTemplate;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShipingFeeTempDto {
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
     * ����ģ��
     */
    private List<RegionTemplate> regionTemplateList;
    /**
     * �Ʒѹ���
     * 1-�Ʒѡ�2-�Ƽ���3-�����
     */
    private int type;
}
