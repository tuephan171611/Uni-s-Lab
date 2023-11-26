/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0001;

/**
 *
 * @author msi
 */
public class BubbleSort {

    public void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            System.out.print("Step " + (i + 1) + ":");
            System.out.println();
            for (int j = 0; j < n - i - 1; j++) {
                // Compare adjacent elements and swap them if necessary
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    System.out.print("SWAP: ");
                    for (int k = 0; k < n; k++) {
                        System.out.print(array[k] + " ");
                    }
                    System.out.println();
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                } else {
                    System.out.print("OK: ");
                    for (int k = 0; k < n; k++) {
                        System.out.print(array[k] + " ");
                    }
                    System.out.println();
                }
            }
            // If no swaps were performed in the inner loop, the array is already sorted
            if (!swapped) {
                break;
            }
            System.out.println();
        }
    }

}
