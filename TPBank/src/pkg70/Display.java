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
public class Display {
    InputData inputData = new InputData();
    
    int displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int select_an_option = inputData.selectAnOption("Please choice one option: ");
        System.out.println();
        return select_an_option;
    }
}
