import java.util.ArrayList;

/**
 * InventoryManager System 
 * Developed for the CSI142 Tuck Shop Project.
 * This class uses Composition to manage products and track daily sales.
 */
public class InventoryManager {
    
    // Using Composition: This manager holds the collection of stock items
    private ArrayList<Product> stockList;

    public InventoryManager() {
        // Initializing the list when the manager is created
        this.stockList = new ArrayList<>();
    }

    // Function to add a new product into the system
    public void registerNewProduct(Product item) {
        stockList.add(item);
        System.out.println("System Log: " + item.getName() + " has been added to the shop.");
    }

    // Displays the full inventory and highlights items that need restocking
    public void showInventoryStatus() {
        System.out.println("\n--- TUCK SHOP CURRENT STOCK ---");
        for (Product item : stockList) {
            System.out.println("Product: " + item.getName() + 
                               " | Quantity: " + item.getQuantity() + 
                               " | Unit Price: P" + item.getPrice());
            
            // Logic for the Low Stock Alert system
            if (item.getQuantity() < 5) {
                System.out.println("!!! ATTENTION: " + item.getName() + " is running low on stock.");
            }
        }
    }

    // Handles the sale process and updates stock levels automatically
    public void processSale(String nameOfItem, int amountSold) {
        for (Product item : stockList) {
            // Case-insensitive check to find the product
            if (item.getName().equalsIgnoreCase(nameOfItem)) {
                if (item.getQuantity() >= amountSold) {
                    
                    // The core logic: Subtracting sold amount from current stock
                    item.setQuantity(item.getQuantity() - amountSold);
                    
                    double totalRevenue = item.getPrice() * amountSold;
                    System.out.println("Transaction Successful: P" + totalRevenue + " received.");
                    System.out.println("Updated stock level for " + nameOfItem + ": " + item.getQuantity());
                } else {
                    System.out.println("Transaction Failed: Insufficient stock for " + nameOfItem);
                }
                return;
            }
        }
        System.out.println("Error: Item not found in the inventory system.");
    }
}