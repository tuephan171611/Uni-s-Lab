/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0001;

import java.util.Random;

/**
 *
 * @author msi
 */
public class GenerateRandomArray {

    /**
     * Generates an array of random integers.
     *
     * @param numElements The number of elements in the array.
     * @return The generated array of random integers.
     */
    public int[] generateRandomArray(int numElements) {
        int[] array = new int[numElements];
        Random random = new Random();
        for (int i = 0; i < numElements; i++) {
            array[i] = random.nextInt(numElements) + 0;
        }
        return array;
    }

    /**
     * Displays the elements of an array.
     *
     * @param array The array to be displayed.
     */
    public void displayArray(int[] array) {
        System.out.print("[" + array[0] + ", ");
        for (int i = 1; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1] + "]");
        System.out.println();
    }

}
