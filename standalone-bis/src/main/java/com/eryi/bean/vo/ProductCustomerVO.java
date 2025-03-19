package com.eryi.bean.vo;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCustomerVO {
    private String id;
    private String name;
    private String price;
    private String mainImage;
    private String tags;
}
