package com.eryi.customer;

import com.eryi.Main;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.dto.OrderDto;
import com.eryi.bean.dto.OrderItemDto;
import com.eryi.controller.CustomerController;
import com.eryi.service.OrderDelayListenner;
import com.eryi.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest(classes = Main.class)
public class CustomerTest {
    @Autowired
    private CustomerController customerController;
    @Autowired
    private OrderDelayListenner orderDelayListenner;
    @Test
    private void testOrderOverDue(){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderItems(new ArrayList<OrderItemDto>());
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setOnSaleId("856b955d-c5de-40df-8a7d-05f14a7e0820");
        orderItemDto.setShipingFee(new BigDecimal("5.0"));
        orderItemDto.setTotalPrice(new BigDecimal("100.0"));
        orderItemDto.setCount(1);
        orderDto.getOrderItems().add(orderItemDto);
        orderDto.setUserId("1");
        orderDto.setShopId("1");
        orderDto.setAddress("1");
        orderDto.setStatus(1);
        orderDto.setShipingFee(new BigDecimal("5.0"));
        orderDto.setTotalCount(1);
        customerController.createOrder(orderDto);
    }
}
