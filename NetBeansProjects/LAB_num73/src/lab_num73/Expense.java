/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_num73;

/**
 *
 * @author phanm
 */
public class Expense {
   private int ID;
   private String date;
   private double amount;
   private String content;
    
   public Expense() {
    }

    public Expense(String date, double amount, String content, int ID) {
        this.ID = ID;
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
