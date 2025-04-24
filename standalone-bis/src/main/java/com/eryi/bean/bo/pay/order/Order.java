package com.eryi.bean.bo.pay.order;

import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.shop.Shop;
import com.eryi.bean.dto.OrderItemDto;
import com.eryi.dao.OrderDao;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private OrderDao orderDao;
    /**
     * 主键
     */
    private String id;
    /**
     * 用户
     */
    private User user;
    /**
     * 商铺
     */
    private Shop shop;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 订单项
     */
    private List<OrderItem> orderItems;
    /**
     * 状态
     * 1.未支付 2.已支付 3.已发货 4.已收货 5.已退款 6.已取消 7.超期
     */
    private int status;

    /**
     * 支付渠道
     * 1.支付宝 2.微信 3.其他
     */
    private int channel;

    /**
     * 总价格
     */
    private BigDecimal totalPrice;

    /**
     * 总运费
     */
    private BigDecimal totalShipingFee;

    /**
     * 备注
     */
    private String remark;

    @JsonCreator
    public Order(@JsonProperty("id") String id) {
        this.id = id;
    }

    public int addOrderItem(OrderItem orderItem) {
        return orderDao.addOrderItem(orderItem);
    }
}
