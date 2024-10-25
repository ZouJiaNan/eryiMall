package com.eryi.controller;

import com.eryi.domain.Product;
import com.eryi.dto.ResultBean;
import com.eryi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController{

    @Autowired
    ProductService productService;
    @RequestMapping("/getProductById")
    public ResultBean getProductById(String id) {
        return success(productService.getProductById(id));
    }


    @RequestMapping("/addProduct")
    public ResultBean addProduct(Product product) {
        return success(productService.addProduct(product));
    }


    @RequestMapping("/deleteProduct")
    public ResultBean deleteProductById(String id) {
        return success(productService.deleteProductById(id));
    }


    @RequestMapping("/updateProduct")
    public ResultBean updateProduct(Product product) {
        return success(productService.updateProduct(product));
    }
}
