/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg70;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class InputData {

    private final Scanner sc = new Scanner(System.in);
    /*  ^ : mark the start of a line, a string
        \d : numbers from 0 to 9
        {10} : a string of ten characters
        $ : highlight end of a line, a string
     */
    private final String ACCOUNT_NUMBER_VALID = "^\\d{10}$";

    int selectAnOption(String msg) {
        int select_an_option;
        String input;
        String checkBlankOptions;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine();
            /*    
                \s : any blank characters
                + : appear 1 or more times
             */
            // input: 9999 7 8  -> 999978
            checkBlankOptions = input.replaceAll("\\s+", "");
            //Check user input is blank
            if (checkBlankOptions.isEmpty() || input.equals("")) {
                System.out.println("Input must not be blank");
            } else {
                //Remove wrong input type
                try {
                    select_an_option = Integer.parseInt(input);
                    //Check select an option isn't in range from one to three
                    if (select_an_option < 1 || select_an_option > 3) {
                        throw new NumberFormatException();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Please choice from 1 to 3");
                }
            }
        }
        return select_an_option;
    }

    String inputAccountNumber(ResourceBundle bundle) {
        String input;
        String checkAccountNumberBlank;
        while (true) {
            input = sc.nextLine();
            /*  
                \s : any blank characters
                + : appear 1 or more times
             */
            checkAccountNumberBlank = input.replaceAll("\\s+", "");
            //Check user input is blank
            if (checkAccountNumberBlank.isEmpty() || checkAccountNumberBlank.equals("")) {
                System.out.println(bundle.getString("InputAccountNumberBlank"));
                System.out.print(bundle.getString("InputAccountNumber"));
            } 
            //Return valid user account number
            else if (input.matches(ACCOUNT_NUMBER_VALID)) {
                break;
            } else {
                System.out.println(bundle.getString("InputAccountNumberWrongType"));
                System.out.print(bundle.getString("InputAccountNumber"));
            }
        }
        return input;
    }

    String inputPassword(ResourceBundle bundle) {
        String input;
        String checkPasswordBlank;
        int lengthPassword;
        while (true) {
            input = sc.nextLine();
            checkPasswordBlank = input.replace("\\s+", "");
            lengthPassword = input.length();
            //Check user input is blank
            if (checkPasswordBlank.isEmpty() || checkPasswordBlank.equals("")) {
                System.out.println(bundle.getString("InputPasswordBlank"));
                System.out.print(bundle.getString("InputPassword"));
            } 
            //Check user input length is valid
            else if (lengthPassword < 8 || lengthPassword > 33) {
                System.out.println(bundle.getString("InputPasswordWrongType"));
                System.out.print(bundle.getString("InputPassword"));
            } //Check user input have digit and letter
            else {
                int countDigit = 0;
                int countChar = 0;
                for (int i = 0; i < lengthPassword - 1; i++) {
                    if (Character.isDigit(input.charAt(i))) {
                        countDigit += 1;
                    } else if (Character.isLetter(input.charAt(i))) {
                        countChar += 1;
                    }
                }
                if (countChar == 0 || countDigit == 0) {
                    System.out.println(bundle.getString("InputPasswordWrongType"));
                    System.out.print(bundle.getString("InputPassword"));
                } else {
                    break;
                }
            }
        }
        return input;
    }

}
