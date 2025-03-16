package com.eryi.bean.dto;

import com.eryi.bean.bo.product.Spec;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SPUDto {
    private List<Spec> specs;
    private String mainImage;
    private String productId;
}
