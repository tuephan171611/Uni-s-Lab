/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.EastAsiaCountries;
import model.Country;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        ViewCountry view = new ViewCountry();
        ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
        while (true) {
            //Step 1:Display the menu
            displayMenu();
            //Step 2:User selects an option
            int option = Utility.getInt("Enter option: ",1, 5);
            switch (option) {
                case 1:
                    //Input the information of 11 countries in East Asia
                    view.inputCountry(countryList);
                    break;
                case 2:
                    //Display already information
                    view.displayCountryJustInput(countryList);
                    break;
                case 3:
                    //Search information of countries by user-entered name
                    view.searchCountryByName(countryList);
                    break;
                case 4:
                    //Display the information of countries sorted name in ascending 
                    view.sortAscendingCountryByName(countryList);
                    break;
                case 5:
                    //Exit
                    System.exit(0);
                    break;

            }
        }
    }

    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }
}
