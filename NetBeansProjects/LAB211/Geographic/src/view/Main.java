/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.Clock;
import model.Country;
import model.EastAsiaCountries;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        ViewCountry view = new ViewCountry();
         while (true){
            displayMenu();
            int option = Utility.getInt(
            "Enter option: ","INVAID FORMAT NUMBER!",1, 5);
            switch (option) {
                case 1:
                //Enter the information for 11 countries in Southeast Asia
                 view.inputCountry();
                    break;
                case 2:
                    //Display already information
                    view.displayCountryJustInput();
                    break;
                case 3:
                    //Search the country according to the entered country's name
                    view.searchCountryByName();
                    break;
                case 4:
                    //Display the information increasing with the country name
                    view.sortAscendingCountryByName();
                    break;
                case 5:
                    //Exit
                    System.exit(0);
                    break;

            }
        } 
    }

    private static void displayMenu() {
        System.out.println("                               MENU\n" +
"==========================================================================\n" +
"1. Input the information of 11 countries in East Asia\n" +
"2. Display the information of country you've just input\n" +
"3. Search the information of country by user-entered name\n" +
"4. Display the information of countries sorted name in ascending order  \n" +
"5. Exit \n" +
"==========================================================================\n" 
);
    }
   
}
