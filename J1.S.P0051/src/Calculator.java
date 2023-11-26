/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Calculator {
    Display display = new Display();

    public static void normalCalculator() {
        System.out.println("----- Normal Calculator -----");
        double memory, number;
        String operator;
        memory = InputData.InputDouble("Enter number: ", "Must be number", false);
        //Use loop to check input user is correct
        while (true) {
            operator = InputData.InputOperator();
            //if operator is addition then print the memory result of the addition     
            if (operator.equalsIgnoreCase("+")) {
                memory += InputData.InputDouble("Enter number: ", "Must be number", false);
                System.out.println("Memory: " + memory);
            }
            //if operator is subtract then print the memory result of the subtract
            else if (operator.equalsIgnoreCase("-")) {
                memory -= InputData.InputDouble("Enter number: ", "Must be number", false);
                System.out.println("Memory: " + memory);
            }
            //if operator is mutiply then print the memory result of the mutiply
            else if (operator.equalsIgnoreCase("*")) {
                memory *= InputData.InputDouble("Enter number: ", "Must be number", false);
                System.out.println("Memory: " + memory);
            }
            //if operator is divide then print the memory result of the divide 
            else if (operator.equalsIgnoreCase("/")) {
                number = InputData.InputDouble("Enter number: ", "Must be number", false);
                //If the number is zero then the division cannot be performed
                if(number == 0) {
                    System.out.println("Not divide by zero");
                    continue;
                }
                memory /= number;
                System.out.println("Memory: " + memory);
            }
            //if operator is exponent then print the memory result of the exponent 
            else if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, InputData.InputDouble("Enter number: ", "Must be number", false));
                System.out.println("Memory: " + memory);
            }
            //if operator is equal then print the final result of the operation and return
            else if (operator.equalsIgnoreCase("=")) {
                System.out.printf("Result: %.2f\n", memory);
                return;
            }
        }

    }

    public void BMICalculator() {
        System.out.println("----- BMI Calculator -----");
        double weight = InputData.InputDouble("Enter Weight(kg): ", "BMI is digit", true);
        double height = InputData.InputDouble("Enter Height(cm): ", "BMI is digit", true);
        double BMI = weight * 10000 / (height * height);
        System.out.printf("BMI Number: %.2f\n", BMI);
        System.out.println("BMI Status: " + display.displayBMIStatus(BMI));
    }
}
