/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0101;

import Object.Employee;
import java.util.ArrayList;
import java.util.Scanner;
import manager.Display;
import manager.EmployeeManager;
import manager.Validation;

/**
 *
 * @author msi
 */
public class J1SP0101 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Validation getData = new Validation();
        EmployeeManager EmployeeManagement = new EmployeeManager();
        Display display = new Display();
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        do {
            //1. Display a menu
            display.DisplayMenu();
            //2. Ask and Get user's choice
            choice = getData.getInteger("Let's select option: ", 1, 6);
            //3.Do the option user select
            switch (choice) {
                case 1://Add Employee
                    EmployeeManagement.addEmployee(EmployeeList);
                    break;
                case 2: //Update employees
                    EmployeeManagement.updateEmployee(EmployeeList);
                    break;
                case 3://Removed employees
                    int Id;
                    EmployeeManagement.removedEmployee(EmployeeList);
                    break;
                case 4: //Search employees
                    EmployeeManagement.search(EmployeeList);
                    break;
                case 5://Sort employees by salary
                    EmployeeManagement.sortBySalary(EmployeeList);
                    break;
            }
        } while (choice < 6);
    }
}
