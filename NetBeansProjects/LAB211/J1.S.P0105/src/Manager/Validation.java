/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author msi
 */
public class Validation {

    /**
     * Description: Reads an integer input from the user within the specified
     * range.
     *
     * @param msg The message prompt for the user.
     * @param outRangeMsg The error message for input out of range.
     * @param min The minimum value allowed.
     * @param max The maximum value allowed.
     * @return The integer input from the user.
     */
    public int getInt(String msg, String outRangeMsg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        double intInput;
        String input;
        if (msg.isEmpty()) {
            System.out.print(msg);
        } else {
            System.out.print(msg);
        }
        do {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input is empty.");
                continue;
            }
            try {
                intInput = Double.parseDouble(input);
                if (intInput < min || intInput > max) {
                    throw new Error();
                }
                // User entered a real number
                if ((int) intInput != intInput) {
                    throw new Exception();
                } else {
                    break;
                }
                // User entered a string
            } catch (NumberFormatException StringInput) {
                System.err.println("Input cannot be a String.");
            } catch (Exception RealNumber) {
                System.err.println("Input cannot be a real number.");

            } catch (Error OutOfRange) {
                System.err.println(outRangeMsg);
            }
        } while (true);
        return (int) intInput;
    }

    /**
     * Description: Reads a double input from the user within the specified
     * range.
     *
     * @param msg The message prompt for the user.
     * @param outRangeMsg The error message for input out of range.
     * @param min The minimum value allowed.
     * @param max The maximum value allowed.
     * @return The double input from the user.
     */
    public double getDouble(String msg, String outRangeMsg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                double input = Double.parseDouble(sc.nextLine().trim());
                if (input < min || input > max) {
                    System.out.println(outRangeMsg);
                }
                return input;
            } catch (Exception e) {
                System.out.println(outRangeMsg);
            }
        }
    }

    /**
     * Description: Reads a string input from the user.
     *
     * @param msg The message prompt for the user.
     * @return The string input from the user.
     */
    public String getString(String msg) {
        Scanner sc = new Scanner(System.in);
        String input;
        if (msg.isEmpty()) {
            System.out.print(msg);
        } else {
            System.out.print(msg);
        }
        do {
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Input is empty.");
            } else if (!input.matches("[a-zA-Z0-9 ]+")) {
                System.err.println("Input cannot be a number or special character");
            } else {
                break;
            }
        } while (true);
        return input;
    }

    /**
     * Description: Reads a date input from the user.
     *
     * @return The date input from the user.
     */
    public Date getDate() {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat;
        String input;
        Date date;
        do {
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input is empty.");
                continue;
            }
            try {
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                date = dateFormat.parse(input);
                break;
            } catch (ParseException dateFormatException) {
                System.err.print("Date must follow the format (dd/MM/yyyy). Re-enter: ");
            }
        } while (true);
        return date;
    }

}
