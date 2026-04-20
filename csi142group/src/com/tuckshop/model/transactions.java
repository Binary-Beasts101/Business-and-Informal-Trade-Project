package com.tuckshop.model;

import java.time.LocalDateTime;

public class transactions {
    private String productId;
    private int quantitySold;
    private LocalDateTime date;

    public transactions(String productId, int quantitySold) {
        this.productId = productId;
        this.quantitySold = quantitySold;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                " | Sold: " + quantitySold +
                " | Date: " + date;
    }
}