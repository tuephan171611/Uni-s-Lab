/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_num73;

import java.util.ArrayList;

/**
 *
 * @author phanm
 */
class ManageExpense {

    ArrayList<Expense> listExpense = new ArrayList<>();

    void addExpense() {
        System.out.println("--------- Add an expense ---------");
        int idlast;
        if (listExpense.isEmpty()) {
            idlast = 1;
        } else {
            idlast = listExpense.get(listExpense.size() - 1).getID() + 1;
        }

        String date = Utility.inputDate("Enter Date:");
        double amount = Utility.getDouble("Enter Amount:", 0, Integer.MAX_VALUE);
        String content = Utility.getString("Enter Content:", Utility.REGEX_STRING, "Content must be letter!");
        // The ID is set only if there are already expenses in the list
        int newExpenseID = listExpense.isEmpty() ? idlast : idlast + 1;
        listExpense.add(new Expense(date, amount, content, newExpenseID));
        System.out.println("Add sucessful!");

    }

    void displayExpense() {
        if (listExpense.isEmpty()) {
            System.out.println("List is not empty");
        }
        System.out.println("-----------Display all expenses---------");
        double total = 0;
        System.out.printf("%-15s%-15s%-15s%-15s\n", "ID", "Date", "Amount", "Content");
        for (Expense expense : listExpense) {
            expense.displayExpense();
            total = total + expense.getAmount();
        }
        System.out.printf("%-15s%10.0f%n\n", "                     Total:", total);
    }

    void deleteExpense() {
        if (listExpense.isEmpty()) {
            System.out.println("List is not empty");
        }
        System.out.println("--------Delete an expense--------");
        int searchID = Utility.getInt("ID:", 0, Integer.MAX_VALUE);
        boolean founded = false;
        //loop to access all contact in list
        for (Expense expense : listExpense) {
            //check if contact ID is exist in contact list 
            if (expense.getID() == searchID) {
                founded = true;
                listExpense.remove(expense);
                System.out.println("Delete sucessful!");
                break;
            }
        }
        if (!founded) {
            System.out.println("Not Found");
        }
    }
}
