/*
 * Author: Wayne Ashley
 * Task: Milestone 3 - Tuck Shop Management System
 * Description: Handles inventory storage, sales calculations, and stock display.
 */
package com.tuckshop.services;

import java.util.ArrayList;
import com.tuckshop.model.Product;

public class InventoryManager {
    private ArrayList<Product> stockList = new ArrayList<>();
    private double totalRevenue = 0.0; // Added for receipt tracking

    public void registerNewProduct(Product item) {
        stockList.add(item);
    }

    public void displayReceipt() {
        System.out.println("\n======= OFFICIAL TUCK SHOP RECEIPT =======");
        System.out.println(String.format("%-10s %-15s %-10s %-10s", "ID", "NAME", "PRICE", "STOCK"));
        System.out.println("-------------------------------------------");

        for (Product item : stockList) {
            System.out.println(String.format("%-10s %-15s P%-9.2f %-10d",
                    item.getId(), item.getName(), item.getPrice(), item.getQuantity()));
        }

        System.out.println("-------------------------------------------");
        System.out.println("TOTAL REVENUE COLLECTED: P" + String.format("%.2f", totalRevenue));
        System.out.println("===========================================\n");
    }

    public void sellProduct(String id, int amount) {
        for (Product item : stockList) {
            if (item.getId().equalsIgnoreCase(id)) {
                if (item.getQuantity() >= amount && amount > 0) {
                    item.setQuantity(item.getQuantity() - amount);
                    double saleTotal = item.getPrice() * amount;
                    totalRevenue += saleTotal;

                    System.out.println("\n--- SALE SUCCESSFUL ---");
                    System.out.println("Sold: " + amount + " x " + item.getName());
                    System.out.println("Total Price: P" + String.format("%.2f", saleTotal));
                } else {
                    System.out.println("\nERROR: Not enough stock or invalid amount!");
                }
                return;
            }
        }
        System.out.println("\nERROR: Product ID '" + id + "' not found.");
    }
}