
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
public class ManangeExpense {

    void addExpense(ArrayList<Expense> listExpense) {
        System.out.println("--------- Add an expense ---------");
        String date = Utility.inputDate("Enter Date:");
        double amount = Utility.getDouble("Enter Amount:", 0, Integer.MAX_VALUE);
        String content = Utility.getString("Enter Content:", Utility.REGEX_STRING, "Content must be letter!");
        listExpense.add(new Expense(date, amount, content));
        System.out.println("Add sucessful!");
        
    }

    void displayExpense(ArrayList<Expense> listExpense) {
        if(listExpense.isEmpty())
        {
            System.out.println("List is not empty");
        }
        System.out.println("-----------Display all expenses---------");
        double total = 0;
        for (Expense expense : listExpense) {
            total = total + expense.getAmount();
        }
        System.out.printf("%-15s%-15s%-15s%-15s\n","ID","Date","Amount","Content");
        for (Expense expense : listExpense) {
            expense.displayExpense();
        }
        System.out.printf("%-15s%10.0f%n\n","                     Total:",total);
    }

    void deleteExpense(ArrayList<Expense> listExpense) {
        if(listExpense.isEmpty()){
            System.out.println("List is not empty");
        }
        System.out.println("--------Delete an expense--------");
        int searchID  = Utility.getInt("ID:", 0, Integer.MAX_VALUE);
        boolean founded = false;
        //loop to access all contact in list
        for (Expense expense : listExpense) {
            //check if contact ID is exist in contact list 
            if(expense.getID() == searchID){
                founded = true;
                listExpense.remove(expense);
                System.out.println("Delete sucessful!");
                break;
            }
        }
        if(! founded){
            System.out.println("Not Found");
        }
    }

}
