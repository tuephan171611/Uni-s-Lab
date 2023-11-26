/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Expense {
   private static int auto_Increment = 1;
   private int ID;
   private String date;
   private double amount;
   private String content;

    public Expense() {
       ID = auto_Increment++; 
    }

    public Expense(String date, double amount, String content) {
        this.ID = auto_Increment++;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void displayExpense(){
        System.out.printf("%-15s%-15s%-15s%-15s\n",ID,date,amount,content);
    }
    
   
}
