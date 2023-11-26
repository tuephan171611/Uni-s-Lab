
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Main {
    
    public static void main(String[] args) {
        Ebank ebank = new Ebank();
        Locale locale;
        ebank.mockData();
        while (true) {
            //display menu
            displayMenu();
            //user selects an option
            int option = Utility.getInt("Please choice one option:",1, 3);
            //Perform language based on the selected option
            switch (option) {
                //Vietnamese language
                case 1:
                    //Login with Vietnamese
                    ebank.loginVietnamese();
                    break;
                //English language  
                case 2:
                    //Login with English
                    ebank.loginEnglish();
                    break;
                //Exit 
                case 3:
                    System.exit(0);
                    break;
            }
            
        }
        
    }
    
    private static void displayMenu() {
        System.out.println("-------Login Program-------\n"
                + "1. Vietnamese\n"
                + "2. English\n"
                + "3. Exit");
    }
}
