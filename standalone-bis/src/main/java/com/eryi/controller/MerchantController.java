package com.eryi.controller;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.bo.shop.Shop;
import com.eryi.bean.dto.*;
import com.eryi.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * �̼���ؽӿ�
 */
@RestController
@RequestMapping("/bis/merchant/")
public class MerchantController extends BaseController {
    @Autowired
    MerchantService merchantService;

    /**
     * ������Ʒ
     */
    @PostMapping("/addProduct")
    public ResultBean addProduct(@RequestBody ProductDto productDto) {
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
    @PostMapping("/category")
    public ResultBean addCategory(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(UUID.randomUUID()+"");
        category.setName(categoryDto.getName());
        category.setPlatformDivision(categoryDto.getPlatformDivision());
        category.setParentCategory(new Category());
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
     * @return
     */
    @PostMapping("/editOnSale")
    public ResultBean editOnSale(@RequestBody OnsaleDto onsaleDto) {
        OnSale onSale=new OnSale();
        onSale.setId(UUID.randomUUID().toString());
        onSale.setSalePrice(onsaleDto.getSalePrice());
        onSale.setAmount(onsaleDto.getAmount());
        onSale.setStartTime(onSale.getStartTime());
        onSale.setEndTime(onSale.getEndTime());
        onSale.setListingStatus(onsaleDto.getListingStatus());
        onSale.setOrderNum(onSale.getOrderNum());
        onSale.setProduct(new Product());
        onSale.getProduct().setId(onsaleDto.getProductId());
        return success(merchantService.editOnSale(onSale));
    }

    /**
     * ����������Ϣ
     * @return
     */
    @PostMapping("/addOnSale")
    public ResultBean addOnSale(@RequestBody OnsaleDto onsaleDto) {
        OnSale onSale=new OnSale();
        onSale.setId(UUID.randomUUID().toString());
        onSale.setSalePrice(onsaleDto.getSalePrice());
        onSale.setPrice(onsaleDto.getPrice());
        onSale.setAmount(onsaleDto.getAmount());
        onSale.setStartTime(onsaleDto.getStartTime());
        onSale.setEndTime(onsaleDto.getEndTime());
        onSale.setListingStatus(onsaleDto.getListingStatus());
        onSale.setOrderNum(onsaleDto.getOrderNum());
        onSale.setProduct(new Product());
        onSale.getProduct().setId(onsaleDto.getProductId());
        return success(merchantService.addOnSale(onSale));
    }

    /**
     * �����˷�ģ��
     */
    @PostMapping("/shipFeeTemp")
    public ResultBean addShipingFeeTemp(@RequestBody ShipingFeeTempDto shipingFeeTempDto) {
        ShipingFeeTemp shipingFeeTemp = new ShipingFeeTemp();
        shipingFeeTemp.setId(UUID.randomUUID()+"");
        shipingFeeTemp.setName(shipingFeeTempDto.getName());
        Shop shop = new Shop();
        shop.setId(shipingFeeTempDto.getShopId());
        shipingFeeTemp.setShop(shop);
        shipingFeeTemp.setRegionTemplateList(shipingFeeTempDto.getRegionTemplateList());
        shipingFeeTemp.getRegionTemplateList().forEach(regionTemplate -> {
            regionTemplate.setShipingFeeTempId(shipingFeeTemp.getId());
        });
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
