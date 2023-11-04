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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputData inputData = new InputData();
        Calculate calculate = new Calculate();
        Display display = new Display();
        List<Float> number = new ArrayList<>();
        int select_an_option;
        float A, B, C;
        do {
            //Step 1: Display menu and ask users to select an option
            select_an_option = display.displayMenu();
            //Step 2: Perform function based on the selected option
            switch(select_an_option){
                //Option 1: Calculate Superlative Equation
                case 1:  
                    //Step 1: Input coefficient A
                    A = inputData.getFloatNumber("Enter A: ");
                    //Step 2: Input coefficient B
                    B = inputData.getFloatNumber("Enter B: ");
                    //Step 3: Calculate the solution
                    List<Float> solution1 = calculate.superlativeEquation(A, B, number);
                    //Step 4: Display solution
                    display.displaySolution(solution1, select_an_option);
                    //Step 5: Display number odd
                    display.displayNumberOdd(number, "Number is Odd:");
                    //Step 6: Display number even
                    display.displayNumberEven(number);
                    //Step 7: Display number perfect square
                    display.displayPerfectSquare(number);
                    break;
                //Option 2: Calculate Quadratic Equation
                case 2:
                    //Step 1: Input coefficient A
                    A = inputData.getFloatNumber("Enter A: ");
                    //Step 2: Input coefficient B
                    B = inputData.getFloatNumber("Enter B: ");
                    //Step 3: Input coefficient C
                    C = inputData.getFloatNumber("Enter C: ");
                    //Step 4: Calculate the solution 
                    List<Float> solution2 = calculate.quadraticEquation(A, B, C, number);
                    //Step 5: Display solution
                    display.displaySolution(solution2, select_an_option);
                    //Step 6: Display number odd
                    display.displayNumberOdd(number, "Odd Number(s):");
                    //Step 7: Display number even
                    display.displayNumberEven(number);
                    //Step 8: Display number perfect square
                    display.displayPerfectSquare(number);
                    break;
                //Option 3: Exit program
                case 3: 
                    System.exit(0);
            }
            number.clear();
        } while (true);
    }

}
