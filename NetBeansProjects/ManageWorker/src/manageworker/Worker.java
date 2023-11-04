/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageworker;
import java.io.*;
/**
 *
 * @author lenovo
 */
public class Worker implements Serializable{
    String ID;
    String name;
    int age;
    double salary;
    String workLocation;

    public Worker(String ID, String name, int age, double salary, String workLocation) {
        this.ID = ID;
        this.name = name;
        this.age=age;
        this.salary = salary;
        this.workLocation = workLocation;
    }
    
}
