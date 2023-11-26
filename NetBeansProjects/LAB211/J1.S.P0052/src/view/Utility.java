/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Utility {
    public static final Scanner sc = new Scanner(System.in);
    /**
     * Regex for name country, code country, terrain country
     *a-z = Matches a character in the range "a" to "z" 
     *A-Z = Matches a character in the range "A" to "Z" 
     *0-9 = Matches a character in the range "0" to "9"
     */
    public static final String REGEX_NAME = "[a-zA-Z ]+";
    public static final String REGEX_CODE = "[a-zA-Z ]+";
    public static final String REGEX_TERRAIN = "[a-zA-Z ]+";;
     public static int getInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();
                //input is empty->tell error
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !");
                } else {
                    //check user enter number or not
                    int number = Integer.parseInt(input);
                    //check range of number
                    if (number < min || number > max) {
                        System.out.println("Number must be range "+min+"->"+max);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException exception) {
                System.out.println("Input must be a integer number!");
            }

        }
    }
     public static float getFloat(String message, float min, float max) {

        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();
                //input is empty->tell error
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !");
                } else {
                    //check user enter number or not
                    float number = Float.parseFloat(input);
                    //check range of number
                    if (number <= min || number > max) {
                        System.out.println("Total area must be greater than 0");
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException exception) {
                 System.out.println("Input must be a float number!");
            }

        }

    }
     public static String getString(String message, String regex, String error) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            //input is empty->tell error
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } else {
                //if input matches regex => return input
                // else print error
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            }
        }

}
}