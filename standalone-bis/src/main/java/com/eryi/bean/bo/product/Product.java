package com.eryi.bean.bo.product;

import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.bo.shop.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
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
     * ���
     */
    private String specs;
    /**
     * ��ǩ
     */
    private String tags;
    /**
     * ����
     */
    private BigDecimal platformDivision;
    /**
     * ͼƬ·��
     */
    private String imags;
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

    public Product(){
        this.category=new Category();
        this.shipingFeeTemp=new ShipingFeeTemp();
    }
}
