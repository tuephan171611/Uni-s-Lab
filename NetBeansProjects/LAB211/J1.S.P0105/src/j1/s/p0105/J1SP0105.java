/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0105;

import Entity.Product;
import Entity.Storekeeper;
import Manager.Display;
import Manager.Manager;
import Manager.Search;
import Manager.Update;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class J1SP0105 {

    public static void main(String[] args) {
        // Create instances of necessary classes
        Manager manager = new Manager();
        Display display = new Display();
        Search search = new Search();
        Update update = new Update();

        // Create ArrayLists to store storekeepers and products
        ArrayList<Storekeeper> storeKeeperList = new ArrayList<>();
        ArrayList<Product> productList = new ArrayList<>();

        int choice;
        do {
            // Display the main menu
            display.displayMenu();

            // Prompt the user for a menu choice
            choice = manager.getMenuChoice(1, 6);

            // Process the user's choice
            switch (choice) {
                case 1:
                    // Add a new storekeeper
                    manager.addStoreKeeper(storeKeeperList);
                    break;
                case 2:
                    // Add a new product
                    manager.addProduct(storeKeeperList, productList);
                    break;
                case 3:
                    // Update a product
                    update.updateProduct(storeKeeperList, productList);
                    break;
                case 4:
                    // Search for a product
                    search.searchProduct(productList);
                    break;
                case 5:
                    // Sort the products
                    manager.sortProduct(productList);
                    break;
                case 6:
                    // Exit the program
                    System.exit(0);
                    break;
            }
        } while (choice != 6);
    }

}
