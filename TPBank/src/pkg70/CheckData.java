/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg70;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class CheckData {
    private final Scanner sc = new Scanner(System.in);
    
    boolean checkAccountNumber(String accountNumber) {
        AccountList a = new AccountList();
        ArrayList <Account> b = a.AccountList();
        //Loop use to access each element of arraylist from begining to the end
        for (Account account : b) {
            //Check accountNumber is exist in list acount or not
            if (account.getAccountNumber().equals(accountNumber)) {
                return true;
            }
        }
        return false;
    }
    
    boolean checkPassword(String accountNumber, String password) {
        AccountList a = new AccountList();
        ArrayList <Account> b = a.AccountList();
        //Loop use to access each element of arraylist from begining to the end
        for (Account account : b) {
            /*Check if the account number exists in the list or not and password 
            of AccountNumber input is equal with password of account 
            have number account same with AccountNumber or not*/
            if (account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password)) {
                    return true;
                }
            }
        return false;
    }
    
    void checkCaptcha(ResourceBundle bundle, String captcha) {
        String input;
        String checkCaptchaBlank;
        while (true) {
            input = sc.nextLine();
            checkCaptchaBlank = input.replaceAll("\\s+", "");
            //Check user input is blank
            if (checkCaptchaBlank.isEmpty() || checkCaptchaBlank.equals("")) {
                System.out.println(bundle.getString("InputCaptchaBlank"));
                System.out.print(bundle.getString("InputCaptcha"));
            }
            //Check if captcha is incorrect
            else if (!checkCaptchaBlank.equals(captcha)) {
                System.out.println(bundle.getString("InputCaptchaWrongType"));
                System.out.print(bundle.getString("InputCaptcha"));
            } else {
                break;
            }
        }
    }
}
