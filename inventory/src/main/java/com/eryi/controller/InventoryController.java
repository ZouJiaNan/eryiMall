package com.eryi.controller;

import com.eryi.domain.Inventory;
import com.eryi.domain.query.InventoryQuery;
import com.eryi.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class InventoryController{
    @Autowired
    InventoryService inventoryService;
    public int addInventory(Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    public int updateInventory(Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }

    public Inventory getInventoryById(String id) {
        return inventoryService.getInventoryById(id);
    }

    public List<Inventory> getInventoryList(InventoryQuery inventoryQuery) {
        return inventoryService.getInventoryList(inventoryQuery);
    }
}
