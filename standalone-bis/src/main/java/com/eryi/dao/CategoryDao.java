package com.eryi.dao;

import com.eryi.bean.bo.product.Category;
import com.eryi.bean.po.CategoryPo;
import com.eryi.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {

    @Autowired
    CategoryMapper categoryMapper;
    public int addCategory(Category category){
        CategoryPo categoryPo = new CategoryPo();
        categoryPo.setId(categoryPo.getId());
        categoryPo.setName(categoryPo.getName());
        categoryPo.setParentId(categoryPo.getParentId());
        return categoryMapper.addCategory(categoryPo);
    }
}
