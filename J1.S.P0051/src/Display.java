/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class Display {
    public static int DisplayMenu() {
        System.out.println("========= Calculator Program =========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        int select_an_option = InputData.SelectAnOption("Please choice one option: ");
        return select_an_option;
    }
    
     public static String displayBMIStatus(double BMI) {
        //BMI is less than 19 then print BMI is under standard  
        if (BMI < 19) {
            return "UNDER-STANDARD";
        }
        //BMI is between 19 to 25 then print BMI is standard
        else if (BMI >= 19 && BMI < 25) {
            return "STANDARD";
        }
        //BMI is between 25 to 30 then print BMI is overweight
        else if (BMI >= 25 && BMI < 30) {
            return "OVERWEIGHT";
        } 
        //BMI is between 30 to 40 then print BMI is fat
        else if (BMI >= 30 && BMI < 40) {
            return "FAT SHOULD LOSE WEIGHT";
        } 
        //BMI is over 40 then print BMI is very fat
        else {
            return "VERY FAT - SHOULD LOSE WEIGHT IMMEDITATELY";
        }
    }
}

