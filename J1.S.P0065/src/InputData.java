
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class InputData {

    private static final Scanner sc = new Scanner(System.in);

    public Student createStudent(String name, String classes, double maths, double chemistry, double physics) {
        name = getString("Name:");
        classes = getString("Classes:");
        maths = getDouble("Maths:", "Maths");  
        chemistry = getDouble("Chemistry:", "Chemistry");
        physics = getDouble("Physics:", "Physics");
        Student student = new Student(name, classes, null, maths, chemistry, physics, 0);
        return student;
    }
    
    public String getString(String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine().trim();
            if (input.equals("")) {
                System.out.println("Could not be empty");
                continue;
            }
            return input;
        } while (true);
    }
    
    public String getYN(String msg) {
        String input;
        do {            
            input = getString(msg);
            if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")) {
                return input;
            }else {
                System.out.println("Input is not correct");
            }
        } while (true);
    }

    public double getDouble(String msg, String subject) {
        double data;
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            try {
                data = Double.parseDouble(input);
                if (data < 1) {
                    System.out.println(subject + " is greater than zero");
                    continue;
                }
                if (data > 10) {
                    System.out.println(subject + " is less than equal ten");
                    continue;
                }
                return data;
            } catch (Exception e) {
                System.out.println(subject + " is digit");
            }

        } while (true);
    }
}
