/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0011;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pC
 */
public class J1SP0011 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String binary = "10110000101010101000101001010101010100101010100100101010101000010111110";
        String decimal = BinaryToDecimal(binary);
        System.out.println(decimal);
        
        String binary1 = DecimalToBinary(decimal);
        System.out.println(binary);
        System.out.println(binary1);
        System.out.println("======================================================================================");
        String hexadecimal = "ABCDEFFEDCBA12345678991010987654321";
        String decimal1 = HexadecimalToDecimal(hexadecimal);
        System.out.println(decimal1);
        
        
        String hexadecimal1 = DecimalToHexadecimal(decimal1);
        System.out.println(hexadecimal1);
        System.out.println(hexadecimal);
    }

    private static String BinaryToDecimal(String binary) {
        //The BigInteger constant zero.
        BigInteger decimal = BigInteger.ZERO;
        //The BigInteger constant one.
        BigInteger power = BigInteger.ONE;
        //The BigInteger constant two.
        BigInteger BigTwo = new BigInteger("2");
        
        //loop traverse string binary from last to first
        for (int i = binary.length() - 1; i >= 0; i--) {
            //check if element at i pos is number 1
            if (binary.charAt(i) == '1') {
                // bigInteger decimal plus power
                decimal = decimal.add(power);
            }
            //power after a loop will multiply with 2
            power = power.multiply(BigTwo);
        }
        
        return decimal.toString();
//Để đổi giá trị Nhị phân ra thành Thập phân, ta lấy dãy số Nhị phân cần chuyển, 
// nhân lần lượt các phần tử của chúng bắt đầu từ phần tử cuối (theo chiều mũi tên màu đỏ) với 20 cho đến 2n-1 
// (với n là số phần tử của dãy số), sau đó, chúng ta tiến hành cộng các giá trị tìm được từ phép nhân, ta sẽ được kết quả một con số 
    }
    
    private static String DecimalToBinary(String decimal) {
        //Create an empty string to hold the binary representation of the number.
        BigInteger decimalNumber = new BigInteger(decimal);
        StringBuilder binaryStringBuilder = new StringBuilder();
        //The BigInteger constant two.
        BigInteger BigTwo = new BigInteger("2");
        
        //While the input number is not = zero:
        while(!decimalNumber.equals(BigInteger.ZERO)){
//            Divide the input number by 2 using integer division 
            BigInteger[] divisionResult = decimalNumber.divideAndRemainder(BigTwo);//returns both the quotient and the remainder as an array of BigInteger objects.
            //Append the remainder (either 0 or 1) to the binary string.
            binaryStringBuilder.append(divisionResult[1]);//The append() method in StringBuilder is used to add characters or strings to the end of a StringBuilder object.
            decimalNumber = divisionResult[0];
        }
        //using String builder to reverse String correctly append 0-1
        String binary = binaryStringBuilder.reverse().toString();
        //Return the binary string
        return binary;
    }

    private static String HexadecimalToDecimal(String hexadecimal) {
        char[] hexaDigit = {'0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        //create object store big number decimal integer initial constant 0 value
        BigInteger decimal = BigInteger.ZERO;
        //
        BigInteger base = BigInteger.ONE;
        BigInteger number16 = new BigInteger("16");

        //traverse String hexadecimal from right to left
        for (int i = hexadecimal.length() - 1; i >= 0; i--) {
            //take digit at i pos
            char digit = hexadecimal.charAt(i);
            //set value at 0
            BigInteger value = new BigInteger("0");
            //loop find current digit fit with any char in char array
            for (int j = 0; j < hexaDigit.length; j++) {
                //check if current digit in String hexadecimal equal current char in char array
                if (digit == hexaDigit[j]) {
                    //create new value object has value is pos of this char in char array
                    value = new BigInteger(Integer.toString(j));
                    break;
                }
            }

            decimal = decimal.add(value.multiply(base));
            base = base.multiply(number16);
        }

        // Convert the decimal integer to a string
        String decimalString = decimal.toString();

        // Return the decimal string
        return decimalString;
    }

    
    private static String DecimalToHexadecimal(String decimal) {
        char[] hexaDigit = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        BigInteger num = new BigInteger(decimal);
        if (num.compareTo(BigInteger.ZERO) == 0) {
            return "0";
        }

        StringBuilder hexa = new StringBuilder();
        BigInteger number16 = new BigInteger("16");

        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divAndRem = num.divideAndRemainder(number16);
            int remainder = divAndRem[1].intValue();
            char hexaChar = hexaDigit[remainder];
            hexa.insert(0, hexaChar);
            num = divAndRem[0];
        }

        return hexa.toString();
    }


    
}
