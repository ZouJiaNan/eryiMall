package com.eryi.bean.bo.shop;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 运费模板
 */
@Data
@AllArgsConstructor
@Setter
@Getter
public class ShipingFeeTemp {
    private String id;
    /**
     * 商铺
     */
    private Shop shop;
    /**
     * 名称
     */
    private String name;
    /**
     * 地区模板
     */
    private List<RegionTemplate> regionTemplateList;
    /**
     * 计费规则
     * 1-计费、2-计件、3-计体积
     */
    private int type;

    public ShipingFeeTemp() {
        this.regionTemplateList = new ArrayList<>();
    }
}
