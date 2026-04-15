package com.tuckshop.services;

import com.tuckshop.model.product;
import java.util.ArrayList;

public class Invetory {
    private ArrayList<product> productsList = new ArrayList<>();

    public void addProduct(product p) {
        productsList.add(p);
    }

    public void viewProducts() {
        if (productsList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (product p : productsList) {
            System.out.println(p);
        }
    }

    public product findProductById(String id) {
        for (product p : productsList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean sellProduct(String id, int quantity) {
        product p = findProductById(id);

        if (p == null) {
            System.out.println("Product not found.");
            return false;
        }

        if (p.getQuantity() < quantity) {
            System.out.println("Not enough stock.");
            return false;
        }

        p.decreaseStock(quantity);
        return true;
    }

    public void lowStockAlert(int threshold) {
        System.out.println("Low stock items:");
        for (product p : productsList) {
            if (p.getQuantity() <= threshold) {
                System.out.println(p);
            }
        }
    }
}