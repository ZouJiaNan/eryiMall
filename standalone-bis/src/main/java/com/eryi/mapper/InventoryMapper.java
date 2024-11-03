package com.eryi.mapper;

import com.eryi.domain.Inventory;
import com.eryi.domain.OrderItem;
import com.eryi.domain.query.InventoryQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {
    int addInventory(Inventory inventory);
    int updateInventory(Inventory inventory);
    Inventory getInventoryById(String id);
    List<Inventory> getInventoryList(InventoryQuery inventoryQuery);
    int lockStockByProductId(OrderItem orderItem);
}
