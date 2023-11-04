/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author msi
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    /**
     * Description: Prompts the user to input an integer within a specified
     * range.
     *
     * @param msg The message to display when prompting for input.
     * @param min The minimum value allowed for the input.
     * @param max The maximum value allowed for the input.
     * @return The valid integer input from the user.
     */
    public int getInteger(String msg, int min, int max) {
        String input;
        int IntNumber = -1;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            }
            try {
                IntNumber = Integer.parseInt(input);
                //check choice in range min and max
                if (IntNumber >= min && IntNumber <= max) {
                    break;
                } else {
                    System.out.println("Input must be in range " + min + " to " + max);
                    continue;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Input must be integer");
            }
        } while (true);
        return IntNumber;
    }

    /**
     * Description: Prompts the user to input an integer within a specified
     * range.
     *
     * @param msg The message to display when prompting for input.
     * @param min The minimum value allowed for the input.
     * @param max The maximum value allowed for the input.
     * @return The valid integer input from the user.
     */
    public double getDouble(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            try {
                System.out.print(msg);
                double input = Double.parseDouble(sc.nextLine().trim());
                if (input < min || input > max) {
                    System.out.println("Salary greater than 0");
                }
                return input;
            } catch (Exception e) {
                System.out.println("Salary greater than 0 ");
            }
        }
    }

    /**
     * Description: Prompts the user to input a string that matches a specified
     * regex pattern.
     *
     * @param msg The message to display when prompting for input.
     * @param regex The regular expression pattern to match the input against.
     * @return The valid string input from the user.
     */
    public String getString(String msg, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } else {
                if (regex.isEmpty()) {
                    break;
                } else if (input.matches(regex)) {
                    break;
                } else {
                    System.out.println("Input not match format require");
                    continue;
                }
            }
        } while (true);
        return input;
    }

    /**
     * Description: Prompts the user to input a string that matches a specified
     * email format.
     *
     * @param msg The message to display when prompting for input.
     * @param regex The regular expression pattern to match the email input
     * against.
     * @return The valid email input from the user.
     */
    public String getMail(String msg, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } else {
                if (regex.isEmpty()) {
                    break;
                } else if (input.matches(regex)) {
                    break;
                } else {
                    System.out.println("Email format must be follow (example@example.com)");
                    System.out.print("Re-enter: ");
                    continue;
                }
            }
        } while (true);
        return input;
    }

    /**
     * Description: Prompts the user to input a string that matches a specified
     * phone number format.
     *
     * @param msg The message to display when prompting for input.
     * @param regex The regular expression pattern to match the phone number
     * input against.
     * @return The valid phone number input from the user.
     */
    public String getPhone(String msg, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } else {
                if (regex.isEmpty()) {
                    break;
                } else if (input.matches(regex)) {
                    break;
                } else {
                    System.out.println("Phone has at least 10 digits");
                    System.out.print("Re-enter: ");
                    continue;
                }
            }
        } while (true);
        return input;
    }

    /**
     * Description: Prompts the user to input a date in the format "dd/MM/yyyy".
     *
     * @param msg The message to display when prompting for input.
     * @return The valid date input from the user.
     */
    public Date getDate(String msg) {
        String input;
        Date date;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //24-02-2023
            dateFormat.setLenient(false);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input could not be empty!!!");
                continue;
            } else if (!input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                System.out.println("Input is wrong format");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                break;
            } catch (ParseException exception) {
                System.out.println("Date doesn't existed!!");
            }
        } while (true);
        return date;
    }
}
