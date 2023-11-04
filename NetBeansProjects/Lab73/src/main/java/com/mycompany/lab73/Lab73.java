/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab73;

/**
 *
 * @author phanm
 */
public class Lab73 {

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
        System.out.println("""
                           =======Handy Expense program======
                           1. Add an expense
                           2. Display all expenses
                           3. Delete an expense
                           4. Quit""");
    }
    }

