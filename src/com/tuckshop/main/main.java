package com.tuckshop.main;

import com.tuckshop.model.product;
import com.tuckshop.model.transactions;
import com.tuckshop.services.Invetory;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Invetory inventory = new Invetory();
        ArrayList<transactions> transactionsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== TUCKSHOP INVENTORY SYSTEM ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Sell Product");
            System.out.println("4. Low Stock Alert");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.next();

                    System.out.print("Enter Name: ");
                    String name = scanner.next();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();

                    inventory.addProduct(new product(id, name, price, qty));
                    System.out.println("Product added.");
                    break;

                case 2:
                    inventory.viewProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    String sellId = scanner.next();

                    System.out.print("Enter Quantity: ");
                    int sellQty = scanner.nextInt();

                    boolean success = inventory.sellProduct(sellId, sellQty);

                    if (success) {
                        transactionsList.add(new transactions(sellId, sellQty));
                        System.out.println("Sale successful.");
                    }
                    break;

                case 4:
                    inventory.lowStockAlert(5);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}