/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.EastAsiaCountries;

/**
 *
 * @author Admin
 */
public class ManageEastAsiaCountries {

    public boolean checkDuplicateCode(String countryCode,
            ArrayList<EastAsiaCountries> countryList) {
        //loop from first to last element in countryList
        for (EastAsiaCountries country : countryList) {
            //if countryCode in list equals countryCode in input->duplicate->return true
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }

    public void addToCountryList(String countryCode, String countryName, float
    totalArea, String countryTerrain, ArrayList<EastAsiaCountries> countryList){
        EastAsiaCountries country = new EastAsiaCountries(countryCode,
                countryName, totalArea, countryTerrain);
        countryList.add(country);
    }

    public void search(ArrayList<EastAsiaCountries> listFound,
            String countryName, ArrayList<EastAsiaCountries> countryList) {
        countryName = countryName.toUpperCase();
        //loop from first to last element
        for (EastAsiaCountries country : countryList) {
            //if name of country equal name input -> add to search list
      if (country.getCountryName().toUpperCase().contains(countryName)){
                listFound.add(country);
            }
        }
    }

}
