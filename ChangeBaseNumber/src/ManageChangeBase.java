/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author admin
 */
public class ManageChangeBase {
    private static final GetInput getInput = new GetInput();

    public static int chooseInputBase() {
        int inputBase = getInput.getSelectAnOption("Choose base input: ");
        return inputBase;
    }

    public static int chooseOutputBase() {
        int outputBase = getInput.getSelectAnOption("Choose base output: ");
        return outputBase;
    }

    public static String inputValue(int baseInput) {
        String value = getInput.getInputValue("Enter value: ", baseInput);
        return value;
    }

    public static String convertInputValue(int baseInput, int baseOutput, String inputValue) {
        String result = "";
        if(baseInput==baseOutput){
        return inputValue;
        }
        switch (baseInput) {
            case 2:
                if (baseOutput==10) {
                    result = Convert.convertBinaryToDecimal(inputValue);
                } else if (baseOutput == 16) {
                    result = Convert.convertBinaryToHexadecimal(inputValue);
                }
                break;
            case 10:
                if (baseOutput == 2) {
                    result = Convert.convertDecimalToBinary(inputValue);
                } else if (baseOutput==16) {
                    result = Convert.convertDecimalToHexadecimal(inputValue);
                }
                break;
            case 16:
                if (baseOutput == 2) {
                    result = Convert.convertHexadecimalToBinary(inputValue);
                } else if (baseOutput == 10) {
                    result = Convert.convertHexadecimalToDecimal(inputValue);
                }
                break;
        }
        return result;
    }

    public static void display(int baseInput, int baseOutput, String inputValue, String result) {
        System.out.print(inputValue + "(" + getBase(baseInput) + ") = ");
        System.out.println(result + "(" + getBase(baseOutput) + ")");
    }
    
    private static String getBase(int base) {
        if (base == 2) {
            return "BIN"; 
        } else if (base == 10) {
            return "DEC";
        } else {
            return "HEX";
        }
    }
    
}
