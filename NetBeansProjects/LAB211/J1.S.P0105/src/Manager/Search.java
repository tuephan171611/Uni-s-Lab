/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Product;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author msi
 */
public class Search {

    Manager manager = new Manager();
    Validation getData = new Validation();
    Display displayProductList = new Display();

    /**
     * Description: Allows the user to search for products based on different
     * criteria.
     *
     * @param productList The list of products.
     */
    public void searchProduct(ArrayList<Product> productList) {
        if (productList.isEmpty()) {
            System.err.println("List of product is empty. Please enter product to continue searching");
        } else {
            Display displayList = new Display();
            displayList.displaySearchMenu();
            int choice = manager.getMenuChoice(1, 4);
            switch (choice) {
                case 1:
                    searchByName(productList);
                    break;
                case 2:
                    searchByCategory(productList);
                    break;
                case 3:
                    searchByStorekeeper(productList);
                    break;
                case 4:
                    searchByReceiptdate(productList);
                    break;
                case 5:
                    break;
            }
        }
    }

    /**
     * Description: Searches for products by name.
     *
     * @param productList The list of products.
     */
    public void searchByName(ArrayList<Product> productList) {
        displayProductList.displayProductList(productList);
        ArrayList<Product> resultList = new ArrayList<>();
        System.out.print("Enter product name you want to search: ");

        do {
            String searchProductName = getData.getString("");
            for (Product product : productList) {
                if (searchProductName.equalsIgnoreCase(product.getProductName())) {
                    resultList.add(product);
                }
            }
            if (resultList.isEmpty()) {
                System.err.println("Product not found.");
            } else {
                break;
            }
        } while (true);
        displayProductList.displayProductList(resultList);
    }

    /**
     * Description: Searches for products by category.
     *
     * @param productList The list of products.
     */
    public void searchByCategory(ArrayList<Product> productList) {
        displayProductList.displayProductList(productList);
        ArrayList<Product> resultList = new ArrayList<>();
        System.out.print("Enter category you want to search: ");
        do {
            String searchCategory = getData.getString("");
            for (Product product : productList) {
                if (searchCategory.equalsIgnoreCase(product.getCategory())) {
                    resultList.add(product);
                }
            }
            if (resultList.isEmpty()) {
                System.err.println("Product not found.");
            } else {
                displayProductList.displayProductList(resultList);
                break;
            }
        } while (true);
    }

    /**
     * Description: Searches for products by storekeeper name.
     *
     * @param productList The list of products.
     */
    public void searchByStorekeeper(ArrayList<Product> productList) {
        displayProductList.displayProductList(productList);
        ArrayList<Product> resultList = new ArrayList<>();
        System.out.print("Enter storekeeper name you want to search: ");

        do {
            String storeKeeperName = getData.getString("");
            for (Product product : productList) {
                if (product.getStoreKeeper().getStoreKeeperName().equalsIgnoreCase(storeKeeperName)) {
                    resultList.add(product);
                }
            }
            if (resultList.isEmpty()) {
                System.err.println("No products found.");
            } else {
                displayProductList.displayProductList(resultList);
                break;
            }
        } while (true);
    }

    /**
     * Description: Searches for products by receipt date.
     *
     * @param productList The list of products.
     */
    public void searchByReceiptdate(ArrayList<Product> productList) {
        displayProductList.displayProductList(productList);
        ArrayList<Product> resultList = new ArrayList<>();
        System.out.print("Enter receipt date you want to search [dd/MM/yyyy]: ");

        do {
            Date searchReceiptDate = getData.getDate();
            for (Product product : productList) {
                if (product.getReceiptDate().equals(searchReceiptDate)) {
                    resultList.add(product);
                }
            }
            if (resultList.isEmpty()) {
                System.err.println("Product not found.");
            } else {
                displayProductList.displayProductList(resultList);
                break;
            }
        } while (true);
    }

}
