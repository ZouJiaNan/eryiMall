package com.eryi.bean.bo.customer;

import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.bo.product.Product;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 购物车子项
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarItem {
    private String id;
    private String carId;
    private OnSale onSale;
}
