
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Utility {
    /**
     * \d{10}:matches 10 digit characters(0-9)
     * ?=:matches a group after the main expression without including it in the result
     * \d:matches any digit character(0-9)
     * {8-31}:the number have 8-31 characters
     * a-z:matches a character in the range 'a' to 'z'
     * A-Z:matches a character in the range 'A' to 'Z'
     * 0-9:matches a character in the range '0' to '9'
     * 
     */
  public static final Scanner sc = new Scanner(System.in);
  public static final String REGEX_USERNAME = "\\d{10}";
  public static final String REGEX_PASSWORD = "(?=.*\\d.*)(?=.*[a-zA-z].*).{8,31}";
  public static final String REGEX_CAPTCHA= "[a-zA-z0-9]+";
  
  public static int getInt(String message, int min, int max) {
      while (true) {          
          try {
              System.out.println(message);
              String input = sc.nextLine();
              //if input is empty->tell error
              if(input.isEmpty()){
                  System.out.println("Input is not empty!");
              }
              else{
                  //check user enter number or not
                  int number = Integer.parseInt(input);
                  //check range of number
                  if(number < min || number > max){
                      System.out.println("Number must be range"+min+"->"+max);
                  }
                  else{
                      return number;
                  }
              }
          } catch (NumberFormatException e) {
              System.out.println("Input must be integer number!");
          }
    
      }
    }
   public static String getString(String message, String error,String regex) {
        while (true) {
            try{
            System.out.print(message);
            String input = sc.nextLine().trim();
            //input is empty->tell error
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty!");
            } 
                //if input matches regex => return input
                // else print error
                else if (input.matches(regex)) {
                    return input;
                } else {
                    System.out.println(error);
                }
            
        }
            catch(Exception e){
                System.out.println(error);
            }
        }
     }
    
}
