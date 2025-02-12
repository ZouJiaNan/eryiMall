package com.eryi.controller;

import com.eryi.bo.Inventory;
import com.eryi.bo.OrderItem;
import com.eryi.bo.query.InventoryQuery;
import com.eryi.dto.ResultBean;
import com.eryi.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Controller
public class InventoryController extends BaseController{
    @Autowired
    InventoryService inventoryService;

    private final ReentrantLock lock=new ReentrantLock();

    /**
     * Ëø¶¨¿â´æ
     * ¼´lock_stock+¶©µ¥¹ºÂòÁ¿&&actual_stock-¶©µ¥¹ºÂòÊýÁ¿
     * @param productId
     * @param stock
     * @return
     */
    public ResultBean lockStock(String productId, int stock){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(productId);
        orderItem.setCount(stock);
        return success(inventoryService.lockStockByProductId(orderItem));
    }
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
