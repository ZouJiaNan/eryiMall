package com.eryi.dao;

import com.eryi.bean.bo.product.OnSale;
import com.eryi.bean.po.OnSalePo;
import com.eryi.mapper.OnSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OnSaleDao {
    @Autowired
    OnSaleMapper onSaleMapper;

    public int addOnSale(OnSale onSale){
        return onSaleMapper.addOnSale(BoToPo(onSale));
    }
    public int editOnSale(OnSale onSale){
        return onSaleMapper.editOnSale(BoToPo(onSale));
    }

    public List<OnSale> getOnSaleList(String userId){
        return onSaleMapper.getOnSaleList();
    }
    private OnSalePo BoToPo(OnSale onSale){
        OnSalePo onSalePo=new OnSalePo();
        onSalePo.setId(onSale.getId());
        onSalePo.setOrderNum(onSale.getOrderNum());
        onSalePo.setPrice(onSale.getPrice());
        onSalePo.setAmount(onSale.getAmount());
        onSalePo.setRemain(onSale.getRemain());
        onSalePo.setStartTime(onSale.getStartTime());
        onSalePo.setEndTime(onSale.getEndTime());
        onSalePo.setListingStatus(onSale.getListingStatus());
        onSalePo.setProductId(onSale.getProduct().getId());
        onSalePo.setSalePrice(onSale.getSalePrice());
        return onSalePo;
    }
}
