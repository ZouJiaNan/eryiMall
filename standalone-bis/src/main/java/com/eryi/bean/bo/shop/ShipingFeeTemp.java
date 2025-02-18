package com.eryi.bean.bo.shop;

import com.eryi.bean.po.RegionTemplatePo;
import com.eryi.dao.RegionTemplateDao;
import com.eryi.dao.ShipingFeeTempDao;
import lombok.*;

import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.List;

/**
 * �˷�ģ��
 */
@Data
@AllArgsConstructor
@Setter
@Getter
public class ShipingFeeTemp {
    private ShipingFeeTempDao shipingFeeTempDao;
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

    public ShipingFeeTemp() {
        this.regionTemplateList = new ArrayList<>();
    }

    public int addRegionTemplate(List<RegionTemplate> regionTemplateList){
        return shipingFeeTempDao.addRegionTemplate(regionTemplateList);
    }
}
