package com.eryi.controller;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.bo.product.SKU;
import com.eryi.bean.dto.OrderDto;
import com.eryi.bean.dto.ResultBean;
import com.eryi.bean.po.CategoryPo;
import com.eryi.bean.po.OnSalePo;
import com.eryi.bean.vo.CategoryCustomerVO;
import com.eryi.bean.vo.ProductCustomerVO;
import com.eryi.service.CustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 顾客相关接口
 */
@RestController("BisOrderController")
@RequestMapping("/bis/customer")
public class CustomerController extends BaseController{

    @Autowired
    CustomerService customerService;

    /**
     * 获取分类列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getCategorys")
    public ResultBean getCategorys(String userId,int level,String parentId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        CategoryPo categoryPo=new CategoryPo();
        categoryPo.setLevel(level);
        categoryPo.setName("");
        categoryPo.setParentId(parentId);
        List<Category> categories = customerService.getCategorys(categoryPo);
        PageInfo<Category> pageInfo = new PageInfo<>(categories);
        List<CategoryCustomerVO> categorys = new ArrayList<>();
        pageInfo.getList().forEach(category -> {
            String id=category.getId();
            String name=category.getName();
            CategoryCustomerVO categoryCustomerVO=new CategoryCustomerVO(id,name,category.getParentId());
            categorys.add(categoryCustomerVO);
        });
        return success(categorys);
    }

    /**
     * 查看分类下的商品列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getProductsByCate")
    public ResultBean getProductsByCate(String userId,String categoryId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = customerService.getProducts(categoryId,null);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        List<ProductCustomerVO> productCustomerVOS = new ArrayList<>();
        pageInfo.getList().forEach(product -> {
            ProductCustomerVO productCustomerVO = new ProductCustomerVO();
            productCustomerVO.setId(product.getId());
            productCustomerVO.setName(product.getName());
            productCustomerVO.setMainImage(product.getSpu().getMainImage());
            productCustomerVO.setTags(product.getTags());
            productCustomerVO.setPrice(product.getSpu().getViewPrice());
            productCustomerVOS.add(productCustomerVO);
        });
        return success(productCustomerVOS);
    }

    /**
     * 搜索商品
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/searchProducts")
    public ResultBean searchProducts(String userId,String name,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = customerService.getProducts(null,name);
        PageInfo<Product> pageInfo = new PageInfo<>(products);
        List<ProductCustomerVO> results = new ArrayList<>();
        pageInfo.getList().forEach(product -> {
            String ProductName = product.getName();
            String id=product.getId();
            BigDecimal price=product.getSpu().getSkus().get(0).getOnSale().getPrice();
            BigDecimal salePrice=null;
            String images=product.getSpu().getMainImage();
            String tags=product.getTags();
            ProductCustomerVO productCustomerVO=new ProductCustomerVO(id,ProductName,price.toString(),images,tags);
            results.add(productCustomerVO);
        });
        return success(results);
    }

    /**
     * 查看商品详情
     * @param userId
     * @param productId
     * @return
     */
    @GetMapping("/getProductDetil")
    public ResultBean getProductDetail(String userId,String productId) {
        return success(customerService.getProductDetail(productId));
    }

    /**
     * 加入购物车
     * @param productId
     * @param userId
     * @return
     */
    @PostMapping("/carItem")
    public ResultBean addCarItem(String productId,String userId) {
        return success(customerService.addCarItem(userId,productId));
    }

    /**
     * 创建订单
     * @param orderDto
     */
    @PostMapping("order")
    public ResultBean createOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setUser(new User(orderDto.getUserId()));
        order.setAddress(orderDto.getAddress());
        order.setTotalShipingFee(orderDto.getShipingFee());
        order.setStatus(1);
        orderDto.getOrderItems().forEach(orderItemDto -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setId(UUID.randomUUID().toString());
            orderItem.setOrderId(order.getId());
            Product product = new Product();
            SKU sku=new SKU();
            sku.setSkuCode(orderItemDto.getSkuCode());
            OnSale onSale=new OnSale();
            onSale.setId(orderItemDto.getOnSaleId());
            sku.setOnSale(onSale);
            product.setSkus(new ArrayList<SKU>());
            product.getSkus().add(sku);
            product.setId(orderItemDto.getProductId());
            orderItem.setProduct(product);
            orderItem.setCount(orderItemDto.getCount());
            orderItem.setTotalPrice(orderItemDto.getTotalPrice());
            orderItem.setShipingFee(orderItemDto.getShipingFee());
            if(order.getOrderItems()==null) {
                order.setOrderItems(new ArrayList<>());
            }
            order.getOrderItems().add(orderItem);
            order.setTotalPrice(orderItem.getTotalPrice());
        });
        return success(customerService.createOrder(order));
    }

    /**
     * 生成支付界面
     * @param orderDto
     * @return
     */
    @RequestMapping("genernatePCAlipayHtml")
    public ResultBean genernatePCAlipayHtml(OrderDto orderDto){
        Order order=new Order();
        order.setId(orderDto.getOrderNum());
        order.setRemark(orderDto.getRemark());
        order.setTotalPrice(orderDto.getTotalPrice());
        return success(customerService.genernatePCAlipayHtml(order));
    }

    /**
     * 支付订单
     * @param order
     * @return
     */
    @PostMapping("payOrder")
    public ResultBean payOrder(Order order) {
        //支付订单
        //扣减库存
        return success(1);
    }
}
