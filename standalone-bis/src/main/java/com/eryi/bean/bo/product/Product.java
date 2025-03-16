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
     * ��������
     */
    private Category category;
    /**
     * ����
     */
    private String name;
    /**
     * ��ǩ
     */
    private String tags;
    /**
     * ƽ̨�ֳ�
     */
    private BigDecimal platformDivision;
    /**
     * ������Ʒ
     */
    private List<Product> associatedProds;
    /**
     * �Żݻ
     */
    private BaseCouponDiscount couponDiscount;
    /**
     * �˷�ģ��
     */
    private ShipingFeeTemp shipingFeeTemp;
    /**
     * ����
     */
    private Shop shop;
    /**
     * ����
     */
    private String description;
    /**
     * ��׼��Ʒ��Ԫ
     */
    private SPU spu;

    public Product(){
        this.category=new Category();
        this.shipingFeeTemp=new ShipingFeeTemp();
    }
}
