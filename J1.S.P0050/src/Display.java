/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Display {

    InputData inputData = new InputData();

    int displayMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        int select_an_option = inputData.selectAnOption("Please choice one option: ");
        if(select_an_option == 1) {
            System.out.println("----- Calculate Equation -----");
        }
        else if (select_an_option == 2) {
            System.out.println("----- Calculate Quadratic Equation -----");
        }
        return select_an_option;
    }

    void displaySolution(List<Float> solution, int choice) {
        //Check solution is null
        if (solution == null) {
            System.out.println("No Solution");
            return;
        } 
        //Check solution is empty
        else if (solution.isEmpty()) {
            System.out.println("Infinitely many solutions");
            return;
        }
        switch (choice) {
            case 1:
                System.out.printf("Solution: x = %.3f\n", solution.get(0));
                break;
            case 2:
                if (solution.size() == 1) {
                    System.out.printf("Solution: x = %.3f\n", solution.get(0));
                } else {
                    System.out.printf("Solution: x1 = %.3f and x2 = %.3f\n",
                            solution.get(0), solution.get(1));
                }
        }

    }

    void displayNumberEven(List<Float> number) {
        List<Float> evenNumber = new ArrayList<>();
        //Loop to access from first number to last number 
        for (int i = 0; i < number.size(); i++) {
            if (inputData.getEvenNumber(number.get(i))) {
                evenNumber.add(number.get(i));
            }
        }
        //Check even number is empty
        if (evenNumber.isEmpty()) {
            System.out.println("No Even Number");
        } else {
            System.out.print("Number is Even:");
            //Loop to access even number in list
            for (int i = 0; i < evenNumber.size(); i++) {
                //Even number is last position in list then print
                if (i == evenNumber.size() - 1) {
                    System.out.println(evenNumber.get(i));
                } else {
                    System.out.print(evenNumber.get(i) + ", ");
                }
            }
        }
    }

    void displayNumberOdd(List<Float> number, String msg) {
        List<Float> oddNumber = new ArrayList<>();
        //Loop to access from first number to last number 
        for (int i = 0; i < number.size(); i++) {
            if (inputData.getOddNumber(number.get(i))) {
                oddNumber.add(number.get(i));
            }
        }
        //Check odd number is empty
        if (oddNumber.isEmpty()) {
            System.out.println("No Odd Number");
        } else {
            System.out.print(msg);
            //Loop to access odd number in list
            for (int i = 0; i < oddNumber.size(); i++) {
                //Odd number is last position in list then print
                if (i == oddNumber.size() - 1) {
                    System.out.println(oddNumber.get(i));
                } else {
                    System.out.print(oddNumber.get(i) + ", ");
                }
            }
        }
    }

    void displayPerfectSquare(List<Float> number) {
        List<Float> squareNumber = new ArrayList<>();
        //Loop to access from first number to last number   
        for (int i = 0; i < number.size(); i++) {
            if (inputData.getPerfectSquareNumber(number.get(i))) {
                squareNumber.add(number.get(i));
            }
        }
        //Check square number is empty
        if (squareNumber.isEmpty()) {
            System.out.println("No Perfect Square Number");
        } else {
            System.out.print("Number is Perfect Square:");
            //Loop to access square number in list
            for (int i = 0; i < squareNumber.size(); i++) {
                //Square number is last position in list then print 
                if (i == squareNumber.size() - 1) {
                    System.out.println(squareNumber.get(i));
                } else {
                    System.out.print(squareNumber.get(i) + ", ");
                }
            }
        }
    }

}
