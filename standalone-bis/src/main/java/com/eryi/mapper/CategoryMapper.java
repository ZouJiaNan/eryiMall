package com.eryi.mapper;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.po.CategoryPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int addCategory(CategoryPo categoryPo);
    List<Category> getCategorys(CategoryPo categoryPo);
}
