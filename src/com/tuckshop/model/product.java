package com.tuckshop.model;

public class product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseStock(int amount) {
        this.quantity += amount;
    }

    public void decreaseStock(int amount) {
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Price: " + price +
                " | Stock: " + quantity;
    }
}