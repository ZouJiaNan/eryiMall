package com.eryi.bean.dto.mapper;

import com.eryi.bean.po.CategoryPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    int addCategory(CategoryPo categoryPo);
}
