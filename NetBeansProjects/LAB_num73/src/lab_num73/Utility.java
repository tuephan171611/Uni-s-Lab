package lab_num73;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public final static Scanner sc = new Scanner(System.in);
    public static final String REGEX_STRING = "[a-zA-Z ]+";
    public static final String REGEX_DATE = "\\d{1,2}[-][a-zA-Z]{3}[-]\\d{4}";
    public static final String DATE_FORMAT = "dd-MMM-yyyy";
    public static int getInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();
                //input is empty->tell error
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !");
                } else {
                    //check user enter number or not
                    int number = Integer.parseInt(input);
                    //check range of number
                    if (number < min || number > max) {
                        System.out.println("Number must be range "+min+"->"+max);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a integer number!");
            }

        }
}
     public static String getString(String message, String regex, String error) {
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
      public static double getDouble(String message, double min, double max) {

        while (true) {
            try {
                System.out.print(message);
                String input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    if (!(number % 0.5 == 0)) {
                        System.out.println("Input must be divide to 0.5");
                    }
                    if (number < min || number > max) {
                        System.out.println("Number must be range "+min+"->"+max);
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be a integer number");
            }

        }

    }
    public static String inputDate(String message) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            // Input date
            System.out.print(message);
            String inputDate = sc.nextLine();
            
            //if input is empty => tell error
            if (inputDate.isEmpty()) {
                System.out.println("Input cannot be empty !!!");
            } else {
                //if input matches with regex => return string
                //else tell error
                if (inputDate.matches(REGEX_DATE) == false) {
                    System.out.println("Input must be in format [dd-MMM-yyyy]");
                } else if (checkDateExist(inputDate) == false) {
                    System.out.println("Date does not exist!!");
                }else if(checkMoreThanCurrentDate(inputDate) == true) {
                    System.out.println("Date must be not greater or equal to current date !!");
                }else {
                    return inputDate;
                }
            }
        }

    }
      public static boolean checkMoreThanCurrentDate(String input) {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            Date currentDate = new Date();
            String currentDateString = dateFormat.format(currentDate);
            Date inputDate = dateFormat.parse(input);
            currentDate = dateFormat.parse(currentDateString);
            
            //neu nhu input date < current date => true
            //else => return false
            return !(inputDate.equals(currentDate) || inputDate.before(currentDate));
            
        } catch (ParseException ex) {
            return false;
        }
    }
      public static boolean checkDateExist(String date) {
      SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
      dateFormat.setLenient(false);
      try {
          dateFormat.parse(date);
          return true;
      } catch (ParseException ex) { 
          return false;
      }
  }
     
}
