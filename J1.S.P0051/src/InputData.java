
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class InputData {

    private static final Scanner in = new Scanner(System.in);

    public static int SelectAnOption(String msg) {
        int select_an_option;
        //Use loop until user input correct
        while (true) {
            System.out.print(msg);
            try {
                select_an_option = Integer.parseInt(in.nextLine().trim());
                //Check select an option is not range from one to three
                if (select_an_option < 1 || select_an_option > 3) {
                    throw new NumberFormatException();
                }
                return select_an_option;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in range from one to three");
            }
        }
    }

    public static double InputDouble(String msg, String error, boolean check) {
        double data;
        //Use loop until user input correct
        while (true) {
            System.out.print(msg);
            try {
                data = Double.parseDouble(in.nextLine());
                //if check is true then data must be greater than zero
                if (check == true) {
                    if (data < 0) {
                        System.out.println("Could not be less than zero");
                        continue;
                    }
                }
                return data;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
    }

    //allow user input operator
    public static String InputOperator() {
        String input;
        //Use loop until user input correct
        while (true) {
            System.out.print("Enter Operator: ");
            input = in.nextLine().trim();
            //Check input is empty
            if (input.isEmpty()) {
                System.out.println("Could not be empty");
            }
            //Check input is one of operators: +, -, *, /, ^, =
            if (input.equalsIgnoreCase("+") || input.equalsIgnoreCase("-")
                    || input.equalsIgnoreCase("*") || input.equalsIgnoreCase("/")
                    || input.equalsIgnoreCase("^") || input.equalsIgnoreCase("=")) {
                return input;
            } else {
                System.out.println("Please input (+, -, *, /, ^)");
            }
        }
    }

}

