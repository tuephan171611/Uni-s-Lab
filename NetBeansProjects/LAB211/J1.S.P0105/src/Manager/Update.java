/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Product;
import Entity.Storekeeper;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author msi
 */
public class Update {

    Validation getData = new Validation();
    Display displayList = new Display();
    Manager manager = new Manager();

    /**
     * Description: Updates the ID of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateProductID(ArrayList<Product> productList, Product productUpdate) {
        System.out.println("Enter product ID:");
        do {
            int productID = getData.getInt("", "Input cannot be less than or equal to zero", 1, Integer.MAX_VALUE);
            if (!manager.checkProductIdExist(productList, productID)
                    || productUpdate.getProductID() == productID) {
                productUpdate.setProductID(productID);
                break;
            } else {
                System.err.println("Product ID is duplicate");
            }
        } while (true);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Updates the name of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateProductName(ArrayList<Product> productList, Product productUpdate) {
        String productName = getData.getString("Enter product name:");
        productUpdate.setProductName(productName);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Updates the location of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateProductLocation(ArrayList<Product> productList, Product productUpdate) {
        String location = getData.getString("Enter location:");
        productUpdate.setLocation(location);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Updates the price of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateProductPrice(ArrayList<Product> productList, Product productUpdate) {
        int price = getData.getInt("Enter price", "Price must be a positive number", 0, Integer.MAX_VALUE);
        productUpdate.setPrice(price);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Updates the expiry date of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateExpiryDate(ArrayList<Product> productList, Product productUpdate) {
        System.out.print("Enter product's expiry date[dd/MM/yyyy]:");
        do {
            Date expiryDate = getData.getDate();
            Date dateOfManu = productUpdate.getDateOfManufacture();
            if (expiryDate.before(dateOfManu)) {
                System.err.println("Expiry date must be after date of manufacture.");
            } else {
                productUpdate.setExpiryDate(expiryDate);
                break;
            }
        } while (true);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Updates the manufacture date of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateManufactureDate(ArrayList<Product> productList, Product productUpdate) {
        System.out.print("Enter product's manufacture date[dd/MM/yyyy]:");
        do {
            Date dateOfManu = getData.getDate();
            Date currentTimeNow = new Date();
            if (dateOfManu.after(currentTimeNow)) {
                System.err.println("Date of manufacture must be in the past.");
            } else {
                productUpdate.setDateOfManufacture(dateOfManu);
                break;
            }
        } while (true);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Updates the category of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateProductCategory(ArrayList<Product> productList, Product productUpdate) {
        String category = getData.getString("Enter category:");
        productUpdate.setCategory(category);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Updates the storekeeper of a product.
     *
     * @param storeList The list of storekeepers.
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateStoreKeeper(ArrayList<Storekeeper> storeList, ArrayList<Product> productList, Product productUpdate) {
        Display displayStoreList = new Display();
        displayStoreList.displayStorekeeper(storeList);
        do {
            int storeKeeperChoice = getData.getInt("Choose Storekeeper: ", "StoreID does not exist", 1, storeList.size());
            for (Storekeeper storekeeper : storeList) {
                if (storekeeper.getStoreKeeperID() == storeKeeperChoice) {
                    productUpdate.setStoreKeeper(storekeeper);
                    break;
                }
            }
            break;
        } while (true);
        displayStoreList.displayProductList(productList);
    }

    /**
     * Description: Updates the receipt date of a product.
     *
     * @param productList The list of products.
     * @param productUpdate The product to be updated.
     */
    public void updateReceiptDate(ArrayList<Product> productList, Product productUpdate) {
        System.out.print("Enter receipt date[dd/MM/yyyy]: ");
        do {
            Date receiptDate = getData.getDate();
            Date dateOfManu = productUpdate.getDateOfManufacture();
            Date expiryDate = productUpdate.getExpiryDate();
            if (receiptDate.before(dateOfManu) || receiptDate.after(expiryDate)) {
                System.err.println("Receipt date must be between " + dateOfManu + " and " + expiryDate);
            } else {
                productUpdate.setReceiptDate(receiptDate);
                break;
            }
        } while (true);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Gets the user's choice from a menu.
     *
     * @param min The minimum choice value.
     * @param max The maximum choice value.
     * @return The user's choice.
     */
    public int getMenuChoice(int min, int max) {
        return getData.getInt("Enter your choice: ", "Input is out of range: [" + min + "], [" + max + "]", min, max);
    }

    /**
     * Description: Provides a menu to update a product and handles the user's
     * choice.
     *
     * @param productList The list of products.
     * @param storeList The list of storekeepers.
     * @param productUpdate The product to be updated.
     */
    private void updateProductChoice(ArrayList<Product> productList, ArrayList<Storekeeper> storeList, Product productUpdate) {
        int choice;
        do {
            displayList.displayUpdateMenu();
            choice = getMenuChoice(1, 10);
            switch (choice) {
                case 1:
                    updateProductID(productList, productUpdate);
                    break;
                case 2:
                    updateProductName(productList, productUpdate);
                    break;
                case 3:
                    updateProductLocation(productList, productUpdate);
                    break;
                case 4:
                    updateProductPrice(productList, productUpdate);
                    break;
                case 5:
                    updateExpiryDate(productList, productUpdate);
                    break;
                case 6:
                    updateManufactureDate(productList, productUpdate);
                    break;
                case 7:
                    updateProductCategory(productList, productUpdate);
                    break;
                case 8:
                    updateStoreKeeper(storeList, productList, productUpdate);
                    break;
                case 9:
                    updateReceiptDate(productList, productUpdate);
                    break;
                case 10:
                    // Exit
                    break;
            }
        } while (choice != 10);
    }

    /**
     * Description: Updates a product in the list of products.
     *
     * @param storeList The list of storekeepers.
     * @param productList The list of products.
     */
    public void updateProduct(ArrayList<Storekeeper> storeList, ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println("The list of products is empty. Cannot update product!");
            return;
        }

        displayList.displayProductList(productList);
        Product productUpdate = null;
        do {
            int productChoice = getData.getInt("Enter the ID of the product you want to update:", "Product ID does not exist", 1, Integer.MAX_VALUE);
            for (Product product : productList) {
                if (productChoice == product.getProductID()) {
                    productUpdate = product;
                    break;
                }
            }
            // Check if the product ID that the user input is not found
            if (productUpdate == null) {
                System.err.println("Product ID does not exist");
            } else {
                break;
            }
        } while (true);
        updateProductChoice(productList, storeList, productUpdate);
    }
}
