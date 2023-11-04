/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Product;
import Entity.Storekeeper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class Display {

    /**
     * Description: Displays the main menu options.
     */
    public void displayMenu() {
        System.out.println();
        System.out.println("                                        MENU                                         ");
        System.out.println("=====================================================================================");
        System.out.println("1. Add Storekeeper");
        System.out.println("2. Add product");
        System.out.println("3. Update product");
        System.out.println("4. Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("5. Sort product by Expiry date, Date of manufacture");
        System.out.println("6. Exit");
        System.out.println("=====================================================================================");
    }

    /**
     * Description: Displays the list of storekeepers.
     *
     * @param storeList The list of storekeepers.
     */
    public void displayStorekeeper(ArrayList<Storekeeper> storeList) {
        if (storeList.isEmpty()) {
            System.out.println("Store list is empty!");
        } else {
            System.out.println("=======Storekeeper List=========");
            System.out.format("%-5s%-35s\n", "ID", "Name");

            for (Storekeeper storekeeper : storeList) {
                System.out.format("%-5s%-35s\n", storekeeper.getStoreKeeperID(), storekeeper.getStoreKeeperName());
            }
        }
    }

    /**
     * Description: Displays the list of products.
     *
     * @param productList The list of products.
     */
    public void displayProductList(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.out.println("Product list is empty!");
        } else {
            System.out.println("==========Product List===========");
            System.out.format("%-3s%-20s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n",
                    "ID", "Name", "Location", "Price", "Manufacture date",
                    "Expiry date", "Category", "Storekeeper", "Receipt date");

            for (Product product : productList) {
                displayProduct(product);
            }
        }
    }

    /**
     * Description: Displays the details of a product.
     *
     * @param product The product to display.
     */
    public void displayProduct(Product product) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String expiryDate = dateFormat.format(product.getExpiryDate());
        String dateOfManu = dateFormat.format(product.getDateOfManufacture());
        String receiptDate = dateFormat.format(product.getReceiptDate());
        System.out.format("%-3d%-20s%-10s%-10s%-20s%-20s%-15s%-20s%-15s\n",
                product.getProductID(), product.getProductName(), product.getLocation(),
                product.getPrice(), dateOfManu, expiryDate, product.getCategory(),
                product.getStoreKeeper().getStoreKeeperName(), receiptDate);
    }

    /**
     * Description: Displays the update menu options.
     */
    public void displayUpdateMenu() {
        System.out.println();
        System.out.println("                                        UPDATE MENU                                         ");
        System.out.println("=====================================================================================");
        System.out.println("1. Update product ID");
        System.out.println("2. Update product name");
        System.out.println("3. Update location");
        System.out.println("4. Update price");
        System.out.println("5. Update expiry date");
        System.out.println("6. Update date of manufacture");
        System.out.println("7. Update category");
        System.out.println("8. Update storekeeper");
        System.out.println("9. Update receipt date");
        System.out.println("10. Exit");
        System.out.println("=====================================================================================");
    }

    /**
     * Description: Displays the search menu options.
     */
    public void displaySearchMenu() {
        System.out.println("=================SEARCH MENU==================");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by category");
        System.out.println("3. Search by storekeeper");
        System.out.println("4. Search by receipt date");
    }

}
