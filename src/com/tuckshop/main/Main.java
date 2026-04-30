package com.tuckshop.main;

import java.util.Scanner;
import com.tuckshop.model.Product;
import com.tuckshop.model.Food;
import com.tuckshop.services.InventoryManager;

/**
 * Author: Wayne Ashley
 * Task: Milestone 3 - Tuck Shop Management System (Final Submission)
 */
public class Main {
    public static void main(String[] args) {
        InventoryManager myTuckShop = new InventoryManager();
        Scanner input = new Scanner(System.in);

        // Initial Data setup
        myTuckShop.registerNewProduct(new Food("P01", "Coke", 12.50, 10, 140));
        myTuckShop.registerNewProduct(new Food("P02", "Chips", 8.00, 20, 250));

        boolean active = true;
        while (active) {
            System.out.println("\n========================================");
            System.out.println("   TUCK SHOP MANAGEMENT SYSTEM v1.0   ");
            System.out.println("========================================");
            System.out.println("1. View Current Stock");
            System.out.println("2. Sell Item");
            System.out.println("3. Restock Item (Add Inventory)");
            System.out.println("4. Exit System");
            System.out.print("Select Option: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n--- CURRENT INVENTORY ---");
                    // This calls the display method to show stock levels
                    myTuckShop.displayReceipt();
                    break;

                case "2":
                    System.out.print("Enter Product ID to Sell: ");
                    String sellId = input.nextLine();
                    System.out.print("Quantity: ");
                    try {
                        int sellQty = Integer.parseInt(input.nextLine());
                        myTuckShop.sellProduct(sellId, sellQty);
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Quantity must be a number.");
                    }
                    break;

                case "3":
                    System.out.print("Enter Product ID to Restock: ");
                    String restockId = input.nextLine();
                    System.out.print("Amount to Add: ");
                    try {
                        int addQty = Integer.parseInt(input.nextLine());
                        myTuckShop.restockProduct(restockId, addQty);
                        System.out.println("SUCCESS: Inventory updated.");
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: Quantity must be a number.");
                    }
                    break;

                case "4":
                    active = false;
                    System.out.println("System shutting down... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
                    break;
            }
        }
        input.close();
    }
}
