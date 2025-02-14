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
 * 商家相关接口
 */
@RestController
public class MerchantController extends BaseController {
    @Autowired
    MerchantService merchantService;

    /**
     * 新增商品
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
     * 新增分类
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
     * 修改商品上架/下架 状态
     *
     * @return
     */
    @PostMapping("/changeListStatus")
    public ResultBean changeListStatus() {
        return null;
    }

    /**
     * 编辑售卖信息
     *
     * @return
     */
    @PostMapping("/editOnSale")
    public ResultBean editOnSale() {
        return null;
    }

    /**
     * 新增运费模板
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
     * 发货
     *
     * @return
     */
    public ResultBean sendOutOrder() {
        return null;
    }
}
