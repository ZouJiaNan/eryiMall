package com.eryi.bo.query;

import com.eryi.bo.Inventory;

public class InventoryQuery extends Inventory {
    protected int startIndex;
    protected int pageSize;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
