/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author msi
 */
public class Storekeeper {

    private int storeKeeperID;
    private String storeKeeperName;

    public Storekeeper() {
    }

    public Storekeeper(int storeKeeperID, String storeKeeperName) {
        this.storeKeeperID = storeKeeperID;
        this.storeKeeperName = storeKeeperName;
    }

    public int getStoreKeeperID() {
        return storeKeeperID;
    }

    public void setStoreKeeperID(int storeKeeperID) {
        this.storeKeeperID = storeKeeperID;
    }

    public String getStoreKeeperName() {
        return storeKeeperName;
    }

    public void setStoreKeeperName(String storeKeeperName) {
        this.storeKeeperName = storeKeeperName;
    }

}
