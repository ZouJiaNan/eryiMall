package com.eryi.bean.po;

import com.eryi.bean.bo.common.User;
import com.eryi.bean.bo.pay.PayTransection;
import com.eryi.bean.bo.pay.RefundTransection;
import com.eryi.bean.bo.pay.order.LogisticsNews;
import com.eryi.bean.bo.pay.order.OrderItem;
import com.eryi.bean.bo.shop.Shop;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPo {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户
     */
    private String userId;
    /**
     * 商铺
     */
    private String shopId;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 支付交易
     */
    private String payTransectionId;
    /**
     * 退款交易
     */
    private String refundTransectionId;

    /**
     * 状态
     * 1.未支付 2.已支付 3.已发货 4.已收货 5.已退款 6.已取消
     */
    private int status;

    /**
     * 物流消息
     */
    private LogisticsNews logisticsNews;

    /**
     * 运费
     */
    private BigDecimal shipingFee;
}
