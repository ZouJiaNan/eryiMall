package com.eryi.controller;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.order.Order;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.Category;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import com.eryi.bean.dto.OrderDto;
import com.eryi.bean.dto.ResultBean;
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
            orderItem.setOnSale(new OnSale(orderItemDto.getOnSaleId()));
            orderItem.setCount(orderItemDto.getCount());
            orderItem.setTotalPrice(orderItemDto.getTotalPrice());
            orderItem.setShipingFee(orderItemDto.getShipingFee());
            if(order.getOrderItems()==null) {
                order.setOrderItems(new ArrayList<>());
            }
            order.getOrderItems().add(orderItem);
        });
        return success(customerService.createOrder(order));
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

    /**
     * 获取分类列表
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/getCategorys")
    public ResultBean getCategorys(String userId,int level,String ParentId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categories = customerService.getCategorys(level,ParentId);
        PageInfo<Category> pageInfo = new PageInfo<>(categories);
        List<CategoryCustomerVO> categorys = new ArrayList<>();
        pageInfo.getList().forEach(category -> {
            String id=category.getId();
            String name=category.getName();
            String parentId=category.getParentId();
            CategoryCustomerVO categoryCustomerVO=new CategoryCustomerVO(id,name,parentId);
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
        List<OnSale> onSales = customerService.getProducts(categoryId,null);
        PageInfo<OnSale> pageInfo = new PageInfo<>(onSales);
        List<ProductCustomerVO> products = new ArrayList<>();
        pageInfo.getList().forEach(onSale -> {
            String name = onSale.getProduct().getName();
            String id=onSale.getProduct().getId();
            BigDecimal price=onSale.getPrice();
            BigDecimal salePrice=onSale.getSalePrice();
            String images=onSale.getProduct().getImags();
            String tags=onSale.getProduct().getTags();
            ProductCustomerVO productCustomerVO=new ProductCustomerVO(id,name,price.toString(),salePrice.toString(),images,tags);
            products.add(productCustomerVO);
        });
        return success(products);
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
        List<OnSale> products = customerService.getProducts(null,name);
        PageInfo<OnSale> pageInfo = new PageInfo<>(products);
        List<ProductCustomerVO> results = new ArrayList<>();
        pageInfo.getList().forEach(onSale -> {
            String ProductName = onSale.getProduct().getName();
            String id=onSale.getProduct().getId();
            BigDecimal price=onSale.getPrice();
            BigDecimal salePrice=onSale.getSalePrice();
            String images=onSale.getProduct().getImags();
            String tags=onSale.getProduct().getTags();
            ProductCustomerVO productCustomerVO=new ProductCustomerVO(id,ProductName,price.toString(),salePrice.toString(),images,tags);
            results.add(productCustomerVO);
        });
        return success(results);
    }

    /**
     * 查看商品详情
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/product")
    public ResultBean getProductDetail(String userId,String name,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OnSale> products = customerService.getProducts(null,name);
        PageInfo<OnSale> pageInfo = new PageInfo<>(products);
        List<ProductCustomerVO> results = new ArrayList<>();
        pageInfo.getList().forEach(onSale -> {
            String ProductName = onSale.getProduct().getName();
            String id=onSale.getProduct().getId();
            BigDecimal price=onSale.getPrice();
            BigDecimal salePrice=onSale.getSalePrice();
            String images=onSale.getProduct().getImags();
            String tags=onSale.getProduct().getTags();
            ProductCustomerVO productCustomerVO=new ProductCustomerVO(id,ProductName,price.toString(),salePrice.toString(),images,tags);
            results.add(productCustomerVO);
        });
        return success(results);
    }

    /**
     * 加入购物车
     * @param onSaleId
     * @param userId
     * @return
     */
    @PostMapping("/carItem")
    public ResultBean addCarItem(String onSaleId,String userId) {
        return success(customerService.addCarItem(userId,onSaleId));
    }
}
