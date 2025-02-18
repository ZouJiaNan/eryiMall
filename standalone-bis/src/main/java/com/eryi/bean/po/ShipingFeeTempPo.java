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
     * 商铺
     */
    private String shopId;
    /**
     * 名称
     */
    private String name;
    /**
     * 计费规则
     * 1-计费、2-计件、3-计体积
     */
    private int type;
}
