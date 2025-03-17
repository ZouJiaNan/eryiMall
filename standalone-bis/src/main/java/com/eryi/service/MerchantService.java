package com.eryi.service;

import com.eryi.bean.bo.product.*;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.dao.ShipingFeeTempDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MerchantService {
    /**
     * ������Ʒ
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     * ��������
     * @param category
     * @return
     */
    int addCategory(Category category);

    /**
     * �����˷�ģ��
     * @param shipingFeeTemp
     * @return
     */
    int addShipingFeeTemp(ShipingFeeTemp shipingFeeTemp);
    /**
     * �༭������Ϣ
     * @param onSale
     * @return
     */
    int editOnSale(OnSale onSale);
    /**
     * ����������Ϣ
     * @param onSale
     * @return
     */
    int addOnSale(OnSale onSale);
    /**
     * ��ȡ�˷�ģ���б�
     * @param userId
     * @return
     */
    List<ShipingFeeTemp> getShipingFeeTempList(String userId);
    /**
     * ��ȡ��Ʒ�б�
     * @param userId
     * @return
     */
    List<Product> getProductList(String userId);
    /**
     * ����SPU
     * @param spuJson
     * @return
     */
    int addSPU(String productId,String spuJson);

    /**
     * ����SKU
     * @param productId
     * @param skuJson
     * @return
     */
    int addSKU(String productId,String skuJson);
}
