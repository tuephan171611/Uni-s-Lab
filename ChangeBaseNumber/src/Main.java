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
        ManageChangeBase manageChangeBase = new ManageChangeBase();
        //loop until user want to exit
        while (true) {
            //Step 1: Required user choose the base number input 
            int baseInput = manageChangeBase.chooseInputBase();
            //Step 2: Required user choose the base number out 
            int baseOutput = manageChangeBase.chooseOutputBase();
            //Step 3: User enter the input value
            String inputValue = manageChangeBase.inputValue(baseInput);
            //Step 4: Convert input value from base input to base output
            String result = manageChangeBase.convertInputValue(baseInput, baseOutput, inputValue);
            //Step 5: Display output value
            manageChangeBase.display(baseInput, baseOutput,inputValue ,result);      
        }
    }
    
}
