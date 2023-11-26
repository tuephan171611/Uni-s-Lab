/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_num73;


/**
 *
 * @author phanm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManageExpense manage = new ManageExpense();
        while (true) {
            //display menu
            displayMenu();
            //Users select an option
            int option = Utility.getInt("Your Choice:", 1, 4);
            switch (option) {
                case 1 -> //Add an expense
                    manage.addExpense();
                case 2 -> //Display all expenses
                    manage.displayExpense();
                case 3 -> //Delete an expense
                    manage.deleteExpense();
                case 4 -> System.exit(0);
                //Exit program
            }
        }
    }

    private static void displayMenu() {
        System.out.println("""
                           =======Handy Expense program======
                           1. Add an expense
                           2. Display all expenses
                           3. Delete an expense
                           4. Quit""");
    }
}
