package Controller;


import java.util.ArrayList;
import java.util.Scanner;

public class Validation {

    Scanner sc = new Scanner(System.in);

    /**
     * This main check the line 
     * @param msg The message prompt for the user
     * @param min The minimum allowed choice.
     * @param max The maximum allowed choice.
     * @return The user's choice.
     */
    public int getChoice(String msg, int min, int max) {
        int choice;
        while (true) {
            System.out.print(msg);
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.err.println("Input must be in range [" + min + ", " + max + "]");
            }
        }
    }
    /**
     * This method checks user input for Yes/No (Y/N)
     * @param msg The message prompt for the user.
     * @return True if the user chooses Yes, False if the user chooses No.
     */
    public boolean checkInputYN(String msg) {
        String c;
        while (true) {
            System.out.print(msg);
            c = sc.nextLine().trim();
            if (!c.isEmpty()) {
                if (c.equalsIgnoreCase("Y")) {
                    return true;
                } else if (c.equalsIgnoreCase("N")) {
                    return false;
                }
                System.err.println("You must choose Yes(Y/y) or No(N/n)!");
            } else {
                System.err.println("Cannnot be empty, please input again");
            }
        }
    }
    /**
     * This method checks user input for Update/Delete (U/D).
     * @param msg  The message prompt for the user
     * @return True if the user chooses Update, False if the user chooses Delete.
     */
    public boolean checkInputUD(String msg) {
        String c;
        while (true) {
            System.out.print(msg);
            c = sc.nextLine().trim();
            if (!c.isEmpty()) {
                if (c.equalsIgnoreCase("U")) {
                    return true;
                } else if (c.equalsIgnoreCase("D")) {
                    return false;
                }
                System.err.println("You must choose Update(U/u) or Delete(D/d)!");
            } else {
                System.err.println("Cannnot be empty, please input again");
            }
        }
    }

    /**
     * This method checks user input for a string based on a regex expression.
     * @param msg The message prompt for the user
     * @param regex  expression to validate the input.
     * @return The validated input string.
     */
    public String checkInputString(String msg, String regex) {
        String n;
        while (true) {
            System.out.print(msg);
            n = sc.nextLine();
            if (!n.matches(regex)) {
                System.err.println("Invalid input, please input again");
                continue;
            }
            return n.toUpperCase();
        }
    }

    /**
     * This method checks user input for a course
     * @param msg The message prompt for the user
     * @return The validated input string.
     */
    public String checkInputCourse(String msg) {
        String n;
        while (true) {
            System.out.print(msg);
            n = sc.nextLine().trim();
            //Check the input against different course options
            if (n.equalsIgnoreCase("Java")) {
                return n.substring(0, 1).toUpperCase() + n.substring(1, n.length());
            } else if (n.equalsIgnoreCase(".Net")) {
                return n.substring(0, 1) + n.substring(1, 2).toUpperCase() + n.substring(2, n.length());
            } else if (n.equalsIgnoreCase("C/C++")) {
                return n.substring(0, 1).toUpperCase() + n.substring(1, 2) + n.substring(2, 3).toUpperCase() + n.substring(3, n.length());
            } else {
                System.err.println("There are only three courses: Java, .Net, C/C++");
            }
        }
    }
}
