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
     * ��������
     */
    private String categoryId;
    /**
     * ����
     */
    private String name;
    /**
     * ��ǩ
     */
    private String tags;
    /**
     * ����
     */
    private BigDecimal platformDivision;
    /**
     * ������Ʒ
     */
    private String associatedProdIds;
    /**
     * �Żݻ
     */
    private String couponDiscountId;
    /**
     * �˷�ģ��
     */
    private String shipingFeeTempId;
    /**
     * ����
     */
    private String shopId;
    /**
     * spu��json
     */
    private String spu;
    /**
     * sku��json
     */
    private String sku;
}
