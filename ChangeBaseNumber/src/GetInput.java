/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author admin
 */
public class GetInput {

    private static final Scanner sc = new Scanner(System.in);

    public static int getSelectAnOption(String msg) {
        int select_an_option;
        String input;
        //Loop until user input is correct
        while (true) {
            System.out.println("=== List of base number ===");
            System.out.println("1.Binary");
            System.out.println("2.Decimal");
            System.out.println("3.Heximal");
            System.out.print(msg);
            input = sc.nextLine().trim();
            //Check input is empty
            if (input.isEmpty()) {
                System.out.println("Could not be empty");
            }
            try {
                select_an_option = Integer.parseInt(input);
                //Check select an option isn't in range from one to three
                if (select_an_option >= 1 && select_an_option <= 3) {
                    //Check value of variable baseIn with base choose by user
                    if (select_an_option == 1) {
                        return 2;
                    } else if (select_an_option == 2) {
                        return 10;
                    } else {
                        return 16;
                    }
                } else {
                    System.out.println("Please choice from 1 to 3");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Choice must be integer");
            }
        }
    }

    public static String getInputValue(String msg, int mode) {
        String input;
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            //Check input is empty
            if (input.isEmpty()) {
                System.out.println("Could not be empty");
                continue;
            }
            //Check input is binary value
            if (mode == 2) {
                /*
                    [0|1] is character 0 or 1
                    + is appear one or more times
                 */
                if (input.matches("[0|1]+")) {
                    return input;
                } else {
                    System.out.println("Invalid, this is not number of binary");
                    continue;
                }
            } //Check input is decimal value
            else if (mode == 10) {
                /*
                    [0-9] is number from 0 to 9
                    + is appear one or more times
                 */
                if (input.matches("[0-9]+")) {
                    return input;
                } else {
                    System.out.println("Invalid, this is not number of decimal");
                    continue;
                }
            } //Check input is hexadecimal value
            else if (mode == 16) {
                /*
                    [0-9] is number from 0 to 9
                    [A-F]  is character from A to F
                    + is appear one or more times
                 */
                if (input.matches("[0-9A-F]+")) {
                    return input;
                } else {
                    System.out.println("Invalid, this is not number of hexadecimal");
                    continue;
                }
            }
        }
    }

}
