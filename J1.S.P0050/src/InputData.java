/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class InputData {
    Scanner sc = new Scanner(System.in);
    int selectAnOption(String msg){
        String input;
        int number;
        do {    
            System.out.print(msg);
            input = sc.nextLine();
            //Check input is empty
            if(input.isEmpty()){
                System.out.println("Could not be empty");
                continue;
            }
            try {
                number = Integer.parseInt(input);
                //Check number is not range from one to three
                if(number < 1 || number > 3) 
                    throw new Exception();
                return number;
            } catch (Exception e) {
                System.out.println("Please input number in range from one to three");
            }
        } while (true);
    }
    
    float getFloatNumber(String msg){
        String input;
        float number;     
        do {    
            System.out.print(msg);
            input = sc.nextLine();
            //Check input is empty
            if(input.isEmpty()){
                System.out.println("Could not be empty");
                continue;
            }
            try {
                number = Float.parseFloat(input);
                return number;
            } catch (Exception e) {
                System.out.println("Please input number");
            }
        } while (true);
    }
    
    boolean getOddNumber(float number){
        //Check number is odd number
        if(number%2 != 0) {
            return true;
        }else {
        return false;
        }
    }
    boolean getEvenNumber(float number){
        //Check number is even number
        if(number%2 == 0) {
            return true;
        }else {
        return false;
        }
    }
    boolean getPerfectSquareNumber(float number){
        //Check number is perfect square number
        if(Math.sqrt(number) == (int)Math.sqrt(number)) {
            return true;
        }else {
        return false;
        }
    }
}
