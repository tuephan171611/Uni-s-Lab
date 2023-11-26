
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
      ManangeExpense manage = new ManangeExpense();
        ArrayList<Expense> listExpense = new ArrayList<>();
        while (true) {            
            //display menu
            displayMenu();
            //Users select an option
            int option = Utility.getInt("Your Choice:", 1, 4);
            switch(option){
                case 1:
                    //Add an expense
                    manage.addExpense(listExpense);
                    break;
                case 2:
                    //Display all expenses
                    manage.displayExpense(listExpense);
                    break;
                case 3:
                    //Delete an expense
                    manage.deleteExpense(listExpense);
                    break;
                case 4:
                    System.exit(0);
                    //Exit program
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("=======Handy Expense program======\n" +
"1. Add an expense\n" +
"2. Display all expenses\n" +
"3. Delete an expense\n" +
"4. Quit");
    }
}
