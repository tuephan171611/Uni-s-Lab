/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.script.ScriptEngine;
import model.EastAsiaCountries;

/**
 *
 * @author Admin
 */
public class ManageEastAsiaCountries {

    ArrayList<EastAsiaCountries> countryList;

    public ManageEastAsiaCountries() {
        countryList = new ArrayList<>();
        countryList.add(new EastAsiaCountries("VN", "Viet Nam", 100, "Nice"));
        countryList.add(new EastAsiaCountries("TL", "ThaiLand", 123, "Nice"));
    }

    public ArrayList<EastAsiaCountries> getCountryList() {
        return countryList;
    }

    public boolean checkDuplicateCode(String countryCode) {
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;

    }

    public boolean checkDuplicateName(String countryName) {
        for (EastAsiaCountries country : countryList) {
            if(country.getCountryName().equalsIgnoreCase(countryName)){
                return true;
            }
        }
        return false;
    }
    public void addToCountryList(String countryCode, String countryName,
            float todalArea, String countryTerrain ){
        EastAsiaCountries country = new EastAsiaCountries(countryCode, 
                countryName, todalArea, countryTerrain);
        countryList.add(country);
    }

    public void search(ArrayList<EastAsiaCountries> listFound, String countryName) {
        countryName = countryName.toUpperCase();
        for (EastAsiaCountries eastAsiaCountries : countryList) {
            // check if an country contain countryName, add to listFound
            if(eastAsiaCountries.getCountryName().toUpperCase().contains(countryName)){
                listFound.add(eastAsiaCountries);
            }
        }
    }
   
}
