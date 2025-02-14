package com.eryi.controller;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.dto.CategoryDto;
import com.eryi.bean.dto.ProductDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.bean.dto.ShipingFeeTempDto;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * �̼���ؽӿ�
 */
@RestController
public class MerchantController extends BaseController {
    @Autowired
    MerchantService merchantService;

    /**
     * ������Ʒ
     */
    @PostMapping("/addProduct")
    public ResultBean addProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.getCategory().setId(productDto.getCategoryId());
        product.setSpecs(productDto.getSpecs());
        product.setTags(productDto.getTags());
        product.getShipingFeeTemp().setId(productDto.getFreeTemplateId());
        return success(merchantService.addProduct(product));
    }

    /**
     * ��������
     * @param categoryDto
     * @return
     */
    @PostMapping("/addCategory")
    public ResultBean addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(UUID.randomUUID()+"");
        category.setName(categoryDto.getName());
        category.setPlatformDivision(categoryDto.getPlatformDivision());
        category.getParentCategory().setId(categoryDto.getParentId());
        return success(merchantService.addCategory(category));
    }

    /**
     * �޸���Ʒ�ϼ�/�¼� ״̬
     *
     * @return
     */
    @PostMapping("/changeListStatus")
    public ResultBean changeListStatus() {
        return null;
    }

    /**
     * �༭������Ϣ
     *
     * @return
     */
    @PostMapping("/editOnSale")
    public ResultBean editOnSale() {
        return null;
    }

    /**
     * �����˷�ģ��
     */
    @PostMapping("/ShipFeeTemp")
    public ResultBean addShipingFeeTemp(ShipingFeeTempDto shipingFeeTempDto) {
        ShipingFeeTemp shipingFeeTemp = new ShipingFeeTemp();
        shipingFeeTemp.setId(UUID.randomUUID()+"");
        shipingFeeTemp.setName(shipingFeeTempDto.getName());
        shipingFeeTemp.setRegionTemplateList(shipingFeeTempDto.getRegionTemplateList());
        return success(merchantService.addShipingFeeTemp(shipingFeeTemp));
    }

    /**
     * ����
     *
     * @return
     */
    public ResultBean sendOutOrder() {
        return null;
    }
}
