package com.eryi.bean.bo.product;

import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@Setter
@Getter
public class Product {
    private String id;
    /**
     * 所属分类
     */
    private Category category;
    /**
     * 名称
     */
    private String name;
    /**
     * 标签
     */
    private String tags;
    /**
     * 平台分成
     */
    private BigDecimal platformDivision;
    /**
     * 关联商品
     */
    private List<Product> associatedProds;
    /**
     * 优惠活动
     */
    private BaseCouponDiscount couponDiscount;
    /**
     * 运费模板
     */
    private ShipingFeeTemp shipingFeeTemp;
    /**
     * 商铺
     */
    private Shop shop;
    /**
     * 描述
     */
    private String description;
    /**
     * 标准产品单元
     */
    private SPU spu;

    public Product(){
        this.category=new Category();
        this.shipingFeeTemp=new ShipingFeeTemp();
    }
}
