import java.util.HashMap;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Display {
     public static void DisplayGUI() {
        System.out.println("====== Management Student Program ======");
    }
    
    public static void DisplayStudentInfo(List<Student> Students) {
        //Use loop to access from the first student to last student
        for (int index = 0; index < Students.size(); index ++) {
            System.out.println("------ Student "+ (index + 1) +" Info ------");
            System.out.print("Name:");
            System.out.printf("%s\n", Students.get(index).getName());
            
            System.out.print("Classes:");
            System.out.printf("%s\n", Students.get(index).getClasses());
            
            System.out.print("AVG:");
            System.out.printf("%.1f\n", Students.get(index).getAverage());
            
            System.out.print("Type:");
            System.out.printf("%s\n", Students.get(index).getType());
        }
    }
    
    public static void DisplayClassificationInfo(HashMap<String, Double> rank){
        System.out.println("--------Classification Info -----");
        Set<String> keySet = rank.keySet();
        for (String key : keySet) {
            System.out.println(key + ": " + rank.get(key) + "%");
        }
    }
            
}
