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
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    /**
     * constructor no parameter
     */
    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    /**
     * constructor full parameter
     *
     * @param countryTerrain
     * @param countryCode
     * @param countryName
     * @param totalArea
     */
    public EastAsiaCountries(String countryCode, String countryName,
            float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        super.display();
        System.out.format(" %-15s\n", countryTerrain);
    }

}
