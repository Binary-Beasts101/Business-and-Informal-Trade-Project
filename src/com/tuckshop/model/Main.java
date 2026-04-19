package com.tuckshop.model;

public class Main {
    public static void main(String[] args) {
        InventoryManager myTuckShop = new InventoryManager();

        product item1 = new product("P01", "Coke", 12.50, 10);
        product item2 = new product("P02", "Chips", 8.00, 20);
        product item3 = new product("P03", "Biscuits", 5.50, 15);

        myTuckShop.registerNewproduct(item1);
        myTuckShop.registerNewproduct(item2);
        myTuckShop.registerNewproduct(item3);

        myTuckShop.displayAllItems();

        System.out.println("\nSuccess! System is stable.");
    }
}