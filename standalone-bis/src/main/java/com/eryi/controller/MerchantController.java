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
 * �̼���ؽӿ�
 */
@RestController
@RequestMapping("/bis/merchant/")
public class MerchantController extends BaseController {
    @Autowired
    MerchantService merchantService;

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
     * ������Ʒ
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
     * ����SPU
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
     * ���SPU
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
     * ����SKU
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
     * �޸���Ʒ�ϼ�/�¼� ״̬
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
     * ��ȡ�˷�ģ���б�
     * @param userId
     * @return
     */
    @GetMapping("/shipFeeTemp")
    public ResultBean getShipingFeeTempList(String userId) {
        return success(merchantService.getShipingFeeTempList(userId));
    }

    /**
     * ��ȡ��Ʒ�б�
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
     * ����������Ϣ
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
     * ����
     *
     * @return
     */
    public ResultBean sendOutOrder() {
        return null;
    }

    /**
     * ����SPU
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
