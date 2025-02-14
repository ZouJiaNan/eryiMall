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
     * 商铺
     */
    private String shopId;
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
}
