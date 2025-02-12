package com.eryi.mapper;

import com.eryi.bo.Inventory;
import com.eryi.bo.OrderItem;
import com.eryi.bo.query.InventoryQuery;
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
