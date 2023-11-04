/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg70;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        InputData inputData = new InputData();
        Display display = new Display();
        Manager manager = new Manager();
        int select_an_option;
        while (true) {
            //Step 1: Display a menu and ask users to select an option
            select_an_option = display.displayMenu();
            //Step 2: Perform language based on the selected option
            switch (select_an_option) {
                //Option 1: Login with Vietnamese language
                case 1:
                    manager.VietnameseLogin();
                    break;
                //Option 2: Login with English language
                case 2:
                    manager.EnglishLogin();
                    break;
                //Option 3: Exit
                case 3:
                    break;
            }
        }
    }
}
