/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg70;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class AccountList {
    ArrayList<Account> arrayList = new ArrayList<>();

    public ArrayList<Account> AccountList() {
        arrayList.add(new Account("1234567890", "sangdz12"));
        arrayList.add(new Account("1234567891", "sangdz13"));
        arrayList.add(new Account("1234567892", "sangdz14"));
        return arrayList;
    }
    
}
