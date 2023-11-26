
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
public class MarkCalculation {
    
    HashMap<String, Double> getPercentTypeStudent(List<Student> students) {
        HashMap<String, Double> percent = new HashMap<>();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int number_Student = students.size();
        //Use loop to access from first student to last student
        for (Student student : students) {
            //Count the number of students who got grade A 
            if (student.getType().equals("A")) {
                countA++;
            }
            //Count the number of students who got grade B
            else if (student.getType().equals("B")) {
                countB++;
            }
            //Count the number of students who got grade C
            else if (student.getType().equals("C")) {
                countC++;
            }
            //Count the number of students who got grade D
            else if (student.getType().equals("D")) {
                countD++;
            }
        }
        double percentA =  100*countA/number_Student;
        double percentB =  100*countB/number_Student;
        double percentC =  100*countC/number_Student;
        double percentD =  100*countD/number_Student;
        percent.put("A", percentA);   
        percent.put("B", percentB);
        percent.put("C", percentC);
        percent.put("D", percentD);
        return percent;    
                }
    
    List<Student> averageStudent(List<Student> students) {
        double math, chemistry, physics, average;
        //Use loop to access from first student to last student
        for (Student student : students) {
            math = student.getMaths();
            chemistry = student.getChemistry();
            physics = student.getPhysics();
            average = (math + physics + chemistry) / 3;
            student.setAverage(average);
            //If average is greater than 7.5 then classify students as type A
            if (average > 7.5) {
                student.setType("A");
            } 
            //If average between 6 to 7.5 then classify students as type B
            else if (average <= 7.5 && average >= 6) {
                student.setType("B");
            } 
            //If average from 4 to less than 6 then classify students as type C
            else if (average >= 4 && average < 6) {
                student.setType("C");
            } 
            //If average is less than 4 then classify students as type D
            else if (average < 4) {
                student.setType("D");
            }
        }
        return students;
    }
    
}
