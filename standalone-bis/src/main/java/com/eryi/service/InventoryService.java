package com.eryi.service;

import com.eryi.domain.Inventory;
import com.eryi.domain.query.InventoryQuery;

import java.util.List;

public interface InventoryService {
    int addInventory(Inventory inventory);
    int updateInventory(Inventory inventory);
    Inventory getInventoryById(String id);
    List<Inventory> getInventoryList(InventoryQuery inventoryQuery);
}
