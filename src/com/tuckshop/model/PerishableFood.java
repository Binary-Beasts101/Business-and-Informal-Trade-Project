package com.tuckshop.model;

public class PerishableFood extends Food {
    private String expiryDate;

    public PerishableFood(String id, String name, double price, int quantity, int calories, String expiryDate) {
        super(id, name, price, quantity, calories);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }
}
