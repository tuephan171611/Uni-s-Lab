/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibo;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Fibo {

    public static void main(String[] args) {
        //Step 1: Use recursion method to find 45 sequence Fibonacci
        ArrayList array = new ArrayList();
        findFibonacci(array, 0, 1, 3, 45);
        //Step 2: Display array to the screen
        Display(array);
    }

    //Arraylist containing fibonacci number 
    private static int findFibonacci(ArrayList array, int num1, int num2, int index, int number) {
        //The number first recursion method
        if (index == 3) {
            array.add(0);
            array.add(1);
        }
        //Stop recursion method to find number Fibonacci
        if (index > number) {
            return 0;
        }
        array.add(num1 + num2);
        return findFibonacci(array, num2, num1 + num2, index + 1, number);
    }

    //Display
    private static void Display(ArrayList arrayList) {
        System.out.println("The 45 sequence fibonacci: ");
        //Display each element
        for (int i = 0; i < arrayList.size() - 1; i++) {
            System.out.print("Number" + (i + 1) + "=");
            System.out.print(arrayList.get(i) + ", ");
            System.out.println("");
        }
        System.out.print("Number" + arrayList.size() + "=");
        //Display last element
        System.out.print(arrayList.get(arrayList.size() - 1) + ".");
        
        do {

        } while (true);
    }

}
