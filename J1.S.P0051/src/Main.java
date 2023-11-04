/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        Calculator calculator = new Calculator();
        InputData inputData = new InputData();
        int select_an_option;
        //Use loop until user want to exit
        while (true) {
            //Step 1: Display a menu and ask users to select an option
            select_an_option = display.DisplayMenu();
            //Step 2: Perform function based on the selected option
            switch (select_an_option) {
                //Option 1: Normal calculator
                case 1:
                    calculator.normalCalculator();
                    break;
                //Option 2: Calculator BMI    
                case 2:
                    calculator.BMICalculator();
                    break;
                //Option 3: Exit the program
                case 3:
                    return;
            }
        }
    }
}
