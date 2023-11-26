/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Product;
import Entity.Storekeeper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author msi
 */
public class Manager {

    Validation getData = new Validation();
    Display displayList = new Display();

    /**
     * Description: Adds a new storekeeper to the store list.
     *
     * @param storeList The list of storekeepers.
     */
    public void addStoreKeeper(ArrayList<Storekeeper> storeList) {
        Display displayStore = new Display();
        String storeKeeperName;
        int storeKeeperID;
        System.out.print("Enter StoreKeeper name: ");
        do {
            storeKeeperName = getData.getString("");
            if (storeList.isEmpty()) {
                storeKeeperID = 1;
                Storekeeper storeKeeper = new Storekeeper(storeKeeperID, storeKeeperName);
                storeList.add(storeKeeper);
            } else {
                storeKeeperID = storeList.size() + 1;
                Storekeeper storeKeeper = new Storekeeper(storeKeeperID, storeKeeperName);
                storeList.add(storeKeeper);
            }
            break;
        } while (true);
        displayStore.displayStorekeeper(storeList);
    }

    /**
     * Description: Adds a new product to the product list.
     *
     * @param storeList The list of storekeepers.
     * @param productList The list of products.
     */
    public void addProduct(ArrayList<Storekeeper> storeList, ArrayList<Product> productList) {
        int productID;
        boolean isProductExist;
        System.out.print("Enter ID: ");
        do {
            productID = getData.getInt("", "Input cannot be less than or equal to zero", 1, Integer.MAX_VALUE);
            isProductExist = checkProductIdExist(productList, productID);
            if (isProductExist) {
                System.err.println("ProductID already exists!");
            } else {
                break;
            }
        } while (true);

        String productName = getData.getString("Enter ProductName: ");
        Storekeeper newStorekeeper = null;
        if (storeList.isEmpty()) {
            System.out.print("Store list is empty.\nDo you want to add a new Storekeeper(Y/N): ");
            do {
                String userChoice = getData.getString("");
                if (userChoice.equalsIgnoreCase("y")) {
                    String storeName = getData.getString("Enter Storekeeper name: ");
                    newStorekeeper = new Storekeeper(storeList.size() + 1, storeName);
                    storeList.add(newStorekeeper);
                    break;
                } else if (userChoice.equalsIgnoreCase("n")) {
                    return;
                } else {
                    System.err.print("Invalid Choice. Please enter Y or N to continue: ");
                }
            } while (true);
        }

        String productLocation = getData.getString("Enter location: ");
        double priceProduct = getData.getDouble("Enter price:", "Price must be a positive number", 0, Integer.MAX_VALUE);

        Date dateOfManu;
        System.out.print("Enter product's manufacture date[dd/MM/yyyy]: ");
        do {
            dateOfManu = getData.getDate();
            Date currentTimeNow = new Date();
            if (dateOfManu.after(currentTimeNow)) {
                System.err.println("Date of manufacture must be in the past.");
            } else {
                break;
            }
        } while (true);

        Date expiryDate;
        System.out.print("Enter product's expiry date[dd/MM/yyyy]: ");
        do {
            expiryDate = getData.getDate();
            if (expiryDate.before(dateOfManu)) {
                System.err.println("Expiry date must be after date of manufacture.");
            } else {
                break;
            }
        } while (true);

        String category = getData.getString("Enter category: ");
        Storekeeper store = null;
        if (newStorekeeper != null) {
            store = newStorekeeper;
        } else {
            do {
                displayList.displayStorekeeper(storeList);
                int storeKeeperChoice = getData.getInt("Choose Storekeeper: ", "StoreID does not exist", 1, storeList.size());
                for (Storekeeper storekeeper : storeList) {
                    if (storekeeper.getStoreKeeperID() == storeKeeperChoice) {
                        store = new Storekeeper(storekeeper.getStoreKeeperID(), storekeeper.getStoreKeeperName());
                        break;
                    }
                }
                break;
            } while (true);
        }

        Date receiptDate;
        System.out.println("Enter receipt date[dd/MM/yyyy]:");
        do {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            receiptDate = getData.getDate();
            String DateOfManu = dateFormat.format(dateOfManu);
            String ExpiryDate = dateFormat.format(expiryDate);
            if (receiptDate.before(dateOfManu) || receiptDate.after(expiryDate)) {
                System.err.println("Receipt date must be from " + DateOfManu + " to " + ExpiryDate);
            } else {
                break;
            }
        } while (true);

        Product newProduct = new Product(productID, productName, productLocation, priceProduct, expiryDate, dateOfManu, category, store, receiptDate);
        productList.add(newProduct);
        displayList.displayProductList(productList);
    }

    /**
     * Description: Sorts the product list by expiry date and date of
     * manufacture.
     *
     * @param productList The list of products.
     */
    public void sortProduct(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println("List of products is empty. Cannot sort products.");
        } else {
            Display displayProduct = new Display();
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    if (o1.getExpiryDate().equals(o2.getExpiryDate())) {
                        return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
                    } else {
                        return o1.getExpiryDate().compareTo(o2.getExpiryDate());
                    }
                }
            });
            displayProduct.displayProductList(productList);
        }
    }

    /**
     * Description: Checks if a product ID already exists in the product list.
     *
     * @param productList The list of products.
     * @param productID The ID of the product to check.
     * @return true if the product ID already exists, false otherwise.
     */
    public boolean checkProductIdExist(ArrayList<Product> productList, int productID) {
        boolean isDuplicate = false;
        for (Product product : productList) {
            if (productID == product.getProductID()) {
                isDuplicate = true;
                break;
            }
        }
        return isDuplicate;
    }

    /**
     * Description: Gets the user's menu choice within the specified range.
     *
     * @param min The minimum valid menu choice.
     * @param max The maximum valid menu choice.
     * @return The user's menu choice.
     */
    public int getMenuChoice(int min, int max) {
        return getData.getInt("Enter your choice: ", "Input is out of range: [" + min + "], [" + max + "]", min, max);
    }

}
