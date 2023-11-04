


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) {
        InputData inputdata = new InputData();
        MarkCalculation markCalculation = new MarkCalculation();
        Display display = new Display();
        Student student;
        String choice;
        String name = "", classes = "";
        double maths = 0, chemistry = 0, physics = 0;
        List<Student> Students = new ArrayList();
        //Step 1: Display GUI
        display.DisplayGUI();
        do {
            //Step 2: Input Data
            student = inputdata.createStudent(name, classes, maths, chemistry, physics); 
            //Step 3: Add Student to list
            Students.add(student);
            //Step 4: User input y/n or Y/N
            choice = inputdata.getString("Do you want to enter more student information?(Y/N):");
        } while (choice.equalsIgnoreCase("Y"));
        //Step 5: Classifies students
        List<Student> StudentClassification = markCalculation.averageStudent(Students);
        //Step 6: Gives student rank statistics by %
        HashMap<String, Double> rank = markCalculation.getPercentTypeStudent(StudentClassification);
        //Display student info
        display.DisplayStudentInfo(StudentClassification);   
        //Display classification info
        display.DisplayClassificationInfo(rank);
    }
}
