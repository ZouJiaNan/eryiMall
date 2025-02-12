package com.eryi.controller;

import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * �̼���ؽӿ�
 */
@RestController
public class MerchantController extends BaseController{
    @Autowired
    MerchantService merchantService;
    /**
     * ������Ʒ
     */
    @PostMapping("/addProduct")
    public ResultBean addProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.getCategory().setId(productDto.getCategoryId());
        product.setSpecs(productDto.getSpecs());
        product.setTags(productDto.getTags());
        product.getShipingFeeTemp().setId(productDto.getFreeTemplateId());
        return success(merchantService.addProduct(product));
    }

    /**
     * �޸���Ʒ�ϼ�/�¼� ״̬
     * @return
     */
    @PostMapping("/changeListStatus")
    public ResultBean changeListStatus(){
        return null;
    }

    /**
     * �༭������Ϣ
     * @return
     */
    @PostMapping("/editOnSale")
    public ResultBean editOnSale(){
        return null;
    }

    /**
     * �����˷�ģ��
     */
    @PostMapping("/ShipFeeTemp")
    public ResultBean addShipingFeeTemp(){
        return null;
    }

    /**
     * ����
     * @return
     */
    public ResultBean sendOutOrder(){
        return null;
    }
}
