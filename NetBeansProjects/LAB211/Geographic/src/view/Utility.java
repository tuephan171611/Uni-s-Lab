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
     * regex for code country
     * a-z:Matches a character in the range "a" to "z"
     * A-Z:Matches a character in the range "A" to "Z" 
     * 0-9:Matches a character in the range "0" to "9"
     */
    public static final String REGEX_CODE = "[a-zA-Z0-9 ]+";
    /**
     * regex for name country 
     * a-z:Matches a character in the range "a" to "z"
     * A-Z:Matches a character in the range "A" to "Z"
     * 0-9:Matches a character in the range "0" to "9"
     */
    public static final String REGEX_NAME = "[a-zA-Z0-9 ]+";
    /**
     * regex for terrain country
     * a-z:Matches a character in the range "a" to "z"
     * A-Z:Matches a character in the range "A" to "Z" 
     * 0-9:Matches a character in the range "0" to "9"
     */
    public static final String REGEX_TERRAIN = "[a-zA-Z0-9 ]+";

    public static String getString(String message, String errorString,
            String regex) {
        while (true) {
            System.out.println(message);
            //input
            String input = sc.nextLine().trim();
            //check input mathes with regex
            //if input mathes regex -> true->return input
            if (input.matches(regex)) {
                return input;
            } //else ->false->errorString
            else {
                System.out.println(errorString);
            }
        } 
    }

    public static int getInt(String message, String erroString, int min,
            int max) {
         while (true){
            try {
                System.out.println(message);
                int number = Integer.parseInt(sc.nextLine());
                //check number in the range min->max
                if (number > max || number < min) {
                    System.out.println("Number must in range" + min + "->" + max);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(erroString);
            }
         }
    }

    public static float getFloat(String message, String erroString, float min,
            float max) {
        while (true) {
            try {
                System.out.println(message);
                float number = Float.parseFloat(sc.nextLine());
                //check number in the range min->max
                if (number > max || number <= min) {
                    System.out.println("Total area must be greater than 0");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(erroString);
            }

        }
    }
}
