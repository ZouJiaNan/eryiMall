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
        categoryPo.setId(category.getId());
        categoryPo.setName(category.getName());
        categoryPo.setParentId(category.getParentId());
        categoryPo.setLevel(category.getLevel());
        categoryPo.setPlatformDivision(category.getPlatformDivision());
        return categoryMapper.addCategory(categoryPo);
    }
}
