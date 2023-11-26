/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Country {
    protected String countryCode, countryName;
    protected float todalArea;
    /**
     * constructor no parameter
     */
    public Country() {
    }
    /**
     * constructor full parameter
     * @param countryCode
     * @param countryName
     * @param todalArea 
     */
    public Country(String countryCode, String countryName, float todalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.todalArea = todalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTodalArea() {
        return todalArea;
    }

    public void setTodalArea(float todalArea) {
        this.todalArea = todalArea;
    }
    public void display(){
        System.out.format("%-15s %-15s %-15s",
            countryCode, countryName, todalArea);
    }

    

  
}
