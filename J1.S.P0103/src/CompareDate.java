
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
 * @author LENOVO
 */
public class CompareDate {
    public static void main(String[] args) {
        //1. User enter the first date with [dd/mm/yyyy] format
        Date firstDate = enterDatewithDDMMYYYYformat("Please enter the first date: ");
        //2. User enter the second date with [dd/mm/yyyy] format
        Date secondDate = enterDatewithDDMMYYYYformat("Please enter the second date: ");
        //3. Compare between two dates
        int result = CompareTwoDates(firstDate, secondDate); 
        //4. Display the result
        Display(result);
    }

    private static Date enterDatewithDDMMYYYYformat(String command) {  
        Scanner sc = new Scanner(System.in);
        String input;
        Date date;
        //loop uses to input and convert string to date
        do {            
            System.out.print(command);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            if (input.isEmpty()) {
                System.err.println("Input could not be empty");
                continue;
            }
            if (checkContainLetterOrCharacter(input)) {
                System.err.println("Input could not contain letters or characters");
                continue;
            }
            // \d{1,2}: the number have 1 or 2 digit number
            //[/]: contain character /
            //\d{4}: the number must have 4 digit
            if (!input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                System.err.println("Input is in wrong date format");
                continue;
            }
            try {
                date = dateFormat.parse(input);
                break;
            } catch (Exception e) {
                System.err.println("The input date doesn't exist");
            }
        } while (true);
        return date;
        
    }

    private static int CompareTwoDates(Date firstDate, Date secondDate) {
        if (firstDate.before(secondDate)) {
            return 1;
        } else if (firstDate.after(secondDate)) {
            return 2;
        } else {
            return 3;
        }
    }

    private static void Display(int result) {
        switch (result) {
            default:
                break;
            case 1:
                System.out.println("");
                System.out.println("Date1 is before Date2");
                break;
            case 2:
                System.out.println("");
                System.out.println("Date1 is after Date2");
                break;
            case 3:
                System.out.println("");
                System.out.println("Both dates are equal");
                break;
        }
    }
    
    private static boolean checkContainLetterOrCharacter(String input) {
        //loop use to access each character of input 
        for (int i = 0; i < input.length(); i++) {
            //check if character in index i is out range from character '/' to '9'
            if (!(input.charAt(i) <= '9' && input.charAt(i) >= '/')) {
                return true;
            }
        }
        return false;
        
    }
    
    
    
    
}
