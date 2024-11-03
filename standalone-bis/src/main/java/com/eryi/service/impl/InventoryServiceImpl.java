package com.eryi.service.impl;

import com.eryi.domain.Inventory;
import com.eryi.domain.OrderItem;
import com.eryi.domain.query.InventoryQuery;
import com.eryi.mapper.InventoryMapper;
import com.eryi.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    InventoryMapper inventoryMapper;


    @Override
    public int addInventory(Inventory inventory) {
        return inventoryMapper.addInventory(inventory);
    }

    @Override
    public int updateInventory(Inventory inventory) {
        return inventoryMapper.updateInventory(inventory);
    }

    @Override
    public Inventory getInventoryById(String id) {
        return inventoryMapper.getInventoryById(id);
    }

    @Override
    public List<Inventory> getInventoryList(InventoryQuery inventoryQuery) {
        return inventoryMapper.getInventoryList(inventoryQuery);
    }

    @Override
    public int lockStockByProductId(OrderItem orderItem) {
        return 0;
    }
}
