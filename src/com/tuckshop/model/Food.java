package com.tuckshop.model;

public class Food extends Product {
    private int calories;

    public Food(String id, String name, double price, int quantity, int calories) {
        super(id, name, price, quantity);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }
}