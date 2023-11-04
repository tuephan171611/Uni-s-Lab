/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import Object.Employee;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class Display {

    /**
     * Description: Displays the main menu options of the program.
     */
    public void DisplayMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1. Add employees");
        System.out.println("\t2. Update employees");
        System.out.println("\t3. Remove employees");
        System.out.println("\t4. Search employees");
        System.out.println("\t5. Sort employees by salary");
        System.out.println("\t6. Exit");
    }

    /**
     * Description: Displays the details of an employee at the specified index
     * in the employee list.
     *
     * @param EmployeeList The list of employees.
     * @param index The index of the employee to display.
     */
    public void DisplayElementofList(ArrayList<Employee> EmployeeList, int index) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String DayofBirth = dateFormat.format(EmployeeList.get(index).getDOB());
        System.out.format("%-10s%-30s%-30s%-15s%-30s%-20s%-12s%-10s%-10s%-10s\n",
                EmployeeList.get(index).getId(), EmployeeList.get(index).getFirstName(), EmployeeList.get(index).getLastName(),
                EmployeeList.get(index).getPhone(), EmployeeList.get(index).getEmail(), EmployeeList.get(index).getAddress(), DayofBirth,
                EmployeeList.get(index).getSex(), EmployeeList.get(index).getSalary(), EmployeeList.get(index).getAgency());
    }

    /**
     * Description: Displays all employees in the provided list.
     *
     * @param EmployeeList The list of employees.
     */
    public void displayAllList(ArrayList<Employee> EmployeeList) {
        System.out.println("The Employees List: ");
        System.out.format("%-10s%-30s%-30s%-15s%-30s%-20s%-12s%-10s%-10s%-10s\n", "Id", "First Name", "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        for (int i = 0; i < EmployeeList.size(); i++) {
            DisplayElementofList(EmployeeList, i);
        }
    }

}
