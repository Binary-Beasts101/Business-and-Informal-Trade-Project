package com.tuckshop.services;

import com.tuckshop.model.Product;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> productsList = new ArrayList<>();

    public void addProduct(Product p) {
        productsList.add(p);
    }

    public void viewProducts() {
        if (productsList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product p : productsList) {
            System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Stock: " + p.getQuantity());
        }
    }

    public Product findProductById(String id) {
        for (Product p : productsList) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}