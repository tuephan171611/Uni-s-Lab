/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0001;

import java.util.Scanner;

/**
 *
 * @author msi
 */
public class J1SP0001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arrayTest = {5, 1, 12, -5, 16};
        Scanner sc = new Scanner(System.in);
        BubbleSort bbSort = new BubbleSort();
        GenerateRandomArray randomArray = new GenerateRandomArray();
        System.out.print("Enter number of array: ");
        int numberOfArray = Integer.parseInt(sc.nextLine());
        int[] array = randomArray.generateRandomArray(numberOfArray);
        System.out.print("Unsorted array: ");
        randomArray.displayArray(array);
        bbSort.bubbleSort(array);
        System.out.print("Sorted array: ");
        randomArray.displayArray(array);
//        randomArray.displayArray(arrayTest);
//        bbSort.bubbleSort(arrayTest);
//        randomArray.displayArray(arrayTest);

    }

}
