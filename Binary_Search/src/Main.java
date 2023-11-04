
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
    private static int inputPositiveDecimalNumber(String msg) {
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
                continue;            }

            //check input user is a positive number            
            try {
                data = Double.parseDouble(input.trim());
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

    private static int[] RandomAllElementsOfArray(int size_array) {
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
        System.out.print("[");
        System.out.print("");
         //use loop to print all element of array
        for (int i = 0; i < size_array; i++) {
            //Print the last element in array
            if (i == size_array - 1) {
                System.out.print(array[i] + "]");
                //System.out.print(array[i]);
            } //if is not the last element in array then print ","
            else {
                System.out.print(array[i] + ", ");
            }
        }
    }

    private static void SortAscendingArray(int[] array) {
        int size_array = array.length;
        /*Use loop to traverse from the first element to the last element,
        after each loop there will be a sorted element*/
        for (int i = 0; i < size_array; i++) {
            /*Use loop to traverse from the first unsorted element
            to the element after the last sorted element in array*/
            for (int j = 0; j < size_array - 1 - i; j++) {
                /*Compare each pair of adjacent element when previous 
                element is greater than next element*/
                if (array[j] > array[j + 1]) {
                  //Swap the position of two adjacent elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static int BinarySearch(int[] array, int search_number, int check) {
        int size_array = array.length;
        int first_element = 0;
        int last_element = size_array - 1;
        int middle_element;
        int count = 1;
        //Repeat until the first element and the last element meet each other
        while (first_element <= last_element) {
            middle_element = (first_element + last_element) / 2;
            /*Check if the middle element is greater than the search number then
            search number is to be searched in the second half of the array*/
            if (array[middle_element] > search_number) {
                //Print the step in binary algorithm
                if (check == 1) {
                    System.out.println("");
                    System.out.print("Step " + count + " (middle element is " +
                            array[middle_element] + " > " + search_number + "):" + "   ");
                    DisplayArray(array, "");
                    System.out.println("");
                }
                last_element = middle_element - 1;
            } 
            /*Check if the middle element is less than the search number then
            search number is to be searched in the first half of the array*/ 
            else if (array[middle_element] < search_number) {
                //Print the step in binary algorithm
                if (check == 1) {
                    System.out.println("");
                    System.out.print("Step " + count + " (middle element is " + 
                            array[middle_element] + " < " + search_number + "):" + "   ");
                    DisplayArray(array, "");
                    System.out.println("");
                }
                first_element = middle_element + 1;
            } 
            /*Check if the middle element is equal to the search number then
            return the location of middle element*/ 
            else if (array[middle_element] == search_number) {
                //Print the step in binary search algorithm
                if (check == 1) {
                    System.out.println("");
                    System.out.print("Step " + count + " (middle element is " + 
                            array[middle_element] + " == " + search_number + "):" + "   ");
                    DisplayArray(array, "");
                    System.out.println("");
                }
                return middle_element;
            }
            count++;
        }
        //If check = 0 then print out the expectation of user interface
        if (check == 0) {
            System.out.println("");
        }
        
        //Print the step not found search number in binary search algorithm
//        System.out.println("");
//        System.out.print("Step " + count + " (searched value is absent): " + "   ");
//        DisplayArray(array, "");
//        System.out.println("");

        //Exit the loop when the search number is not found, then return -1 
        return -1;
    }

    private static void DisplayIndexOfSearchNumber(int search_number, int index) {
        //Print out in case no value is found   
        if (index == -1) {
            System.out.println("Not found " + search_number);
        } //If the search number is found, print the position of that value
        else {
            System.out.println("");
            System.out.println("Found " + search_number + " at index: " + index);
        }
    }

    public static void main(String[] args) {
        // Step 1: Input a positive decimal number about number of array
        int size_array = inputPositiveDecimalNumber("Enter number of array: ");
        // Step 2: Input a positive decimal number about search number         
        int search_number = inputPositiveDecimalNumber("Enter search value: ");
        /* Step 3: Generate random integer in number range
        for each array element and random all elements of array*/
//          int[] array = {-1, 5, 6, 18, 19, 25, 46, 78, 102, 114};  //test case
        int[] array = RandomAllElementsOfArray(size_array);
        // Step 4: Sort ascending array by Algorithm
        SortAscendingArray(array);
        // Step 5: Display array after sorting
        DisplayArray(array, "Sorted array: ");
        // Step 6: Search index element in array by Binary Search Algorithm        
        int indexOfSearchNumber = BinarySearch(array, search_number, 0);
//        int indexOfSearchNumber = BinarySearch(array, search_number, 1);
        // Step 7: Display the index of search number in array 
        DisplayIndexOfSearchNumber(search_number, indexOfSearchNumber);
    }
}
