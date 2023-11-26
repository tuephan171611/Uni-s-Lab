
import java.util.Random;
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
public class Main {
    public static void main(String[] args) {
        //Step 1: Use positive decimal number to input size array 
        int size_array = InputPositiveDecimalNumber("Enter number of array: ");
        
        //Step 2: Use positive decimal number to input search number
        int search_number = InputPositiveDecimalNumber("Enter search value: ");
        
        /*Step 3: Generate random integer in number range
        for each array element and random all elments of array*/
        int[] array = RandomAllElements(size_array);

        //Step 4: Display array 
        DisplayArray(array, "The array: ");

        //Step 5: Use Linear Search algorithm to find search number
        int indexOfSearchNumber = LinearSearch(array, search_number);

        //Step 6: Display the index of search number in array.
        DisplayIndexOfSearchNumber(indexOfSearchNumber, search_number);
    }

    private static int InputPositiveDecimalNumber(String msg) {
        Scanner sc = new Scanner(System.in);
        double data;
        String input;
        //use loop until user correct        
        do {
            System.out.println(msg);
            //check input user is empty
            input = sc.nextLine().trim();
            if (input.equals("")) {
                System.out.println("Could not be empty, "
                        + "please enter positive integer number");
                continue;
            }
            //check input user is a positive number            
            try {
                data = Double.parseDouble(input);
                //check input user is a real number;               
                if (data != (int) data) {
                    System.out.println("Could not be a real number, "
                            + "please enter positive integer number");
                    continue;
                }
                //check input user must be a number more than zero
                if (data > 0) {
                    return (int) data;
                } else {
                    System.out.println("Could not be less than zero, "
                            + "please enter positive integer number");
                }
            } catch (NumberFormatException e) {
                System.out.println("Could not be a string, "
                        + "please enter positive integer number");
            }
        } while (true);
    }

    private static int[] RandomAllElements(int size_array) {
        int[] array = new int[size_array];
        Random random_array = new Random();
        //use loop to random each of element in array
        for (int i = 0; i < size_array; i++) {
            array[i] = random_array.nextInt(size_array);
        }
        return array;
    }

    private static void DisplayArray(int[] array, String msg) {
        System.out.print(msg);
        int size_array = array.length;
        //use loop to print all element of array  
        System.out.print("[");
        for (int i = 0; i < size_array; i++) {
            //if the last element has been closed then print "]" 
            if (i == size_array - 1) {
                System.out.print(array[i] + "]");
            } //if is not the last element in array then print ","
            else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    private static int LinearSearch(int[] array, int search_number){
        int size_array = array.length;
        //use loop to traverse from the first element to the last element     
        for (int i = 0; i < size_array; i++) {
            /*Use the condition to compare each element in the array with 
            the search number. After that, returns its position in the array*/
            if (array[i] == search_number) {
                return i;
            }           
        }
        //exit the loop when the search number is not found, then return -1  
        return -1;
    }

    private static void DisplayIndexOfSearchNumber(int index,int search_number){
        //use the condition to print out in case no value is found   
        if (index == -1) {
            System.out.println("");
            System.out.println("Not found " + search_number);
        } 
        //if the search number is found, print the position of that value
        else {
            System.out.println("");
            System.out.println("Found " + search_number + " at index: " +index);
        }
    }
}
