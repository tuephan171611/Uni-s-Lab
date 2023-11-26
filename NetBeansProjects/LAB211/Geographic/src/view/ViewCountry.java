/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ForkJoinPool;
import model.EastAsiaCountries;

/**
 *
 * @author Admin
 */
public class ViewCountry {

    ManageEastAsiaCountries manage = new ManageEastAsiaCountries();

    void inputCountry() {
        String countryCode, countryName, countryTerrain;
        float todalArea;
        //input information
        while (true) {
            countryCode = Utility.getString("Enter code of country: ", "INVAID",
                    Utility.REGEX_CODE);
            //check duplicate countryCode
            //=> true => duplicate countryCode => Error => Reinput
            //=> false => not duplicate => break;
            if (manage.checkDuplicateCode(countryCode)) {
                System.out.println("Duplicate countryCode!!!");
            } else {
                break;
            }
        }
        while (true) {
            countryName = Utility.getString("Enter name of country: ", "INVAID",
                    Utility.REGEX_NAME);
            //check duplicate countryName
            //=> true => duplicate countryCode => Error => Reinput
            //=> false => not duplicate => break;

            if (manage.checkDuplicateName(countryName)) {
                System.out.println("Duplicate countryName!!!");
            } else {
                break;
            }
        }

        todalArea = Utility.getFloat("Enter total Area: ", "INVAID", 0,
                Float.MAX_VALUE);
        countryTerrain = Utility.getString("Enter terrain of country: ","INVAID"
                 ,Utility.REGEX_TERRAIN);

        //add the list
        manage.addToCountryList(countryCode, countryName, todalArea,
                countryTerrain);
        System.out.println("ADD SUCCESSFULL!!");
    }
    void displayCountryJustInput(){
        
        ArrayList<EastAsiaCountries> countryList = manage.getCountryList();
        //get country just input = country at last index
        EastAsiaCountries country = countryList.get(countryList.size() - 1);
        //display
        System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name", "Area", "Terrain");
        country.display();
    }
     void searchCountryByName(){
        //create countryListFound
        ArrayList<EastAsiaCountries> listFound = new ArrayList<>();
        //input name
        String countryName = Utility.getString("Enter name of country: ", "INVAID",
                    Utility.REGEX_NAME);
        //search the country by contain
        manage.search(listFound,countryName);
        //not found
        if(listFound.isEmpty()){
            System.out.println("NOT FOUND!!!");
        }else{
        //found
        System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name",
                 "Total Area", "Terrain");
            for (EastAsiaCountries eastAsiaCountries : listFound) {
                eastAsiaCountries.display();
            }
        }
    }

    void sortAscendingCountryByName() {
        ArrayList<EastAsiaCountries> countryList = manage.getCountryList();
        Collections.sort(countryList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
             return o1.getCountryName().compareTo(o2.getCountryName());
            }
        });
//         System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name",
//                 "Total Area", "Terrain");
//         for (EastAsiaCountries eastAsiaCountries : countryList) {
//                eastAsiaCountries.display();
//            }
    }
}
