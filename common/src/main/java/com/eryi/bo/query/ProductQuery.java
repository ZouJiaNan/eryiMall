package com.eryi.bo.query;

import com.eryi.bo.Product;

public class ProductQuery extends Product {
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
