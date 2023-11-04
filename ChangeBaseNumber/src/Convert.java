/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigInteger;

/**
 *
 * @author admin
 */
public class Convert {
    private static final String base = "0123456789ABCDEF";
    
    public static String convertDecimalToBinary(String value) {
        BigInteger values = new BigInteger(value);
        BigInteger binary = new BigInteger("2");
        StringBuilder result = new StringBuilder("");
        String remainder;
        //Loop run when value is difference to zero
        while (!values.equals(new BigInteger("0"))) {  
            //Divide the remainder of the value by 2
            remainder = values.mod(binary).toString();
            result.append(remainder);
            values = values.divide(binary);
        }
        return result.reverse().toString();
    }
    
    public static String convertBinaryToDecimal(String value) {
        BigInteger binary = new BigInteger("2");
        int number = 0, count = 0;
        BigInteger result = new BigInteger("0");
        /*Loop to access from last character of value to 
        first character of value*/
        for (int i = value.length() - 1; i >= 0; i--) {
            number = base.indexOf(value.charAt(i));
            result = result.add(new BigInteger(Integer.toString(number)).multiply(binary.pow(count)));
            count++;
        }
        return result.toString();
    }
    
    public static String convertDecimalToHexadecimal(String value) {
        BigInteger values = new BigInteger(value);
        BigInteger hexadecimal = new BigInteger("16");
        StringBuilder result = new StringBuilder("");
        int remainder;
        //Loop run when value is difference to zero
        while (!values.equals(new BigInteger("0"))) {            
            remainder = Integer.parseInt(values.mod(hexadecimal).toString());
            result.append(base.charAt(remainder));
            values = values.divide(hexadecimal);
        }
        return result.reverse().toString();
    }
    
    public static String convertHexadecimalToDecimal(String value) {
        BigInteger hexadecimal = new BigInteger("16");
        int number = 0;
        int count = 0;
        BigInteger result = new BigInteger("0");
        /*Loop to access from last character of value to 
        first character of value*/
        for (int i = value.length() - 1; i >= 0; i--) {
            number = base.indexOf(value.charAt(i));
            result = result.add(new BigInteger(Integer.toString(number)).multiply(hexadecimal.pow(count)));
            count++;
        }
        return result.toString();
    }
    
    public static String convertHexadecimalToBinary(String value) {
        String decimal = convertHexadecimalToDecimal(value);
        String binary = convertDecimalToBinary(decimal);
        return binary;
    }
    
    public static String convertBinaryToHexadecimal(String value) {
        String decimal = convertBinaryToDecimal(value);
        String hexadecimal = convertDecimalToHexadecimal(decimal);
        return hexadecimal;
    }
    
}
