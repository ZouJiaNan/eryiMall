package com.eryi.service.Impl;

import com.eryi.bo.Inventory;
import com.eryi.bo.OrderItem;
import com.eryi.bo.query.InventoryQuery;
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
        return inventoryMapper.lockStockByProductId(orderItem);
    }
}
