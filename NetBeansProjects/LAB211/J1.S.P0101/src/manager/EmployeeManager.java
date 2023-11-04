/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import Object.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author msi
 */
public class EmployeeManager {

    Validation val = new Validation();
    Scanner sc = new Scanner(System.in);
    Display display = new Display();

    /**
     * Description: Checks if an employee ID already exists in the provided
     * list.
     *
     * @param Id The employee ID to check for existence.
     * @param EmployeeList The list of employees to search in.
     * @return True if the ID exists in the list, false otherwise.
     */
    public boolean checkIdExist(int Id, ArrayList<Employee> EmployeeList) {
        boolean isExist = false;
        if (EmployeeList.isEmpty()) {
            return isExist;
        } else {
            for (Employee employee : EmployeeList) {
                if (employee.getId() == Id) {
                    System.out.println("Id has been existed!!!");
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    /**
     * Description: Checks if an employee ID already exists in the provided
     * list.
     *
     * @param Id The employee ID to check for existence.
     * @param EmployeeList The list of employees to search in.
     * @return True if the ID exists in the list, false otherwise.
     */
    public void addEmployee(ArrayList<Employee> EmployeeList) {
        int Id;
        do {
            Id = val.getInteger("Enter employee's id: ", 1, Integer.MAX_VALUE);
            boolean isExist = checkIdExist(Id, EmployeeList);
            if (isExist) {
                continue;
            } else {
                break;
            }
        } while (true);
        String FirstName = val.getString("Enter employee's first name: ", "");
        String LastName = val.getString("Enter employee's last name: ", "");
        String Phone = val.getPhone("Enter employee's phone number: ", "^0[9843]{1}\\d{8}$"); // Phone start with zero and contain 10 digits
        String Email = val.getMail("Enter employee's email: ", "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$");
        String Address = val.getString("Enter employee's address: ", "");
        Date DOB;
        do {
            DOB = val.getDate("Enter employee birthday[dd/MM/yyyy]: ");
            Date now = new Date();
            if (DOB.before(now)) {
                break;
            } else {
                System.out.println("Birthday must before today!");
                continue;
            }
        } while (true);
        //[FM}: allow input is F or M
        String sex = val.getString("Enter employee's gender[F: female; M: male]: ", "[FM]");
        double Salary = val.getDouble("Enter employee salary: ", 0, Integer.MAX_VALUE);
        String Agency = val.getString("Enter employee agency: ", "");
        Employee employee = new Employee(Id, FirstName, LastName, Phone, Email, Address, DOB, sex, Salary, Agency);
        EmployeeList.add(employee);
    }

    /**
     * Description: search employee bu id
     *
     * @param: List employee and id
     * @return: index
     */
    public int searchByID(ArrayList<Employee> EmployeeList, int id) {
        int pos = -1;
        if (EmployeeList.isEmpty()) {
            System.out.println("List is empty!!!");
        } else {
            for (Employee employee : EmployeeList) {
                if (id == employee.getId()) {
                    pos = EmployeeList.indexOf(employee);
                    break;
                }
            }
        }
        return pos;
    }

    /**
     * Description: Add an employee's information
     *
     * @param EmployeeList The list of employees to add
     */
    public void updateEmployee(ArrayList<Employee> EmployeeList) {
        int id;
        int pos;
        if (EmployeeList.isEmpty()) {
            System.out.println("List empty");
        } else {
            do {
                display.displayAllList(EmployeeList);
                id = val.getInteger("Enter id employee: ", 0, Integer.MAX_VALUE);
                pos = searchByID(EmployeeList, id);
                //compare pos with -1
                if (pos == -1) {
                    System.out.println("Can't not find employee please enter again!");
                    continue;
                } else {
                    break;
                }
            } while (true);
            do {
                System.out.println("Choose update option:");
                System.out.println("1: Update first name of employee.");
                System.out.println("2: Update lastname of employee.");
                System.out.println("3: Update phone number of employee.");
                System.out.println("4: Update email of employee.");
                System.out.println("5: Update address of employee.");
                System.out.println("6: Update birthday of employee.");
                System.out.println("7: Udate gender of employee.");
                System.out.println("8: Update salary of employee.");
                System.out.println("9: Update agency of employee.");
                System.out.println("10: Update Id of emloyee.");
                int choice = val.getInteger("Let's select option: ", 1, 10);
                switch (choice) {
                    case 1:
                        String FirstName = val.getString("Enter employee's first name: ", "");
                        EmployeeList.get(pos).setFirstName(FirstName);
                        break;
                    case 2:
                        String LastName = val.getString("Enter employee's last name: ", "");
                        EmployeeList.get(pos).setLastName(LastName);
                        break;
                    case 3:
                        String Phone = val.getString("Enter employee's phone number: ", "^0[9843]{1}\\d{8}$");
                        EmployeeList.get(pos).setPhone(Phone);
                        break;
                    case 4:

                        String Email = val.getMail("Enter employee's email: ", "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$");
                        EmployeeList.get(pos).setEmail(Email);
                        break;
                    case 5:
                        String Address = val.getString("Enter employee's address: ", "");
                        EmployeeList.get(pos).setAddress(Address);
                        break;
                    case 6:
                        Date DOB;
                        do {
                            DOB = val.getDate("Enter employee birthday[dd/MM/yyyy]: ");
                            Date now = new Date();
                            if (DOB.before(now)) {
                                break;
                            } else {
                                System.out.println("Birthday must before today!");
                                continue;
                            }
                        } while (true);
                        EmployeeList.get(pos).setDOB(DOB);
                        break;
                    case 7:
                        String sex = val.getString("Enter employee's gender[F: female; M: male]: ", "[FM]");
                        EmployeeList.get(pos).setSex(sex);
                        break;
                    case 8:
                        int Salary = val.getInteger("Enter employee salary: ", 0, Integer.MAX_VALUE);
                        EmployeeList.get(pos).setSalary(Salary);
                        break;
                    case 9:
                        String Agency = val.getString("Enter employee agency: ", "");
                        EmployeeList.get(pos).setAgency(Agency);
                        break;
                    case 10:
                        int Id;
                        do {
                            Id = val.getInteger("Enter employee's id: ", 1, Integer.MAX_VALUE);
                            boolean isExist = checkIdExist(Id, EmployeeList);
                            //check value of variable isExist
                            if (!isExist) {
                                break;
                            }
                        } while (true);
                        EmployeeList.get(pos).setId(Id);
                        break;
                }
                display.displayAllList(EmployeeList);
                //[yn]: accept input must be y or n
                String answer = val.getString("Do you want to continue?y|n: ", "[yn]");
                //compare value of answer with string "n"
                if (answer.equals("n")) {
                    break;
                } else {
                    continue;
                }
            } while (true);
        }

    }

    /**
     * Description: Removes an employee from the provided list based on their
     * ID.
     *
     * @param EmployeeList The list of employees to search and remove from.
     */
    public void removedEmployee(ArrayList<Employee> EmployeeList) {
        int id;
        int pos;
        if (EmployeeList.isEmpty()) {
            System.out.println("List empty");
        } else {
            do {
                id = val.getInteger("Enter id employee: ", 0, Integer.MAX_VALUE);
                pos = searchByID(EmployeeList, id);
                //compare pos with -1
                if (pos == -1) {
                    System.out.println("Can't not find employee please enter again! ");
                    return;
                } else {
                    break;
                }
            } while (true);
            EmployeeList.remove(pos);
            display.displayAllList(EmployeeList);
        }
    }

    /**
     * Description: Sorts the provided list of employees by salary in ascending
     * order.
     *
     * @param EmployeeList The list of employees to sort.
     */
    public void search(ArrayList<Employee> EmployeeList) {
        if (EmployeeList.isEmpty()) {
            System.out.println("List empty");
        } else {
            String NameforSearch = val.getString("Enter employee name to find: ", "");
            int pos = -1;
            int count = 0;
            System.out.println("Result of Search: ");
            for (int i = 0; i < EmployeeList.size(); i++) {
                String fullname = EmployeeList.get(i).getFirstName() + " " + EmployeeList.get(i).getLastName();
                if (fullname.contains(NameforSearch)) {
                    pos = i;
                    if (pos != -1) {
                        count++;
                    }
                }
            }
            if (count == 0) {
                System.out.println("Employee doesn't exist");
            } else {
                System.out.format("%-10s%-30s%-30s%-15s%-30s%-20s%-12s%-10s%-10s%-10s\n", "Id", "First Name", "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
            }
            for (int i = 0; i < EmployeeList.size(); i++) {
                String fullname = EmployeeList.get(i).getFirstName() + " " + EmployeeList.get(i).getLastName();
                if (fullname.contains(NameforSearch)) {
                    pos = i;
                    if (pos != -1) {
                        display.DisplayElementofList(EmployeeList, pos);
                    }
                }
            }
        }

    }

    /**
     * Description: Sorts the provided list of employees by salary in ascending
     * order.
     *
     * @param EmployeeList The list of employees to sort.
     */
    public void sortBySalary(ArrayList<Employee> EmployeeList) {
        Collections.sort(EmployeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // Compare the salary of two employee objects
                if (o1.getSalary() == o2.getSalary()) {
                    return o1.getId() - o2.getId();
                } else {
                    return (int) (o1.getSalary() - o2.getSalary());
                }
            }
        });
        if (EmployeeList.isEmpty()) {
            System.out.println("List Empty");
        } else {
            display.displayAllList(EmployeeList);
        }
    }
}
