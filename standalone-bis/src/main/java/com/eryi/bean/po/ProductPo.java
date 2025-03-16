package com.eryi.bean.po;

import com.eryi.bean.bo.product.BaseCouponDiscount;
import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.bo.shop.Shop;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Setter
@Getter
public class ProductPo {
    private String id;
    /**
     * 所属分类
     */
    private String categoryId;
    /**
     * 名称
     */
    private String name;
    /**
     * 标签
     */
    private String tags;
    /**
     * 描述
     */
    private BigDecimal platformDivision;
    /**
     * 关联商品
     */
    private String associatedProdIds;
    /**
     * 优惠活动
     */
    private String couponDiscountId;
    /**
     * 运费模板
     */
    private String shipingFeeTempId;
    /**
     * 商铺
     */
    private String shopId;
    /**
     * spu的json
     */
    private String spu;
    /**
     * sku的json
     */
    private String sku;
}
