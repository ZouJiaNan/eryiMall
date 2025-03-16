package com.eryi.controller;

import com.eryi.bean.bo.product.*;
import com.eryi.bean.bo.shop.ShipingFeeTemp;
import com.eryi.bean.bo.shop.Shop;
import com.eryi.bean.dto.*;
import com.eryi.service.MerchantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 商家相关接口
 */
@RestController
@RequestMapping("/bis/merchant/")
public class MerchantController extends BaseController {
    @Autowired
    MerchantService merchantService;

    /**
     * 新增分类
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
     * 新增商品
     */
    @PostMapping("/addProduct")
    public ResultBean addProduct(@RequestBody ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.getCategory().setId(productDto.getCategoryId());
        product.setTags(productDto.getTags());
        product.getShipingFeeTemp().setId(productDto.getFreeTemplateId());
        return success(merchantService.addProduct(product));
    }

    /**
     * 新增SPU
     * @param spuDto
     * @return
     */
    @PostMapping("/spu")
    public ResultBean addSPU(@RequestBody SPUDto spuDto) {
        SPU spu = new SPU();
        spu.setId(UUID.randomUUID().toString());
        spu.setMainImage(spuDto.getMainImage());
        spu.setSpes(spuDto.getSpecs());
        return success(merchantService.addSPU(spu));
    }

    /**
     * 获得SPU
     * @param userId
     * @param spuDto
     * @return
     */
    @GetMapping("/spu")
    public ResultBean getSPU(String userId,SPUDto spuDto) {
        SPU spu = new SPU();
        spu.setId(UUID.randomUUID().toString());
        spu.setMainImage(spuDto.getMainImage());
        spu.setSpes(spuDto.getSpecs());
        return success(merchantService.addSPU(spu));
    }

    /**
     * 新增SKU
     * @param userId
     * @param skuDto
     * @return
     */
    @PostMapping("/sku")
    public ResultBean addSKU(String userId,SkuDto skuDto) {
        SKU sku = new SKU();
        sku.setId(UUID.randomUUID().toString());
        sku.setSpecValues(skuDto.getSpecValues());
        sku.setProductId(skuDto.getProductId());
        return success(merchantService.addSKU(sku));
    }


    /**
     * 修改商品上架/下架 状态
     * @return
     */
    @PostMapping("/changeListStatus")
    public ResultBean changeListStatus() {
        return null;
    }

    /**
     * 编辑售卖信息
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
     * 新增售卖信息
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
     * 新增运费模板
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
     * 获取运费模板列表
     * @param userId
     * @return
     */
    @GetMapping("/shipFeeTemp")
    public ResultBean getShipingFeeTempList(String userId) {
        return success(merchantService.getShipingFeeTempList(userId));
    }

    /**
     * 获取商品列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getProductList")
    public ResultBean getProductList(String userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList = merchantService.getProductList(userId);
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        return success(pageInfo);
    }

    /**
     * 新增销售信息
     * @param userId
     * @param onsaleDto
     * @return
     */
    @PostMapping("/onSale")
    public ResultBean addOnSale(String  userId,OnsaleDto onsaleDto) {
        OnSale onSale=new OnSale();
        onSale.setId(UUID.randomUUID().toString());
        onSale.setSalePrice(onsaleDto.getSalePrice());
        onSale.setPrice(onsaleDto.getPrice());
        onSale.setAmount(onsaleDto.getAmount());
        onSale.setStartTime(onsaleDto.getStartTime());
        onSale.setEndTime(onsaleDto.getEndTime());
        onSale.setListingStatus(onsaleDto.getListingStatus());
        onSale.setOrderNum(onsaleDto.getOrderNum());
        onSale.setSkuCode(onsaleDto.getSkuCode());
        return success(merchantService.addOnSale(onSale));
    }

    /**
     * 发货
     *
     * @return
     */
    public ResultBean sendOutOrder() {
        return null;
    }

    /**
     * 新增SPU
     * @param userId
     * @param spuDto
     * @return
     */
    public ResultBean addSPU(String userId,SPUDto spuDto) {
        SPU spu = new SPU();
        spu.setId(UUID.randomUUID()+"");
        spu.setMainImage(spuDto.getMainImage());
        spu.setSpes(spuDto.getSpecs());
        return  success(merchantService.addSPU(spu));
    }
}
