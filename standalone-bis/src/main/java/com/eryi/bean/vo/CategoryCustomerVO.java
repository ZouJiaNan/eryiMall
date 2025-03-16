package com.eryi.bean.vo;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCustomerVO {
    private String id;
    private String name;
    private String parentId;
}
