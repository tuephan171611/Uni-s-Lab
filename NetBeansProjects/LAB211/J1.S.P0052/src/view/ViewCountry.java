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

    void inputCountry(ArrayList<EastAsiaCountries> countryList) {
        String countryCode, countryName, countryTerrain;
        float totalArea;
        //if list is full,tell user can not add
        if(countryList.size() == 11){
            System.out.println("List countries is full, can not add more element");
            return;
        }
        //loop util true
        while (true) {
            countryCode = Utility.getString("Enter code of country: \n",
                    Utility.REGEX_CODE, "Code must be letter!");
            //check duplicate countryCode
            //=> true => duplicate countryCode => Error => Reinput
            //=> false => not duplicate => break;
            if (manage.checkDuplicateCode(countryCode, countryList)) {
                System.out.println("Code is exist!");
            } else {
                break;
            }
        }
       
            countryName = Utility.getString("Enter name of country: \n",
                    Utility.REGEX_NAME, "Name must be letter!");
            totalArea = Utility.getFloat("Enter total Area: \n", 0,
                Float.MAX_VALUE);
            countryTerrain = Utility.getString("Enter terrain of country: \n",
                 Utility.REGEX_TERRAIN, "Terrain must be letter!");

        //add the list
        countryList.add(new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain));
        System.out.println("ADD SUCCESSFUL!!");
    }

    void displayCountryJustInput(ArrayList<EastAsiaCountries> countryList) {
        //if countryList is empty->tell error
        if(countryList.isEmpty()){
            System.out.println("List is empty!");
        }
        //get country just input = country at last index
        EastAsiaCountries country = countryList.get(countryList.size() - 1);
        //display
        System.out.format("%-15s %-15s %-15s %-15s\n",
                "ID", "Name", "Total Area", "Terrain");
        country.display();
    }

    void searchCountryByName(ArrayList<EastAsiaCountries> countryList) {
        //create countryListFound
        ArrayList<EastAsiaCountries> listFound = new ArrayList<>();
        //input name
        String countryName = Utility.getString("Enter name of country: \n",
                 Utility.REGEX_NAME, "Name is not exist!");
        //search the country by countryName
        manage.search(listFound, countryName, countryList);
        //if listFound empty->tell error
        if (listFound.isEmpty()) {
            System.out.println("Not found!");
        } else {
            //if found display the country
            System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name",
                    "Total Area", "Terrain");
            for (EastAsiaCountries country : listFound) {
                country.display();
            }
        }
    }

    void sortAscendingCountryByName(ArrayList<EastAsiaCountries> countryList) {
        //if countryList is empty ->tell error
       if(countryList.isEmpty()){
           System.out.println("List country is empty!");
           return;
       }
       ArrayList<EastAsiaCountries> listSort = new ArrayList<>();
       listSort.addAll(countryList);
       //Loop index to index
        for (int i = 0; i < listSort.size(); i++) {
          //loop from first elements to before last unsorted element
            for (int j = 0; j < listSort.size()- i -1; j++) {
                //compare each pair adjacent elements
                if(listSort.get(j).getCountryName().compareToIgnoreCase(listSort.get(j+1).getCountryName()) < 0){
                    EastAsiaCountries temp = listSort.get(j);
                    listSort.set(j,listSort.get(j + 1));
                    listSort.set(j + 1, temp);
                }
            }
            
        }
        System.out.format("%-15s %-15s %-15s %-15s\n", "ID", "Name",
                "Total Area", "Terrarin");
        //loop from first to last element of listSort
        for (EastAsiaCountries country : listSort) {
            country.display();
        }
    }

}
