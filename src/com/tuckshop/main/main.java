package com.tuckshop.main;

import java.util.Scanner;
import com.tuckshop.model.Product;
import com.tuckshop.model.Food; // Import Food if you are using it
import com.tuckshop.services.InventoryManager;

public class Main {
    public static void main(String[] args) {
        InventoryManager myTuckShop = new InventoryManager();
        Scanner input = new Scanner(System.in);

        // Your pre-loaded items
        myTuckShop.registerNewProduct(new Food("P01", "Coke", 12.50, 10, 140));
        myTuckShop.registerNewProduct(new Food("P02", "Chips", 8.00, 20, 250));

        boolean active = true;
        while (active) {
            System.out.println("\n--- TUCK SHOP MANAGEMENT SYSTEM ---");
            System.out.println("1. View Stock/Receipt");
            System.out.println("2. Sell Item");
            System.out.println("3. Exit System");
            System.out.print("Select Option: ");

            String choice = input.nextLine();

            if (choice.equals("1")) {
                myTuckShop.displayReceipt(); // Your cool receipt is back!

            } else if (choice.equals("2")) {
                System.out.print("Enter Product ID: ");
                String id = input.nextLine();

                System.out.print("Amount to Sell: ");
                try {
                    int qty = Integer.parseInt(input.nextLine());
                    myTuckShop.sellProduct(id, qty);
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: Please enter a whole number for quantity.");
                }

            } else if (choice.equals("3")) {
                active = false;
                System.out.println("Shutting down... Goodbye!");
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
        input.close();
    }
}