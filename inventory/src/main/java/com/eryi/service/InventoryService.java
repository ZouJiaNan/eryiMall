package com.eryi.service;

import com.eryi.bo.Inventory;
import com.eryi.bo.OrderItem;
import com.eryi.bo.query.InventoryQuery;

import java.util.List;

public interface InventoryService {
    int addInventory(Inventory inventory);
    int updateInventory(Inventory inventory);
    Inventory getInventoryById(String id);
    List<Inventory> getInventoryList(InventoryQuery inventoryQuery);
    int lockStockByProductId(OrderItem orderItem);
}
